package gr.athtech.recyclerview;
import android.os.Bundle;
import gr.athtech.R;
import android.text.NoCopySpan;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_list);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);


        List<String> arrayItems = new ArrayList<>();

        arrayItems.add("George");
        arrayItems.add("Derek");
        arrayItems.add("Marina");
        arrayItems.add("Balloo");


        RecyclerView recyclerView = findViewById(R.id.recycler_view_list);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(arrayItems,this);

        recyclerView.setAdapter(adapter);




    }

}
