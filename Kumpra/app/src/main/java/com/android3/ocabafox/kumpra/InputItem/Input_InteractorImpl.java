package com.android3.ocabafox.kumpra.InputItem;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by ocabafox on 7/6/2015.
 */
public class Input_InteractorImpl implements Input_Interactor{

    @Override
    public void input(final String input, final OnInputFinishedListener onInputFinishedListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if(TextUtils.isEmpty(input)){
                    onInputFinishedListener.onInputError();
                    error = true;
                }
                if(!error){

                    onInputFinishedListener.onSuccess();
                }
            }
        }, 1000);
    }
}
