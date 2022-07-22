package com.example.maxapp.utils.services;

import static javax.xml.transform.OutputKeys.ENCODING;

import android.content.Context;
import android.os.Environment;

import com.android.volley.NetworkResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MockUtils<T> {
    private static MockUtils mMockUtils;

    public static MockUtils getInstance(){
        return mMockUtils == null ? new MockUtils() : mMockUtils;
    }

    private byte[] readFile(Context context, String fileName) {
        InputStream is = null;
        byte[] fileBytes = null;
        try {
            is = context.getAssets().open( fileName);
            fileBytes = new byte[is.available()];
            is.read(fileBytes);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileBytes;
    }

    private byte[] readFile(Context context, File file) {

        int size = (int) file.length();
        byte[] bytes = new byte[size];
        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            buf.read(bytes, 0, bytes.length);
            buf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public T getResponse(Class<T> responseType, Context context, String fileName) {

        T myClass = null;
        try {

            ObjectMapper m = new ObjectMapper();

            m.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            NetworkResponse networkResponse = new NetworkResponse(readFile(context, fileName));
            String jsonString = new String(networkResponse.data);
            jsonString = jsonString.replace("\n", "").replace("\r", "");
            myClass = m.readValue(jsonString, responseType);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return myClass;
    }

    public T getResponse(Class<T> responseType, Context context, String fileName, String url) {

        T myClass = null;
        try {
            File f = getFileName(url);
            ObjectMapper m = new ObjectMapper();

            m.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            NetworkResponse networkResponse = new NetworkResponse(readFile(context, f));
            String jsonString = new String(networkResponse.data, ENCODING);
            jsonString = jsonString.replace("\n", "").replace("\r", "");
            myClass = m.readValue(jsonString, responseType);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return myClass;
    }

    public File getFileName(String mUrl) {
        String url = mUrl.substring(mUrl.lastIndexOf('/') + 1);
        String file = url + ".json";
        File dir = new File(Environment.getExternalStorageDirectory() + "/Download/test/");
        return new File(dir + "/" + file);
    }

}
