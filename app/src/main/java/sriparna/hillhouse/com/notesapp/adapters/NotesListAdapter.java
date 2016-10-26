package sriparna.hillhouse.com.notesapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sriparna.hillhouse.com.notesapp.NoteModel;
import sriparna.hillhouse.com.notesapp.R;
import sriparna.hillhouse.com.notesapp.interfaces.NoteEventListener;
import sriparna.hillhouse.com.notesapp.interfaces.NotesDataFetcher;

/**
 * Created by sriparna on 26/10/16.
 */
public class NotesListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private LayoutInflater mInflater = null;
    private NotesDataFetcher mDataFetcher = null;
    private NoteEventListener mEventListener = null;

    public NotesListAdapter(LayoutInflater inflater, NotesDataFetcher dataFetcher,
                            NoteEventListener eventListener){
        mInflater = inflater;
        mDataFetcher = dataFetcher;
        mEventListener = eventListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.note_item, parent);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        NoteModel note = mDataFetcher.fetchAllNotes().get(position);
        holder.populate(note.getTitle(), note.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEventListener.onNoteSelected(mDataFetcher.fetchAllNotes().get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataFetcher.fetchAllNotes().size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder{

    private TextView mTitleView = null;
    private TextView mDescription = null;

    public ViewHolder(View itemView) {
        super(itemView);
        mTitleView = (TextView) itemView.findViewById(R.id.note_title);
        mDescription = (TextView) itemView.findViewById(R.id.note_description);
    }

    public void populate(String title, String description){
        mTitleView.setText(title);
        mDescription.setText(description);
    }
}


