package com.pinerestpinssample.utils;

import android.graphics.Color;

import java.io.Serializable;


public class PinterestData implements Serializable {
    private String id="";
    private String created_at="";
    private int width=0;
    private int height=0;
    private int color;
    private int likes=0;
    private boolean liked_by_user=false;
    private String user_id="";
    private String username="";
    private String name="";
    private String profile_image_small="";
    private String profile_image_medium="";
    private String profile_image_large="";
    private String links_photos="";
    private String links_likes="";
    private String urls_raw="";
    private String urls_full="";
    private String urls_regular="";
    private String urls_small="";
    private String urls_thumb="";
    private String categories_title="";
    private int categories_id=0;
    private int categories_photo_count=0;
    private String categories_links_self="";
    private String categories_links_photos="";
    private String links_self="";
    private String links_html="";
    private String links_download="";

    public void SetPinterestId(String pinterestId){
        this.id=pinterestId;
    }

    public String getPinterestId(){
        return id;
    }

    public void SetCreatedAt(String created_at){
        this.created_at=created_at;
    }

    public String getCreatedAt(){
        return created_at;
    }

    public void SetWidth(int width){
        this.width=width;
    }

    public int getWidth(){
        return width;
    }

    public void SetHeight(int height){
        this.height=height;
    }

    public int getHeight(){
        return height;
    }

    public void SetColor(String color){
        this.color=Color.parseColor(color);
    }

    public int getColor(){
        return this.color;
    }

    public void SetLikes(int likes){
        this.likes=likes;
    }

    public int getLikes(){
        return likes;
    }

    public void Setlikesbyuser(boolean liked_by_user){
        this.liked_by_user=liked_by_user;
    }

    public boolean getlikesbyuser(){
        return this.liked_by_user;
    }

    public void SetUserId(String user_id){
        this.user_id=user_id;
    }

    public String getUserId(){
        return user_id;
    }

    public void SetUserName(String username){
        this.username=username;
    }

    public String getUsername(){
        return username;
    }

    public void Setname(String name){
        this.name=name;
    }

    public String getname(){
        return name;
    }

    public void SetProfileImageSmall(String profile_image_small){
        this.profile_image_small=profile_image_small;
    }

    public String getProfileImageSmall(){
        return profile_image_small;
    }

    public void SetProfileImageMedium(String profile_image_medium){
        this.profile_image_medium=profile_image_medium;
    }

    public String getProfileImageMedium(){
        return profile_image_medium;
    }

    public void SetProfileImageLarge(String profile_image_large){
        this.profile_image_large=profile_image_large;
    }

    public String getProfileImageLarge(){
        return profile_image_large;
    }

    public void Setlinksself(String links_self){
        this.links_self=links_self;
    }

    public String getlinksself(){
        return links_self;
    }

    public void Setlinkhtml(String links_html){
        this.links_html=links_html;
    }

    public String getlinkhtml(){
        return links_html;
    }

    public void Setlinkphotos(String links_photos){
        this.links_photos=links_photos;
    }

    public String getlinkphotos(){
        return links_photos;
    }

    public void Setlinklikes(String links_likes){
        this.links_likes=links_likes;
    }

    public String getlinklikes(){
        return links_likes;
    }

    public void SetUrlsraw(String urls_raw){
        this.urls_raw=urls_raw;
    }

    public String getUrlsraw(){
        return urls_raw;
    }

    public void SetUrlsfull(String urls_full){
        this.urls_full=urls_full;
    }

    public String getUrlsfull(){
        return urls_full;
    }

    public void SetUrlsRegular(String urls_regular){
        this.urls_regular=urls_regular;
    }

    public String getUrlsRegular(){
        return urls_regular;
    }

    public void SetUrlsSmall(String urls_small){
        this.urls_small=urls_small;
    }

    public String getUrlsSmall(){
        return urls_small;
    }

    public void SetUrlsthumb(String urls_thumb){
        this.urls_thumb=urls_thumb;
    }

    public String getUrlsthumb(){
        return urls_thumb;
    }
}
