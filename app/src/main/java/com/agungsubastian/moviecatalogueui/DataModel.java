package com.agungsubastian.moviecatalogueui;

import android.os.Parcel;
import android.os.Parcelable;

public class DataModel implements Parcelable {
    private int image;
    private String title;
    private String description;
    private String date;
    private String score;

    DataModel() {
    }

    private DataModel(Parcel in) {
        image = in.readInt();
        title = in.readString();
        description = in.readString();
        date = in.readString();
        score = in.readString();
    }

    public static final Creator<DataModel> CREATOR = new Creator<DataModel>() {
        @Override
        public DataModel createFromParcel(Parcel in) {
            return new DataModel(in);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };

    int getImage() {
        return image;
    }

    void setImage(int image) {
        this.image = image;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    String getDate() {
        return date;
    }

    void setDate(String date) {
        this.date = date;
    }

    String getScore() {
        return score;
    }

    void setScore(String score) {
        this.score = score;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(date);
        parcel.writeString(score);
    }
}
