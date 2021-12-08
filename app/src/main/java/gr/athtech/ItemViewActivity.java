package gr.athtech;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        String title = getIntent().getExtras().getString("title");
        String description = getIntent().getExtras().getString("description");
        int imgId = getIntent().getExtras().getInt("image");



        TextView item_title = findViewById(R.id.item_title);
        item_title.setText(title);


        TextView item_description =  findViewById(R.id.item_description_txt);
        item_description.setText(description);


        ImageView item_image = findViewById(R.id.item_img_large);
        item_image.setImageResource(imgId);









    }
}