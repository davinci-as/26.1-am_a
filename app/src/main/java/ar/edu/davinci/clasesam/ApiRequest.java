package ar.edu.davinci.clasesam;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiRequest extends AsyncTask<String, Integer, String> {

    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        String url = strings[0];
        try {
            String data = run(url);
            //TODO: procesar data
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onPostExecute(String json) {
        super.onPostExecute(json);
        //Log.i("JSON", json);
        //try {
        Gson gson = new Gson();
        ApiResponse response = gson.fromJson(json, ApiResponse.class);
        if(response == null) return;
        ArrayList<Character> results = response.results;
        Character lastItem =  results.get(19);
        Log.i("JSON", lastItem.name);

            //JSONObject response = new JSONObject(json);
            //JSONArray results = response.getJSONArray("results");
            //JSONObject lastItem = results.getJSONObject(19);
            //Log.i("JSON", lastItem.getString("name"));
        //} catch (JSONException e) {
        //    throw new RuntimeException(e);
        //}
    }
}
