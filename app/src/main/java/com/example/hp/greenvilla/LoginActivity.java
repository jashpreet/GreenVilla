package com.example.hp.greenvilla;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hp.greenvilla.Admin.AdminCategoryActivity;
import com.example.hp.greenvilla.Model.Users;
import com.example.hp.greenvilla.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private EditText InputNumber, InputPassword;
    private Button LoginButton;
    private ProgressDialog loadingBar;
    private TextView AdminLink, NotAdminLink, ForgetPasswordLink;

    private String parentDbName = "Users";
//    private CheckBox chkBoxRememberMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginButton = (Button) findViewById(R.id.login_btn);
        InputPassword = (EditText) findViewById(R.id.login_password_input);
        InputNumber = (EditText) findViewById(R.id.login_number_input);
        AdminLink = (TextView) findViewById(R.id.admin_panel_link);
        NotAdminLink = (TextView) findViewById(R.id.not_admin_panel_link);
        ForgetPasswordLink = findViewById(R.id.forget_password_link);
        loadingBar = new ProgressDialog(this);

//        chkBoxRememberMe = findViewById(R.id.remember_me_chkb);
//        Paper.init(this);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                LoginUser();
            }
        });

        ForgetPasswordLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.hp.greenvilla.LoginActivity.this, com.example.hp.greenvilla.ResetPasswordActivity.class);
                intent.putExtra("check", "login");
                startActivity(intent);
            }
        });

        AdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                LoginButton.setText("Login Admin");
                AdminLink.setVisibility(View.INVISIBLE);
                NotAdminLink.setVisibility(View.VISIBLE);
                parentDbName = "Admins";
            }
        });

        NotAdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                LoginButton.setText("Login");
                AdminLink.setVisibility(View.VISIBLE);
                NotAdminLink.setVisibility(View.INVISIBLE);
                parentDbName = "Users";
            }
        });
    }


    private void LoginUser()
    {
        String number = InputNumber.getText().toString();
        String password = InputPassword.getText().toString();

        if (TextUtils.isEmpty(number))
        {
            Toast.makeText(this, "Please write your number...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Please write your password...", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBar.setTitle("Login Account");
            loadingBar.setMessage("Please wait, while we are checking the credentials.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();


            AllowAccessToAccount(number, password);
        }
    }



    private void AllowAccessToAccount(final String number, final String password)
    {
//        if(chkBoxRememberMe.isChecked())
//        {
//            Paper.book().write(Prevalent.UserPhoneKey, number);
//            Paper.book().write(Prevalent.UserPasswordKey, password);
//        }


        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();


        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {

                if (dataSnapshot.child(parentDbName).child(number).exists())
                {
                    Users usersData = dataSnapshot.child(parentDbName).child(number).getValue(Users.class);
                    Log.e("TAG", "stop 1:" + usersData.getNumber());
                    Log.e("TAG", "stop 1:" + usersData.getPassword());

                    //if (usersData.getNumber().equals(number))
                    //{
                        Log.e("TAG", "stop 2");
                        if (usersData.getPassword().equals(password))
                        {
                            Log.e("TAG", "stop 3");
                            if (parentDbName.equals("Admins"))
                            {
                                Toast.makeText(com.example.hp.greenvilla.LoginActivity.this, "Welcome Admin, you are logged in Successfully...", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(com.example.hp.greenvilla.LoginActivity.this, AdminCategoryActivity.class);
                                startActivity(intent);
                            }
                            else if (parentDbName.equals("Users"))
                            {
                                Log.e("TAG", "stop 4");
                                Toast.makeText(com.example.hp.greenvilla.LoginActivity.this, "logged in Successfully...", Toast.LENGTH_SHORT).show();
                                Log.e("TAG", "stop 5");
                                loadingBar.dismiss();

                                Intent intent = new Intent(com.example.hp.greenvilla.LoginActivity.this, com.example.hp.greenvilla.HomeActivity.class);
                                Prevalent.currentOnlineUser = usersData;
                                startActivity(intent);
                            }
                      //  }
                        else
                        {
                            loadingBar.dismiss();
                            Toast.makeText(com.example.hp.greenvilla.LoginActivity.this, "Password is incorrect.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else
                {
                    Toast.makeText(com.example.hp.greenvilla.LoginActivity.this, "Account with this " + number + " does not exist.", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}