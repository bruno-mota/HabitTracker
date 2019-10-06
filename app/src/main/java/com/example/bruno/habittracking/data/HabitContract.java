package com.example.bruno.habittracking.data;
import android.provider.BaseColumns;
/**
 * Created by Bruno on 1/7/2018.
 */
public class HabitContract {
    private HabitContract(){}
    public static final class HabitEntry implements BaseColumns{
        public final static String TABLE_NAME = "pets";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HABIT__NAME = "habit";
        // Time spent would theoretically be time spent in minutes defaulted to 0 if no time is put in.
        public final static String COLUMN_TIME_SPENT = "time";
    }
}
