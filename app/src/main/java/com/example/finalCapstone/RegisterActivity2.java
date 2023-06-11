package com.example.finalCapstone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity2 extends AppCompatActivity {

    EditText userEmail, userName, userPassword, userCPassword;
    Button register;
    String email,name,password,CPassword;
    TextView back_to_login;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        userEmail = (EditText) findViewById(R.id.userEmail1);
        userName = (EditText) findViewById(R.id.name1);
        userPassword = (EditText) findViewById(R.id.userPassword1);
        userCPassword = (EditText) findViewById(R.id.confirm_password1);
        register = (Button) findViewById(R.id.register_button1);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        back_to_login=findViewById(R.id.registerText);
        back_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(RegisterActivity2.this,MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = userEmail.getText().toString();
                name = userName.getText().toString();
                password = userPassword.getText().toString();
                CPassword = userCPassword.getText().toString();

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // send user to main activity
                            callMainActivity();
                            Toast.makeText(RegisterActivity2.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegisterActivity2.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

    }
    public void callMainActivity()
    {
        Intent mainIntent = new Intent(RegisterActivity2.this, LoginQuestion.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mainIntent);
    }
}