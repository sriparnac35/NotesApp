package sriparna.hillhouse.com.notesapp.interfaces;

import sriparna.hillhouse.com.notesapp.NoteModel;

/**
 * Created by sriparna on 26/10/16.
 */
public interface NoteEventListener {
    void onNoteSelected(NoteModel note);
}
