package com.example.edu.sqliteprzyklad;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class StartActivity extends AppCompatActivity {

    public SQLiteDatabase database;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        database = openOrCreateDatabase("COVID",MODE_PRIVATE,null);
        String sqlDB = "CREATE TABLE IF NOT EXISTS COVID (country VARCHAR PRIMARY KEY, cases INTEGER, active INTEGER, casesPerOneMilion INTEGER, testsPerOneMilion INTEGER)";
        database.execSQL(sqlDB);
    }

    public void onShowHistory(View view){
        Intent intent = new Intent(this, ShowDataActivity.class);
        startActivity(intent);
    }


    public void onInsertData(View view) {
        Intent intent = new Intent(this, InsertActivity.class);
        startActivity(intent);
    }

    public void onGetStats(View view) {
        Intent intent = new Intent(this, StatsActivity.class);
        startActivity(intent);
    }
}