package com.wycd.yushangpu.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.wycd.yushangpu.bean.Home;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter {
    private volatile static DBAdapter adapterInstance;
    private Context context;
    private DBHelper tvmDBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx) {
        this.context = ctx;
        tvmDBHelper = new DBHelper(context);

    }

    /**
     * return DBAdapter instance
     *
     * @param ctx
     * @return
     */
    public static synchronized DBAdapter getInstance(Context ctx) {
        if (adapterInstance == null) {
            synchronized (DBAdapter.class) {
                if (adapterInstance == null) {
                    adapterInstance = new DBAdapter(ctx);
                    adapterInstance.openWriteable();
                }
            }
        }
        return adapterInstance;
    }

    public void openWriteable() throws SQLException {
        db = tvmDBHelper.getWritableDatabase();
    }

    /**
     * close the database
     */
    public void close() {
        if (tvmDBHelper != null) {
            tvmDBHelper.close();
            tvmDBHelper = null;
            adapterInstance = null;
        }
    }


    /**
     * 更新购物车信息
     */
    public void updateHome(Home shopcar, String biaohao) {
        ContentValues initialValues = getHomeValues(shopcar);

        int id = db.update(DBHelper.HOME_TABLE_NAME, initialValues,
                DBHelper.home_biaohao + " =?", new String[]{biaohao});
    }


    public void updateListShopCar(List<Home> list, String biaohao) {
        for (Home home : list) {
            ContentValues initialValues = getHomeValues(home);

            int id = db.update(DBHelper.HOME_TABLE_NAME, initialValues,
                    DBHelper.home_biaohao + " =?", new String[]{biaohao});
        }
    }


    public ContentValues getHomeValues(Home shopcar) {
        ContentValues initialValues = new ContentValues();

        initialValues.put(DBHelper.home_account, shopcar.account);
        initialValues.put(DBHelper.home_aheadchosenumber, shopcar.aheadChoseNumber);
        initialValues.put(DBHelper.home_aheadcount, shopcar.aheadCount);
        initialValues.put(DBHelper.home_aheadmaxnumber, shopcar.aheadMaxNumber);
        initialValues.put(DBHelper.home_behindchosenumber, shopcar.behindChoseNumber);
        initialValues.put(DBHelper.home_behindcount, shopcar.behindCount);
        initialValues.put(DBHelper.home_behindmaxnumber, shopcar.behindMaxNumber);
        initialValues.put(DBHelper.home_biaohao, shopcar.biaohao);
        initialValues.put(DBHelper.home_chosenumberdown, shopcar.chosenumberDown + "");
        initialValues.put(DBHelper.home_chosenumbertop, shopcar.chosenumberTop + "");
        initialValues.put(DBHelper.home_company, shopcar.company);
        initialValues.put(DBHelper.home_icon, shopcar.icon);
        initialValues.put(DBHelper.home_lotteryid, shopcar.lotteryId);
        initialValues.put(DBHelper.home_lotteryno, shopcar.lotteryNo);
        initialValues.put(DBHelper.home_lotterytime, shopcar.lotteryTime);
        initialValues.put(DBHelper.home_lotterytype, shopcar.lotteryType);
        initialValues.put(DBHelper.home_name, shopcar.name);
        initialValues.put(DBHelper.home_number, shopcar.number);
        initialValues.put(DBHelper.home_price, shopcar.price);
        initialValues.put(DBHelper.home_symbol, shopcar.symbol);
        initialValues.put(DBHelper.home_total, shopcar.total);
        initialValues.put(DBHelper.home_type, shopcar.type);
        initialValues.put(DBHelper.home_zhunum, shopcar.zhuNum);
        return initialValues;
    }

    /**
     * 根据账号获取商品信息
     *
     * @return
     */
    public List<Home> getLiHome(Cursor cursor) {
        List<Home> list = null;
        if (cursor != null) {
            list = new ArrayList<Home>();
            while (cursor.moveToNext()) {
                Home shopcar = new Home();
                shopcar.name = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_name));
                shopcar.aheadChoseNumber = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_aheadchosenumber));
                shopcar.aheadCount = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_aheadcount));
                shopcar.aheadMaxNumber = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_aheadmaxnumber));
                shopcar.behindChoseNumber = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_behindchosenumber));
                shopcar.behindCount = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_behindcount));
                shopcar.behindMaxNumber = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_behindmaxnumber));
                shopcar.biaohao = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_biaohao));
                shopcar.chosenumberDown = Integer.parseInt(cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_chosenumberdown)));
                shopcar.chosenumberTop = Integer.parseInt(cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_chosenumbertop)));
                shopcar.company = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_company));
                shopcar.icon = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_icon));
                shopcar.lotteryId = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_lotteryid));
                shopcar.lotteryNo = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_lotteryno));
                shopcar.lotteryTime = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_lotterytime));
                shopcar.lotteryType = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_lotterytype));
                shopcar.number = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_number));
                shopcar.symbol = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_symbol));
                shopcar.total = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_total));
                shopcar.type = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_type));
                shopcar.zhuNum = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_zhunum));
                shopcar.price = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_price));
                shopcar.account = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_account));
                list.add(shopcar);
            }

            if (!cursor.isClosed()) {
                cursor.close();
            }
        }
        return list;
    }

    /**
     * 根据账号获取商品信息
     *
     * @return
     */
    public List<Home> getListHome(String account) {
        Cursor cursor = null;
        cursor = db.query(DBHelper.HOME_TABLE_NAME, null,
                DBHelper.home_account + " =?", new String[]{account.trim()},
                null, null, null);

        return getLiHome(cursor);
    }

    /**
     * 根据商品id获取购物车商品信息
     *
     * @return
     */
    public Home getHome(String number) {
        Home shopcar = null;
        Cursor cursor = null;
        if (!"".equals(number)) {
            cursor = db.query(DBHelper.HOME_TABLE_NAME, null,
                    DBHelper.home_biaohao + "=?", new String[]{number}, null,
                    null, null);
            if (cursor.moveToFirst()) {
                shopcar = new Home();
                shopcar.name = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_name));
                shopcar.aheadChoseNumber = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_aheadchosenumber));
                shopcar.aheadCount = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_aheadcount));
                shopcar.aheadMaxNumber = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_aheadmaxnumber));
                shopcar.behindChoseNumber = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_behindchosenumber));
                shopcar.behindCount = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_behindcount));
                shopcar.behindMaxNumber = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_behindmaxnumber));
                shopcar.biaohao = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_biaohao));
                shopcar.chosenumberDown = Integer.parseInt(cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_chosenumberdown)));
                shopcar.chosenumberTop = Integer.parseInt(cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_chosenumbertop)));
                shopcar.company = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_company));
                shopcar.icon = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_icon));
                shopcar.lotteryId = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_lotteryid));
                shopcar.lotteryNo = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_lotteryno));
                shopcar.lotteryTime = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_lotterytime));
                shopcar.lotteryType = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_lotterytype));
                shopcar.number = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_number));
                shopcar.symbol = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_symbol));
                shopcar.total = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_total));
                shopcar.type = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_type));
                shopcar.zhuNum = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_zhunum));
                shopcar.price = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_price));
                shopcar.account = cursor.getString(cursor
                        .getColumnIndex(DBHelper.home_account));
            }
        }
        if (!cursor.isClosed()) {
            cursor.close();
        }
        return shopcar;
    }
    //

    /**
     * 将所有获取到的卷烟信息保存到数据库中
     *
     * @return
     */
    public long insertHome(List<Home> list) {
        // deleteLABEL_TABLE_NAME();
        int count = 0;
        if (null != list && list.size() > 0) {
            db.beginTransaction();
            ContentValues initialValues = null;
            for (Home shopcar : list) {
                if (hasShopCar(shopcar.biaohao)) {
                    updateHome(shopcar, shopcar.biaohao);
                } else {
                    initialValues = new ContentValues();
                    initialValues.put(DBHelper.home_account, shopcar.account);
                    initialValues.put(DBHelper.home_aheadchosenumber, shopcar.aheadChoseNumber);
                    initialValues.put(DBHelper.home_aheadcount, shopcar.aheadCount);
                    initialValues.put(DBHelper.home_aheadmaxnumber, shopcar.aheadMaxNumber);
                    initialValues.put(DBHelper.home_behindchosenumber, shopcar.behindChoseNumber);
                    initialValues.put(DBHelper.home_behindcount, shopcar.behindCount);
                    initialValues.put(DBHelper.home_behindmaxnumber, shopcar.behindMaxNumber);
                    initialValues.put(DBHelper.home_biaohao, shopcar.biaohao);
                    initialValues.put(DBHelper.home_chosenumberdown, shopcar.chosenumberDown + "");
                    initialValues.put(DBHelper.home_chosenumbertop, shopcar.chosenumberTop + "");
                    initialValues.put(DBHelper.home_company, shopcar.company);
                    initialValues.put(DBHelper.home_icon, shopcar.icon);
                    initialValues.put(DBHelper.home_lotteryid, shopcar.lotteryId);
                    initialValues.put(DBHelper.home_lotteryno, shopcar.lotteryNo);
                    initialValues.put(DBHelper.home_lotterytime, shopcar.lotteryTime);
                    initialValues.put(DBHelper.home_lotterytype, shopcar.lotteryType);
                    initialValues.put(DBHelper.home_name, shopcar.name);
                    initialValues.put(DBHelper.home_number, shopcar.number);
                    initialValues.put(DBHelper.home_price, shopcar.price);
                    initialValues.put(DBHelper.home_symbol, shopcar.symbol);
                    initialValues.put(DBHelper.home_total, shopcar.total);
                    initialValues.put(DBHelper.home_type, shopcar.type);
                    initialValues.put(DBHelper.home_zhunum, shopcar.zhuNum);
                    db.insert(DBHelper.HOME_TABLE_NAME, null, initialValues);
                }
            }
            db.setTransactionSuccessful();
            db.endTransaction();
        }
        return count;
    }

    public long insertHome(Home shopcar) {
        // deleteLABEL_TABLE_NAME();
        int count = 0;
        if (null != shopcar) {
            db.beginTransaction();
            ContentValues initialValues = null;
            if (hasShopCar(shopcar.biaohao)) {
                updateHome(shopcar, shopcar.biaohao);
            } else {
                initialValues = new ContentValues();
                initialValues.put(DBHelper.home_account, shopcar.account);
                initialValues.put(DBHelper.home_aheadchosenumber, shopcar.aheadChoseNumber);
                initialValues.put(DBHelper.home_aheadcount, shopcar.aheadCount);
                initialValues.put(DBHelper.home_aheadmaxnumber, shopcar.aheadMaxNumber);
                initialValues.put(DBHelper.home_behindchosenumber, shopcar.behindChoseNumber);
                initialValues.put(DBHelper.home_behindcount, shopcar.behindCount);
                initialValues.put(DBHelper.home_behindmaxnumber, shopcar.behindMaxNumber);
                initialValues.put(DBHelper.home_biaohao, shopcar.biaohao);
                initialValues.put(DBHelper.home_chosenumberdown, shopcar.chosenumberDown + "");
                initialValues.put(DBHelper.home_chosenumbertop, shopcar.chosenumberTop + "");
                initialValues.put(DBHelper.home_company, shopcar.company);
                initialValues.put(DBHelper.home_icon, shopcar.icon);
                initialValues.put(DBHelper.home_lotteryid, shopcar.lotteryId);
                initialValues.put(DBHelper.home_lotteryno, shopcar.lotteryNo);
                initialValues.put(DBHelper.home_lotterytime, shopcar.lotteryTime);
                initialValues.put(DBHelper.home_lotterytype, shopcar.lotteryType);
                initialValues.put(DBHelper.home_name, shopcar.name);
                initialValues.put(DBHelper.home_number, shopcar.number);
                initialValues.put(DBHelper.home_price, shopcar.price);
                initialValues.put(DBHelper.home_symbol, shopcar.symbol);
                initialValues.put(DBHelper.home_total, shopcar.total);
                initialValues.put(DBHelper.home_type, shopcar.type);
                initialValues.put(DBHelper.home_zhunum, shopcar.zhuNum);
                db.insert(DBHelper.HOME_TABLE_NAME, null, initialValues);
            }
            db.setTransactionSuccessful();
            db.endTransaction();
        }
        return count;
    }

    public long insertNotUpShopCar(List<Home> list) {
        // deleteLABEL_TABLE_NAME();
        int count = 0;
        if (null != list && list.size() > 0) {
            db.beginTransaction();
            ContentValues initialValues = null;
            for (Home shopcar : list) {
//                if(hasShopCar(shopcar.goodsid)){
//                    updateShopCar(shopcar,shopcar.goodsid);
//                }else {
                initialValues = new ContentValues();
                initialValues.put(DBHelper.home_account, shopcar.account);
                initialValues.put(DBHelper.home_aheadchosenumber, shopcar.aheadChoseNumber);
                initialValues.put(DBHelper.home_aheadcount, shopcar.aheadCount);
                initialValues.put(DBHelper.home_aheadmaxnumber, shopcar.aheadMaxNumber);
                initialValues.put(DBHelper.home_behindchosenumber, shopcar.behindChoseNumber);
                initialValues.put(DBHelper.home_behindcount, shopcar.behindCount);
                initialValues.put(DBHelper.home_behindmaxnumber, shopcar.behindMaxNumber);
                initialValues.put(DBHelper.home_biaohao, shopcar.biaohao);
                initialValues.put(DBHelper.home_chosenumberdown, shopcar.chosenumberDown + "");
                initialValues.put(DBHelper.home_chosenumbertop, shopcar.chosenumberTop + "");
                initialValues.put(DBHelper.home_company, shopcar.company);
                initialValues.put(DBHelper.home_icon, shopcar.icon);
                initialValues.put(DBHelper.home_lotteryid, shopcar.lotteryId);
                initialValues.put(DBHelper.home_lotteryno, shopcar.lotteryNo);
                initialValues.put(DBHelper.home_lotterytime, shopcar.lotteryTime);
                initialValues.put(DBHelper.home_lotterytype, shopcar.lotteryType);
                initialValues.put(DBHelper.home_name, shopcar.name);
                initialValues.put(DBHelper.home_number, shopcar.number);
                initialValues.put(DBHelper.home_price, shopcar.price);
                initialValues.put(DBHelper.home_symbol, shopcar.symbol);
                initialValues.put(DBHelper.home_total, shopcar.total);
                initialValues.put(DBHelper.home_type, shopcar.type);
                initialValues.put(DBHelper.home_zhunum, shopcar.zhuNum);
                db.insert(DBHelper.HOME_TABLE_NAME, null, initialValues);
//                }
            }
            db.setTransactionSuccessful();
            db.endTransaction();
        }
        Log.i("tag", list.size() + "=总共成度。. :");
        return count;
    }

    public Boolean hasShopCar(String number) {
        Boolean b = false;
        Cursor cursor = null;
        if (!"".equals(number)) {
            cursor = db.query(DBHelper.HOME_TABLE_NAME, null,
                    DBHelper.home_biaohao + "=?", new String[]{number},
                    null, null, null);
            b = cursor.moveToFirst();
        }
        if (!cursor.isClosed()) {
            cursor.close();
        }
        return b;
    }

    public boolean deleteHome() {
        return db.delete(DBHelper.HOME_TABLE_NAME, null, null) > 0;
    }

    public boolean deleteHome(String biaohao) {
        return db.delete(DBHelper.HOME_TABLE_NAME, DBHelper.home_biaohao + " =?", new String[]{biaohao}) > 0;
    }
}
