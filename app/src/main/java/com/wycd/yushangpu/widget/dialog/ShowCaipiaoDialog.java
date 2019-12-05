package com.wycd.yushangpu.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.WindowManager;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.Home;
import com.wycd.yushangpu.db.DBAdapter;
import com.wycd.yushangpu.http.InterfaceBack;

import java.util.List;


/**
 * Created by songxiaotao on 2017/12/21.
 */

public class ShowCaipiaoDialog extends Dialog {
    private InterfaceBack back;
    private DBAdapter mdbadapter;
    private List<Home> list;
    private Context context;

    public ShowCaipiaoDialog(Context context, final DBAdapter mdbadapter, final List<Home> list, final InterfaceBack back) {
        super(context, R.style.ActionSheetDialogAnimation);
        this.back = back;
        this.mdbadapter = mdbadapter;
        this.list = list;
        this.context = context;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.dialog_look_ballnum);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setView();
    }

    private void setView() {

    }

    @Override
    public void show() {
        super.show();
        /**
         * 设置宽度全屏，要设置在show的后面
         */
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setAttributes(layoutParams);
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param dipValue （DisplayMetrics类中属性density）
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
