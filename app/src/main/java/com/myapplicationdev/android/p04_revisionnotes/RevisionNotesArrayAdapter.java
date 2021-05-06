package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class RevisionNotesArrayAdapter extends ArrayAdapter<Note> {
	Context context;
	ArrayList<Note> notes;
	ImageView iv1, iv2, iv3, iv4, iv5;
	TextView textViewNote;


	public RevisionNotesArrayAdapter(Context context, int resource, ArrayList<Note> objects) {
		super(context, resource, objects);
		this.notes = objects;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(R.layout.row, parent, false);

		//Match the UI components with Java variables
		textViewNote = rowView.findViewById(R.id.textViewNote);
		iv1 = rowView.findViewById(R.id.imageView1star);
		iv2 = rowView.findViewById(R.id.imageView2star);
		iv3 = rowView.findViewById(R.id.imageView3star);
		iv4 = rowView.findViewById(R.id.imageView4star);
		iv5 = rowView.findViewById(R.id.imageView5star);


		Note note = notes.get(position);
		int stars = note.getStars();

		//Check if the property for starts >= 5, if so, "light" up the stars
		if (stars == 0) {
			iv5.setImageResource(android.R.drawable.btn_star_big_off);
			iv4.setImageResource(android.R.drawable.btn_star_big_off);
			iv3.setImageResource(android.R.drawable.btn_star_big_off);
			iv2.setImageResource(android.R.drawable.btn_star_big_off);
			iv1.setImageResource(android.R.drawable.btn_star_big_off);
		}else if (stars == 1) {
			iv5.setImageResource(android.R.drawable.btn_star_big_off);
			iv4.setImageResource(android.R.drawable.btn_star_big_off);
			iv3.setImageResource(android.R.drawable.btn_star_big_off);
			iv2.setImageResource(android.R.drawable.btn_star_big_off);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		}else if (stars == 2) {
			iv5.setImageResource(android.R.drawable.btn_star_big_off);
			iv4.setImageResource(android.R.drawable.btn_star_big_off);
			iv3.setImageResource(android.R.drawable.btn_star_big_off);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		}else if (stars == 3) {
			iv5.setImageResource(android.R.drawable.btn_star_big_off);
			iv4.setImageResource(android.R.drawable.btn_star_big_off);
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		}else if (stars == 4) {
			iv5.setImageResource(android.R.drawable.btn_star_big_off);
			iv4.setImageResource(android.R.drawable.btn_star_big_on);
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		}else if (stars == 5) {
			iv5.setImageResource(android.R.drawable.btn_star_big_on);
			iv4.setImageResource(android.R.drawable.btn_star_big_on);
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		}

		textViewNote.setText(note.getNoteContent());

		return rowView;
	}



}
