package com.example.android.miwok;

public class Word {
    private String mDefaultTranslations;
    private String mMiwokTranslations;
    private int audioId;
    private int imageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED=-1;

    public Word(String mDefaultTranslations,String mMiwokTranslations , int audioId){
        this.mDefaultTranslations=mDefaultTranslations;
        this.mMiwokTranslations=mMiwokTranslations;
        this.audioId=audioId;
    }

    public Word(String mDefaultTranslations,String mMiwokTranslations,int imageResourceId ,int audioId){
        this.mDefaultTranslations=mDefaultTranslations;
        this.mMiwokTranslations=mMiwokTranslations;
        this.imageResourceId=imageResourceId;
        this.audioId=audioId;
    }

    //get the default translation of the word
    public String getDefaultTranslations() {
        return mDefaultTranslations;
    }

    //to get the miwok translation of the word
    public String getMiwokTranslations() {
        return mMiwokTranslations;
    }

    public int getImageResourceId() { return imageResourceId; }

    public boolean hasImage() {
        return imageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioId(){
        return audioId;
    }
}
