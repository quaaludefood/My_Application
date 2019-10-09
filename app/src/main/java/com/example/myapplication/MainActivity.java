package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");

        Button btnLogIn = (Button)findViewById(R.id.btnLogIn);
        final String Name = "phil";
        final String Password = "password";



        btnLogIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                TextView txtName = (TextView)findViewById(R.id.txtName);
                TextView txtPassword = (TextView)findViewById(R.id.txtPassword);
                Log.d(TAG, "BtnLogin Clicked!");
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
