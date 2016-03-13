package com.example.ringers;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Objects;

/**
 * Created by 성준 on 2016-03-11.
 */
public class Restful extends AsyncTask<String,String,String>{


    @Override
    protected String doInBackground(String... params) {
        String ret =httpRequestGet(params);
        return ret;
    }

    private String httpRequestGet(String... uuid) {
        InputStream is = null;
        Reader reader = null;
        int len = 500;
        try {
            URL url = new URL("http://clug.kr:8003/"+uuid[0]+"/"+uuid[1]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            int resp = conn.getResponseCode();
            Log.d("respense", "The response is: " + resp);
            is = conn.getInputStream();
            reader = new InputStreamReader(is, "UTF-8");
            char[] buff = new char[len];
            reader.read(buff);
            String str = new String(buff);
            JSONObject data = new JSONObject(str);
            String ret = data.getString(uuid[0]);
            Log.d("respense", ret);
            return ret;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
