package com.example.sda.testmvp.di;

import com.example.sda.testmvp.main.MainActivity;

import javax.inject.Singleton;

/**
 * Created by sda on 26.06.17.
 */

@Singleton
@dagger.Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity activity);


}
