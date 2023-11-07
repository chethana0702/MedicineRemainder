package com.example.dummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dummy.R;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText LoginUsername,LoginPassword;
    Button btnLogin;
    String user,pass;
    int count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginUsername=(EditText) findViewById(R.id.login_username);
        LoginPassword=(EditText) findViewById(R.id.login_password);
        btnLogin=(Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        Bundle bundle=getIntent().getBundleExtra("data");
        user=bundle.getString("uname");
        pass=bundle.getString("pwd");
    }


    @Override
    public void onClick(View view) {
        String user1=LoginUsername.getText().toString();
        String pass1=LoginPassword.getText().toString();
        if((user.equals(user1)) && (pass.equals(pass1)))
        {
            startActivity(new Intent(this,medicine.class));
            Toast.makeText(this,"login successful",Toast.LENGTH_LONG).show();

        }
        else
        {
            count++;
            if(count==3)
            {
                btnLogin.setEnabled(false);
                Toast.makeText(this,"Failed login attempts",Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this,"login failed "+count,Toast.LENGTH_LONG).show();
            }
        }
    }
}
