package gr.athtech.recyclerview;
import gr.athtech.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    interface Listener {

        public void onItemClick(View view , String data );

    }



    @NonNull
    private List<String> arrayData;
    private Listener callback;


    public RecyclerViewAdapter(List<String> arrayData, Listener callback) {


        this.arrayData = arrayData;
        this.callback = callback;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_holder,  parent, false);
        return new RecyclerViewHolder(view,callback);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        String data = arrayData.get(position);
        holder.bindData(data);

    }

    @Override
    public int getItemCount() {
        return arrayData.size() ;
    }
}
