package com.example.kelompok15.pakarAc;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class register extends AppCompatActivity {

    private EditText edtEmail,edtPassword;
    private Button btnRegister;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
        registerUser();
    }

    private void registerUser() {
        btnRegister.setOnClickListener(view -> {
            //menampung imputan user
            String emailUser = edtEmail.getText().toString().trim();
            String passwordUser = edtPassword.getText().toString().trim();

            //validasi email dan password
            // jika email kosong
            if (emailUser.isEmpty()){
                edtEmail.setError("Email tidak boleh kosong");
            }
            // jika email not valid
            else if (!Patterns.EMAIL_ADDRESS.matcher(emailUser).matches()){
                edtEmail.setError("Email tidak valid");
            }
            // jika password kosong
            else if (passwordUser.isEmpty()){
                edtPassword.setError("Password tidak boleh kosong");
            }
            //jika password kurang dari 6 karakter
            else if (passwordUser.length() < 6){
                edtPassword.setError("Password minimal terdiri dari 6 karakter");
            }
            else {
                //create user dengan firebase auth
                auth.createUserWithEmailAndPassword(emailUser,passwordUser)
                        .addOnCompleteListener(register.this, task -> {
                            //jika gagal register do something
                            if (!task.isSuccessful()){
                                Toast.makeText(register.this,
                                        "Register gagal karena "+ Objects.requireNonNull(task.getException()).getMessage(),
                                        Toast.LENGTH_LONG).show();
                            }else {
                                //jika sukses akan menuju ke login activity
                                startActivity(new Intent(register.this,login.class));
                            }
                        });
            }
        });
    }

    private void initView() {
        edtEmail = findViewById(R.id.edt_email_register);
        edtPassword = findViewById(R.id.edt_password_register);
        btnRegister = findViewById(R.id.btn_sign_up);
        auth = FirebaseAuth.getInstance();
    }
}