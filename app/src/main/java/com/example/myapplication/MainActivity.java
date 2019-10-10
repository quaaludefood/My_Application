package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication.Database.DBHelper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteOpenHelper dbHelper = new DBHelper(this);
        database = dbHelper.getWritableDatabase();
        toastMessage("DB was created!");

        /*************Below here is my original code******************/
        Button btnLogIn = (Button)findViewById(R.id.btnLogIn);
        final String Name = "phil";
        final String Password = "password";



        btnLogIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                TextView txtName = (TextView)findViewById(R.id.txtName);
                TextView txtPassword = (TextView)findViewById(R.id.txtPassword);
                String strName =   txtName.getText().toString();
                String strPassword =   txtPassword.getText().toString();
                if(strName.equals(Name) && strPassword.equals(Password) )
                {
                    toastMessage("Welcome. Name: "+ strName+ "   Password:" + strPassword);

                }else
                {
                    toastMessage("Cannot log in! Name: "+ strName+ "   Password:" + strPassword);

                }

            }

        });
    }

    /**
     * Prints out the message as a toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
