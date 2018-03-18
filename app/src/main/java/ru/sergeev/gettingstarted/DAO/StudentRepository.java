package ru.sergeev.gettingstarted.DAO;


import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.Name;
import ru.sergeev.gettingstarted.entities.Student;

public class StudentRepository {
    private Realm realm;

    void getRealm(){
        realm = Realm.getDefaultInstance();
    }

    void closeRealm(){
        realm.close();
    }

    RealmResults<Student> findAll(){
        return realm.where(Student.class).findAllAsync();
    }

    Student findByStudentId(Integer id){
        return realm.where(Student.class).equalTo("studentId", id).findFirstAsync();
    }
    Student findStudentByNameNameId(Integer nameId){
        return realm.where(Student.class).equalTo("name.nameId", nameId).findFirstAsync();
    }
    RealmResults<Student> findStudentsByStudentClassClassId(Integer classId){
        return realm.where(Student.class).equalTo("studentClass.classId", classId).findAllAsync();
    }
}
