package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    EditText editTextNote;
    RadioGroup radioGroupStars;
    Button buttonInsertNote, buttonShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextNote = findViewById(R.id.editTextNote);
        radioGroupStars = findViewById(R.id.radioGroupStars);
        buttonInsertNote = findViewById(R.id.buttonInsertNote);
        buttonShowList = findViewById(R.id.buttonShowList);



        buttonInsertNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = "";
                int stars = 0;


                if(editTextNote.getText().toString().trim().length() != 0){
                    note = editTextNote.getText().toString();
                }
                else{
                    editTextNote.setError("Please enter your revision note");
                }

                if (radioGroupStars.getCheckedRadioButtonId() == -1){
                    Toast.makeText(MainActivity.this, "Please select the amount of star(s)", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (radioGroupStars.getCheckedRadioButtonId() == R.id.radio1){
                        stars = 1;
                    }
                    else if (radioGroupStars.getCheckedRadioButtonId() == R.id.radio2){
                        stars = 2;
                    }
                    else if (radioGroupStars.getCheckedRadioButtonId() == R.id.radio3){
                        stars = 3;
                    }
                    else if (radioGroupStars.getCheckedRadioButtonId() == R.id.radio4){
                        stars = 4;
                    }
                    else if (radioGroupStars.getCheckedRadioButtonId() == R.id.radio5){
                        stars = 5;
                    }

                }//end of radio group validation



                DBHelper db = new DBHelper(MainActivity.this);
                // Insert a task
                db.insertNote(note, stars);
                db.close();

                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();

            }
        });//end of buttonInsertNote


        buttonShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });//end of buttonShowList



    }//end of onCreate

}//end of class
