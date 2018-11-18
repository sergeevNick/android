package ru.sergeev.gettingstarted.service;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Field;
import java.util.ArrayList;

import io.realm.Realm;
import ru.sergeev.gettingstarted.entities.Mark;
import ru.sergeev.gettingstarted.environment.Environment;
import ru.sergeev.gettingstarted.environment.Params;

public class RequestServiceData {
    private static Realm realm;

    public static StringRequest get(String url, Params params) {
        return RequestServiceData.request(url, Request.Method.GET, params, new Gson());
    }

    private static StringRequest request(String url, Integer method, Params params, Gson data) {
        url = Environment.baseUrl + url;

        Field[] fields = params.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object value = null;
            try {
                value = field.get(params);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (value != null) {
                url = url.replace(":" + field.getName(), value.toString());
            }
        }

        return new StringRequest(method, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {
                        Gson gson = new Gson();
                        ArrayList<Mark> marks1 = gson.fromJson(response, new TypeToken<ArrayList<Mark>>() {
                        }.getType());
                        for (final Mark mark : marks1) {
                            try {
                                realm = Realm.getDefaultInstance();
                                realm.executeTransaction(new Realm.Transaction() {
                                    @Override
                                    public void execute(Realm realm) {
                                        realm.insertOrUpdate(mark);
                                    }
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                realm.close();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
    }
}
