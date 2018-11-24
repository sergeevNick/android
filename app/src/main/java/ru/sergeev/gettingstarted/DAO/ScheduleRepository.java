package ru.sergeev.gettingstarted.DAO;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.Schedule;

public class ScheduleRepository {
    private Realm realm;

    public ScheduleRepository(Realm realm) {
        this.realm = realm;
    }

    public RealmResults<Schedule> findAll() {
        return this.realm.where(Schedule.class).findAll();
    }

    public RealmResults<Schedule> findScheduleByGradeId(Integer classId) {
        return this.realm.where(Schedule.class).equalTo("grade.gradeId", classId).findAll();
    }

    public Schedule findScheduleByGradeIdAndDayId(Integer classId, Integer dayId) {
        return this.realm.where(Schedule.class).equalTo("grade.gradeId", classId).and().equalTo("day.dayId", dayId).findFirst();
    }
}
