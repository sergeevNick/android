package ru.sergeev.gettingstarted.DAO;


import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.Name;
import ru.sergeev.gettingstarted.entities.Student;
import ru.sergeev.gettingstarted.entities.Teacher;

public class NameRepository {
    private Realm realm;

    void getRealm(){
        realm = Realm.getDefaultInstance();
    }

    void closeRealm(){
        realm.close();
    }

    RealmResults<Name> findAll(){
        return realm.where(Name.class).findAllAsync();
    }


    Name findNameByNameId(Integer id){
        return realm.where(Name.class).equalTo("nameId", id).findFirstAsync();
    }
}
