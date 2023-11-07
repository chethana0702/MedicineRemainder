package com.example.dummy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText signup_uname,signup_pwd;
    Button signup_btn;
    String regex="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$&!])[A-Za-z\\d@#$&!]{8,10}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup_uname= findViewById(R.id.txt_username);
        signup_pwd= findViewById(R.id.txt_password);
        signup_btn= findViewById(R.id.btn_signup);
        signup_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String uname= signup_uname.getText().toString();
        String pwd=signup_pwd.getText().toString();
        if(validatePwd(pwd)){
            Toast.makeText(getBaseContext(), "valid password", Toast.LENGTH_LONG).show();
            Bundle bundle = new Bundle();
            bundle.putString("uname",uname);
            bundle.putString("pwd",pwd);
            Intent it = new Intent(this, Login.class);
            it.putExtra("data",bundle);
            startActivity(it);
        }else{
            Toast.makeText(getBaseContext(),"Invalid Password",Toast.LENGTH_LONG).show();
        }
    }

    private boolean validatePwd(String pwd) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pwd);
        return matcher.matches();
    }
}