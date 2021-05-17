package com.example.freshshare;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private Button button;
    private EditText vendor;
    private EditText email;
    private EditText address;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public static boolean IsEmailValid(CharSequence c){
        return !TextUtils.isEmpty(c) && Patterns.EMAIL_ADDRESS.matcher(c).matches();
    }

    public void SignUp(View view){
        vendor = findViewById(R.id.vendor);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        password = findViewById(R.id.password);

        if(vendor.getText().toString().isEmpty()){
            vendor.setError("Please Enter Vendor Name");
            return;
        }
        if(!IsEmailValid(email.getText())){
            email.setError("Please Enter Valid Email");
            return;
        }
        if(address.getText().toString().isEmpty()){
            address.setError("Please Enter address");
            return;
        }
        if(password.getText().toString().isEmpty()){
            password.setError("Please Set Password");
            return;
        }

        Intent intent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();

        startActivity(intent);

    }

}
