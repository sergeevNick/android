package ru.sergeev.gettingstarted.DAO;

import java.util.Set;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.Mark;
import ru.sergeev.gettingstarted.entities.Student;
import ru.sergeev.gettingstarted.entities.Subject;

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


    RealmResults<Mark> findMarksByStudentStudentId(Integer studentId) {
        return realm.where(Mark.class).equalTo("student.studentId", studentId).findAllAsync();
    }

    RealmResults<Mark> findMarksByStudentStudentIdAndSubjectSubjectId(Integer studentId, Integer subjectId) {
        return realm.where(Mark.class).equalTo("student.studentId", studentId).and().equalTo("subject.subjectId", subjectId).findAllAsync()
                ;
    }

    RealmResults<Mark> findMarksByStudentStudentIdAndSubjectName(Integer studentId, String subjectName) {
        return realm.where(Mark.class).equalTo("student.studentId", studentId).and().equalTo("subject.name", subjectName).findAllAsync();
    }
}
