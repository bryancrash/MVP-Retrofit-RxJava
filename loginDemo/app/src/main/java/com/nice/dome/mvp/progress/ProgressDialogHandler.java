package com.nice.dome.mvp.progress;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.nice.dome.mvp.R;


public class ProgressDialogHandler extends Handler {

    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private ProgressDialog pd;
    private ProgressBar pb;

    private Context context;
    private boolean cancelable;
    private ProgressCancelListener mProgressCancelListener;
    private WindowManager windowManager;
    private WindowManager mWm;
    private Dialog loadingDialog;

    public ProgressDialogHandler(Context context, ProgressCancelListener mProgressCancelListener,
                                 boolean cancelable) {
        super();
        this.context = context;
        this.mProgressCancelListener = mProgressCancelListener;
        this.cancelable = cancelable;
    }




    private void initProgressDialog() {
        if (pd == null) {
            pd = new ProgressDialog(context);
            pd.setCancelable(cancelable);

            if (cancelable) {
                pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        mProgressCancelListener.onCancelProgress();
                    }
                });
            }

            if (!pd.isShowing()) {
                pd.show();
            }
        }
    }

    private void dismissProgressDialog() {
        if (pd != null) {
            pd.dismiss();
            pd = null;
        }
    }

    private void initDialog() {
        if (loadingDialog == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View v = inflater.inflate(R.layout.dialog_loading, null);// 得到加载view
            RelativeLayout layout = (RelativeLayout) v.findViewById(R.id.dialog_view);// 加载布局
            // main.xml中的ImageView
            ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
            // 加载动画
            Animation animation = AnimationUtils.loadAnimation(
                    context, R.anim.loading_animation);
            // 使用ImageView显示动画
            spaceshipImage.startAnimation(animation);
            // 创建自定义样式dialog
            loadingDialog = new Dialog(context, R.style.loading_dialog);

            loadingDialog.setCancelable(cancelable);// 可以用“返回键”取消
            loadingDialog.setContentView(layout, new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT));// 设置布局

            if (cancelable) {
                loadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        mProgressCancelListener.onCancelProgress();
                    }
                });
            }

            if (!loadingDialog.isShowing()) {
                loadingDialog.show();
            }
        }
    }

    private void dismissDialog() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }






    private void showProgressBar() {
        if (pb == null) {
            pb = new ProgressBar(context, null, android.R.attr.progressBarStyle);
            Activity mAcitvity = (Activity) context;
            mWm = (WindowManager) mAcitvity.getSystemService(Context.WINDOW_SERVICE);
            WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
            mParams.width = 80;
            mParams.height = 80;
            mWm.addView(pb, mParams);
        }

    }

    private void dismissProgressBar() {
        if (pb != null) {
            mWm.removeViewImmediate(pb);
            pb.setVisibility(View.INVISIBLE);
            pb = null;
        }
    }


    /**
     * 以下三个都可以实现效果
     */
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                //initProgressDialog();
                //showProgressBar();
                initDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                //dismissProgressDialog();
                //dismissProgressBar();
                dismissDialog();
                break;
        }
    }

}
