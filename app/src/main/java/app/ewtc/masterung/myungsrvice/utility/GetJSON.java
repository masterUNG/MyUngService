package app.ewtc.masterung.myungsrvice.utility;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

/**
 * Created by masterung on 19/11/2017 AD.
 */

public class GetJSON extends AsyncTask<String, Void, String>{

    private Context context;

    public GetJSON(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[0]).build();


        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}   // Main Class
