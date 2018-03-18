package ru.sergeev.gettingstarted.DAO;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.Teacher;

public class TeacherRepository {
    private Realm realm;

    void getRealm(){
        realm = Realm.getDefaultInstance();
    }

    void closeRealm(){
        realm.close();
    }

    RealmResults<Teacher> findAll(){
        return realm.where(Teacher.class).findAllAsync();
    }

    Teacher findTeacherByTeacherId(Integer id){
        return realm.where(Teacher.class).equalTo("teacherId", id).findFirstAsync();
    }
    Teacher findFirstByNameNameId(Integer nameId){
        return realm.where(Teacher.class).equalTo("name.nameId", nameId).findFirstAsync();
    }

}