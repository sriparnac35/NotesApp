package sriparna.hillhouse.com.notesapp;

/**
 * Created by sriparna on 26/10/16.
 */
public class NoteModel {

    public static final int INVALID_ID = -1;

    private int mID = INVALID_ID;
    private String mTitle = "";
    private String mDescription = "";


    public NoteModel(int id, String title, String description){
        this.mID = id;
        this.mTitle = title;
        this.mDescription = description;
    }

    //Getters

    public int getID(){
        return mID;
    }

    public String getTitle(){
        return mTitle;
    }

    public String getDescription(){
        return mDescription;
    }

    //setters

    public void setTitle(String title){
        this.mTitle = title;
    }

    public void setDescription(String description){
        this.mDescription = description;
    }

}
