package in.vl.librarymanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

import in.vl.librarymanagementsystem.model.Model_Student;

public class StudentLogin extends AppCompatActivity {

    EditText etEnrollmentNumber;
    EditText etPassword;

    Button btnLogin;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_login);
        etEnrollmentNumber = findViewById(R.id.etEnrollmentNumber);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEnrollmentNumber = etEnrollmentNumber.getText().toString();
                String strPassword = etPassword.getText().toString();

                if(strEnrollmentNumber.isEmpty() || strPassword.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Enter valid deatils !", Toast.LENGTH_SHORT).show();
                    return;
                }


                databaseReference = FirebaseDatabase.getInstance().getReference().child("Students");
                Query validateUser = databaseReference.orderByChild("enrollmentNumber").equalTo(strEnrollmentNumber);

                validateUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists())
                        {
                            for(DataSnapshot snapshot : dataSnapshot.getChildren())
                            {
                                String passwordFromDB = snapshot.child("password").getValue(String.class);
                                String pushID = snapshot.child("pushID").getValue(String.class);
                                if(strPassword.equals(passwordFromDB))
                                {
                                    Intent intent = new Intent(getApplicationContext() , StudentProfile.class);
                                    intent.putExtra("strEnrollmentNumber" , strEnrollmentNumber);
                                    intent.putExtra("pushID" , pushID);
                                    startActivity(intent);
                                    Toast.makeText(StudentLogin.this, "Login successfully..", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(StudentLogin.this, "Invalid credentials !", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        else
                        {
                            Toast.makeText(StudentLogin.this, "Enrollment not found !", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.e("DatabaseError" , "" + databaseError);
                    }
                });


            }
        });

    }
}