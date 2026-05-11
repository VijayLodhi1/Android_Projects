package in.vl.librarymanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import in.vl.librarymanagementsystem.model.Model_Student;

public class NewUser extends AppCompatActivity {

    RadioButton rbLibIncharge;
    RadioButton rbPrincipalFaculty;
    RadioButton rbStudent;

    LinearLayout llStudent;

    EditText etFullName;
    EditText etDate;
    EditText etMonth;
    EditText etYear;
    EditText etFatherName;
    EditText etMotherName;
    EditText etEnrollmentNumber;
    EditText etEmailID;
    EditText etPassword;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_user);
        rbLibIncharge = findViewById(R.id.rbLibIncharge);
        rbPrincipalFaculty = findViewById(R.id.rbPrincipalFaculty);
        rbStudent = findViewById(R.id.rbStudent);

        llStudent = findViewById(R.id.llStudent);

        etFullName = findViewById(R.id.etFullName);
        etDate = findViewById(R.id.etDate);
        etMonth = findViewById(R.id.etMonth);
        etYear = findViewById(R.id.etYear);
        etFatherName = findViewById(R.id.etFatherName);
        etMotherName = findViewById(R.id.etMotherName);
        etEnrollmentNumber = findViewById(R.id.etEnrollmentNumber);
        etEmailID = findViewById(R.id.etEmailID);
        etPassword = findViewById(R.id.etPassword);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rbStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llStudent.setVisibility(View.VISIBLE);
            }
        });

    }

    public void createStudentDB(View view)
    {
        String strFullName = etFullName.getText().toString();
        String strDOB = etDate.getText().toString() + "/" + etMonth.getText().toString() + "/" + etYear.getText().toString();
        String strFatherName = etFatherName.getText().toString();
        String strMotherName = etMotherName.getText().toString();
        String strEnrollmentNumber = etEnrollmentNumber.getText().toString();
        String strEmailID = etEmailID.getText().toString();
        String strPassword = etPassword.getText().toString();

        if(strFullName.isEmpty() || strDOB.isEmpty() || strFatherName.isEmpty() || strMotherName.isEmpty() || strEmailID.isEmpty() || strPassword.isEmpty())
        {
            Toast.makeText(this, "Enter valid deatils !", Toast.LENGTH_SHORT).show();
            return;
        }

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Students").push();
        Model_Student modelStudent = new Model_Student(strFullName , strDOB , strFatherName , strMotherName , strEnrollmentNumber , strEmailID , strPassword , databaseReference.getKey());
        databaseReference.setValue(modelStudent);

        Intent intent = new Intent(this , StudentLogin.class);
        startActivity(intent);

        Toast.makeText(this, "User created successfully..", Toast.LENGTH_SHORT).show();
    }

}