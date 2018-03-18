package ru.sergeev.gettingstarted.DAO;

import java.util.Set;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.ScheduleRow;

public class ScheduleRowRepository {
    private Realm realm;

    void getRealm() {
        realm = Realm.getDefaultInstance();
    }

    void closeRealm() {
        realm.close();
    }

    RealmResults<ScheduleRow> findAll() {
        return realm.where(ScheduleRow.class).findAllAsync();
    }

    ScheduleRow findScheduleRowByScheduleRowId(Integer id) {
        return realm.where(ScheduleRow.class).equalTo("scheduleRowId", id).findFirstAsync();
    }

    RealmResults<ScheduleRow> findScheduleRowsByScheduleScheduleId(Integer scheduleId){
        return realm.where(ScheduleRow.class).equalTo("schedule.scheduleId", scheduleId).findAllAsync();
    }


    RealmResults<ScheduleRow> findScheduleRowsByTeacherTeacherId(Integer teacherId){
        return realm.where(ScheduleRow.class).equalTo("teacher.teacherId", teacherId).findAllAsync();
    }

    RealmResults<ScheduleRow> findScheduleRowsBySubjectSubjectId(Integer subjectId){
        return realm.where(ScheduleRow.class).equalTo("subject.subjectId", subjectId).findAllAsync();
    }
}
