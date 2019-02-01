package com.kudzai.stockapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etDate,etitem,etOpening,etpurchases,ettransfers,etclosing,etAddit_info ;
    Button btnAdd,btnView;
    DatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etDate = (EditText) findViewById(R.id.etDate);
        etitem = (EditText) findViewById(R.id.edItem);
        etOpening = (EditText) findViewById(R.id.etOpening);
        etpurchases = (EditText) findViewById(R.id.purchases);
        ettransfers = (EditText) findViewById(R.id.transfers);
        etclosing = (EditText) findViewById(R.id.etclosing);
        etAddit_info = (EditText) findViewById(R.id.etaddit_info);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        myDB = new DatabaseHelper(this);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewListContents.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = etDate.getText().toString();
                String item = etitem.getText().toString();
                String opening = etOpening.getText().toString();
                String purchases = etpurchases.getText().toString();
                String transfers = ettransfers.getText().toString();
                String closing = etclosing.getText().toString();
                String addit_info = etAddit_info.getText().toString();
                if(date.length() != 0 && item.length() != 0 && opening.length() != 0 && purchases.length() != 0
                        && transfers.length() != 0 && closing.length() != 0 && addit_info.length() != 0)
                {
                    AddData(date,item,opening,purchases,transfers,closing,addit_info);
                    etDate.setText("");
                    etitem.setText("");
                    etOpening.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"You must put something in the text field!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void AddData(String date,String item, String opening ,String purchases,String transfers,String closing,String addit_info){
        boolean insertData = myDB.addData(date,item,opening,purchases,transfers,closing,addit_info);

        if(insertData==true){
            Toast.makeText(MainActivity.this,"Successfully Entered Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this,"Something went wrong :(.",Toast.LENGTH_LONG).show();
        }
    }
}
