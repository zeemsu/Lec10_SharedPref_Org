package edu.montclair.mobilecomputing.m_alrajab.lec10_sharedpref_org.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by m_alrajab on 2/22/17.
 */

public class Utils {

    public static final String SHARED_PREF_FILENAME="edu.montclair.mobilecomputing.m_alrajab.lec10_sharedpref_org.SHAREDFILE1";
    public static final String KEY_TITLE="Title_";
    public static final String KEY_BODY="Body_";


    public static String[] getListFromSP(Context context, String key){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_FILENAME,
                Context.MODE_PRIVATE);
        Map<String, ?> map=sharedPreferences.getAll();
        ArrayList<String> lst= new ArrayList<>();
        for(String str:map.keySet()){
            if(str.startsWith(key))
                lst.add((String)map.get(str));
        }
        return lst.toArray(new String[lst.size()]);
    }
    public static String[] getListFromFile(Context context, String key){
        String temp="";
        String listOfFiles="";
        try {
            Log.i("KEY:",key);
            FileInputStream fileInputStream=context.openFileInput(key.replace(" ",""));
            int c;
            while((c=fileInputStream.read())!=1){
                temp+=Character.toString((char)c);
            }
            fileInputStream.close();

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
        ArrayList<String> lst= new ArrayList<>();
        lst.add(temp);
        return lst.toArray(new String[lst.size()]);

    }


}
