package com.example.mad;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText edit_name,edit_email,edit_password;
    TextView view_name,view_email,view_password, AlreadySignIn;
    Button signup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
        edit_name = findViewById(R.id.edit_name);
        edit_email = findViewById(R.id.edit_email);
        edit_password = findViewById(R.id.edit_password);
        view_name = findViewById(R.id.view_name);
        view_email = findViewById(R.id.view_email);
        view_password = findViewById(R.id.view_password);
        signup = findViewById(R.id.btn_signup);
        AlreadySignIn = findViewById(R.id.AlreadySignIn);
        DB = new DBHelper(this);
        Intent intent =new Intent(this,HomeActivity.class);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameText = edit_name.getText().toString();
                String emailText = edit_email.getText().toString();
                String passwordText = edit_password.getText().toString();
                Boolean insert= DB.insertuserdata(nameText, emailText, passwordText);
                if (insert==true){
                    Toast.makeText(SignUpActivity.this, "New Entry inserted", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }else {
                    Toast.makeText(SignUpActivity.this, "New Entry Not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public  void SetVal(View view){
        view_name.setText("Your Name is: " +edit_name.getText().toString());
        view_email.setText("Your email is: " +edit_email.getText().toString());
        view_password.setText("Your Password is: " +edit_password.getText().toString());
    }
    public void NavigateLogin(View view){
        Intent intent =new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}