package in.vl.setuone1;

import android.os.Bundle;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import in.vl.setuone1.model.UserModel;

public class CreateAccountActivity extends AppCompatActivity {

    EditText etEmailID, etUsername, etPassword, etConfirmPassword;
    Button btnCreateAccount;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        etEmailID = findViewById(R.id.etEmailID);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);

        btnCreateAccount.setOnClickListener(view -> {
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
                databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").push();
                UserModel userModel = new UserModel(email , username , password , databaseReference.getKey());
                databaseReference.setValue(userModel);
                Toast.makeText(this, "Account created successfully....", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext() , LoginActivity.class));
                finish();
            }
        });
    }
}