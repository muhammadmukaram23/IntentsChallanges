package com.example.intentschallanges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class information extends AppCompatActivity {
    EditText etname,etnumber,etwebsite,etlocation;
    ImageView ivhappy,ivsad,ivmoodbad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        init();
        ivhappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name=etname.getText().toString().trim();
                String Number=etnumber.getText().toString().trim();
                String Website=etwebsite.getText().toString().trim();
                String Location=etlocation.getText().toString().trim();
                int vectorAssetId = R.drawable.round_mood_24;


                if(!Name.isEmpty()&&!Number.isEmpty()&&!Website.isEmpty()&&!Location.isEmpty()){
                    Intent i=new Intent();
                    i.putExtra("Name",Name);
                    i.putExtra("Number",Number);
                    i.putExtra("Website",Website);
                    i.putExtra("Location",Location);
                    i.putExtra("VectorAssetId", vectorAssetId);


                    setResult(RESULT_OK,i);
                    finish();
                }else{
                    Toast.makeText(information.this, "Enter the fields", Toast.LENGTH_SHORT).show();
                }


            }
        });

        ivsad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name=etname.getText().toString().trim();
                String Number=etnumber.getText().toString().trim();
                String Website=etwebsite.getText().toString().trim();
                String Location=etlocation.getText().toString().trim();
                int vectorAssetId = R.drawable.baseline_outlet_24;

                if(!Name.isEmpty()&&!Number.isEmpty()&&!Website.isEmpty()&&!Location.isEmpty()){
                    Intent i=new Intent();
                    i.putExtra("Name",Name);
                    i.putExtra("Number",Number);
                    i.putExtra("Website",Website);
                    i.putExtra("Location",Location);
                    i.putExtra("VectorAssetId", vectorAssetId);


                    setResult(RESULT_OK,i);
                    finish();
                }else{
                    Toast.makeText(information.this, "Enter the fields", Toast.LENGTH_SHORT).show();
                }


            }
        });

        ivmoodbad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name=etname.getText().toString().trim();
                String Number=etnumber.getText().toString().trim();
                String Website=etwebsite.getText().toString().trim();
                String Location=etlocation.getText().toString().trim();
                int vectorAssetId = R.drawable.baseline_mood_bad_24;

                if(!Name.isEmpty()&&!Number.isEmpty()&&!Website.isEmpty()&&!Location.isEmpty()){
                    Intent i=new Intent();
                    i.putExtra("Name",Name);
                    i.putExtra("Number",Number);
                    i.putExtra("Website",Website);
                    i.putExtra("Location",Location);
                    i.putExtra("VectorAssetId", vectorAssetId);


                    setResult(RESULT_OK,i);
                    finish();
                }else{
                    Toast.makeText(information.this, "Enter the fields", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
    public void init(){
        etname=findViewById(R.id.etname);
        etnumber=findViewById(R.id.etnumber);
        etwebsite=findViewById(R.id.etwebsite);
        etlocation=findViewById(R.id.etlocation);
        ivhappy=findViewById(R.id.ivhappy);
        ivsad=findViewById(R.id.ivsad);
        ivmoodbad=findViewById(R.id.ivmoodbad);
    }
}