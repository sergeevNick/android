package ru.sergeev.gettingstarted.DAO;


import java.util.Set;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.Class;

public class ClassRepository {

    private RealmResults<Class> results;
    private Class aClass;
    private Realm realm;

    RealmResults<Class>findAll(){
        try {
            realm = Realm.getDefaultInstance();
            results = realm.where(Class.class).findAllAsync();
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
        return results;
    }

    Class findClassByClassId(Integer id){
        try {
            realm = Realm.getDefaultInstance();
            aClass = realm.where(Class.class).equalTo("classId", id).findFirstAsync();
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
        return aClass;
    }

    Class findClassByNumber(String number){
        try {
            realm = Realm.getDefaultInstance();
            aClass = realm.where(Class.class).equalTo("number", number).findFirst();
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
        return aClass;
    }
}
