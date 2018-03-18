package ru.sergeev.gettingstarted.DAO;

import java.util.Set;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.Day;
import ru.sergeev.gettingstarted.entities.Schedule;

public class ScheduleRepository {
    private Realm realm;

    void getRealm(){
        realm = Realm.getDefaultInstance();
    }

    void closeRealm(){
        realm.close();
    }

    RealmResults<Schedule> findAll() {
        return realm.where(Schedule.class).findAllAsync();
    }

    Schedule findScheduleByScheduleId(Integer id){
        return realm.where(Schedule.class).equalTo("scheduleId", id).findFirstAsync();
    }

    RealmResults<Schedule> findSchedulesByScheduleClassClassId(Integer classId){
        return realm.where(Schedule.class).equalTo("scheduleClass.classId", classId).findAllAsync();
    }
    RealmResults<Schedule> findSchedulesByScheduleClassNumber(String classNumber){
        return realm.where(Schedule.class).equalTo("scheduleClass.number", classNumber).findAllAsync();
    }

    Schedule findScheduleByScheduleClassClassIdAndDayDayId(Integer classId, Integer dayId){
        return realm.where(Schedule.class).equalTo("scheduleClass.classId", classId).and().equalTo("day.dayId", dayId).findFirstAsync();
    }
    Schedule findScheduleByScheduleClassClassIdAndDayDayName(Integer classId, String dayName){
        return realm.where(Schedule.class).equalTo("scheduleClass.classId", classId).and().equalTo("day.dayName", dayName).findFirstAsync();
    }

}
