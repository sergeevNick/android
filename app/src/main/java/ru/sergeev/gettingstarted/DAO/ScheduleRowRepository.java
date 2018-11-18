package ru.sergeev.gettingstarted.DAO;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.ScheduleRow;

public class ScheduleRowRepository {
    private Realm realm;

    public void getRealm() {
        realm = Realm.getDefaultInstance();
    }

    public void closeRealm() {
        realm.close();
    }

    public RealmResults<ScheduleRow> findScheduleRowsByScheduleScheduleId(Integer scheduleId){
        return realm.where(ScheduleRow.class).equalTo("schedule.scheduleId", scheduleId).findAllAsync();
    }
}
