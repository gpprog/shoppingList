package gr.athtech.recyclerview;
import android.os.Bundle;
import gr.athtech.R;
import android.text.NoCopySpan;
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

                    Snackbar.make(view, getResources().getString(R.string.app_name),Snackbar.LENGTH_SHORT).addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                        @Override
                        public void onDismissed(Snackbar transientBottomBar, int event) {
                            super.onDismissed(transientBottomBar, event);
                            isClicked = false;
                        }
                    }).show();



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

}
