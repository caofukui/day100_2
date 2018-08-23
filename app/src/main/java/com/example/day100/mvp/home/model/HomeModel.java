package com.example.day100.mvp.home.model;

import android.util.Log;

import com.example.day100.bean.DesignerBean;
import com.example.day100.bean.LunBoBean;
import com.example.day100.bean.NewsBean;
import com.example.day100.utils.RetrofitUtils;
import com.example.day100.utils.RetrofitUtils2;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HomeModel {

    private static final String TAG =HomeModel.class.getSimpleName() ;

    public void getLunBo(final IHomeModel iHomeModel){
        Observable<LunBoBean> observable = RetrofitUtils.getInstance().getInterface().getLunBo();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LunBoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG,e.getMessage());
                    }

                    @Override
                    public void onNext(LunBoBean lunBoBean) {
                        iHomeModel.onSucccessLunBo(lunBoBean);
                    }
                });
    }

    public void getDesigner(String token, String version, final IHomeModel iHomeModel){
        Observable<DesignerBean> observable = RetrofitUtils2.getInstance().getInterface().getDesigner(token, version);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DesignerBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DesignerBean designerBean) {
                        iHomeModel.onSuccessDesigner(designerBean);
                    }
                });
    }


    public void getNews(final IHomeModel iHomeModel){
        Observable<NewsBean> observable = RetrofitUtils.getInstance().getInterface().getNews();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        iHomeModel.onSuccessNews(newsBean);
                    }
                });
    }


}
