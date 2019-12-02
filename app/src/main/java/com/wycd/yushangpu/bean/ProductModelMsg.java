package com.wycd.yushangpu.bean;

import java.io.Serializable;

public class ProductModelMsg implements Serializable {
    private String GID;// 	GID	string
    private String PM_Name;//	组名称	string
    private String PM_Properties;//	规格属性	string
    private int PM_Type;//	规格类型	int?
    private String SM_GID;//	店铺GID	string
    private String SM_Name;//	店铺名	string
    private String PM_Creator;//	操作员	string
    private String PM_CreateTime;//	创建时间	DateTime?
    private String CY_GID;//	企业GID	string
}
