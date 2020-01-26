package com.example.mybrary.ui.myWishes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mybrary.R;
import java.util.List;

public class MyAdapterWishes  extends RecyclerView.Adapter<MyAdapterWishes.MyViewHolder> {
   private List<Wishes> mWishes;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        CardView cardView;
        TextView title;
        TextView autor;
        Button delete;
        public MyViewHolder(View v) {
            super(v);
            cardView =  v.findViewById(R.id.cardview);
            title =  v.findViewById(R.id.wish_title);
            autor =  v.findViewById(R.id.wish_autor);
            delete  = v.findViewById(R.id.btn_deleete);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapterWishes(List<Wishes> wishes) {
        this.mWishes = wishes;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapterWishes.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.title.setText(mWishes.get(position).title);
        holder.autor.setText(mWishes.get(position).autor);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mWishes.size();
    }
}