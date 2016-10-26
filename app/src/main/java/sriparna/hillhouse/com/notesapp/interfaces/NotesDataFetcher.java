package sriparna.hillhouse.com.notesapp.interfaces;

import java.util.List;

import sriparna.hillhouse.com.notesapp.NoteModel;

/**
 * Created by sriparna on 26/10/16.
 */
public interface NotesDataFetcher {
    //TODO: implement pagination
    public List<NoteModel> fetchAllNotes();
}
