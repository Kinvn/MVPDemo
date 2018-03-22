package com.kinvn.mvp.mvpdemo.Model;

import com.kinvn.mvp.mvpdemo.Model.User;

/**
 * Created by Kinvn on 2018/3/21.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
