package com.example.studentinfoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextStudentID, editTextClass, editTextPlan;
    private RadioGroup radioGroupYear, radioGroupMajor;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextName = findViewById(R.id.editTextName);
        editTextStudentID = findViewById(R.id.editTextStudentID);
        editTextClass = findViewById(R.id.editTextClass);
        editTextPlan = findViewById(R.id.editTextPlan);
        radioGroupYear = findViewById(R.id.radioGroupYear);
        radioGroupMajor = findViewById(R.id.radioGroupMajor);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    submitData();
                }
            }
        });
    }

    private boolean validateInput() {
        boolean isValid = true;
        String name = editTextName.getText().toString().trim();
        String studentId = editTextStudentID.getText().toString().trim();
        String className = editTextClass.getText().toString().trim();
        String plan = editTextPlan.getText().toString().trim();


        if (TextUtils.isEmpty(name)) {
            editTextName.setError("Vui lòng nhập họ và tên");
            isValid = false;
        }


        if (TextUtils.isEmpty(studentId)) {
            editTextStudentID.setError("Vui lòng nhập MSSV");
            isValid = false;
        }


        if (TextUtils.isEmpty(className)) {
            editTextClass.setError("Vui lòng nhập lớp");
            isValid = false;
        }


        if (radioGroupYear.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Vui lòng chọn năm học của sinh viên", Toast.LENGTH_SHORT).show();
            isValid = false;
        }


        if (radioGroupMajor.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Vui lòng chọn chuyên ngành", Toast.LENGTH_SHORT).show();
            isValid = false;
        }

        if (!isValid) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
        }

        return isValid;
    }

    private void submitData() {

        String name = editTextName.getText().toString();
        String studentId = editTextStudentID.getText().toString();
        String className = editTextClass.getText().toString();
        String plan = editTextPlan.getText().toString();


        int selectedYearId = radioGroupYear.getCheckedRadioButtonId();
        RadioButton selectedYearButton = findViewById(selectedYearId);
        String year = selectedYearButton != null ? selectedYearButton.getText().toString() : "";


        int selectedMajorId = radioGroupMajor.getCheckedRadioButtonId();
        RadioButton selectedMajorButton = findViewById(selectedMajorId);
        String major = selectedMajorButton != null ? selectedMajorButton.getText().toString() : "";


        Intent intent = new Intent(MainActivity.this, SecondActivity.class);


        intent.putExtra("NAME", name);
        intent.putExtra("STUDENT_ID", studentId);
        intent.putExtra("CLASS", className);
        intent.putExtra("YEAR", year);
        intent.putExtra("MAJOR", major);
        intent.putExtra("PLAN", plan);


        startActivity(intent);
    }
}