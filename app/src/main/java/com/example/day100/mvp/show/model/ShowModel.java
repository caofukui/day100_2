package com.example.day100.mvp.show.model;

import com.example.day100.bean.ShowBean;
import com.example.day100.utils.RetrofitUtils;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ShowModel {

    public void getShow(int pscid, final IShowModel iShowModel){
        Observable<ShowBean> observable = RetrofitUtils.getInstance().getInterface().getShow(pscid);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShowBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ShowBean showBean) {
                        iShowModel.onSuccess(showBean);
                    }
                });
    }

}
