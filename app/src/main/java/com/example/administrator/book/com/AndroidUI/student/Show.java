package com.example.administrator.book.com.AndroidUI.student;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.administrator.book.R;
import com.example.administrator.book.com.control.StudentControl;
import com.example.administrator.book.com.model.Student;

public class Show extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        textView = (TextView) findViewById(R.id.textView);

        StudentControl studentControl = new StudentControl(this);
        Student s[] = studentControl.getAllStudent();


        String temp = "";
        for (int i = 0; i < s.length; i++) {
            temp+=(s[i].getNo() + " " + s[i].getName() + " " + s[i].getMajor() + " " +
                    s[i].getClasses() + " " + s[i].getPhone()+"\n");
        }
        textView.setText(temp);
    }
}
