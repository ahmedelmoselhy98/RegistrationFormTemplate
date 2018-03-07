package com.e.k.m.a.registrationform;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Form extends AppCompatActivity {

    private EditText inputFirstName, inputLasttName, inputAge;
    private TextInputLayout inputLayoutFirstName, inputLayoutLastName, inputLayoutAge;
    private Button regisiter;
    private RadioGroup genderRadioGroup,activityRadioGroup,situationRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        inputFirstName = findViewById(R.id.input_fname);
        inputLasttName = findViewById(R.id.input_lname);
        inputAge = findViewById(R.id.input_age);
        inputLayoutFirstName = findViewById(R.id.input_layout_fname);
        inputLayoutLastName = findViewById(R.id.input_layout_lname);
        inputLayoutAge = findViewById(R.id.input_layout_age);
        inputFirstName.addTextChangedListener(new MyTextWatcher(inputFirstName));
        inputLasttName.addTextChangedListener(new MyTextWatcher(inputLasttName));
        inputAge.addTextChangedListener(new MyTextWatcher(inputAge));
        regisiter = findViewById(R.id.btn_regisiter);
        genderRadioGroup = findViewById(R.id.gender_radiogroup);
        activityRadioGroup = findViewById(R.id.activity_radiogroup);
        situationRadioGroup = findViewById(R.id.situation_of_child_radiogroup);
        regisiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
    }
    private void submitForm() {
        if (!validateFirstName()) {
            return;
        }

        if (!validateLastName()) {
            return;
        }

        if (!validateAge()) {
            return;
        }
        if (!validateGender())
            return;
        if (!validateActivity())
            return;
        if (!validateSituation())
            return;
        Snackbar.make(regisiter,"Success!",Snackbar.LENGTH_SHORT).show();
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_fname:
                    validateFirstName();
                    break;
                case R.id.input_lname:
                    validateLastName();
                    break;
                case R.id.input_age:
                    validateAge();
                    break;
            }
        }
    }
    private boolean validateFirstName() {
        if (inputFirstName.getText().toString().trim().isEmpty()) {
            inputLayoutFirstName.setError(getString(R.string.err_msg_fName));
            requestFocus(inputFirstName);
            return false;
        } else {
            inputLayoutFirstName.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validateLastName() {
        if (inputLasttName.getText().toString().trim().isEmpty()) {
            inputLayoutLastName.setError(getString(R.string.err_msg_lName));
            requestFocus(inputLasttName);
            return false;
        } else {
            inputLayoutLastName.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validateAge() {
        if (inputAge.getText().toString().trim().isEmpty()) {
            inputLayoutAge.setError(getString(R.string.err_msg_Age));
            requestFocus(inputAge);
            return false;
        } else {
            inputLayoutAge.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validateGender() {
        if (genderRadioGroup.getCheckedRadioButtonId() == -1) {
            Snackbar.make(regisiter, "You Must Choose your Gender!", Snackbar.LENGTH_SHORT).show();
            return false;
        }
         else
            return true;
    }
    private boolean validateActivity() {
        if (activityRadioGroup.getCheckedRadioButtonId() == -1) {
            Snackbar.make(regisiter, "You Must Choose your Activity!", Snackbar.LENGTH_SHORT).show();
            return false;
        }
        else
            return true;
    }
    private boolean validateSituation() {
        if (situationRadioGroup.getCheckedRadioButtonId() == -1) {
            Snackbar.make(regisiter, "You Must Choose your Situation Of Child!", Snackbar.LENGTH_SHORT).show();
            return false;
        }
        else
            return true;
    }

}
