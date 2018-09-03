package ru.sergeev.gettingstarted.DAO;


import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.Grade;

public class ClassRepository {

    private RealmResults<Grade> results;
    private Grade aGrade;
    private Realm realm;

    RealmResults<Grade>findAll(){
        try {
            realm = Realm.getDefaultInstance();
            results = realm.where(Grade.class).findAllAsync();
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
        return results;
    }

    Grade findClassByClassId(Integer id){
        try {
            realm = Realm.getDefaultInstance();
            aGrade = realm.where(Grade.class).equalTo("classId", id).findFirstAsync();
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
        return aGrade;
    }

    Grade findClassByNumber(String number){
        try {
            realm = Realm.getDefaultInstance();
            aGrade = realm.where(Grade.class).equalTo("number", number).findFirst();
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
        return aGrade;
    }
}
