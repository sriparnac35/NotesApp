package sriparna.hillhouse.com.notesapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import sriparna.hillhouse.com.notesapp.NoteModel;

/**
 * Created by sriparna on 26/10/16.
 */
public class NotesDatabaseHandler {
    private NotesSqliteHelper mSqliteHelper = null;

    public  NotesDatabaseHandler(Context context){
        mSqliteHelper = new NotesSqliteHelper(context, NotesDatabaseConstants.TABLE_NAME, null,
                NotesDatabaseConstants.CURRENT_DATABASE_VERSION);
    }

    public void createNewNote(NoteModel note){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotesDatabaseConstants.COLUMN_NAME_TITLE, note.getTitle());
        contentValues.put(NotesDatabaseConstants.COLUMN_NAME_DESCRIPTION, note.getDescription());

        mSqliteHelper.getWritableDatabase().insert(NotesDatabaseConstants.TABLE_NAME, null, contentValues);

    }

    public void editNote(NoteModel note){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotesDatabaseConstants.COLUMN_NAME_TITLE, note.getTitle());
        contentValues.put(NotesDatabaseConstants.COLUMN_NAME_DESCRIPTION, note.getDescription());

        mSqliteHelper.getWritableDatabase().update(NotesDatabaseConstants.TABLE_NAME,
                contentValues,
                NotesDatabaseConstants.COLUMN_NAME_ID + " = " ,
                new String[]{new Integer(note.getID()).toString()});


    }

    public void deleteNote(NoteModel note){

        mSqliteHelper.getWritableDatabase().delete(NotesDatabaseConstants.TABLE_NAME,
                NotesDatabaseConstants.COLUMN_NAME_ID + " = ",
                new String[] {new Integer(note.getID()).toString()});
    }

    public List<NoteModel> getAllNotes(){
        Cursor cursor = mSqliteHelper.getReadableDatabase().query(NotesDatabaseConstants.TABLE_NAME, null,
                null, null, null, null, null);
        List<NoteModel> result = new ArrayList<>();

        if (cursor != null && cursor.getCount() > 0){
            int idColumnIndex = cursor.getColumnIndex(NotesDatabaseConstants.COLUMN_NAME_ID);
            int titleColumnIndex = cursor.getColumnIndex(NotesDatabaseConstants.COLUMN_NAME_TITLE);
            int descriptionColumnIndex = cursor.getColumnIndex(NotesDatabaseConstants.COLUMN_NAME_DESCRIPTION);

            while (cursor.moveToNext()){
                int id = cursor.getInt(idColumnIndex);
                String title = cursor.getString(titleColumnIndex);
                String description = cursor.getString(descriptionColumnIndex);

                NoteModel note = new NoteModel(id, title, description);
                result.add(note);
            }
        }
        return result;

    }
}
