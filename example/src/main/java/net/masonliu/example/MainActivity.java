package net.masonliu.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import net.masonliu.statusbarcolor.StatusBarColorUtil;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1、if activity have drawlayout ,must after setcontentview
        //2、if activity have drawlayout ,values-v19 add <item name="android:fitsSystemWindows">true</item>
        //   and toast use StatusBarColorUtil.showToastWithDrawLayout
        StatusBarColorUtil.setStatusBarColorResourceAfterSetContentView(this, R.color.red);


        Toolbar toolbar = (Toolbar) findViewById(R.id.home_activity_toolbar);

        setSupportActionBar(toolbar);

        TextView www = (TextView) findViewById(R.id.www);
        www.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
        TextView www3 = (TextView) findViewById(R.id.www3);
        www3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ThirdActivity.class));
            }
        });
        TextView www4 = (TextView) findViewById(R.id.www4);
        www4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NoActionBarActivity.class));
            }
        });
        StatusBarColorUtil.showToastWithDrawLayout(this, "dd", true);
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
