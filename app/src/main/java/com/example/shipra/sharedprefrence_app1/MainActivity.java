package com.example.shipra.sharedprefrence_app1;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends Activity{

    SharedPreferences sharedpreferences;
    //declare the variables for edit text and button

    EditText et_Name, et_email, et_pass;
    Button btsave;
// declare the variables for shared prefrence to get the key value

    public static final String MyPREFERENCES = "mypref";
    public static final String Name = "NmaeKey";
    public static final String Email = "EmailKey";
    public static final String Password = "passKey";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_Name = (EditText) findViewById(R.id.name);
        et_email = (EditText) findViewById(R.id.email);
        et_pass = (EditText) findViewById(R.id.pass);

        btsave = (Button) findViewById(R.id.save);



        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        et_Name.setText(sharedpreferences.getString(Name, ""));

        if (sharedpreferences.contains(Name)) {
            et_Name.setText(sharedpreferences.getString(Name, ""));
        }

        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n = et_Name.getText().toString();
                String e = et_email.getText().toString();
                String p = et_pass.getText().toString();


                SharedPreferences.Editor editor = sharedpreferences.edit();




                editor.putString(Name, n);
                editor.putString(Email, e);
                editor.putString(Password, p);

                editor.commit();


                Toast.makeText(MainActivity.this, "Thanks", Toast.LENGTH_LONG).show();

            }
        });


    }




}