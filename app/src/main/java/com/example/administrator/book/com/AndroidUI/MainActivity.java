package com.example.administrator.book.com.AndroidUI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.example.administrator.book.R;
import com.example.administrator.book.com.AndroidUI.student.StudentActivity;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int item1= Menu.FIRST;
    private static final int item2= Menu.FIRST+1;
    private static final int item3= Menu.FIRST+2;
    private static final int item4= Menu.FIRST+3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onClick(View v) {

    }
    //菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,item1,0,"学生管理");
        menu.add(0,item2,0,"图书维护");
        menu.add(0,item3,0,"借阅图书");
        menu.add(0,item4,0,"预约借阅");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case item1:
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,StudentActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            case item2:
                break;
            case item3:
                break;
            case item4:
                break;
        }
        return true;
    }

}
