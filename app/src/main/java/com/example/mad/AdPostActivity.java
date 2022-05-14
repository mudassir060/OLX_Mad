package com.example.mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class AdPostActivity extends AppCompatActivity {
    EditText titel, description, price, url;
    String email;
    Button SU;
    TextView loginPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_post);
//        getSupportActionBar().hide();
        getSupportActionBar().setTitle("Ad Post");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        titel=findViewById(R.id.edit_titel);
        description=findViewById(R.id.edit_description);
        price=findViewById(R.id.edit_price);
        url=findViewById(R.id.edit_url);
        email = "mudassirmukhtar4@gmail.com";
//        SU=findViewById(R.id.signup);
//        loginPage=findViewById(R.id.v1);
    }
    public void AdPostPage(View view){
//        Intent intent =new Intent(this,AdPostActivity.class);
//        startActivity(intent);
    }    public void HomePage(View view){
        Intent intent =new Intent(this,HomeActivity.class);
        startActivity(intent);
    }    public void ProfilePage(View view){
        Intent intent =new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
    public  void PostNow (View view){
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Posts");
        myRef.addValueEventListener(new ValueEventListener() {
            String E = new Date().toString();

            @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists())
                    {
//                        email.setError("Email Already Exist");
                    }
                    else
                    {
                        String T=titel.getText().toString();
                        String D=description.getText().toString();
                        String P=price.getText().toString();
                        String U=url.getText().toString();
                            myRef.child(E).child("titel").setValue(T);
                            myRef.child(E).child("description").setValue(D);
                            myRef.child(E).child("price").setValue(P);
                            myRef.child(E).child("url").setValue(U);
                            myRef.child(E).child("email").setValue(email);

                        Intent  intent =new Intent(AdPostActivity.this,HomeActivity.class);
                        startActivity(intent);
                            finish();

                    }
                }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

        }

}