package ru.sergeev.gettingstarted.service;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.DAO.DayRepository;
import ru.sergeev.gettingstarted.entities.Day;

/**
 * Created by serge on 18.03.2018.
 */

public class Service {

    private static Service instance;

    private DayRepository dayRepository;

    private Service() {
        this.dayRepository = new DayRepository();
    }

    public static Service getInstance(){
        if(instance == null){
            instance = new Service();
        }
        return instance;
    }

    public RealmResults<Day> listAllDays(){
       return dayRepository.findAll();
    }
    public void addDay(String dayName){
        dayRepository.saveDay(dayName);
    }

    public void deleteDay(Integer id){
        dayRepository.deleteDay(id);
    }

    public void deleteDayByName(String name,Realm realm){
        dayRepository.deleteDayByName(name, realm);
    }

    public Day getDayByName(String name,Realm realm){
        return dayRepository.findDayByDayName(name, realm);
    }
}
