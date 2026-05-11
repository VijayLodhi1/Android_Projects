package in.vl.setuone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import javax.xml.validation.Validator;


public class LoginActivity extends AppCompatActivity {
    EditText etLoginEmailID, etLoginPassword;
    Button btnLogin, btnCreateNewAccount;
    DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        etLoginEmailID = findViewById(R.id.etLoginEmailID);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnCreateNewAccount = findViewById(R.id.btnCreateNewAccount);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLogin();
            }
        });

        btnCreateNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });

    }

    private void btnLogin()
    {
        String email = etLoginEmailID.getText().toString().trim();
        String password = etLoginPassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty())
        {
            Toast.makeText(this, "Enter email and password", Toast.LENGTH_SHORT).show();
        }

        else
        {
           signIn(email , password);

        }
    }

    private void signIn(String email , String password)
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Success..", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            login(user.getEmail());
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Failed..", "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Invalid Credentials",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }
                    }
                });
    }

    private void login(String email)
    {
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        Query query = databaseReference.orderByChild("emailID").equalTo(email);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    String username = snapshot.child("username").getValue(String.class);
                    Intent intent = new Intent(getApplicationContext() , PreferencesActivity.class);
                    intent.putExtra("username" , username);
                    Toast.makeText(LoginActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Error.." , databaseError.getMessage());
            }
        });
    }

    private void signup()
    {
        startActivity(new Intent(this, CreateAccountActivity.class));
    }

}