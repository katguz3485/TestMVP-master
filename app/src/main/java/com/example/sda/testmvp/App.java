package com.example.sda.testmvp;

import android.app.Application;

import com.example.sda.testmvp.di.AppComponent;
import com.example.sda.testmvp.di.AppModule;
import com.example.sda.testmvp.di.DaggerAppComponent;


public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initDagger();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }



 private void initDagger() {
      appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

}
