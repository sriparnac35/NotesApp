package sriparna.hillhouse.com.notesapp.fragments;


import android.os.Bundle;
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
public class EditNoteFragment extends Fragment {

    private TextView mTitleTextView = null;
    private TextView mDescriptionTextView = null;
    private Button mEditButton = null;
    private Button mCancelButton = null;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_note_view, container, false);
        mTitleTextView = (TextView) view.findViewById(R.id.note_view_title);
        mDescriptionTextView = (TextView) view.findViewById(R.id.note_view_description);

        mEditButton = (Button) view.findViewById(R.id.edit);
        mEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mCancelButton = (Button) view.findViewById(R.id.cancel);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }
}
