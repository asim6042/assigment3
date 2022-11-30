package com.example.my_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            final SQLiteDatabase db;
            SQLiteOpenHelper openHelper;
            final Cursor[] cursor = new Cursor[1];
            final Button button4;
            final EditText editText8, editText9;

            openHelper = new DatabaseHelper(this);
            db = openHelper.getReadableDatabase();
            editText8 = (EditText) findViewById(R.id.editText8);
            editText9 = (EditText) findViewById(R.id.editText9);
            button4 = (Button) findViewById(R.id.button4);
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = editText8.getText().toString();
                    String pass = editText9.getText().toString();

                    cursor[0] = db.rawQuery("SELECT *FROM " + DatabaseHelper.TABLE_NAME +
                            " WHERE " + DatabaseHelper.COL_5 + "=? AND "
                            + DatabaseHelper.COL_4 + "=?", new String[]{email, pass});
                    if (cursor[0] != null) {
                        if (cursor[0].getCount() > 0) {
                            Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getApplicationContext(), "Login error", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
            });
        }
}