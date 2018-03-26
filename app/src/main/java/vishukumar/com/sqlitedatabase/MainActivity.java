package vishukumar.com.sqlitedatabase;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //MyDatabaseHelper myDatabaseHelper;
    StatusDatabaseHelper statusDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("tag", "Creating MyDatabaseHelper object");

        //myDatabaseHelper = new MyDatabaseHelper(this);
        statusDatabaseHelper = new StatusDatabaseHelper(this);

        Log.d("tag", "End");

        //Log.d("tag", "Return value : " + myDatabaseHelper.insertData("vishu1", "vishu", "35"));



        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.format(date));

        Log.d("tag", "Insert status : " + statusDatabaseHelper.addEntryInMyDiary(simpleDateFormat.format(date), "i am creating this", "happy"));

        /*
        Cursor cursor = myDatabaseHelper.getAllData();
        if(cursor.getCount() == 0) {
            Log.d("tag", "No Entries in Database");
        } else {
            Log.d("tag", "Printing entries from Database");
            while (cursor.moveToNext()) {
                System.out.println(cursor.getString(0));
                System.out.println(cursor.getString(1));
                System.out.println(cursor.getString(2));
                System.out.println(cursor.getString(3));
                System.out.println();

                Log.d("tag", cursor.getString(0));
                Log.d("tag", cursor.getString(1));
                Log.d("tag", cursor.getString(2));
                Log.d("tag", cursor.getString(3));
                Log.d("tag", "\n");
            }
        }
        */

        Cursor cursor = statusDatabaseHelper.getAllStatus();
        if(cursor.getCount() == 0) {
            Log.d("tag", "No Entries in Database");
        } else {
            Log.d("tag", "Printing entries from Database");
            while (cursor.moveToNext()) {
                System.out.println(cursor.getString(0));
                System.out.println(cursor.getString(1));
                System.out.println(cursor.getString(2));
                System.out.println(cursor.getString(3));
                System.out.println();

                Log.d("tag", cursor.getString(0));
                Log.d("tag", cursor.getString(1));
                Log.d("tag", cursor.getString(2));
                Log.d("tag", cursor.getString(3));
                Log.d("tag", "\n");
            }
        }
    }
}
