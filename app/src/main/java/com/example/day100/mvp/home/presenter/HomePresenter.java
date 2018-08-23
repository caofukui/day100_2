package com.example.day100.mvp.home.presenter;

import com.example.day100.MainActivity;
import com.example.day100.bean.DesignerBean;
import com.example.day100.bean.LunBoBean;
import com.example.day100.bean.NewsBean;
import com.example.day100.mvp.home.model.HomeModel;
import com.example.day100.mvp.home.model.IHomeModel;
import com.example.day100.mvp.home.view.IHomeView;

public class HomePresenter implements IHomePresenter {
    private IHomeView iHomeView;
    private HomeModel homeModel;

    public HomePresenter(IHomeView iHomeView) {
        this.iHomeView=iHomeView;
        this.homeModel=new HomeModel();
    }

    public void setLunBo(){
        homeModel.getLunBo(new IHomeModel() {
            @Override
            public void onSucccessLunBo(LunBoBean lunBoBean) {
                iHomeView.onSucccessLunBo(lunBoBean);
            }

            @Override
            public void onSuccessDesigner(DesignerBean designerBean) {

            }

            @Override
            public void onSuccessNews(NewsBean newsBean) {

            }
        });
    }

    public void setDesigner(String token, String version){
        homeModel.getDesigner(token, version, new IHomeModel() {
            @Override
            public void onSucccessLunBo(LunBoBean lunBoBean) {

            }

            @Override
            public void onSuccessDesigner(DesignerBean designerBean) {
                iHomeView.onSuccessDesigner(designerBean);
            }

            @Override
            public void onSuccessNews(NewsBean newsBean) {

            }
        });
    }

    public void setNews(){
        homeModel.getNews(new IHomeModel() {
            @Override
            public void onSucccessLunBo(LunBoBean lunBoBean) {

            }

            @Override
            public void onSuccessDesigner(DesignerBean designerBean) {

            }

            @Override
            public void onSuccessNews(NewsBean newsBean) {
                iHomeView.onSuccessNews(newsBean);
            }
        });
    }


    @Override
    public void onDestroys() {
        if (iHomeView!=null){
            iHomeView=null;
        }
    }
}
