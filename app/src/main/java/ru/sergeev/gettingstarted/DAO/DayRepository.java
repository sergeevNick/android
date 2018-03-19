package ru.sergeev.gettingstarted.DAO;


import android.util.Log;

import java.util.Set;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.Day;

public class DayRepository {
    private Realm realm;
    private RealmResults<Day> results;
    private Day day;

    public void getRealm() {
        realm = Realm.getDefaultInstance();
    }

    public void closeRealm() {
        realm.close();
    }

    public RealmResults<Day> findAll() {
        try {
            realm = Realm.getDefaultInstance();
            results = realm.where(Day.class).findAll();
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
        return results;
    }


    public Day findDayByDayId(Integer id) {
        try {
            realm = Realm.getDefaultInstance();
            day = realm.where(Day.class).equalTo("dayId", id).findFirst();

        } finally {
            if (realm != null) {
                realm.close();
            }
        }
        return day;
    }

    public Day findDayByDayName(String name, Realm realm) {
        return realm.where(Day.class).equalTo("dayName", name).findFirst();
    }

    public void saveDay(final String name) {
        realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Number currentIdNum = realm.where(Day.class).max("dayId");
                int nextId;
                if (currentIdNum == null) {
                    nextId = 1;
                } else {
                    nextId = currentIdNum.intValue() + 1;
                }
                Day day = realm.createObject(Day.class, nextId);
                day.setDayName(name);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.v("saving", "Added day with name: " + name);
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e("saving", "Failed to add day with name: " + name);
            }
        });
        realm.close();
    }


    public void deleteDay(final Integer id) {
        realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                findDayByDayId(id).deleteFromRealm();
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.v("deleting", "Deleted day with id: " + id);
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e("deleting", "Failed to delete day with id: " + id);
            }
        });
        realm.close();
    }

    public void deleteDayByName(final String name, Realm realm) {

       // realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Day result;
                result = findDayByDayName(name, realm);
                if (result.isValid()) {
                    result.deleteFromRealm();
                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.v("deleting", "Deleted day with name: " + name);
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e("deleting", "Failed to delete day with name: " + name);
            }
        });
       // realm.close();
    }
}

