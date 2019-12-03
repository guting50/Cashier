package com.wycd.yushangpu.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.KeyboardUtils;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.adapter.SearchVipPopAdapter;
import com.wycd.yushangpu.bean.VipDengjiMsg;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpOnlyVipMsg;
import com.wycd.yushangpu.tools.DateUtils;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by ZPH on 2019-06-29.
 */

public class VipChooseDialog extends Dialog {


    @BindView(R.id.keyboard_title)
    TextView keyboardTitle;
    @BindView(R.id.iv_close)
    ImageView ivClose;
    @BindView(R.id.tv_content)
    EditText tv_content;
    @BindView(R.id.iv_del)
    ImageView ivDel;
    @BindView(R.id.rl_search)
    RelativeLayout rlSearch;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_cardnum)
    TextView tvCardnum;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_birthday)
    TextView tvBirthday;
    @BindView(R.id.tv_grade)
    TextView tvGrade;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_balance)
    TextView tvBalance;
    @BindView(R.id.tv_integral)
    TextView tvIntegral;
    @BindView(R.id.btn_keyboard_7)
    Button btnKeyboard7;
    @BindView(R.id.btn_keyboard_8)
    Button btnKeyboard8;
    @BindView(R.id.btn_keyboard_9)
    Button btnKeyboard9;
    @BindView(R.id.btn_keyboard_4)
    Button btnKeyboard4;
    @BindView(R.id.btn_keyboard_5)
    Button btnKeyboard5;
    @BindView(R.id.btn_keyboard_6)
    Button btnKeyboard6;
    @BindView(R.id.btn_keyboard_1)
    Button btnKeyboard1;
    @BindView(R.id.btn_keyboard_2)
    Button btnKeyboard2;
    @BindView(R.id.btn_keyboard_3)
    Button btnKeyboard3;
    @BindView(R.id.btn_keyboard_0)
    Button btnKeyboard0;
    @BindView(R.id.btn_keyboard_00)
    Button btnKeyboard00;
    @BindView(R.id.btn_keyboard_delete)
    LinearLayout btnKeyboardDelete;
    @BindView(R.id.btn_keyboard_dian)
    Button btnKeyboardDian;
    @BindView(R.id.btn_keyboard_confirm)
    TextView btnKeyboardConfirm;
    @BindView(R.id.ll_keyboard_confirm)
    LinearLayout llKeyboardConfirm;
    @BindView(R.id.ll_fast_consume_keyboard)
    LinearLayout llFastConsumeKeyboard;

    private Activity mContext;
    private InterfaceBack back;
    private Dialog dialog;
    private StringBuilder mEditContentBuilder = new StringBuilder("");
    private VipDengjiMsg mVipDengjiMsg;
    private VipDengjiMsg.DataBean mVipDetail;
    private PopupWindow popupWindow;

    public VipChooseDialog(Activity context, final InterfaceBack back) {
        super(context, R.style.ActionSheetDialogStyle);
        this.mContext = context;
        this.back = back;
        dialog = LoadingDialog.loadingDialog(context, 1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_choose_vip);
        ButterKnife.bind(this);
        setCancelable(true);
        setCanceledOnTouchOutside(true);

        tv_content.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    rlSearch.setBackgroundResource(R.drawable.bg_edittext_focused);
                } else {
                    rlSearch.setBackgroundResource(R.drawable.bg_edittext_normal);
                }
            }
        });

        KeyboardUtils.registerSoftInputChangedListener(mContext, new KeyboardUtils.OnSoftInputChangedListener() {
            @Override
            public void onSoftInputChanged(int height) {
                if (height == 0) {
                    rlSearch.requestFocus();
                }
            }
        });

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


    @OnClick({R.id.iv_close, R.id.tv_content, R.id.iv_del, R.id.btn_keyboard_7, R.id.btn_keyboard_8, R.id.btn_keyboard_9, R.id.btn_keyboard_4, R.id.btn_keyboard_5, R.id.btn_keyboard_6, R.id.btn_keyboard_1, R.id.btn_keyboard_2, R.id.btn_keyboard_3, R.id.btn_keyboard_0, R.id.btn_keyboard_00, R.id.btn_keyboard_delete, R.id.btn_keyboard_dian, R.id.ll_keyboard_confirm, R.id.li_jiesuan})
    public void onViewClicked(View view) {
        KeyboardUtils.hideSoftInput(view);
        switch (view.getId()) {
            case R.id.iv_close:
                dismiss();

                break;
            case R.id.tv_content:

                break;
            case R.id.iv_del:
                rlSearch.requestFocus();
                tv_content.setText("");
                mEditContentBuilder = new StringBuilder("");
                break;
            case R.id.btn_keyboard_7:
                keyTouch("7");

                break;
            case R.id.btn_keyboard_8:
                keyTouch("8");

                break;
            case R.id.btn_keyboard_9:
                keyTouch("9");

                break;
            case R.id.btn_keyboard_4:
                keyTouch("4");

                break;
            case R.id.btn_keyboard_5:
                keyTouch("5");

                break;
            case R.id.btn_keyboard_6:
                keyTouch("6");

                break;
            case R.id.btn_keyboard_1:
                keyTouch("1");

                break;
            case R.id.btn_keyboard_2:
                keyTouch("2");

                break;
            case R.id.btn_keyboard_3:
                keyTouch("3");

                break;
            case R.id.btn_keyboard_0:
                keyTouch("0");

                break;
            case R.id.btn_keyboard_00:
                keyTouch("00");

                break;
            case R.id.btn_keyboard_delete:
                rlSearch.requestFocus();
                mEditContentBuilder = new StringBuilder(tv_content.getText().toString());

                if (!NullUtils.isNull(mEditContentBuilder)) {
                    mEditContentBuilder.deleteCharAt(mEditContentBuilder.length() - 1);
                }
                tv_content.setText(mEditContentBuilder.toString() + "");
                break;
            case R.id.btn_keyboard_dian:
                rlSearch.requestFocus();
                mEditContentBuilder = new StringBuilder(tv_content.getText().toString());
                if (!NullUtils.isNull(mEditContentBuilder) && !mEditContentBuilder.toString().contains(".")) {
                    mEditContentBuilder.append(".");
                }
                if (NullUtils.isNull(mEditContentBuilder)) {
                    mEditContentBuilder.append("0.");
                }
                if (!NullUtils.isNull(mEditContentBuilder)) {
                    String[] str = mEditContentBuilder.toString().split("\\+");
                    if (!str[str.length - 1].contains(".")) {
                        mEditContentBuilder.append(".");
                    }
                }
                tv_content.setText(mEditContentBuilder.toString() + "");
                break;
            case R.id.ll_keyboard_confirm:
                rlSearch.requestFocus();
                obtainVipList(mContext, tv_content.getText().toString(), tv_content);

                break;
            case R.id.li_jiesuan:
                rlSearch.requestFocus();
                if (mVipDetail != null) {
                    back.onResponse(mVipDetail);
                    dismiss();
                } else {
//                    ToastUtils.showToast(mContext, "请选择会员");
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择会员");
                }
                break;
        }
    }


    private void keyTouch(String string) {
        rlSearch.requestFocus();
        mEditContentBuilder = new StringBuilder("");
        mEditContentBuilder.append(tv_content.getText().toString());
        mEditContentBuilder.append(string);
        tv_content.setText(mEditContentBuilder.toString() + "");
    }


    private void obtainVipList(Activity context, String serachContent, final View view) {
        dialog.show();

        ImpOnlyVipMsg onlyVipMsg = new ImpOnlyVipMsg();
        onlyVipMsg.vipMsg(context, serachContent, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                dialog.dismiss();
                mVipDengjiMsg = (VipDengjiMsg) response;
                //查询单个结果直接显示  多个结果popwindow显示选择
                if (mVipDengjiMsg.getData().size() == 1) {
                    mVipDetail = mVipDengjiMsg.getData().get(0);
                    initView();

                } else if (mVipDengjiMsg.getData().size() > 1) {
                    showPop(view);


                } else {//没有查询到结果

                }

            }

            @Override
            public void onErrorResponse(Object msg) {
                dialog.dismiss();
            }
        });

    }

    /**
     * 查询结果为多个会员时弹窗
     *
     * @param v
     */

    private void showPop(View v) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.pop_search_vip_list, null);
        int viewWidth = v.getWidth();
        popupWindow = new PopupWindow(mContext);
        popupWindow.setContentView(view);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setWidth(viewWidth);
        popupWindow.setHeight(ListPopupWindow.WRAP_CONTENT);
        popupWindow.showAsDropDown(v);
        ListView poplist = (ListView) view.findViewById(R.id.lv_search);
        SearchVipPopAdapter searchVipPopAdapter = new SearchVipPopAdapter(mContext, mVipDengjiMsg);
        poplist.setAdapter(searchVipPopAdapter);

        poplist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popupWindow.dismiss();
                mVipDetail = mVipDengjiMsg.getData().get(position);
                initView();


            }
        });
    }

    /***
     *查询会员后数据页面显示
     */

    private void initView() {
        if (DateUtils.isOverTime(mVipDetail.getVIP_Overdue())) {
//            tv_content.setText(mVipDetail.getVCH_Card() + "");
            tvName.setText("姓名：" + NullUtils.noNullHandle(mVipDetail.getVIP_Name()) + "");
            tvCardnum.setText("卡号：" + NullUtils.noNullHandle(mVipDetail.getVCH_Card()) + "");
            tvSex.setText("性别：" + sexIntToString(mVipDetail.getVIP_Sex()));
            tvBirthday.setText("生日：" + NullUtils.noNullHandle(mVipDetail.getVIP_Birthday()) + "");
            tvGrade.setText("等级：" + NullUtils.noNullHandle(mVipDetail.getVG_Name()) + "");
            tvPhone.setText("手机：" + NullUtils.noNullHandle(mVipDetail.getVIP_CellPhone()) + "");
            tvBalance.setText(StringUtil.twoNum(String.valueOf(NullUtils.noNullHandle(mVipDetail.getMA_AvailableBalance()))) + "");
            tvIntegral.setText(StringUtil.twoNum(String.valueOf(NullUtils.noNullHandle(mVipDetail.getMA_AvailableIntegral()))) + "");
        } else {
//            ToastUtils.showToast(mContext, "该会员已过期");
            com.blankj.utilcode.util.ToastUtils.showShort("该会员已过期");
            mVipDetail = null;
        }


    }

    /***
     * 编译男女
     * @param sex
     * @return
     */
    private String sexIntToString(int sex) {
        if (sex == 0) {
            return "男";
        } else if (sex == 1) {
            return "女";
        }
        return "未知";
    }
}
