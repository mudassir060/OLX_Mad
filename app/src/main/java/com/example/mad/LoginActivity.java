package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
public class LoginActivity extends AppCompatActivity {
//    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
//        DB = new DBHelper(this);
//        Intent intent =new Intent(this,HomeActivity.class);
    }
    public  void SetVal(View view){
        TextView setf_name = findViewById(R.id.Textf_name);
        TextView set_password = findViewById(R.id.Textage);
        EditText editTextF_Name = findViewById(R.id.editTextemail);
        EditText editText_password = findViewById(R.id.editTextage);
        setf_name.setText("Your Father Name is: " +editTextF_Name.getText().toString());
        set_password.setText("Your Password is: " +editText_password.getText().toString());
    }
    public void OpenSignup(View view){
        Intent intent =new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }
    public void SignIn(View view){
//        Cursor res = DB.view();
//        if (res.getCount()==0){
//            Toast.makeText(this, "NO Entry exist", Toast.LENGTH_SHORT).show();
//        }
//        StringBuffer buffer = new StringBuffer();
//        while (res.moveToLast()){
//            buffer.append("Name"+ res.getString(0)+"\n");
//            buffer.append("Email"+ res.getString(1)+"\n");
//            buffer.append("{Password}"+ res.getString(2)+"\n\n");
//        }
//        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//        builder.setCancelable(true);
//        builder.setTitle("user entries");
//        builder.setMessage(buffer.toString());
//        builder.show();
//        EditText editTextF_Name = findViewById(R.id.editTextemail);
//        EditText editText_password = findViewById(R.id.editTextage);
//        if (editTextF_Name.getText().toString() == "xyz@gmail.com"||editText_password.getText().toString() == "qwerty"){
//            Intent  intent =new Intent(this,Signup_activity.class);
//            startActivity(intent);
//        }else {
        Intent  intent =new Intent(this,AdPostActivity.class);
        startActivity(intent);
//        }
    }
}