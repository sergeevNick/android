package ru.sergeev.gettingstarted.DAO;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.entities.Subject;

public class SubjectRepository {
    private Realm realm;

    public SubjectRepository(Realm realm) {
        this.realm = realm;
    }

    public RealmResults<Subject> findAll() {
        return this.realm.where(Subject.class).findAll();
    }

    public Subject findSubjectBySubjectId(Integer id) {
        return this.realm.where(Subject.class).equalTo("subjectId", id).findFirst();
    }

    public Subject findSubjectByName(String name) {
        return this.realm.where(Subject.class).equalTo("name", name).findFirst();
    }

    public Subject findSubjectByRoom(Integer room) {
        return this.realm.where(Subject.class).equalTo("room", room).findFirst();
    }
}
