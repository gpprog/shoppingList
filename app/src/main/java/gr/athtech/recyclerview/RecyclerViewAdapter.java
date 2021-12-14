package gr.athtech.recyclerview;
import gr.athtech.R;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    interface Listener {

        public void onItemClick(View view , String data , int imgData, int position );

    }



    @NonNull
    private TypedArray imageData;
    private List<String> arrayData;
    private Listener callback;


    public RecyclerViewAdapter(List<String> arrayData, TypedArray imageData,Listener callback) {

        this.arrayData = arrayData;
        this.callback = callback;
        this.imageData = imageData;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_holder,  parent, false);
        return new RecyclerViewHolder(view,callback);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        int imgId = imageData.getResourceId(position,0);
        String title = arrayData.get(position);
        holder.bindData(title,imgId,position);

        





    }

    @Override
    public int getItemCount() {
        return arrayData.size() ;
    }
}

