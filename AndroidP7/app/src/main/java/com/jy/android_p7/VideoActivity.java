package com.jy.android_p7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.yczbj.ycvideoplayerlib.player.VideoPlayer;
import org.yczbj.ycvideoplayerlib.ui.view.BasisVideoController;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mVideoBtn;
    private VideoPlayer mPlayerVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_video);
        initView ();
    }

    private void initView() {
        mVideoBtn = (Button) findViewById (R.id.btn_video);
        mVideoBtn.setOnClickListener (this);
        mPlayerVideo = (VideoPlayer) findViewById (R.id.video_player);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()) {
            case R.id.btn_video:
                // TODO 20/12/15
//                 创建基础视频播放器，一般播放器的功能
                BasisVideoController basisVideoController = new BasisVideoController (this);
//              设置控制器
                mPlayerVideo.setController (basisVideoController);
//              设置视频播放链接地址
                mPlayerVideo.setUrl ("http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8");
//                mPlayerVideo.setUrl ("/sdcard/Pictures/sb.mp4");
//              开始播放
                mPlayerVideo.start ();

                mPlayerVideo.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPlayerVideo.start();
                    }
                },300);
                break;
            default:
                break;
        }
    }
}
