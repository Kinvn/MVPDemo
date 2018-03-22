package com.kinvn.mvp.mvpdemo;

import com.kinvn.mvp.mvpdemo.Model.OnLoginListener;

/**
 * Created by Kinvn on 2018/3/21.
 */

public interface IUserBiz {
    public void login(String username, String password, OnLoginListener listener);
}
