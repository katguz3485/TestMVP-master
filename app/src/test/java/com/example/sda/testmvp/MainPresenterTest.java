package com.example.sda.testmvp;

import com.example.sda.testmvp.main.MainActivityMvpView;
import com.example.sda.testmvp.main.MainPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by kasiaguzik on 17.07.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {


    @Mock
    MainActivityMvpView view;

    private MainPresenter presenter;


    @Before
    public void setUp() throws Exception {
        presenter = new MainPresenter();
        presenter.attachView(view);
    }

    @Test
    public void shouldshowEmptyStringMessage() {
        String s = "";
        presenter.onClick(s);
        verify(view).showEmptyDataMessage(R.id.error_message);
    }

    @Test
    public void shouldShowWrongDataTypeMessage() {
        String s = "DFDFs";
        presenter.onClick(s);
        verify(view).showWrongDataTypeMessage(R.id.wrong_data_type_message);
    }

    @Test
    public void shouldShowInsertedValue() {
        String s = "23";
        presenter.onClick(s);
        verify(view).showText(s);

    }

}