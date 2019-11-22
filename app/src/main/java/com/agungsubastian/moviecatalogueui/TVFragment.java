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


/**
 * A simple {@link Fragment} subclass.
 */
public class TVFragment extends Fragment {
    private RecyclerView rvTv;
    private ArrayList<DataModel> list = new ArrayList<>();

    public TVFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv, container, false);
        rvTv = view.findViewById(R.id.rv_tv);
        rvTv.setHasFixedSize(true);

        list.addAll(getListTV());
        showRecyclerList();
        return view;
    }

    private ArrayList<DataModel> getListTV() {
        String[] dataTitle = getResources().getStringArray(R.array.data_title_tv);
        String[] dataScore = getResources().getStringArray(R.array.data_score_tv);
        String[] dataDate = getResources().getStringArray(R.array.data_date_tv);
        String[] dataDescription = getResources().getStringArray(R.array.data_description_tv);
        @SuppressLint("Recycle") TypedArray dataImage = getResources().obtainTypedArray(R.array.data_image_tv);
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
        rvTv.setLayoutManager(new LinearLayoutManager(getContext()));
        DataAdapter dataAdapter = new DataAdapter(list);
        rvTv.setAdapter(dataAdapter);

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

