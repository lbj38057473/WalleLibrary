package org.wall.mo.base.mvp;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import org.wall.mo.base.fragment.MaxLifecycleFragment;

/**
 * Copyright (C), 2018-2020
 * Author: ziqimo
 * Date: 2020-01-01 22:04
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public abstract class BaseMVPMaxLifecycleFragment<presenter extends BaseContract.BasePresenter, B extends ViewDataBinding, T extends Parcelable>
        extends MaxLifecycleFragment<B, T>
        implements BaseContract.BaseView {

    public presenter mPresenter;

    /**
     * 展示dialog次数
     */
    private int showDialogCount = 0;


    protected abstract presenter createPresenter();


    @Override
    public void initView(View rootView, Bundle savedInstanceState) {
        mPresenter = createPresenter();
        if (mPresenter != null) {
            //这里处理一次
            mPresenter.attachView(this);
            mPresenter.onCreate(savedInstanceState);
        }
    }


    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        mPresenter.onRestoreInstanceState(savedInstanceState);
    }


    @Override
    public void onStart() {
        super.onStart();
        if (mPresenter != null) {
            mPresenter.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter != null) {
            boolean viewNull = mPresenter.onResume();
            if (!viewNull) {
                mPresenter.detachView();
                //这里处理再一次
                mPresenter.attachView(this);
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mPresenter != null) {
            mPresenter.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mPresenter != null) {
            mPresenter.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onCurDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter.onDestroy();
        }
        mPresenter = null;
    }

    protected abstract void onCurDestroy();


    @Override
    public void onLoadFail(boolean showLoading, int flag) {
        if (!showLoading) {
            return;
        }
        //错误提示，让自己实现，不在底层处理
        showDialogCount--;
        if (showDialogCount < 0) {
            showDialogCount = 0;
            hideDialog();
        }
    }

    @Override
    public void onLoadStart(boolean showLoading, int flag, String tipMsg) {
        if (!showLoading) {
            return;
        }
        showDialogCount++;
        if (showDialogCount == 1) {
            showDialog(tipMsg);
        }
    }

    @Override
    public void onLoadSuccess(boolean showLoading, int flag, Object model) {
        if (!showLoading) {
            return;
        }
        showDialogCount--;
        if (showDialogCount < 0) {
            showDialogCount = 0;
            hideDialog();
        }
    }
}
