package com.example.proyecto_pc.my_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;
import static android.util.Patterns.EMAIL_ADDRESS;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Switch switchRemember;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        bindUI();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                if(login(email,password)){
                    goToMain();
                }
            }
        });
    }




    private void bindUI(){

        editTextEmail=(EditText) findViewById(R.id.editText_Email);
        editTextPassword=(EditText) findViewById(R.id.editText_Pass);
        switchRemember=(Switch) findViewById(R.id.switch_remember);
        btnLogin=(Button) findViewById(R.id.btn_login);

    }


    private boolean login(String email, String pass){
        if (!isValidEmail(email)) {
            Toast.makeText(this,"Email no es valido",Toast.LENGTH_LONG).show();
            return false;
        }else if (!isValinPassword(pass)){
            Toast.makeText(this,"Contrasena no es valido",Toast.LENGTH_LONG).show();
            return false;
        }else {
            return true;
        }
    }


    private boolean isValidEmail(String email){
        return !isEmpty(email) && EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValinPassword (String password){
        return password.length()>4;
    }

    private void goToMain(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
