package com.example.day100.mvp.show.presenter;

import com.example.day100.activity.ShowActivity;
import com.example.day100.bean.ShowBean;
import com.example.day100.mvp.show.model.IShowModel;
import com.example.day100.mvp.show.model.ShowModel;
import com.example.day100.mvp.show.view.IShowView;

public class ShowPresenter implements IShowPresenter {
    private IShowView iShowView;
    private ShowModel showModel;

    public ShowPresenter(IShowView iShowView) {
        this.iShowView=iShowView;
        this.showModel=new ShowModel();
    }

    public void setShow(int pscid){
        showModel.getShow(pscid, new IShowModel() {
            @Override
            public void onSuccess(ShowBean showBean) {
                iShowView.onSuccess(showBean);
            }
        });
    }


    @Override
    public void onDestroys() {
        if (iShowView!=null){
            iShowView=null;
        }
    }
}
