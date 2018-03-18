package ru.sergeev.gettingstarted.DAO;


import java.util.Set;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.ScheduleRow;
import ru.sergeev.gettingstarted.entities.Subject;

public class SubjectRepository {
    private Realm realm;

    void getRealm(){
        realm = Realm.getDefaultInstance();
    }

    void closeRealm(){
        realm.close();
    }

    RealmResults<Subject> findAll(){
        return realm.where(Subject.class).findAllAsync();
    }

    Subject findSubjectBySubjectId(Integer id){
        return realm.where(Subject.class).equalTo("subjectId", id).findFirstAsync();
    }

    Subject findSubjectByName(String name){
        return realm.where(Subject.class).equalTo("name", name).findFirstAsync();
    }
    Subject findSubjectByRoom(Integer room){
        return realm.where(Subject.class).equalTo("room", room).findFirstAsync();
    }
}
