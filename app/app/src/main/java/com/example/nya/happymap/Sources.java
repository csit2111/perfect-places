package com.example.nya.happymap;

import java.util.ArrayList;
import java.util.List;


public class Sources {
    public List<String> photos;
    public List<String> videos;

    public Sources(List<String> ph, List<String> videos) {
        this.photos = ph;
        this.videos = videos;
    }

    public Sources(List<String> ph) {
        this.photos = ph;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void addPhoto(String p){
        photos.add(p);
    }

    public void addVideo(String v){
        videos.add(v);
    }
}