package com.example.noteapmain;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapterRecylerView extends RecyclerView.Adapter<NoteAdapterRecylerView.NoteViewHolder> {

    Context context;
   List<NoteEntity> items;
    public NoteAdapterRecylerView(List<NoteEntity> items,Context context){
        this.items=items;
        this.context=context;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items_recylerview_layout,parent,false);

        return new NoteViewHolder(view);
    }




    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

        NoteEntity note = items.get(position);
        holder.content.setText(note.noteData);
          holder.title.setText(note.title);

          //for updating data
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, addUpdateActivity.class);
                intent.putExtra("id",note.id);
                intent.putExtra("content",note.noteData);
                intent.putExtra("title",note.title);
                context.startActivity(intent);

            }

        });


        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                deleteItem(position,note);
                items.remove(position);
                notifyItemRemoved(position);// Notify the adapter that the item has been removed
                notifyItemRangeChanged(position, items.size());// this will Refresh the view

                // Deleting item from database
                NoteDBHelper noteDBHelper = NoteDBHelper.getdb( context);
                noteDBHelper.noteDao().deleteNoteById(note);
            }
        });
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        TextView content;
        TextView title;
//        Button deleteBtn;
        ImageView update,deleteBtn;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            content=itemView.findViewById(R.id.textcontent);
            title =itemView.findViewById(R.id.textTitle);
            deleteBtn=itemView.findViewById(R.id.deleteItem);
            update=itemView.findViewById(R.id.update);
        }
    }
}
