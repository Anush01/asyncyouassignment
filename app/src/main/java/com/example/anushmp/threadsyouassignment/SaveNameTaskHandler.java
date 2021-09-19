package com.example.anushmp.threadsyouassignment;

import android.os.AsyncTask;


import java.io.FileOutputStream;


public class SaveNameTaskHandler extends AsyncTask {

    //sidd disqus

    String name;
    FileOutputStream fos;

    public SaveNameTaskHandler(String name, FileOutputStream fos){

        this.name = name;
        this.fos = fos;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }



    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        //String currentName = (String) objects[0];

        //access global name var here.

       // FileOutputStream fos = null;

        try{

            fos.write(name.getBytes());


        }catch (Exception e){}


        String done ="done";

        return done;
    }
}
