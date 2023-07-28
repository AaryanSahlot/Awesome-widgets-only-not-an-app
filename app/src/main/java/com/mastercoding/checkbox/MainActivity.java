package com.mastercoding.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox box1,box2;
    Button btn1;
//    RadioButton radioButton1,radioButton2;   // we will not initiate these here because we will create a class RadioButton and make object radiobutton
                                                //    to pointout our both radiobuttons or to initiate the radiobutton of radiogroup whichever is clicked
    RadioGroup radioGroup1;
    Spinner spinner;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for checkbox
        box1=findViewById(R.id.checkbox1);
        box2=findViewById(R.id.checkbox2);
        btn1=findViewById(R.id.btn);

        // for radiobutton
        radioGroup1=findViewById(R.id.radioGroup);

        //for spinner
        spinner=findViewById(R.id.spinner);

        //for Time Picker
        timePicker=findViewById(R.id.timepicker);
//        timePicker.setIs24HourView(true);
        timePicker.setIs24HourView(false);


        // for radiobutton
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {     //radiogroup dabane per kya hoga
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked) {          // oncheckedchange method radio group k har radio button ko access ker sakte hai
                                                                                            // or har radio button ko access karainge iss "int checked" sai or iska naam bhi change ker sakte hai

                RadioButton radioButton=findViewById(checked);          // initiating every radio button when it is clicked
                                                                        // ye RadioButton naam ki ek class banai iss radio group k aandar
                                                                        // aab ek object banaya jo initiate karega radio group k radio buttons ko
                                                                        // " jonsa bhi checked hua hoga "
                Toast.makeText(MainActivity.this,
                        ""+radioButton.getText()+" is Checked", Toast.LENGTH_LONG).show();
            }
        });


        //for spinner
        //data set/source
        String[] cources = {"C++", "Java", "Python", "Data Structure"};  // this is the data source of spinner now we will connect the data source to spinner

        //adapter
        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_spinner_item,cources);

        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(ad);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        "You Select: "+cources[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // for checkbox
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //for time picker
                String cuttentTime="Time: "+timePicker.getCurrentHour()+" : "+timePicker.getCurrentMinute();
                Toast.makeText(getApplicationContext(),
                        ""+cuttentTime, Toast.LENGTH_SHORT).show();

                if (box1.isChecked()){
                    Toast.makeText(MainActivity.this, "Apple is Clicked", Toast.LENGTH_SHORT).show();
                }
                else{

                }

                if (box2.isChecked()) {
                    Toast.makeText(MainActivity.this, "Mango is Clicked", Toast.LENGTH_SHORT).show();
                }
                else{

                }

                Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });



    }
}