package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setTitle("Profile");
    }
    public void AdPostPage(View view){
        Intent intent =new Intent(this,AdPostActivity.class);
        startActivity(intent);
    }    public void HomePage(View view){
        Intent intent =new Intent(this,HomeActivity.class);
        startActivity(intent);
    }    public void ProfilePage(View view){
//        Intent intent =new Intent(this,ProfileActivity.class);
//        startActivity(intent);
    }
}