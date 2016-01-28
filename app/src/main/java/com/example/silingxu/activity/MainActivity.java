package com.example.silingxu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static  String TAG="xlc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        LinearLayout linearLayout=new LinearLayout(this);
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//        this.setContentView(linearLayout);
//
        Log.d(TAG, "-----onCreate------");
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button start=(Button)findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, second.class);
                startActivity(i);
            }
        });
        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
        findViewById(R.id.onstart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,second.class);
//                startActivity(intent);
                Intent intent=new Intent();
                intent.setAction("android.intent.action.XLC");
                startActivity(intent);
            }
        });
        TextView textView=(TextView)findViewById(R.id.display);
        textView.setText("Activity 为 "+this.toString()+"\n"+"Task id 为 "+this.getTaskId());
        Log.d(TAG+"xxxxx","Activity 为 "+this.toString()+"\n"+"Task id 为 "+this.getTaskId());

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"-----onStop------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "-----onDestroy------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "-----onPause------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "-----onResume------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "-----onStart------");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "-----onRestart------");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
/*
* activity启动模式之standard模式
* 当系统启动某个activity时，会为该activity启动一个task栈，隶属于这个app中的所有activity都是这个栈在这个栈中，栈不变，只有退出后，在重新启动，才会重新分配task栈给当前应用程序使用。从taskid的变化
* 可以得出结论,不同的应用程序分到的task栈不一样，同一个activity允许有很多实例
*
* singleTop模式，当要启动的activity位于task栈顶时，系统不会重新创建新的activity实例，直接复用已有的activity实例，不在栈顶时和standard模式一样，会重新创建实例
*
* singleTask模式-当activity启动模式被设定为singleTask时，有以下三种情况
* （1）如activity不存在，则创建activity实例并且置于task栈顶
* （2）如activity存在且位于栈顶，则启动模式和singleTop模式一样
* （3）如activity存在但是不在栈顶，此时系统会将activity移到栈顶，并且将其他位于其上面的activity实例移出栈
*
* singleInstance模式
* 首先无论从哪个task启动activity，都只会创建一个实例，并且会使用一个全新的Task栈去加载这个Activity实例
* （1）当要启动的activity不存在时，首先会创建一个全新的task栈，然后在创建activity实例，加载到task中
* （2）当activity实例存在时，无论位于哪个应用程序中或者哪个task中，系统都会把该activity的task转到前台，从而使activity显示出来，所以说只存在一个activity实例，在当前运行的系统环境中
* 需要注意的是，采用singleInstance模式加载activity总是位于栈顶，且所在的task只包含该activity。
*
*
*
* 前三种模式都是位于同一个task栈中，最后一个是独立于一个全新的栈中
* singleTask只有唯一的实例，在task栈中和singleInstance一样，有且只有一个实例
* */
