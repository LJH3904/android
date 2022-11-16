package org.techtown.misson_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText_login_Id,editText_login_Password;
    public static final int MainActivity_signal = 1;
    public static final String MainActivity_DATA = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        editText_login_Id = findViewById(R.id.editText_login_Id);
        editText_login_Password = findViewById(R.id.editText_login_Password);

        Button button = findViewById(R.id.button_login_Login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText_login_Id == null || editText_login_Password == null){
                    Toast.makeText(MainActivity.this, "아이디와 비밀번호를 입력해주세요.", Toast.LENGTH_LONG).show();
                } // 사용자 이름이나 비밀번호가 입력되지 않았을 경우 나오는 토스트 메시지

                Intent login_intent = new Intent(getApplicationContext(),MenuActivity.class);

                startActivity(login_intent);


            }
        });

    }
}