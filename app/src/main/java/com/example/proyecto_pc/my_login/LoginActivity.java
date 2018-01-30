package com.example.proyecto_pc.my_login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;
import static android.util.Patterns.EMAIL_ADDRESS;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences prefs;


    private EditText editTextEmail;
    private EditText editTextPassword;
    private Switch switchRemember;
    private Button btnLogin;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindUI();
        prefs=getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        setCredentialsIfExits();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                if(login(email,password)){
                    goToMain();
                    saveOnPrefenrences(email,password);
                }
            }
        });
    }

    private void setCredentialsIfExits(){
       String email=getUserMailPrefs();
       String password=getUserPassPrefs();
       if (!TextUtils.isEmpty(email) &&!TextUtils.isEmpty(password)){
           editTextEmail.setText(email);
           editTextPassword.setText(password);
       }
    }

    private String getUserMailPrefs(){
        return prefs.getString("email","");
    }
    private String getUserPassPrefs(){
        return prefs.getString("password","");
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


    private void saveOnPrefenrences(String email,String Password){
        if (switchRemember.isChecked()){
            SharedPreferences.Editor editor=prefs.edit();
            editor.putString("email",email);
            editor.putString("password",Password);
            editor.apply();

        }
    }

    private boolean isValidEmail(String email){
        return !isEmpty(email) && EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValinPassword (String password){
        return password.length()>=4;
    }

    private void goToMain(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }



}
