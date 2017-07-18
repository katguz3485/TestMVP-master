package com.example.sda.testmvp.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sda.testmvp.App;
import com.example.sda.testmvp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityMvpView {

    @BindView(R.id.editText)
    EditText editText;

    @Inject
    MainPresenter presenter;

    @BindView(R.id.textView)
    TextView textView;


    @OnClick(R.id.submit_button)
    public void getText() {
        presenter.onClick(editText.getText().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((App) getApplication()).getAppComponent().inject(this);
        init();


    }

    private void init() {
        presenter.attachView(this);
    }


    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }


    @Override
    public void showEmptyDataMessage(int resId) {
        textView.setText(getString(resId));
    }

    @Override
    public void showText(String s) {
        textView.setText(s);
    }

    @Override
    public void showWrongDataTypeMessage(int messageId) {
        textView.setText(getString(messageId));
    }
}
