package ru.sergeev.gettingstarted.date;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by serge on 15.03.2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "schoolManager";


    // Table Names
    private static final String TABLE_NAME = "NAMES";
    private static final String TABLE_OTHER_INFO = "OTHER_INFO";
    private static final String TABLE_USER = "USER";
    private static final String TABLE_STUDENT = "STUDENTS";
    private static final String TABLE_TEACHER = "TEACHERS";
    private static final String TABLE_CLASS = "CLASSES";
    private static final String TABLE_SCHEDULE = "SCHEDULES";
    private static final String TABLE_DAY = "DAYS";
    private static final String TABLE_LESSON = "LESSONS";
    private static final String TABLE_SUBJECT = "SUBJECTS";
    private static final String TABLE_MARK = "MARKS";
    private static final String TABLE_SCHEDULE_ROW = "SCHEDULE_ROWS";

    //Common id's
    private static final String COLUMN_NAME_ID = "NAME_ID";
    private static final String COLUMN_OTHER_INFO_ID = "OTHER_INFO_ID";
    private static final String COLUMN_USER_ID = "USER_ID";
    private static final String COLUMN_STUDENT_ID = "STUDENT_ID";
    private static final String COLUMN_TEACHER_ID = "TEACHER_ID";
    private static final String COLUMN_CLASS_ID = "CLASS_ID";
    private static final String COLUMN_SCHEDULE_ID = "SCHEDULE_ID";
    private static final String COLUMN_DAY_ID = "DAY_ID";
    private static final String COLUMN_LESSON_ID = "LESSON_ID";
    private static final String COLUMN_SUBJECT_ID = "SUBJECT_ID";
    private static final String COLUMN_MARK_ID = "MARK_ID";
    private static final String COLUMN_SCHEDULE_ROW_ID = "SCHEDULE_ROW_ID";


    //NAMES Table - column names
    private static final String COLUMN_FIRST_NAME = "FIRST_NAME";
    private static final String COLUMN_SECOND_NAME = "SECOND_NAME";
    private static final String COLUMN_LAST_NAME = "LAST_NAME";

    //OTHER_INFO Table - column names
    private static final String COLUMN_EMAIL = "EMAIL";
    private static final String COLUMN_ADDRESS = "ADDRESS";
    private static final String COLUMN_BIRTH_DATE = "BIRTH_DATE";

    //USER Table - column names
    private static final String COLUMN_LOGIN = "LOGIN";
    private static final String COLUMN_PASSWORD = "PASSWORD";
    private static final String COLUMN_ROLE = "ROLE";

    //SUBJECTS Table - column names
    private static final String COLUMN_NAME = "NAME";
    private static final String COLUMN_ROOM = "ROOM";

    //MARKS Table - column names
    private static final String COLUMN_VALUE = "VALUE";
    private static final String COLUMN_DATE = "DATE";

    //CLASSES Table - column names
    private static final String COLUMN_NUMBER = "NUMBER";

    //DAYS Table - column names
    private static final String COLUMN_DAY_NAME = "DAY_NAME";

    //LESSONS Table - column names
    private static final String COLUMN_START_TIME = "START_TIME";
    private static final String COLUMN_END_TIME = "END_TIME";


    //Tables create statement
    private static final String CREATE_TABLE_NAMES = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( " +
            COLUMN_NAME_ID + " INTEGER PRIMARY KEY ASC AUTOINCREMENT UNIQUE NOT NULL, " +
            COLUMN_FIRST_NAME + " STRING(45) NOT NULL, " +
            COLUMN_SECOND_NAME + " STRING(45) NOT NULL," +
            COLUMN_LAST_NAME + " STRING(45) NOT NULL " + ")";

    private static final String CREATE_TABLE_OTHER_INFO = "CREATE TABLE IF NOT EXISTS " + TABLE_OTHER_INFO + " ( " +
            COLUMN_OTHER_INFO_ID + " INTEGER PRIMARY KEY ASC AUTOINCREMENT UNIQUE NOT NULL, " +
            COLUMN_EMAIL + " STRING(45) UNIQUE NOT NULL, " +
            COLUMN_ADDRESS + " STRING(45) NOT NULL, " +
            COLUMN_BIRTH_DATE + " DATE NOT NULL " + ")";

    private static final String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS " + TABLE_USER + " ( " +
            COLUMN_USER_ID + " INTEGER PRIMARY KEY ASC AUTOINCREMENT UNIQUE NOT NULL, " +
            COLUMN_LOGIN + " STRING(20) UNIQUE NOT NULL, " +
            COLUMN_PASSWORD + " STRING(60) NOT NULL, " +
            COLUMN_ROLE + " STRING(7) NOT NULL " + ")";

    private static final String CREATE_TABLE_STUDENTS = "CREATE TABLE IF NOT EXISTS " + TABLE_STUDENT + " ( " +
            COLUMN_STUDENT_ID + " INTEGER PRIMARY KEY ASC AUTOINCREMENT UNIQUE NOT NULL, " +
            COLUMN_NAME_ID + " INTEGER FOREIGN KEY (" + COLUMN_NAME_ID + ") REFERENCES " + TABLE_NAME + " (" + COLUMN_NAME_ID + ") ON DELETE CASCADE ON UPDATE CASCADE NOT NULL, " +
            COLUMN_OTHER_INFO_ID + " INTEGER FOREIGN KEY (" + COLUMN_OTHER_INFO_ID + ") REFERENCES " + TABLE_OTHER_INFO + " (" + COLUMN_OTHER_INFO_ID + ") ON DELETE CASCADE ON UPDATE CASCADE NOT NULL, " +
            COLUMN_CLASS_ID + " INTEGER FOREIGN KEY (" + COLUMN_CLASS_ID + ") REFERENCES " + TABLE_CLASS + " (" + COLUMN_CLASS_ID + ") ON DELETE CASCADE ON UPDATE CASCADE NOT NULL, " +
            COLUMN_USER_ID + " INTEGER FOREIGN KEY (" + COLUMN_USER_ID + ") REFERENCES " + TABLE_USER + " (" + COLUMN_USER_ID + ") ON DELETE CASCADE ON UPDATE CASCADE NOT NULL " + ")";

    private static final String CREATE_TABLE_TEACHERS = "CREATE TABLE IF NOT EXISTS " + TABLE_TEACHER + " ( " +
            COLUMN_TEACHER_ID + "INTEGER PRIMARY KEY ASC AUTOINCREMENT UNIQUE NOT NULL, " +
            COLUMN_NAME_ID + " INTEGER FOREIGN KEY (" + COLUMN_NAME_ID + ") REFERENCES " + TABLE_NAME + " (" + COLUMN_NAME_ID + ") ON DELETE CASCADE ON UPDATE CASCADE NOT NULL, " +
            COLUMN_OTHER_INFO_ID + " INTEGER FOREIGN KEY (" + COLUMN_OTHER_INFO_ID + ") REFERENCES " + TABLE_OTHER_INFO + " (" + COLUMN_CLASS_ID + ") ON DELETE CASCADE ON UPDATE CASCADE NOT NULL, " +
            COLUMN_USER_ID + " INTEGER FOREIGN KEY (" + COLUMN_USER_ID + ") REFERENCES " + TABLE_USER + " (" + COLUMN_USER_ID + ") ON DELETE CASCADE ON UPDATE CASCADE NOT NULL " + ")";

    private static final String CREATE_TABLE_CLASSES = "CREATE TABLE IF NOT EXISTS " + TABLE_CLASS + " ( " +
            COLUMN_CLASS_ID + "INTEGER PRIMARY KEY ASC AUTOINCREMENT UNIQUE NOT NULL, " +
            COLUMN_NUMBER + "STRING(3) UNIQUE NOT NULL " + ")";

    private static final String CREATE_TABLE_SUBJECTS = "CREATE TABLE IF NOT EXISTS " + TABLE_SUBJECT + " ( " +
            COLUMN_SUBJECT_ID + "INTEGER PRIMARY KEY ASC AUTOINCREMENT UNIQUE NOT NULL, " +
            COLUMN_NAME + "STRING(20) UNIQUE NOT NULL, " +
            COLUMN_ROOM + "INTEGER NOT NULL " + ")";

    private static final String CREATE_TABLE_MARKS = "CREATE TABLE IF NOT EXISTS " + TABLE_MARK + " ( " +
            COLUMN_MARK_ID + "INTEGER PRIMARY KEY ASC AUTOINCREMENT UNIQUE NOT NULL," +
            COLUMN_VALUE + " INTEGER NOT NULL, " +
            COLUMN_DATE + " DATE NOT NULL, " +
            COLUMN_STUDENT_ID + " INTEGER FOREIGN KEY (" + COLUMN_STUDENT_ID + ") REFERENCES " + TABLE_STUDENT + " (" + COLUMN_STUDENT_ID + ") ON DELETE CASCADE ON UPDATE CASCADE NOT NULL, " +
            COLUMN_SUBJECT_ID + " INTEGER FOREIGN KEY (" + COLUMN_SUBJECT_ID + ") REFERENCES " + TABLE_SUBJECT + " (" + COLUMN_SUBJECT_ID + ") ON DELETE CASCADE ON UPDATE CASCADE NOT NULL " + ")";

    private static final String CREATE_TABLE_SCHEDULES = "CREATE TABLE IF NOT EXISTS " + TABLE_SCHEDULE + " ( " +
            COLUMN_SCHEDULE_ID + "INTEGER PRIMARY KEY ASC AUTOINCREMENT UNIQUE NOT NULL," +
            COLUMN_CLASS_ID + " INTEGER FOREIGN KEY (" + COLUMN_CLASS_ID + ") REFERENCES " + TABLE_CLASS + " (" + COLUMN_CLASS_ID + ") ON DELETE CASCADE ON UPDATE CASCADE NOT NULL, " +
            COLUMN_DAY_ID + " INTEGER FOREIGN KEY (" + COLUMN_DAY_ID + ") REFERENCES " + TABLE_DAY + " (" + COLUMN_DAY_ID + ") ON DELETE RESTRICT ON UPDATE CASCADE NOT NULL " + ")";

    private static final String CREATE_TABLE_DAYS = "CREATE TABLE IF NOT EXISTS " + TABLE_DAY + " ( " +
            COLUMN_DAY_ID + "INTEGER PRIMARY KEY ASC AUTOINCREMENT UNIQUE NOT NULL, " +
            COLUMN_DAY_NAME + "STRING(15) NOT NULL " + ")";

    private static final String CREATE_TABLE_SCHEDULE_ROWS = "CREATE TABLE IF NOT EXISTS " + TABLE_SCHEDULE_ROW + " ( " +
            COLUMN_SCHEDULE_ROW_ID + "INTEGER PRIMARY KEY ASC AUTOINCREMENT UNIQUE NOT NULL," +
            COLUMN_SCHEDULE_ID + " INTEGER FOREIGN KEY (" + COLUMN_SCHEDULE_ID + ") REFERENCES " + TABLE_SCHEDULE + " (" + COLUMN_SCHEDULE_ID + ") ON DELETE CASCADE ON UPDATE CASCADE NOT NULL, " +
            COLUMN_TEACHER_ID + " INTEGER FOREIGN KEY (" + COLUMN_TEACHER_ID + ") REFERENCES " + TABLE_TEACHER + " (" + COLUMN_TEACHER_ID + ") ON DELETE CASCADE ON UPDATE CASCADE NOT NULL, " +
            COLUMN_SUBJECT_ID + " INTEGER FOREIGN KEY (" + COLUMN_SUBJECT_ID + ") REFERENCES " + TABLE_SUBJECT + " (" + COLUMN_SUBJECT_ID + ") ON DELETE CASCADE ON UPDATE CASCADE NOT NULL, " +
            COLUMN_LESSON_ID + " INTEGER FOREIGN KEY (" + COLUMN_LESSON_ID + ") REFERENCES " + TABLE_LESSON + " (" + COLUMN_LESSON_ID + ") ON DELETE CASCADE ON UPDATE CASCADE NOT NULL " + ")";

    private static final String CREATE_TABLE_LESSONS = "CREATE TABLE IF NOT EXISTS " + TABLE_LESSON + " ( " +
            COLUMN_LESSON_ID + "INTEGER PRIMARY KEY ASC AUTOINCREMENT UNIQUE NOT NULL, " +
            COLUMN_START_TIME + "TIME UNIQUE NOT NULL, " +
            COLUMN_END_TIME + "TIME UNIQUE NOT NULL " + ")";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CLASSES);
        db.execSQL(CREATE_TABLE_NAMES);
        db.execSQL(CREATE_TABLE_OTHER_INFO);
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_STUDENTS);
        db.execSQL(CREATE_TABLE_TEACHERS);
        db.execSQL(CREATE_TABLE_SUBJECTS);
        db.execSQL(CREATE_TABLE_MARKS);
        db.execSQL(CREATE_TABLE_DAYS);
        db.execSQL(CREATE_TABLE_SCHEDULES);
        db.execSQL(CREATE_TABLE_SCHEDULE_ROWS);
        db.execSQL(CREATE_TABLE_LESSONS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OTHER_INFO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEACHER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DAY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LESSON);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLASS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUBJECT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MARK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCHEDULE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCHEDULE_ROW);

        // create new tables
        onCreate(db);
    }
}
