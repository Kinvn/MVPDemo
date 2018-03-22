package com.kinvn.mvp.mvpdemo.Presenter;

import android.os.Handler;

import com.kinvn.mvp.mvpdemo.IUserBiz;
import com.kinvn.mvp.mvpdemo.IUserLoginView;
import com.kinvn.mvp.mvpdemo.Model.User;
import com.kinvn.mvp.mvpdemo.Model.UserBiz;
import com.kinvn.mvp.mvpdemo.Model.OnLoginListener;

/**
 * Created by Kinvn on 2018/3/22.
 */

public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler handler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login() {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.hideLoading();
                        userLoginView.toMainActivity(user);
                    }
                });
            }

            @Override
            public void loginFailed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.hideLoading();
                        userLoginView.showFailedError();
                    }
                });
            }
        });
    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
