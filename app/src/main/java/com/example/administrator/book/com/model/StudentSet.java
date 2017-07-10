package com.example.administrator.book.com.model;

/**
 * Created by lsy on 2016/7/14.
 */

import android.content.Context;
import com.example.administrator.book.*;

import java.io.*;
import java.util.ArrayList;

public class StudentSet extends ArrayList<Student> {
    private static StudentSet studentList = null;//定义存储唯一学生集合类的引用变量

    private StudentSet() {//封装构造函数
    }

    //静态成员方法，单例模式
    public static StudentSet getStudentList() {//用静态函数生成集合对象
        if (studentList == null)
            studentList = new StudentSet();
        return studentList;
    }

    //从文件读取学生信息，并将读取的信息转换成学术类的对象，存储到容器arraylist中
    public void readFile(Context io) {
        try {
            InputStream in = io.getResources().openRawResource(R.raw.student1);
            //把字节流转换成字符流并设置编码为国标码
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "gbk"));
            String temp;
            while ((temp = br.readLine()) != null) {
                //读取txt文件里的内容
                String[] s = temp.split(" ");
                String studentNo = s[0];
                String studentName = s[1];
                String studentMajor = s[2];
                String studentClass = s[3];
                String studentMobile = s[4];
                Student student = new Student(studentNo, studentName, studentMajor, studentClass, studentMobile);
                studentList.add(student);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("读取失败！");
        }
        System.out.println("读取成功！");
    }

    //插入一名学生
    public void insertStudent(Student student) {
        this.add(student);
    }

    //删除一名学生或一组学生
    public void deleteStudent(String info) {
        Student student;
        for (int i = 0; i < this.size(); i++) {
            student = this.get(i);
            if (student.getNo().equals(info)||student.getMajor().equals(info)||
                    student.getClasses().equals(info)||student.getName().equals(info)||
                    student.getPhone().equals(info)) {
                this.remove(i);
                i--;//从ArrayList中删除某条数据后，其后的数据会补上去，所以应该从当前位置继续遍历，即先进行i--再进行for循环中的i++
            }
        }
    }

    //删除所有学生
    public void deleteAll() {
        this.clear();
    }

    //获取容器大小
    public int ListLength_S() {
        return this.size();
    }

    public ArrayList<Student> queryStudent(String info) //查询学生信息
    {
        Student student;
        ArrayList<Student> stuList = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < this.size(); j++) {
            student = this.get(j);
            if ((student.getMajor().equals(info)) || (student.getPhone().equals(info)) ||
                    (student.getName().equals(info)) || (student.getNo().equals(info))||
                    (student.getClasses().equals(info))) {
                stuList.add(student);
                i++;
            }
        }

        if (i != 0) {
            System.out.println("共找到" + i + "个符合条件的人员");
            return stuList;
        } else {
            System.out.println("没有找到符合条件的学生!");
            return null;
        }
    }


}
