package com.example.edu.sqliteprzyklad;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        TextView tv1 = findViewById(R.id.sum);
        TextView tv2 = findViewById(R.id.percentage);
        TextView tv3 = findViewById(R.id.tests);


        SQLiteDatabase database = openOrCreateDatabase("COVID", MODE_PRIVATE, null);
        String sqlDB = "CREATE TABLE IF NOT EXISTS COVID (country VARCHAR, cases INTEGER, active INTEGER, casesPerOneMilion INTEGER, testsPerOneMilion INTEGER)";
        database.execSQL(sqlDB);

        Cursor c = database.rawQuery("SELECT SUM(cases) FROM COVID", null);
        c.moveToFirst();
        tv1.setText("SUM OF CASES: "+c.getInt(0));



        c = database.rawQuery("SELECT country FROM COVID ORDER BY ((cases-active)*1.0/(1.0*cases)) DESC ", null);
        c.moveToFirst();
        tv2.setText("HIGHEST CURED PERCENT IN: "+c.getString(0));


        c = database.rawQuery("SELECT country  FROM COVID ORDER BY testsPerOneMilion DESC ",null);

        String s ="";
        if(c.moveToFirst()){

            do {
                s = s+c.getString(0)+", ";
            } while(c.moveToNext());
        }
        tv3.setText("TESTS PER ONE MILLION (DESCENDING): " + s);
        c.close();


    }


}