package com.agungsubastian.moviecatalogueui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class DetailDataActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.detail);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }
        TextView title = findViewById(R.id.title);
        TextView date = findViewById(R.id.date);
        TextView score = findViewById(R.id.score);
        TextView description = findViewById(R.id.description);
        ImageView image = findViewById(R.id.img_photo);
        DataModel data = getIntent().getParcelableExtra(EXTRA_MOVIE);

        assert data != null;
        title.setText(data.getTitle());
        date.setText(data.getDate());
        score.setText(data.getScore());
        description.setText(data.getDescription());
        image.setImageResource(data.getImage());

    }
}
