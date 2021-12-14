package gr.athtech;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class ItemViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // get extras

        String title = getIntent().getExtras().getString("title");
        String description = getIntent().getExtras().getString("description");
        int imgId = getIntent().getExtras().getInt("image");

        // set item title
        TextView item_title = findViewById(R.id.item_title);
        item_title.setText(title);

        // set item description
        TextView item_description =  findViewById(R.id.item_description_txt);
        item_description.setText(description);

        // set item image
        ImageView item_image = findViewById(R.id.item_img_large);
        item_image.setImageResource(imgId);

        // share button
        ImageButton shareBtn = findViewById(R.id.share_btn);

        //share button functionality
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT,description );
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                try{
                    startActivity(Intent.createChooser(shareIntent, "Share item description..."));

                }catch (ActivityNotFoundException e){
                    Log.d("MSG",e.toString());

                }

            }
        });


    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        super.onBackPressed();
    }
}