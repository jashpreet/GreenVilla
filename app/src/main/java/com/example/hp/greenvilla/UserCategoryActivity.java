package com.example.hp.greenvilla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class UserCategoryActivity extends AppCompatActivity {

    private ImageView tShirts, sportsTShirts, femaleDresses, sweathers;
    private ImageView glasses, hatsCaps, walletsBagsPurses, shoes;
    private ImageView headPhonesHandFree, Laptops, watches, mobilePhones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_category);

        tShirts = (ImageView) findViewById(R.id.t_shirts_user);
        sportsTShirts = (ImageView) findViewById(R.id.sports_t_shirts_user);
        femaleDresses = (ImageView) findViewById(R.id.female_dresses_user);
        sweathers = (ImageView) findViewById(R.id.sweathers_user);

        glasses = (ImageView) findViewById(R.id.glasses_user);
        hatsCaps = (ImageView) findViewById(R.id.hats_caps_user);
        walletsBagsPurses = (ImageView) findViewById(R.id.purses_bags_wallets_user);
        shoes = (ImageView) findViewById(R.id.shoes_user);

        headPhonesHandFree = (ImageView) findViewById(R.id.headphones_handfree_user);
        Laptops = (ImageView) findViewById(R.id.laptop_pc_user);
        watches = (ImageView) findViewById(R.id.watches_user);
        mobilePhones = (ImageView) findViewById(R.id.mobilephones_user);

        tShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.hp.greenvilla.UserCategoryActivity.this, com.example.hp.greenvilla.UserCategoryDetail.class);
                intent.putExtra("category", "tShirts");
                startActivity(intent);
            }
        });


        sportsTShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.hp.greenvilla.UserCategoryActivity.this, com.example.hp.greenvilla.UserCategoryDetail.class);
                intent.putExtra("category", "Sports tShirts");
                startActivity(intent);
            }
        });


        femaleDresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.hp.greenvilla.UserCategoryActivity.this, com.example.hp.greenvilla.UserCategoryDetail.class);
                intent.putExtra("category", "Female Dresses");
                startActivity(intent);
            }
        });


        sweathers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.hp.greenvilla.UserCategoryActivity.this, com.example.hp.greenvilla.UserCategoryDetail.class);
                intent.putExtra("category", "Sweathers");
                startActivity(intent);
            }
        });


        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.hp.greenvilla.UserCategoryActivity.this, com.example.hp.greenvilla.UserCategoryDetail.class);
                intent.putExtra("category", "Glasses");
                startActivity(intent);
            }
        });


        hatsCaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.hp.greenvilla.UserCategoryActivity.this, com.example.hp.greenvilla.UserCategoryDetail.class);
                intent.putExtra("category", "Hats Caps");
                startActivity(intent);
            }
        });



        walletsBagsPurses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.hp.greenvilla.UserCategoryActivity.this, com.example.hp.greenvilla.UserCategoryDetail.class );
                intent.putExtra("category", "Wallets Bags Purses");
                startActivity(intent);
            }
        });


        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.hp.greenvilla.UserCategoryActivity.this, com.example.hp.greenvilla.UserCategoryDetail.class);
                intent.putExtra("category", "Shoes");
                startActivity(intent);
            }
        });



        headPhonesHandFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.hp.greenvilla.UserCategoryActivity.this, com.example.hp.greenvilla.UserCategoryDetail.class);
                intent.putExtra("category", "HeadPhones HandFree");
                startActivity(intent);
            }
        });


        Laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.hp.greenvilla.UserCategoryActivity.this, com.example.hp.greenvilla.UserCategoryDetail.class );
                intent.putExtra("category", "Laptops");
                startActivity(intent);
            }
        });


        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.hp.greenvilla.UserCategoryActivity.this, com.example.hp.greenvilla.UserCategoryDetail.class);
                intent.putExtra("category", "Watches");
                startActivity(intent);
            }
        });


        mobilePhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.hp.greenvilla.UserCategoryActivity.this, com.example.hp.greenvilla.UserCategoryDetail.class);
                intent.putExtra("category", "Mobile Phones");
                startActivity(intent);
            }
        });
    }
}
