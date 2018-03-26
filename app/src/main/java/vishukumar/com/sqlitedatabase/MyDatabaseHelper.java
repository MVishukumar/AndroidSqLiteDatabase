package vishukumar.com.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by vishukum on 26-03-2018 0026.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Student.db";
    private static final String TABLE_NAME = "student_table";

    private static final String COL_1 = "ID";
    private static final String COL_2 = "NAME";
    private static final String COL_3 = "SURNAME";
    private static final String COL_4 = "MARKS";


    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        Log.d("tag", "MyDatabaseHelper");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("tag", "onCreate");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME VARCHAR2(255), SURNAME VARCHAR2(255),MARKS INT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d("tag", "onUpgrade");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public int insertData(String name, String surname, String marks) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, marks);

        return (int) sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public Cursor getAllData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }
}
