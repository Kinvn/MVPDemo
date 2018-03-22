package com.kinvn.mvp.mvpdemo;

import com.kinvn.mvp.mvpdemo.Model.User;

/**
 * Created by Kinvn on 2018/3/21.
 */

public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
