package ru.sergeev.gettingstarted.DAO;

import java.util.Set;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.Mark;

public class MarkRepository {

    private Realm realm;

    void getRealm() {
        realm = Realm.getDefaultInstance();
    }

    void closeRealm() {
        realm.close();
    }

    Mark findMarkByMarkId(Integer id) {
        return realm.where(Mark.class).equalTo("markId", id).findFirstAsync();
    }


    RealmResults<Mark> findMarksByUserId(Integer studentId) {
        return realm.where(Mark.class).equalTo("student.userId", studentId).findAllAsync();
    }

    RealmResults<Mark> findMarksByStudentIdAndSubjectId(Integer studentId, Integer subjectId) {
        return realm.where(Mark.class).equalTo("student.userId", studentId).and().equalTo("subject.subjectId", subjectId).findAllAsync()
                ;
    }

    RealmResults<Mark> findMarksByStudentIdAndSubjectName(Integer studentId, String subjectName) {
        return realm.where(Mark.class).equalTo("student.userId", studentId).and().equalTo("subject.name", subjectName).findAllAsync();
    }
}
