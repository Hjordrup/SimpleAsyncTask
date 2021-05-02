package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {


    // TextView reference that is to be updated upon completion of task,
    // It´s a weak refrence to avoid memory leaks (weak references can be garbage collected)
    private WeakReference<TextView> mTextView;

    //Constructor that takes a textView and saves it as a weak reference
    public SimpleAsyncTask(TextView tv){
        this.mTextView = new WeakReference<>(tv);
    }


    @Override
    protected String doInBackground(Void... voids) {
        Random random = new Random();
        int n = random.nextInt(11);
        int nTimesTwohundred = n*200;

        try{
            Thread.sleep(nTimesTwohundred);
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }

        return String.format("Awake at last after sleeping for %s milliseconds!", nTimesTwohundred);
    }




    // This method automatacly gets passed the return value from doInBackground.
    protected void onPostExecute(String result){
        mTextView.get().setText(result);
    }





}
