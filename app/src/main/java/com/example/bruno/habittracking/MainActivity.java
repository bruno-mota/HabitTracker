package com.example.bruno.habittracking;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.bruno.habittracking.data.HabitContract.HabitEntry;
import com.example.bruno.habittracking.data.HabitDb;
public class MainActivity extends AppCompatActivity {
    private HabitDb mDBHelper;
    private static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDBHelper = new HabitDb(this);
        int oneHour = 60;
        int fourHours = 240;
        insertHabit("Took dog for a walk", oneHour);
        insertHabit("Worked on udacity nanodegree", fourHours);
        Cursor cursor = readHabit();
    }
    private void insertHabit(String habit, int time){
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT__NAME, habit);
        values.put(HabitEntry.COLUMN_TIME_SPENT, time);
        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);
    }
    private Cursor readHabit(){
        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT__NAME,
                HabitEntry.COLUMN_TIME_SPENT,
        };
        Cursor cursor = db.query(
                HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }
}
