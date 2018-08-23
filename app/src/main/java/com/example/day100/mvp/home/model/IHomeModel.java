package com.example.day100.mvp.home.model;

import com.example.day100.bean.DesignerBean;
import com.example.day100.bean.LunBoBean;
import com.example.day100.bean.NewsBean;

public interface IHomeModel {
    void onSucccessLunBo(LunBoBean lunBoBean);
    void onSuccessDesigner(DesignerBean designerBean);
    void onSuccessNews(NewsBean newsBean);
}
