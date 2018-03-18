package ru.sergeev.gettingstarted.DAO;


import java.util.Set;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.Lesson;
import ru.sergeev.gettingstarted.entities.ScheduleRow;

public class LessonRepository {

    private Realm realm;

    void getRealm(){
        realm = Realm.getDefaultInstance();
    }

    void closeRealm(){
        realm.close();
    }

    RealmResults<Lesson> findAll(){
        return realm.where(Lesson.class).findAllAsync();
    }

    Lesson findLessonByLessonId(Integer id){
        return realm.where(Lesson.class).equalTo("lessonId", id).findFirstAsync();
    }
}
