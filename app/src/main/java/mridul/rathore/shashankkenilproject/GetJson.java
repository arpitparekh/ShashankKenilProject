package mridul.rathore.shashankkenilproject;

import android.content.Context;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class GetJson {

    public static String getJsonData(String json, Context context){

        try {

            InputStream is = context.getAssets().open(json+".json");

            byte arr[] = new byte[is.available()];

            is.read(arr);

            String data = new String(arr, StandardCharsets.UTF_8);

            return data;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
