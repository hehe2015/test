package com.newyulong.materialdesignstu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by Administrator on 2017/11/2.
 */

public class TextInputLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textinputlayout);

        final TextInputLayout til2 = findViewById(R.id.til_2);
        final EditText et2 = findViewById(R.id.et_2);

        et2.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            public void afterTextChanged(Editable s) {
                String s1 = s.toString();
                if (s1.length()>11){
//                    et2.setError("不能超过11个字符");
                    til2.setError("不能超过11个字符");
                } else{
//                    et2.setError(null);
                    til2.setError(null);
                }
            }
        });

    }
}
