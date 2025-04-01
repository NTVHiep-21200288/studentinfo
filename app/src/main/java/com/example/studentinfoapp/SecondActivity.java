package com.example.studentinfoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewInfo;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        textViewInfo = findViewById(R.id.textViewInfo);
        buttonBack = findViewById(R.id.buttonBack);

        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        String studentId = intent.getStringExtra("STUDENT_ID");
        String className = intent.getStringExtra("CLASS");
        String year = intent.getStringExtra("YEAR");
        String major = intent.getStringExtra("MAJOR");
        String plan = intent.getStringExtra("PLAN");

        // Hiển thị thông tin
        String info =
                "Họ và tên: " + name + "\n" +
                "MSSV: " + studentId + "\n" +
                "Lớp: " + className + "\n" +
                "Sinh viên " + year + "\n" +
                "Chuyên ngành: " + major + "\n\n" +
                "Kế hoạch phát triển bản thân:\n" + plan;

        textViewInfo.setText(info);


        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}