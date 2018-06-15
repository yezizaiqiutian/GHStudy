package com.gh.ghstudy.demo.shap;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.RotateDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.Toast;

import com.gh.ghstudy.R;
import com.gh.ghstudy.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: gh
 * @description:
 * @date: 2018/6/15.
 * @from: shap和layer-list
 * layer-list
 * https://blog.csdn.net/north1989/article/details/53485729
 * https://blog.csdn.net/baidu_33221362/article/details/70217265
 * shap
 * https://www.cnblogs.com/MianActivity/p/5867776.html
 * roate
 * (该博客中有很多其他drawable功能的讲解)
 * https://blog.csdn.net/lonelyroamer/article/details/8252533
 *
 */
public class ShapActivity extends BaseActivity {

    @BindView(R.id.id_iv_roate)
    ImageView id_iv_roate;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, ShapActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shap);
        ButterKnife.bind(this);

        roate();

    }


    private RotateDrawable rotateDrawable;
    int level = 0;

    private void roate() {
        rotateDrawable = (RotateDrawable) id_iv_roate.getDrawable();
        thread.start();
    }

    private Thread thread = new Thread(new Runnable() {
        public void run() {
            while (level <= 10000) {
                handler.sendEmptyMessage(0x00);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            Toast.makeText(mContext, level + "", Toast.LENGTH_SHORT).show();
            rotateDrawable.setLevel(level);
            level += 1000;
        }
    };


}
