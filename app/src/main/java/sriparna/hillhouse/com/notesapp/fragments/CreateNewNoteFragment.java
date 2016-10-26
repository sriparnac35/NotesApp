package sriparna.hillhouse.com.notesapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import sriparna.hillhouse.com.notesapp.R;

/**
 * Created by sriparna on 26/10/16.
 */
public class CreateNewNoteFragment extends Fragment {
    private TextView mTitleTextView = null;
    private TextView mDescriptionTextView = null;
    private Button mSubmitButton = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.new_note_view, container, false);
       mTitleTextView = (TextView) view.findViewById(R.id.note_view_title);
       mDescriptionTextView = (TextView) view.findViewById(R.id.note_view_description);

       mSubmitButton = (Button) view.findViewById(R.id.save);
       mSubmitButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

           }
       });

       return view;
    }
}
