package com.example.sda.testmvp.main;

import com.example.sda.testmvp.R;

import javax.inject.Inject;



public class MainPresenter {


    private MainActivityMvpView view;

    @Inject
    public MainPresenter() {

    }

    public void attachView(MainActivityMvpView view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    public void onClick(String s) {

        if (s.isEmpty()) {
            view.showEmptyDataMessage(R.id.error_message);
        } else if (!s.matches("\\d*")) {

            view.showWrongDataTypeMessage(R.id.wrong_data_type_message);
        } else {
            view.showText(s);
        }

    }



}
