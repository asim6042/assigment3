package com.example.my_sql;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.locks.ReadWriteLock;

public class lloc extends AppCompatActivity {
    Button button,button1,b,b3;
    EditText text, text1;
    SQLiteOpenHelper openHelper1;
    private final int REQ=1;
    private Bitmap bitmap;
    ImageView showimg;
    CardView adding;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lloc);

        openHelper1 = new DatabaseHelper(this);
        button= findViewById(R.id.button14);
        button1= findViewById(R.id.button15);
        b=(Button)findViewById(R.id.button17);
        b3=(Button)findViewById(R.id.button16);
         text= findViewById(R.id.editText12);
         showimg=findViewById(R.id.showing);
         adding=findViewById(R.id.adding);

        text1= findViewById(R.id.editText13);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openHelper1.getWritableDatabase();
                String fname=text.getText().toString();
                String lname=text1.getText().toString();
                insertdata(fname, lname);

                Toast.makeText(lloc.this, "Added", Toast.LENGTH_SHORT).show();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lloc.this,MainActivity2.class);
                startActivity(intent);

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lloc.this,delt.class);
                startActivity(intent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lloc.this,update.class);
                startActivity(intent);
            }
        });

        adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
                Toast.makeText(lloc.this, "Card is on Working", Toast.LENGTH_SHORT).show();
            }
        });



}



    private void openGallery() {
        Intent picking=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(picking,REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQ && resultCode==RESULT_OK)
        {
            Uri uri=data.getData();
            try {
                bitmap=MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            showimg.setImageBitmap(bitmap);
        }
    }

    private void insertdata(String fname, String lname) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.locCOL_2, fname);
        contentValues.put(DatabaseHelper.locCOL_3,lname);
        long id = db.insert(DatabaseHelper.TABLE_loca, null, contentValues);

    }
    }