package com.android3.ocabafox.kumpra.InputItem;

/**
 * Created by ocabafox on 7/6/2015.
 */
public class Input_PresenterImpl implements Input_Presenter, OnInputFinishedListener {
    Input_View input_view;
    Input_Interactor input_interactor;

    public Input_PresenterImpl(Input_View input_view){
        this.input_view = input_view;
        this.input_interactor = new Input_InteractorImpl();
    }

    @Override
    public void validateCredentioals(String input) {
        input_view.showProgress();
        input_interactor.input(input,this);
    }

    @Override
    public void onInputError() {
        input_view.setInputError();
        input_view.hideProgress();
    }

    @Override
    public void onSuccess() {
        input_view.navigateToHome();
    }
}
