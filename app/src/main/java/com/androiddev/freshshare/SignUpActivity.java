package com.androiddev.freshshare;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.androiddev.freshshare.models.Vendor;
import com.androiddev.freshshare.viewmodels.VendorViewModel;

public class SignUpActivity extends AppCompatActivity {

    private VendorViewModel vendorModel;
    private EditText vendor;
    private EditText email;
    private EditText address;
    private EditText imageURL;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        vendorModel = new VendorViewModel();
        vendor = findViewById(R.id.vendor);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        imageURL = findViewById(R.id.imageURL);
    }

    public static boolean IsEmailValid(CharSequence c){
        return !TextUtils.isEmpty(c) && Patterns.EMAIL_ADDRESS.matcher(c).matches();
    }

    public void SignUp(View view){

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
        if(imageURL.getText().toString().isEmpty()){
            imageURL.setError("Please Set ImageURL");
            return;
        }

        Vendor v = new Vendor(vendor.getText().toString(),address.getText().toString(),
                imageURL.getText().toString(),email.getText().toString());
        vendorModel.addVendor(v);

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }
}
