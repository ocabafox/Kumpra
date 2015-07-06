package com.android3.ocabafox.kumpra.InputItem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.android3.ocabafox.kumpra.R;


/**
 * Created by ocabafox on 7/6/2015.
 */
public class Input_Activity extends Activity implements Input_View, View.OnClickListener {

    EditText GetInputItem;
    Input_Presenter input_presenter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_layout);

        progressBar  = (ProgressBar) findViewById(R.id.progress);
        GetInputItem = (EditText) findViewById(R.id.InputItem);

        input_presenter = new Input_PresenterImpl(this);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setInputError() {
        GetInputItem.setError("Input cannot be empty");
    }

    @Override
    public void navigateToHome() {
//        startActivity(new Intent(this, ));
    }


    public void onClick(View v) {
        input_presenter.validateCredentioals(GetInputItem.getText().toString());
    }
}
