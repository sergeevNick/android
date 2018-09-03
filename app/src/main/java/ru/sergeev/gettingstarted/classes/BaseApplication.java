package ru.sergeev.gettingstarted.classes;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by serge on 17.03.2018.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("myrealm.realm").deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);
    }
}
