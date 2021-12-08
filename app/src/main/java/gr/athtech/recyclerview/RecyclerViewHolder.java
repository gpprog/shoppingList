package gr.athtech.recyclerview;
import gr.athtech.R;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private RecyclerViewAdapter.Listener callback;


    public RecyclerViewHolder(@NonNull View itemView, RecyclerViewAdapter.Listener callback ) {

        super(itemView);
        this.callback = callback;

    }




    public void bindData(String data){

        TextView textView = itemView.findViewById(R.id.item_txt);
        textView.setText(data);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callback.onItemClick(v,data);




            }
        });


    }
}
