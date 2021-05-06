package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView lv;
	ArrayAdapter aa;
	ArrayList<Note> al;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//TODO implement the Custom ListView
		lv = findViewById(R.id.lv);

		Intent i = getIntent();

		DBHelper db = new DBHelper(SecondActivity.this);

		al = db.getAllNotes();

		aa = new RevisionNotesArrayAdapter(this, R.layout.row, al);
		lv.setAdapter(aa);
	}


}
