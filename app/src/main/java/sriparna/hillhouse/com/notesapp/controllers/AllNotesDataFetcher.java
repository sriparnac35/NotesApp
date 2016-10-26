package sriparna.hillhouse.com.notesapp.controllers;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import sriparna.hillhouse.com.notesapp.NoteModel;
import sriparna.hillhouse.com.notesapp.database.NotesDatabaseHandler;
import sriparna.hillhouse.com.notesapp.interfaces.NotesDataFetcher;

/**
 * Created by sriparna on 26/10/16.
 */
public class AllNotesDataFetcher implements NotesDataFetcher {
    //Content Observer not applicable in current app

    private List<NoteModel> mNoteList = null;
    private Context mContext = null;

    public AllNotesDataFetcher(Context context){
        this.mContext = context;
        fetchAllNotes();
    }

    @Override
    public List<NoteModel> fetchAllNotes() {
        if (mNoteList == null){
            NotesDatabaseHandler dbHandler = new NotesDatabaseHandler(mContext);
            mNoteList = dbHandler.getAllNotes();
        }

        return mNoteList;
    }
}
