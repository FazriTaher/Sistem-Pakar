package com.example.kelompok15.pakarAc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class login extends AppCompatActivity {
    private EditText edtEmail, edtPassword;
    private Button btnLogin;
    private TextView btnRegister;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        login();
    }

    private void login() {
        btnRegister.setOnClickListener(view -> startActivity(new Intent(login.this, register.class)));
        btnLogin.setOnClickListener(view -> {
            //menampung imputan user
            final String emailUser = edtEmail.getText().toString().trim();
            final String passwordUser = edtPassword.getText().toString().trim();

            //validasi email dan password
            // jika email kosong
            if (emailUser.isEmpty()) {
                edtEmail.setError("Email tidak boleh kosong");
            }
            // jika email not valid
            else if (!Patterns.EMAIL_ADDRESS.matcher(emailUser).matches()) {
                edtEmail.setError("Email tidak valid");
            }
            // jika password kosong
            else if (passwordUser.isEmpty()) {
                edtPassword.setError("Password tidak boleh kosong");
            }
            //jika password kurang dari 6 karakter
            else if (passwordUser.length() < 6) {
                edtPassword.setError("Password minimal terdiri dari 6 karakter");
            } else {
                auth.signInWithEmailAndPassword(emailUser, passwordUser)
                        .addOnCompleteListener(login.this, task -> {
                            // ketika gagal locin maka akan do something
                            if (!task.isSuccessful()) {
                                Toast.makeText(login.this,
                                        "Gagal login karena " + Objects.requireNonNull(task.getException()).getMessage()
                                        , Toast.LENGTH_LONG).show();
                            } else {
                                Bundle bundle = new Bundle();
                                bundle.putString("email", emailUser);
                                bundle.putString("pass", passwordUser);
                                startActivity(new Intent(login.this, HomeAct.class)
                                        .putExtra("emailpass", bundle));
                                finish();
                            }
                        });
            }
        });
    }

    private void initView() {
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        auth = FirebaseAuth.getInstance();
    }
}