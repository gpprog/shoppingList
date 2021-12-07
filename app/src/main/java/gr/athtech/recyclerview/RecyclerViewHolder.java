package gr.athtech.recyclerview;
import gr.athtech.R;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {


    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
    }


    public void bindData(String data){

        TextView textView = itemView.findViewById(R.id.item_txt);
        textView.setText(data);



    }
}
