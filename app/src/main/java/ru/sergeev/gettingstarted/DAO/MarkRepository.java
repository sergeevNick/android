package ru.sergeev.gettingstarted.DAO;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.Mark;

public class MarkRepository {

    private Realm realm;

    public MarkRepository(Realm realm) {
        this.realm = realm;
    }

    public Mark findMarkByMarkId(Integer id) {
        return this.realm.where(Mark.class).equalTo("markId", id).findFirstAsync();
    }

    public RealmResults<Mark> findAll() {
        return this.realm.where(Mark.class).findAll();
    }

    public RealmResults<Mark> findMarksByUserId(Integer studentId) {
        return this.realm.where(Mark.class).equalTo("student.userId", studentId).findAll();
    }

    public RealmResults<Mark> findMarksByStudentIdAndSubjectId(Integer studentId, Integer subjectId) {
        return this.realm.where(Mark.class).equalTo("student.userId", studentId).and().equalTo("subject.subjectId", subjectId).findAll();
    }

    public RealmResults<Mark> findMarksByStudentIdAndSubjectName(Integer studentId, String subjectName) {
        return this.realm.where(Mark.class).equalTo("student.userId", studentId).and().equalTo("subject.name", subjectName).findAll();
    }
}
