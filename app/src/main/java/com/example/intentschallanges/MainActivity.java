package com.example.intentschallanges;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView ivTel;
    ImageView ivweb;
    ImageView ivlocation,ivResource;
    Button btnCreateContact;
    final int OPEN_ACTIVITY=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        hideVectorAssets();
        btnCreateContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,information.class);
                startActivityForResult(i,OPEN_ACTIVITY);

            }
        });

    }
    public void init(){
        ivTel=findViewById(R.id.ivTel);
        ivweb=findViewById(R.id.ivweb);
        ivlocation=findViewById(R.id.ivlocation);
        ivResource=findViewById(R.id.ivResource);
        btnCreateContact=findViewById(R.id.btnCreateContact);

    }
    public void hideVectorAssets() {
        ivTel.setVisibility(View.GONE);
        ivweb.setVisibility(View.GONE);
        ivlocation.setVisibility(View.GONE);
        ivResource.setVisibility(View.GONE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==OPEN_ACTIVITY){
            if(resultCode==RESULT_OK){
                String Name=data.getStringExtra("Name");
                String Number=data.getStringExtra("Number");
                String Website=data.getStringExtra("Website");
                String Location=data.getStringExtra("Location");
                int vectorAssetId = data.getIntExtra("VectorAssetId", 0);
                visibility();
                ivResource.setImageResource(vectorAssetId);
                ivTel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + Number));
                        startActivity(intent);
                    }
                });
                ivweb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://" + Website));

                        startActivity(intent);
                    }
                });
                ivlocation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String location = "latitude,longitude";
                        Uri gmmIntentUri = Uri.parse("geo:" + Location + "?q=" + Location);
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
                    }
                });












            }
        }
    }

    void visibility(){
        ivTel.setVisibility(View.VISIBLE);
        ivweb.setVisibility(View.VISIBLE);
        ivlocation.setVisibility(View.VISIBLE);
        ivResource.setVisibility(View.VISIBLE);

    }
}