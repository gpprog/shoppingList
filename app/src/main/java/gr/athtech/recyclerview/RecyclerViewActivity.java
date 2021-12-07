package gr.athtech.recyclerview;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import gr.athtech.ItemViewActivity;
import gr.athtech.MainActivity;
import gr.athtech.R;
import android.text.NoCopySpan;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {


    private boolean isClicked = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_list);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);



        RecyclerView recyclerView = findViewById(R.id.recycler_view_list);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getArrayItems(), new RecyclerViewAdapter.Listener() {
            @Override
            public void onItemClick(View view, String data) {

                if (!isClicked){



                    isClicked = true;

                    Intent intent = new Intent(RecyclerViewActivity.this, ItemViewActivity.class);
                    intent.putExtra("data",data);
                    startActivityForResult(intent,2000);

                    isClicked = false;


//                    Snackbar.make(view, getResources().getString(R.string.app_name),Snackbar.LENGTH_SHORT).addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
//                        @Override
//                        public void onDismissed(Snackbar transientBottomBar, int event) {
//                            super.onDismissed(transientBottomBar, event);
//                            isClicked = false;
//                        }
//                    }).show();





                }



            }
        });

        recyclerView.setAdapter(adapter);




    }


    private List<String> getArrayItems(){

        List<String> arrayItems = new ArrayList<>();


        arrayItems.add("George");
        arrayItems.add("Derek");
        arrayItems.add("Marina");
        arrayItems.add("Balloo");
        arrayItems.add("George");
        arrayItems.add("Derek");
        arrayItems.add("Marina");
        arrayItems.add("Balloo");
        arrayItems.add("George");
        arrayItems.add("Derek");
        arrayItems.add("Marina");
        arrayItems.add("Balloo");
        arrayItems.add("George");
        arrayItems.add("Derek");
        arrayItems.add("Marina");
        arrayItems.add("Balloo");
        arrayItems.add("George");
        arrayItems.add("Derek");
        arrayItems.add("Marina");
        arrayItems.add("Balloo");

        return  arrayItems;
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 2000){
            if (resultCode == Activity.RESULT_OK){
                Log.d("MSG",String.valueOf(resultCode));
            }else if (resultCode == Activity.RESULT_CANCELED){
                Log.d("MSG",String.valueOf(resultCode));
            }else if (resultCode == 5){
                String name = data.getExtras().getString("name");
                Log.d("MSG",name);
            }else {
                Log.d("MSG",String.valueOf(resultCode));
            }
        }
    }

}
