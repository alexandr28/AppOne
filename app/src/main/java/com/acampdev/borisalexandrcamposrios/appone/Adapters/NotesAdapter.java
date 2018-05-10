package com.acampdev.borisalexandrcamposrios.appone.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.acampdev.borisalexandrcamposrios.appone.POJOS.Note;
import com.acampdev.borisalexandrcamposrios.appone.R;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private Context context;
    private List<Note> noteList;

    public  NotesAdapter(Context context, List<Note> noteList){
        this.context=context;
        this.noteList=noteList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.id.setText(String.valueOf(noteList.get(position).getId()));
        holder.title.setText(noteList.get(position).getTitle());
        holder.body.setText(noteList.get(position).getBody());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView id;
        TextView title;
        TextView body;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView.findViewById(R.id.cardView);
            id= (TextView) itemView.findViewById(R.id.id);
            title= (TextView) itemView.findViewById(R.id.title_cardview);
            body= (TextView) itemView.findViewById(R.id.body_cardview);
            imageView= (ImageView) itemView.findViewById(R.id.trash);
        }
    }
}
