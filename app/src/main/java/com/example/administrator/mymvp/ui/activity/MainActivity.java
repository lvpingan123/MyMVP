package com.example.administrator.mymvp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mymvp.R;
import com.example.administrator.mymvp.service.entity.Bean;
import com.example.administrator.mymvp.service.presenter.BeanPresenter;
import com.example.administrator.mymvp.service.view.BeanView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.Tv)
    TextView Tv;
    @BindView(R.id.load_btn)
    Button loadBtn;
    private BeanPresenter beanPresenter;
    String path="http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        beanPresenter=new BeanPresenter(this,"http://www.qubaobei.com/ios/cf/");
        beanPresenter.onCreate();
        beanPresenter.attachView(beanView);
    }

    @OnClick(R.id.load_btn)
    public void onViewClicked() {
         beanPresenter.getBean("1","20","1");

    }
    private BeanView beanView=new BeanView() {
        @Override
        public void onSuccess(Bean bean) {
            Tv.setText(bean.toString());
        }

        @Override
        public void onError(String error) {
            Toast.makeText(MainActivity.this, "error:"+error, Toast.LENGTH_SHORT).show();
        }
    };
}
