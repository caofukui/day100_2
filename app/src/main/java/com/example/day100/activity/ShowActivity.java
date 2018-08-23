package com.example.day100.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.day100.MainActivity;
import com.example.day100.R;
import com.example.day100.adapter.MyLieBiaoAdapter;
import com.example.day100.bean.ShowBean;
import com.example.day100.mvp.show.presenter.ShowPresenter;
import com.example.day100.mvp.show.view.IShowView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity implements IShowView {

    @BindView(R.id.show_xrv)
    XRecyclerView showXrv;
    private ShowPresenter showPresenter;
    private MyLieBiaoAdapter myLieBiaoAdapter;
    private int pscid=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        showXrv.setLayoutManager(new LinearLayoutManager(ShowActivity.this,LinearLayoutManager.VERTICAL,false));
        showPresenter=new ShowPresenter(this);
        showPresenter.setShow(pscid);
        showXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                pscid=1;
                showPresenter.setShow(pscid);
                showXrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                pscid++;
                showPresenter.setShow(pscid);
                showXrv.loadMoreComplete();
            }
        });

    }

    @Override
    public void onSuccess(ShowBean showBean) {
        myLieBiaoAdapter = new MyLieBiaoAdapter(ShowActivity.this, showBean.getData());
        showXrv.setAdapter(myLieBiaoAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showPresenter.onDestroys();
    }
}
