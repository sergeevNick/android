package ru.sergeev.gettingstarted.DAO;

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

    RealmResults<ScheduleRow> findScheduleRowsByScheduleScheduleId(Integer scheduleId){
        return realm.where(ScheduleRow.class).equalTo("schedule.scheduleId", scheduleId).findAllAsync();
    }
}
