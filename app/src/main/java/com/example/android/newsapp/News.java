package com.example.android.newsapp;

final class News {
    private final String mTitle;
    private final String mSection;
    private final String mDate;
    private final String mAuthor;
    private final String mUrl;

     News(String title, String section, String date, String author, String url) {
        mTitle = title;
        mSection = section;
        mDate = date;
        mAuthor = author;
        mUrl = url;
    }

     String getTitle() {
        return mTitle;
    }

     String getSection() {
        return mSection;
    }

     String getDate() {
        return mDate;
    }

     String getAuthor() {
        return mAuthor;
    }


     String getUrl() {
        return mUrl;
    }
}

