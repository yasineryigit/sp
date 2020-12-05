package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    EditText editText1;
    TextView textView1;
    SharedPreferences sp;
    int storedAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView) findViewById(R.id.textView1);
        editText1 = (EditText) findViewById(R.id.editText1);

        sp = this.getPreferences(Context.MODE_PRIVATE);

        storedAge = sp.getInt("storedAge",0);

        if(storedAge==0){
            textView1.setText("Your age: ");
        }else{
            textView1.setText("Your age: " + storedAge);
        }


    }

    public void saveData(View v){
        if(!editText1.getText().toString().matches("")){
            //textView ile gelen veriyi int'e çevirdik
           int userAge = Integer.parseInt(editText1.getText().toString());
            textView1.setText("Your age: " + userAge);
            sp.edit().putInt("storedAge",userAge).apply();
        }else{
            Toast.makeText(getApplicationContext(),"Please enter a valid value",Toast.LENGTH_SHORT).show();

        }

    }

    public void deleteAge(View v){

        int storedAge=sp.getInt("storedAge",0);
        if(storedAge!=0){
            sp.edit().remove("storedAge").apply();
            textView1.setText("Your age: ");
        }


    }
}
