package com.example.readfile_2acti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    Spinner spinner_item;
    Button btn_mo, btn_quaylai;
    EditText edt_input;
    ArrayList<String> filesname=new ArrayList<>();
    ArrayAdapter arrayAdapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spinner_item=findViewById(R.id.spinner_select);
        btn_mo=findViewById(R.id.btn_mo);
        btn_quaylai=findViewById(R.id.btn_quaylai);
        edt_input=findViewById(R.id.edt_input);
        loadData();
        btn_mo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref=getSharedPreferences("file",MODE_PRIVATE);
                String data=sharedPref.getString(spinner_item.getSelectedItem().toString(),null);
                if(data!=null){
                    edt_input.setText(data);
                }
            }
        });
        btn_quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    private void loadData(){
        Intent intent=getIntent();
        FilesName filesName=(FilesName) intent.getSerializableExtra("data");
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,filesName.getFilenames());
        spinner_item.setAdapter(arrayAdapter);
    }
}
