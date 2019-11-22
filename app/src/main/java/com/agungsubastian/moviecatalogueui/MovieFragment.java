package com.agungsubastian.moviecatalogueui;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MovieFragment extends Fragment {
    private RecyclerView rvMovies;
    private ArrayList<DataModel> list = new ArrayList<>();

    public MovieFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        rvMovies = view.findViewById(R.id.rv_movie);
        rvMovies.setHasFixedSize(true);

        list.addAll(getListMovie());
        showRecyclerList();

        return view;
    }

    private ArrayList<DataModel> getListMovie() {
        String[] dataTitle = getResources().getStringArray(R.array.data_title_movies);
        String[] dataScore = getResources().getStringArray(R.array.data_score_movies);
        String[] dataDate = getResources().getStringArray(R.array.data_date_movies);
        String[] dataDescription = getResources().getStringArray(R.array.data_description_movies);
        @SuppressLint("Recycle") TypedArray dataImage = getResources().obtainTypedArray(R.array.data_image_movies);
        ArrayList<DataModel> listMovie = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            DataModel dataModel = new DataModel();
            dataModel.setTitle(dataTitle[i]);
            dataModel.setScore(dataScore[i]);
            dataModel.setDate(dataDate[i]);
            dataModel.setDescription(dataDescription[i]);
            dataModel.setImage(dataImage.getResourceId(i, -1));
            listMovie.add(dataModel);
        }
        return listMovie;
    }

    private void showRecyclerList() {
        rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        DataAdapter dataAdapter = new DataAdapter(list);
        rvMovies.setAdapter(dataAdapter);

        dataAdapter.setOnItemClickCallback(new DataAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(DataModel dataModel) {
                Intent movieIntent = new Intent(getContext(), DetailDataActivity.class);
                movieIntent.putExtra(DetailDataActivity.EXTRA_MOVIE, dataModel);
                startActivity(movieIntent);
            }
        });
    }
}
