package in.vl.librarymanagementsystem.model;

import android.widget.EditText;
import android.widget.RadioButton;

public class Model_Student {

    String fullName;
    String dob;
    String fatherName;
    String motherName;
    String enrollmentNumber;
    String eMailID;
    String password;
    String pushID;

    public Model_Student()
    {

    }

    public Model_Student(String fullName, String dob, String fatherName, String motherName, String enrollmentNumber, String eMailID, String password, String pushID) {
        this.fullName = fullName;
        this.dob = dob;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.enrollmentNumber = enrollmentNumber;
        this.eMailID = eMailID;
        this.password = password;
        this.pushID = pushID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    public String geteMailID() {
        return eMailID;
    }

    public void seteMailID(String eMailID) {
        this.eMailID = eMailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPushID() {
        return pushID;
    }

    public void setPushID(String pushID) {
        this.pushID = pushID;
    }
}
