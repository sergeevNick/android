package ru.sergeev.gettingstarted.DAO;


import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.OtherInfo;
import ru.sergeev.gettingstarted.entities.Student;
import ru.sergeev.gettingstarted.entities.Teacher;

public class OtherInfoRepository {
    private Realm realm;

    void getRealm(){
        realm = Realm.getDefaultInstance();
    }

    void closeRealm(){
        realm.close();
    }

    RealmResults<OtherInfo> findAll(){
        return realm.where(OtherInfo.class).findAllAsync();
    }

    OtherInfo findOtherInfoByInfoId(Integer id){
        return realm.where(OtherInfo.class).equalTo("infoId", id).findFirstAsync();
    }
}
