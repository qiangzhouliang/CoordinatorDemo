package com.example.qzl.coordinatordemo;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

public class TextInputActivity extends AppCompatActivity implements TextWatcher {

    private TextInputLayout mTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);
        mTextInputLayout = (TextInputLayout) findViewById(R.id.textinputlayout);
        mTextInputLayout.getEditText().addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.length() < 6){
            mTextInputLayout.setError("用户名必须大于6位");
            mTextInputLayout.setErrorEnabled(true);//开启错误
        }else {
            mTextInputLayout.setErrorEnabled(false);
        }
    }
}
