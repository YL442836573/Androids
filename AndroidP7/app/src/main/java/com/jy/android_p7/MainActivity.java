package com.jy.android_p7;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jy.android_p7.factory.PhoneFactory;
import com.jy.android_p7.factory.phone;
import com.jy.android_p7.factory2.HuaWeiFactory;
import com.jy.android_p7.factory2.VivoFactory;
import com.jy.android_p7.factory3.ThreadPoolFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    private Button mFactoryBtn;
    private Button mFactoryThreadBtn;
    private Button mAbstractFactoryBtn;
    private Disposable subscribe;
    private TextView mShowTv;
    private Button mFactory3Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        initView ();
    }

    private void initView() {
        mFactoryBtn = (Button) findViewById (R.id.btn_factory);
        mFactoryBtn.setOnClickListener (this);
        mFactoryThreadBtn = (Button) findViewById (R.id.btn_factoryThread);
        mFactoryThreadBtn.setOnClickListener (this);
        mAbstractFactoryBtn = (Button) findViewById (R.id.btn_abstract_factory);
        mAbstractFactoryBtn.setOnClickListener (this);
        mShowTv = (TextView) findViewById (R.id.tv_show);
        mFactory3Btn = (Button) findViewById (R.id.btn_factory3);
        mFactory3Btn.setOnClickListener (this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()) {
            case R.id.btn_factory:
                // TODO 20/12/15
                initFactory ();
                break;
            case R.id.btn_factoryThread:// TODO 20/12/15
//                ThreadPoolFactory.getExecutor (ThreadPoolFactory.CACHE_THREADPOOL)
//                        .executeTask (new Runnable () {
//                            @Override
//                            public void run() {
//                                Log.e (TAG, "run: 这是缓存线程池");
////                                Toast.makeText (MainActivity.this, "这是缓存线程池", Toast.LENGTH_SHORT).show ();
//                            }
//                        });

                final long time = 3L;
                subscribe = Observable.interval (1, TimeUnit.SECONDS)
                        .subscribeOn (Schedulers.io ())
                        .observeOn (AndroidSchedulers.mainThread ())
                        .subscribe (new Consumer<Long> () {
                            @Override
                            public void accept(Long aLong) throws Exception {
                                if (aLong < time && !subscribe.isDisposed ()) {
                                    mShowTv.setText ("倒计时:" + (time - aLong - 1));
                                } else {
                                    Toast.makeText (MainActivity.this, "已完成", Toast.LENGTH_SHORT).show ();
                                    subscribe.dispose ();
                                }
                            }
                        });

                break;
            case R.id.btn_abstract_factory:// TODO 20/12/15
                HuaWeiFactory huaWeiFactory = new HuaWeiFactory ();
                com.jy.android_p7.factory2.phone phone = huaWeiFactory.createPhone ();
                phone.makephone ();

                VivoFactory vivoFactory = new VivoFactory ();
                com.jy.android_p7.factory2.phone phone1 = vivoFactory.createPhone ();
                phone1.makephone ();
                break;
            case R.id.btn_factory3:// TODO 20/12/15
                ThreadPoolFactory.getThreadPoolFatory (ThreadPoolFactory.CUSTOM_THREADPOOL).executerTask (new Runnable () {
                    @Override
                    public void run() {
                        // TODO 20/12/15
                        Log.e (TAG, "run: 漂亮");

                    }
                });
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop ();
        subscribe.dispose ();
    }

    private void initFactory() {
        phone miPhone = PhoneFactory.PhoneFactory ("MiPhone");
        miPhone.makePhone ();

        phone Iphone = PhoneFactory.PhoneFactory ("Iphone");
        Iphone.makePhone ();
    }
}
