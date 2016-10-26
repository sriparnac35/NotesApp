package sriparna.hillhouse.com.notesapp;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sriparna.hillhouse.com.notesapp.controllers.AllNotesDataFetcher;
import sriparna.hillhouse.com.notesapp.fragments.AllNotesFragment;
import sriparna.hillhouse.com.notesapp.fragments.CreateNewNoteFragment;
import sriparna.hillhouse.com.notesapp.fragments.EditNoteFragment;
import sriparna.hillhouse.com.notesapp.interfaces.NoteCreationListener;
import sriparna.hillhouse.com.notesapp.interfaces.NoteEventListener;

public class MainActivity extends AppCompatActivity implements NoteCreationListener, NoteEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();

        AllNotesFragment fragment = new AllNotesFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(android.R.id.content, fragment, null);
        transaction.commit();

    }

    @Override
    public void createNewNode() {
        CreateNewNoteFragment fragment = new CreateNewNoteFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(android.R.id.content, fragment, null);
        transaction.addToBackStack("");
        transaction.commit();
    }

    @Override
    public void onNoteSelected(NoteModel note) {
        EditNoteFragment fragment = new EditNoteFragment();
        android.support.v4.app.FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        transaction.add(android.R.id.content, fragment, null);
        transaction.addToBackStack("");
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager.getBackStackEntryCount() > 0){
            fragmentManager.popBackStack();
        }

        super.onBackPressed();
    }
}
