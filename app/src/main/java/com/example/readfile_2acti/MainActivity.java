package com.example.readfile_2acti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    EditText edt_input,edt_filename;
    Button btn_nhapmoi,btn_luu,btn_goiact2;
    FilesName filenames=new FilesName();
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_input=findViewById(R.id.edt_input);
        edt_filename=findViewById(R.id.edt_filename);
        btn_luu=findViewById(R.id.btn_luu);
        btn_goiact2=findViewById(R.id.btn_goi_act2);
        btn_nhapmoi=findViewById(R.id.btn_nhapmoi);
        btn_nhapmoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_filename.setText("");
                edt_input.setText("");
            }
        });
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,filenames.getFilenames());
        btn_goiact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("data",filenames);
                startActivity(intent);

            }
        });
        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename=edt_filename.getText().toString();
                filenames.getFilenames().add(filename);
                SharedPreferences sharedPref=getSharedPreferences("file",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPref.edit();
                editor.putString(edt_filename.getText().toString(),edt_input.getText().toString());
                editor.commit();

            }
        });
    }
}
