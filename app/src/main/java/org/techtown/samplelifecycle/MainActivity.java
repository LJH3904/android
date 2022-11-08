package org.techtown.samplelifecycle;

import static java.sql.DriverManager.println;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    @Override
    protected void onStart(){
        super.onStart();

    }
    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
    @Override
    protected void onPause(){
        super.onPause();

        Toast.makeText(this, "onPause 호출됨", Toast.LENGTH_LONG).show();
        saveState();
    }
    @Override
    protected void onResume(){
        super.onResume();

        Toast.makeText(this, "onResume 호출됨", Toast.LENGTH_LONG).show();
        restoreState();
    }
    protected void restoreState(){
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if( (pref != null)&&(pref.contains("name"))){
            String name = pref.getString("name","");
            nameInput.setText(name);
        }
    }
    protected  void saveState(){
        SharedPreferences pref = getSharedPreferences("pref",Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name",nameInput.getText().toString());
        editor.commit();
    }
    protected void clearState(){
        SharedPreferences pref = getSharedPreferences("pref",Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();

    }

}