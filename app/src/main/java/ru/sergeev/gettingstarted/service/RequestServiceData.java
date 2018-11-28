package ru.sergeev.gettingstarted.service;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;

import io.realm.Realm;
import ru.sergeev.gettingstarted.entities.Mark;
import ru.sergeev.gettingstarted.entities.Schedule;
import ru.sergeev.gettingstarted.environment.Environment;
import ru.sergeev.gettingstarted.environment.Params;

public class RequestServiceData {
    private static Realm realm;

    public static StringRequest get(String url, Params params, Class clazz) {
        return RequestServiceData.request(url, Request.Method.GET, params, clazz);
    }

    public static JsonObjectRequest post(String url, Params params, Class clazz, JSONObject data) {
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

        return new JsonObjectRequest(Request.Method.POST, url, data,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        final Mark mark = gson.fromJson(response.toString(), new TypeToken<Mark>() {
                        }.getType());
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
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
    }

    private static StringRequest request(String url, Integer method, Params params, final Class clazz) {
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
                        if (clazz == Mark.class) {
                            RequestServiceData.onMarkResponseCallback(response);
                        } else if (clazz == Schedule.class) {
                            RequestServiceData.onScheduleResponseCallback(response);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
    }

    // TODO: move to generic templates
    private static void onMarkResponseCallback(final String response) {
        Gson gson = new Gson();
        ArrayList<Mark> objects = gson.fromJson(response, new TypeToken<ArrayList<Mark>>() {
        }.getType());
        for (final Mark obj : objects) {
            try {
                realm = Realm.getDefaultInstance();
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.insertOrUpdate(obj);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                realm.close();
            }
        }
    }

    // TODO: move to generic templates
    private static void onScheduleResponseCallback(final String response) {
        Gson gson = new Gson();
        ArrayList<Schedule> objects = gson.fromJson(response, new TypeToken<ArrayList<Schedule>>() {
        }.getType());
        for (final Schedule obj : objects) {
            try {
                realm = Realm.getDefaultInstance();
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.insertOrUpdate(obj);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                realm.close();
            }
        }
    }
}
