package ru.sergeev.gettingstarted.DAO;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.Schedule;

public class ScheduleRepository {
    private Realm realm;

    void getRealm() {
        realm = Realm.getDefaultInstance();
    }

    void closeRealm() {
        realm.close();
    }

    RealmResults<Schedule> findScheduleByGradeId(Integer classId) {
        return realm.where(Schedule.class).equalTo("grade.gradeId", classId).findAllAsync();
    }
}
