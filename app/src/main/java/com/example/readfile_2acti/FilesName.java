package com.example.readfile_2acti;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
@SuppressWarnings("serial")
public class FilesName implements Serializable {
    private ArrayList<String>filenames;

    public FilesName(ArrayList<String> filenames) {
        this.filenames = filenames;
    }
    public FilesName() {
        this.filenames = new ArrayList<>();
    }

    public ArrayList<String> getFilenames() {
        return filenames;
    }

    public void setFilenames(ArrayList<String> filenames) {
        this.filenames = filenames;
    }
}