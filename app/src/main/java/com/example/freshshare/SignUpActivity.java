package com.example.freshshare;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.freshshare.models.Vendor;
import com.example.freshshare.viewmodels.VendorViewModel;
import com.google.android.material.navigation.NavigationView;

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
        imageURL = findViewById(R.id.imageURl);
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
