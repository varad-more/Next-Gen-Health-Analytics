package com.learn2crack.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learn2crack.R;
import com.learn2crack.model.Response;
import com.learn2crack.model.User;
import com.learn2crack.network.NetworkUtil;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

import static com.learn2crack.utils.Validation.validateEmail;
import static com.learn2crack.utils.Validation.validateFields;

public class RegisterFragment extends Fragment {

    public static final String TAG = RegisterFragment.class.getSimpleName();

    private EditText mEtName;
    private EditText mEtEmail;
    private EditText mEtreg_number;
    private EditText mEtcontact_number;
    private EditText mEtaddress_of_prac;
    private EditText mEtpincode;
    private EditText mEtPassword;
    private Button   mBtRegister;
    private TextView mTvLogin;
    private TextInputLayout mTiName;
    private TextInputLayout mTiEmail;
    private TextInputLayout mTireg_number;
    private TextInputLayout mTicontact_number;
    private TextInputLayout mTiaddress_of_prac;
    private TextInputLayout mTipincode;
    private TextInputLayout mTiPassword;
    private ProgressBar mProgressbar;

    private CompositeSubscription mSubscriptions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register,container,false);
        mSubscriptions = new CompositeSubscription();
        initViews(view);
        return view;
    }

    private void initViews(View v) {

        mEtName = (EditText) v.findViewById(R.id.et_name);
        mEtEmail = (EditText) v.findViewById(R.id.et_email);
        mEtreg_number = (EditText) v.findViewById(R.id.et_reg_number);
        mEtcontact_number = (EditText) v.findViewById(R.id.et_contact_number);
        mEtaddress_of_prac = (EditText) v.findViewById(R.id.et_address_of_prac);
        mEtpincode = (EditText) v.findViewById(R.id.et_pincode);
        mEtPassword = (EditText) v.findViewById(R.id.et_password);
        mBtRegister = (Button) v.findViewById(R.id.btn_register);
        mTvLogin = (TextView) v.findViewById(R.id.tv_login);
        mTiName = (TextInputLayout) v.findViewById(R.id.ti_name);
        mTiEmail = (TextInputLayout) v.findViewById(R.id.ti_email);
        mTireg_number = (TextInputLayout) v.findViewById(R.id.ti_reg_number);
        mTicontact_number = (TextInputLayout) v.findViewById(R.id.ti_contact_number);
        mTiaddress_of_prac = (TextInputLayout) v.findViewById(R.id.ti_address_of_prac);
        mTipincode = (TextInputLayout) v.findViewById(R.id.ti_pincode);
        mTiPassword = (TextInputLayout) v.findViewById(R.id.ti_password);
        mProgressbar = (ProgressBar) v.findViewById(R.id.progress);

        mBtRegister.setOnClickListener(view -> register());
        mTvLogin.setOnClickListener(view -> goToLogin());
    }

    private void register() {

        setError();

        String name = mEtName.getText().toString();
        String email = mEtEmail.getText().toString();
        String reg_number = mEtreg_number.getText().toString();
        String contact_number = mEtcontact_number.getText().toString();
        String address_of_prac = mEtaddress_of_prac.getText().toString();
        String pincode = mEtpincode.getText().toString();
        String password = mEtPassword.getText().toString();

        int err = 0;

        if (!validateFields(name)) {

            err++;
            mTiName.setError("Name should not be empty !");
        }

        if (!validateEmail(email)) {

            err++;
            mTiEmail.setError("Email should be valid !");
        }

        if (!validateFields(reg_number)) {

            err++;
            mTireg_number.setError("Reg No should be valid !");
        }

        if (!validateFields(contact_number)) {

            err++;
            mTicontact_number.setError("Contact number should be valid !");
        }

        if (!validateFields(address_of_prac)) {

            err++;
            mTiaddress_of_prac.setError("Address should be valid !");
        }

        if (!validateFields(pincode)) {

            err++;
            mTipincode.setError("pincode should be valid !");
        }


        if (!validateFields(password)) {

            err++;
            mTiPassword.setError("Password should not be empty !");
        }

        if (err == 0) {

            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setReg_number(reg_number);
            user.setContact_number(contact_number);
            user.setAddress_of_prac(address_of_prac);
            user.setPincode(pincode);
            user.setPassword(password);

            mProgressbar.setVisibility(View.VISIBLE);
            registerProcess(user);

        } else {

            showSnackBarMessage("Enter Valid Details !");
        }
    }

    private void setError() {

        mTiName.setError(null);
        mTiEmail.setError(null);
        mTireg_number.setError(null);
        mTicontact_number.setError(null);
        mTiaddress_of_prac.setError(null);
        mTipincode.setError(null);
        mTiPassword.setError(null);
    }

    private void registerProcess(User user) {

        mSubscriptions.add(NetworkUtil.getRetrofit().register(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse,this::handleError));
    }

    private void handleResponse(Response response) {

        mProgressbar.setVisibility(View.GONE);
        showSnackBarMessage(response.getMessage());
    }

    private void handleError(Throwable error) {

        mProgressbar.setVisibility(View.GONE);

        if (error instanceof HttpException) {

            Gson gson = new GsonBuilder().create();

            try {

                String errorBody = ((HttpException) error).response().errorBody().string();
                Response response = gson.fromJson(errorBody,Response.class);
                showSnackBarMessage(response.getMessage());

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            showSnackBarMessage("Network Error !");
        }
    }

    private void showSnackBarMessage(String message) {

        if (getView() != null) {

            Snackbar.make(getView(),message,Snackbar.LENGTH_SHORT).show();
        }
    }

    private void goToLogin(){

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        LoginFragment fragment = new LoginFragment();
        ft.replace(R.id.fragmentFrame, fragment, LoginFragment.TAG);
        ft.commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSubscriptions.unsubscribe();
    }
}
