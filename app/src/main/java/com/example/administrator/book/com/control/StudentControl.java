package com.example.administrator.book.com.control;

import android.content.Context;
import com.example.administrator.book.com.model.Student;
import com.example.administrator.book.com.model.StudentSet;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/18.
 */
public class StudentControl {

    private static StudentSet studentSet;
    private Context context;

    public StudentControl(Context context) {
        this.context = context;
        studentSet = StudentSet.getStudentList();
    }

    //添加学生
    public void addStudent(Student student) {
        studentSet.insertStudent(student);
    }

    //从文件中读取所有学生信息
    public void saveAll() {
        studentSet.readFile(context);
    }

    //删除所有学生
    public void deleteAll() {
        studentSet.deleteAll();
    }

    //删除一个学生或一组学生
    public boolean deleteStudent(String info) {
        ArrayList<Student> student;
        student = studentSet.queryStudent(info);
        if (student != null) {
            studentSet.deleteStudent(info);
            return true;
        }
        return false;
    }

    //更新
    public void updateStudent(Student student) {
        String no = student.getNo();//获取学生学号
        ArrayList<Student> stuList = studentSet.queryStudent(no);//把查询结果放到ArrayList中
        if (stuList != null) {
            studentSet.deleteStudent(no);
            studentSet.insertStudent(student);
        }
    }

    //查询
    public Student[] queryStudent(String no) {
        ArrayList<Student> stuList = studentSet.queryStudent(no);//把查询结果放到ArrayList中
        if (stuList != null) {
            Student[] students = new Student[stuList.size()];
            for (int i = 0; i < stuList.size(); i++) {//将ArrayList中的学生取出来放到学生数组中
                students[i] = stuList.get(i);
            }
            return students;
        } else
            return null;
    }

    //获取所有学生信息
    public Student[] getAllStudent() {
        int size = studentSet.ListLength_S();
        Student students[] = new Student[size];
        for (int i = 0; i < size; i++) {
            students[i] = studentSet.get(i);
        }
        return students;
    }
}
