package in.vl.setuone;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import in.vl.setuone.model.UserModel;

public class CreateAccountActivity extends AppCompatActivity {

    EditText etEmailID, etUsername, etPassword, etConfirmPassword;
    Button btnCreateAccount;
    DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        etEmailID = findViewById(R.id.etEmailID);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCreateAccount();
            }
        });
    }

    private void btnCreateAccount()
    {
        String email = etEmailID.getText().toString().trim();
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        if (email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        }
        else if(!password.equals(confirmPassword))
        {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        }
        else
        {
            createUser(email , password , username);
        }
    }

    private void createUser(String email , String password , String username)
    {
        mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Success..", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            userDetailsToDB(email , username , password);
                        } else {
                            // If sign in fails, display a message to the user.
                            if(task.getException() instanceof FirebaseAuthWeakPasswordException)
                            {
                                Toast.makeText(CreateAccountActivity.this, "Password should be at least 6 characters",
                                        Toast.LENGTH_SHORT).show();
                            }
                            else if(task.getException() instanceof FirebaseAuthUserCollisionException)
                            {
                                Toast.makeText(CreateAccountActivity.this, "The email address is already registered",
                                        Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Log.w("Failed..", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(CreateAccountActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
//                                updateUI(null);
                            }
                        }
                    }
                });
    }

    private void userDetailsToDB(String email , String username , String password)
    {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").push();
        UserModel userModel = new UserModel(email , username , password , databaseReference.getKey());
        databaseReference.setValue(userModel);

        Toast.makeText(CreateAccountActivity.this, "Account created successfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext() , LoginActivity.class));
        finish();
    }

}