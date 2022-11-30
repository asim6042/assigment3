package com.example.my_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class update extends AppCompatActivity {
    Button button;
    EditText editText, ed, edt;
    SQLiteOpenHelper openHelper1;
    SQLiteDatabase db;
    String a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        openHelper1 = new DatabaseHelper(this);

        button = findViewById(R.id.butup);
        ed = findViewById(R.id.enternam);
        edt = findViewById(R.id.enteradr);
        editText = findViewById(R.id.enteride);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = openHelper1.getWritableDatabase();
                a = ed.getText().toString();
                b = edt.getText().toString();
                c=editText.getText().toString();
                updatedata(a, b);
                Toast.makeText(update.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void updatedata(String a, String b) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.locCOL_2, a);
        contentValues.put(DatabaseHelper.locCOL_3,b);
        db.update(DatabaseHelper.TABLE_loca,contentValues,"ID=?",new String[]{c});

    }
}