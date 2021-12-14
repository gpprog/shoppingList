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
import android.widget.ImageButton;

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

        ImageButton logoutButton = findViewById(R.id.btn_logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();



            }
        });


        RecyclerView recyclerView = findViewById(R.id.recycler_view_list);

        // get the titles from resources
        List<String> titles = Arrays.asList(getResources().getStringArray(R.array.shopping_list));

        //get the images from resources
        TypedArray images = getResources().obtainTypedArray(R.array.item_image);


        RecyclerViewAdapter adapter = new RecyclerViewAdapter( titles, images, new RecyclerViewAdapter.Listener() {


            @Override
            public void onItemClick(View view, String title, int imgData, int position) {

                if (!isClicked) {

                    isClicked = true;


                    //get the clicked item description
                    String[] descriptions = getResources().getStringArray(R.array.item_description);
                    String itemDescription = descriptions[position];

                    // pass necessary data to next activity

                    Intent intent = new Intent(RecyclerViewActivity.this, ItemViewActivity.class);

                    intent.putExtra("title", title);
                    intent.putExtra("description", itemDescription);
                    intent.putExtra("image",imgData);





                    startActivityForResult(intent, 2000);



                }


            }
        });

        recyclerView.setAdapter(adapter);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        isClicked = false;

        if (requestCode == 2000) {
            if (resultCode == Activity.RESULT_OK) {

                Log.d("MSG", String.valueOf(resultCode));
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.d("MSG", String.valueOf(resultCode));
            } else {
                Log.d("MSG", String.valueOf(resultCode));
            }
        }
    }




}
