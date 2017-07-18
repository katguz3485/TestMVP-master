package com.example.sda.testmvp.main;

/**
 * Created by sda on 15.07.17.
 */

public interface MainActivityMvpView {


    void showEmptyDataMessage(int resID);

    void showText(String s);

   void showWrongDataTypeMessage(int messageId);

}
