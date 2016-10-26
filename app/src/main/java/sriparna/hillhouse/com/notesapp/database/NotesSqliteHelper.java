package sriparna.hillhouse.com.notesapp.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import sriparna.hillhouse.com.notesapp.database.NotesDatabaseConstants;

/**
 * Created by sriparna on 26/10/16.
 */
public class NotesSqliteHelper extends SQLiteOpenHelper {

    private static String CREATE_DATABASE_STATEMENT = "CREATE TABLE " + NotesDatabaseConstants.TABLE_NAME
            + " ( "
            + NotesDatabaseConstants.COLUMN_NAME_ID +" INTEGER AUTOINCREMENT,"
            + NotesDatabaseConstants.TABLE_NAME + " CHAR ,"
            + NotesDatabaseConstants.COLUMN_NAME_DESCRIPTION + " CHAR "
            +" )";

    private static String DROP_DATABASE_STATEMENT = "DROP TABLE IF EXISTS " +  NotesDatabaseConstants.TABLE_NAME;

    public NotesSqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public NotesSqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version,
                             DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DATABASE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //TODO: PROPER DATA MIGRATION

        sqLiteDatabase.execSQL(DROP_DATABASE_STATEMENT);
        sqLiteDatabase.execSQL(CREATE_DATABASE_STATEMENT);
    }
}
