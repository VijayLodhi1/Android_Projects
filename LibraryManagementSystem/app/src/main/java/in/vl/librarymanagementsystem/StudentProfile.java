package in.vl.librarymanagementsystem;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class StudentProfile extends AppCompatActivity {

    String strEnrollmentNumber;
    String pushID;

    TextView tvWelcome;

    EditText etFullName;
    EditText etDOB;
    EditText etFatherName;
    EditText etMotherName;
    EditText etEnrollmentNumber;
    EditText etEmailID;

    TextView tvEditProfile;

    Button btnUpdateProfile;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_profile);
        tvWelcome = findViewById(R.id.tvWelcome);
        etFullName = findViewById(R.id.etFullName);
        etDOB = findViewById(R.id.etDOB);
        etFatherName = findViewById(R.id.etFatherName);
        etMotherName = findViewById(R.id.etMotherName);
        etEnrollmentNumber = findViewById(R.id.etEnrollmentNumber);
        etEmailID = findViewById(R.id.etEmailID);
        tvEditProfile = findViewById(R.id.tvEditProfile);
        btnUpdateProfile = findViewById(R.id.btnUpdate);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle extras = getIntent().getExtras();
        strEnrollmentNumber = extras.getString("strEnrollmentNumber");
        pushID = extras.getString("pushID");

        displayDetails(strEnrollmentNumber);

    }

    private void displayDetails(String strEnrollmentNumber)
    {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Students");
        Query query = databaseReference.orderByChild("strEnrollmentNumber");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    String strFullname = snapshot.child("fullName").getValue(String.class);
                    String strDOB = snapshot.child("dob").getValue(String.class);
                    String strFatherName = snapshot.child("fatherName").getValue(String.class);
                    String strMotherName = snapshot.child("motherName").getValue(String.class);
                    String strEMailID = snapshot.child("eMailID").getValue(String.class);

                    tvWelcome.setText("Welcome " + strFullname);
                    etFullName.setText(strFullname);
                    etDOB.setText(strDOB);
                    etFatherName.setText(strFatherName);
                    etMotherName.setText(strMotherName);
                    etEnrollmentNumber.setText(strEnrollmentNumber);
                    etEmailID.setText(strEMailID);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("databaseError" , "" + databaseError);
            }
        });
    }

    public void editProfile(View view)
    {
        tvEditProfile.setText("Update Profile Section");
        btnUpdateProfile.setVisibility(View.VISIBLE);

    }

    public void updateProfile(View view)
    {
        String strFullName = etFullName.getText().toString();
        String strEMailID = etEmailID.getText().toString();

        databaseReference.child(pushID).child("fullName").setValue(strFullName);
        databaseReference.child(pushID).child("eMailID").setValue(strEMailID);
        displayDetails(strEnrollmentNumber);

        btnUpdateProfile.setVisibility(View.GONE);

        Toast.makeText(this, "Profile updated successfully..", Toast.LENGTH_SHORT).show();
    }

}