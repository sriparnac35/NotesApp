package sriparna.hillhouse.com.notesapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import sriparna.hillhouse.com.notesapp.R;
import sriparna.hillhouse.com.notesapp.adapters.NotesListAdapter;
import sriparna.hillhouse.com.notesapp.controllers.AllNotesDataFetcher;
import sriparna.hillhouse.com.notesapp.interfaces.NoteEventListener;
import sriparna.hillhouse.com.notesapp.interfaces.NotesDataFetcher;

/**
 * Created by sriparna on 26/10/16.
 */
public class AllNotesFragment extends Fragment {
    private RecyclerView mRecyclerView = null;
    private RecyclerView.Adapter mAdapter = null;
    private NotesDataFetcher mDataFetcher = null;
    private NoteEventListener mNoteEventListener = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof NoteEventListener){
            mNoteEventListener = (NoteEventListener)context;
        }
        else{
            throw new RuntimeException("Activity hosting AllNotesFragment should implement NoteEventListener");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_notes_layout, container,false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.notes_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));

        mDataFetcher = new AllNotesDataFetcher(getActivity());
        mAdapter = new NotesListAdapter(LayoutInflater.from(getActivity()), mDataFetcher, mNoteEventListener);

        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }
}
