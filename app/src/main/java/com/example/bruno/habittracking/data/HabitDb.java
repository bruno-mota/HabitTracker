package com.example.bruno.habittracking.data;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.bruno.habittracking.data.HabitContract.HabitEntry;
/**
 * Created by Bruno on 1/7/2018.
 */
public class HabitDb extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "habit.db";
    private static final int DATABASE_VERSION = 1;
    public HabitDb(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
            String CREATE_HABIT_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
                    + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + HabitEntry.COLUMN_HABIT__NAME + " TEXT NOT NULL, "
                    + HabitEntry.COLUMN_TIME_SPENT + " INTEGER NOT NULL DEFAULT 0);";
            db.execSQL(CREATE_HABIT_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldHabits, int newHabits){
    }
}
