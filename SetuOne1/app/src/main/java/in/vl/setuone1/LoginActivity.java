package in.vl.setuone1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class LoginActivity extends AppCompatActivity {
    EditText etLoginEmailID, etLoginPassword;
    Button btnLogin, btnCreateNewAccount;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginEmailID = findViewById(R.id.etLoginEmailID);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnCreateNewAccount = findViewById(R.id.btnCreateNewAccount);

        btnLogin.setOnClickListener(v -> {
            String strEmailID = etLoginEmailID.getText().toString().trim();
            String strPassword = etLoginPassword.getText().toString().trim();

            if (strEmailID.isEmpty() || strPassword.isEmpty())
            {
                Toast.makeText(this, "Enter email and password", Toast.LENGTH_SHORT).show();
                return;
            }

            else
            {
                databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
                Query validateUser = databaseReference.orderByChild("emailID").equalTo(strEmailID);

                validateUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists())
                        {
                            for(DataSnapshot snapshot : dataSnapshot.getChildren())
                            {
                                String emailIDFromDB = snapshot.child("emailID").getValue(String.class);
                                String passwordFromDB = snapshot.child("password").getValue(String.class);
                                String pushIDFromDB = snapshot.child("pushID").getValue(String.class);
                                String usernameFromDB = snapshot.child("username").getValue(String.class);

                                if(strEmailID.equals(emailIDFromDB) && strPassword.equals(passwordFromDB))
                                {
                                    Intent intent = new Intent(getApplicationContext() , OTTActivity.class);
                                    intent.putExtra("username" , usernameFromDB);
                                    intent.putExtra("pushID" , pushIDFromDB);
                                    startActivity(intent);
                                    Toast.makeText(LoginActivity.this, "Login successfully....", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                                else
                                {
                                    Toast.makeText(LoginActivity.this, "Invalid credentials !", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this, "Register yourself first !", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.e("DatabaseError" , "" + databaseError);
                    }
                });

            }
        });

        btnCreateNewAccount.setOnClickListener(v -> startActivity(new Intent(this, CreateAccountActivity.class)));
    }
}