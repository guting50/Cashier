package com.wycd.yushangpu.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库创建类 封装创建SQLite数据库及卷烟信息表
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "yunshangpu";
    public static final int DATABASE_VERSION = 1;
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS ";
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ";


    public static final String HOME_TABLE_NAME = "HOME";
    public static final String ID = "id";

    /**
     * 选择商品
     */

    public static final String home_lotteryid = "lotteryId";
    public static final String home_number = "number";
    public static final String home_price = "price";
    public static final String home_lotterytype = "lotteryType";
    public static final String home_lotteryno = "lotteryNo";
    public static final String home_name = "name";
    public static final String home_total = "total";
    public static final String home_company = "company";
    public static final String home_aheadcount = "aheadCount";
    public static final String home_aheadmaxnumber = "aheadMaxNumber";
    public static final String home_behindcount = "behindCount";
    public static final String home_behindmaxnumber = "behindMaxNumber";
    public static final String home_icon = "icon";
    public static final String home_symbol = "symbol";
    public static final String home_lotterytime = "lotteryTime";
    public static final String home_type = "type";
    public static final String home_aheadchosenumber = "aheadChoseNumber";
    public static final String home_behindchosenumber = "behindChoseNumber";
    public static final String home_chosenumbertop = "chosenumberTop";
    public static final String home_chosenumberdown = "chosenumberDown";
    public static final String home_zhunum = "zhuNum";
    public static final String home_account = "account";
    public static final String home_biaohao = "biaohao";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(createShopMsg());// 创建车辆信息表
    }

    private String createShopMsg() {
        StringBuilder sb = new StringBuilder();
        sb.append(CREATE_TABLE);
        sb.append(HOME_TABLE_NAME);
        sb.append("(");
        sb.append(ID).append(" integer primary key autoincrement,");
        sb.append(home_aheadchosenumber).append(" varchar(32) ,");
        sb.append(home_aheadcount).append(" varchar(32),");
        sb.append(home_aheadmaxnumber).append(" varchar(32),");
        sb.append(home_behindchosenumber).append(" varchar(32),");
        sb.append(home_behindmaxnumber).append(" varchar(32),");
        sb.append(home_behindcount).append(" varchar(32),");
        sb.append(home_chosenumberdown).append(" varchar(32),");
        sb.append(home_chosenumbertop).append(" varchar(32),");
        sb.append(home_company).append(" varchar(32),");
        sb.append(home_icon).append(" varchar(32),");
        sb.append(home_lotteryid).append(" varchar(32),");
        sb.append(home_lotteryno).append(" varchar(32),");
        sb.append(home_lotterytime).append(" varchar(32),");
        sb.append(home_lotterytype).append(" varchar(32),");
        sb.append(home_name).append(" varchar(32),");
        sb.append(home_number).append(" varchar(32),");
        sb.append(home_symbol).append(" varchar(32),");
        sb.append(home_total).append(" varchar(32),");
        sb.append(home_type).append(" varchar(32),");
        sb.append(home_zhunum).append(" varchar(32),");
        sb.append(home_account).append(" varchar(32),");
        sb.append(home_biaohao).append(" varchar(32),");
        sb.append(home_price).append(" varchar(32)");
        sb.append(")");
        return sb.toString();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE + HOME_TABLE_NAME);// 保存信息
        onCreate(db);
    }

}
