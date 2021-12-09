package gr.athtech.recyclerview;
import gr.athtech.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private RecyclerViewAdapter.Listener callback;


    public RecyclerViewHolder(@NonNull View itemView, RecyclerViewAdapter.Listener callback ) {

        super(itemView);
        this.callback = callback;

    }

    public void bindData(String data, int imgId){

        TextView textView = itemView.findViewById(R.id.item_txt);
        textView.setText(data);


        ImageView item_img = itemView.findViewById(R.id.item_img);
        item_img.setImageResource(imgId);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callback.onItemClick(v,data);

            }
        });


    }
}
