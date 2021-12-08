package gr.athtech.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

                if (!isClicked) {

                    isClicked = true;

                    String[] titles = getResources().getStringArray(R.array.shopping_list);
                    String[] descriptions = getResources().getStringArray(R.array.item_description);
                    TypedArray images = getResources().obtainTypedArray(R.array.item_image);



                    int position = 999;

                    for (int i = 0; i < titles.length; i++) {

                        if (titles[i].matches(data)) {
                            position = i;

                        }
                    }


                    //get the corresponding description

                    String itemDescription = descriptions[position];

                    //get the title
                    String itemTitle = titles[position];


                    // get the corresponding imageId
                    int imgId = images.getResourceId(position,0);




                    Intent intent = new Intent(RecyclerViewActivity.this, ItemViewActivity.class);
                    intent.putExtra("title", data);
                    intent.putExtra("description", itemDescription);
                    intent.putExtra("image",imgId);


                    startActivityForResult(intent, 2000);

                    isClicked = false;

                }


            }
        });

        recyclerView.setAdapter(adapter);


    }

    //get the shopping list

    private List<String> getArrayItems() {

        List<String> arrayItems = Arrays.asList(getResources().getStringArray(R.array.shopping_list));

        return arrayItems;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2000) {
            if (resultCode == Activity.RESULT_OK) {
                Log.d("MSG", String.valueOf(resultCode));
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.d("MSG", String.valueOf(resultCode));
            } else if (resultCode == 5) {
                String name = data.getExtras().getString("name");
                Log.d("MSG", name);
            } else {
                Log.d("MSG", String.valueOf(resultCode));
            }
        }
    }

}
