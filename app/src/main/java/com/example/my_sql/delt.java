package com.example.my_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delt extends AppCompatActivity {

    Button button;
    EditText editText;
    SQLiteOpenHelper openHelper1;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delt);

        openHelper1 = new DatabaseHelper(this);
        button = findViewById(R.id.butdel);
        editText=findViewById(R.id.enterid);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openHelper1.getWritableDatabase();


                deletedata(editText.getText().toString());
                Toast.makeText(delt.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void deletedata(String id4) {

    }
}