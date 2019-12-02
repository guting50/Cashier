package com.wycd.yushangpu.bean;

import java.io.Serializable;

/**
 * Created by ZPH on 2019-07-05.
 */

public class ShopInfoBean implements Serializable{


    /**
     * success : true
     * code : null
     * msg : 执行成功
     * data : {"GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","ShopImg":"/img/head.png","ShopName":"加油站","ShopContact":"6545646","ShopTel":"18328578333","ShopType":"加油站(1年)","ShopMbers":"243/10000","ShopGoods":"128/10000","ShopUsers":"4/10","ShopOverTime":"2020-05-31","ShopCreateTime":"2018-06-29","SM_SersionLife":1,"ShopMaxUsers":10,"ShopMaxProduct":10000,"ShopMaxVip":10000,"ShopMaxStaff":50}
     */

    private boolean success;
    private Object code;
    private String msg;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * GID : 4a7b1141-8ca3-4bef-961f-ffd153357823
         * ShopImg : /img/head.png
         * ShopName : 加油站
         * ShopContact : 6545646
         * ShopTel : 18328578333
         * ShopType : 加油站(1年)
         * ShopMbers : 243/10000
         * ShopGoods : 128/10000
         * ShopUsers : 4/10
         * ShopOverTime : 2020-05-31
         * ShopCreateTime : 2018-06-29
         * SM_SersionLife : 1
         * ShopMaxUsers : 10
         * ShopMaxProduct : 10000
         * ShopMaxVip : 10000
         * ShopMaxStaff : 50
         */

        private String GID;
        private String ShopImg;
        private String ShopName;
        private String ShopContact;
        private String ShopTel;
        private String ShopType;
        private String ShopMbers;
        private String ShopGoods;
        private String ShopUsers;
        private String ShopOverTime;
        private String ShopCreateTime;
        private int SM_SersionLife;
        private int ShopMaxUsers;
        private int ShopMaxProduct;
        private int ShopMaxVip;
        private int ShopMaxStaff;

        public String getGID() {
            return GID;
        }

        public void setGID(String GID) {
            this.GID = GID;
        }

        public String getShopImg() {
            return ShopImg;
        }

        public void setShopImg(String ShopImg) {
            this.ShopImg = ShopImg;
        }

        public String getShopName() {
            return ShopName;
        }

        public void setShopName(String ShopName) {
            this.ShopName = ShopName;
        }

        public String getShopContact() {
            return ShopContact;
        }

        public void setShopContact(String ShopContact) {
            this.ShopContact = ShopContact;
        }

        public String getShopTel() {
            return ShopTel;
        }

        public void setShopTel(String ShopTel) {
            this.ShopTel = ShopTel;
        }

        public String getShopType() {
            return ShopType;
        }

        public void setShopType(String ShopType) {
            this.ShopType = ShopType;
        }

        public String getShopMbers() {
            return ShopMbers;
        }

        public void setShopMbers(String ShopMbers) {
            this.ShopMbers = ShopMbers;
        }

        public String getShopGoods() {
            return ShopGoods;
        }

        public void setShopGoods(String ShopGoods) {
            this.ShopGoods = ShopGoods;
        }

        public String getShopUsers() {
            return ShopUsers;
        }

        public void setShopUsers(String ShopUsers) {
            this.ShopUsers = ShopUsers;
        }

        public String getShopOverTime() {
            return ShopOverTime;
        }

        public void setShopOverTime(String ShopOverTime) {
            this.ShopOverTime = ShopOverTime;
        }

        public String getShopCreateTime() {
            return ShopCreateTime;
        }

        public void setShopCreateTime(String ShopCreateTime) {
            this.ShopCreateTime = ShopCreateTime;
        }

        public int getSM_SersionLife() {
            return SM_SersionLife;
        }

        public void setSM_SersionLife(int SM_SersionLife) {
            this.SM_SersionLife = SM_SersionLife;
        }

        public int getShopMaxUsers() {
            return ShopMaxUsers;
        }

        public void setShopMaxUsers(int ShopMaxUsers) {
            this.ShopMaxUsers = ShopMaxUsers;
        }

        public int getShopMaxProduct() {
            return ShopMaxProduct;
        }

        public void setShopMaxProduct(int ShopMaxProduct) {
            this.ShopMaxProduct = ShopMaxProduct;
        }

        public int getShopMaxVip() {
            return ShopMaxVip;
        }

        public void setShopMaxVip(int ShopMaxVip) {
            this.ShopMaxVip = ShopMaxVip;
        }

        public int getShopMaxStaff() {
            return ShopMaxStaff;
        }

        public void setShopMaxStaff(int ShopMaxStaff) {
            this.ShopMaxStaff = ShopMaxStaff;
        }
    }
}
