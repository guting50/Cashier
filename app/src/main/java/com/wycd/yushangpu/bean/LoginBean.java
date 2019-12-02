package com.wycd.yushangpu.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ZPH on 2019-06-19.
 */

public class LoginBean  implements Serializable{


    /**
     * success : true
     * code : null
     * msg : 执行成功
     * data : {"UM_OriginalAccount":"18328578333","AuthorityList":[],"UM_Number":null,"Agents":{"GID":"PlatformUser","AG_Name":"云上铺","AG_CreateTime":null,"AG_Domain":"pc.yunvip123.com","AG_SoftwareName":"云上铺","AG_LogoUrl":"http://img.yunvip123.com/OEM_IMAGE/0327660b-3dce-4cda-9f6b-c6ed5360a110.jpeg","AG_Type":2,"PCUrl":"","AG_GoodLimit":100,"AG_MberLimit":100},"UM_ThirdPartyOpenID":null,"AG_GID":"PlatformUser","Merchant_No":"","Termina_Token":"","Termina_ID":null,"UM_Unionid":null,"UM_OpenID":null,"UM_RegSource":null,"UM_RegSourceParam":null,"UM_RegIP":null,"GID":"1e505b65-9182-453e-9a37-4e7221ec3505","UM_Acount":"18328578333","UM_Pwd":null,"UM_Name":"分号1","UM_Contact":"","UM_Right":null,"UM_IsLock":0,"UM_Remark":"","UM_IP":"171.217.61.89","UM_LoginTime":null,"UM_Creator":"销售001","UM_UpdateTime":"2018-11-19 14:27:07","UM_IsAmin":0,"CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","ShopList":[{"SM_MaxVip":10000,"SM_MaxProduct":10000,"SM_MaxStaff":50,"SM_SersionLife":"5","SM_TextOptimization":"","SF_Code":"","SM_FunctionList":"","FunctionList":null,"SM_Code":null,"SM_DefaultCode":null,"GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SM_Name":"jll2","SM_Contacter":"6545646","SM_Phone":"18328578333","SM_Addr":"","SM_Remark":"","SM_State":0,"SM_UpdateTime":"2019-04-10 14:55:27","SM_Picture":"/img/head.png","SM_Creator":"1058346971@qq.com","SM_XLong":null,"SM_YLat":null,"SM_Industry":"汽车美容","SM_Range":"","SM_Country":null,"SM_Province":"山西省","SM_Disctrict":"矿区","SM_DetailAddr":"","SM_MapAddr":null,"SM_UpdateState":1,"SM_AcountNum":10,"SM_Type":1,"SM_EndTime":"2023-11-19 13:55:18","SM_CreateTime":"2018-06-29 15:45:53","SM_City":"大同市","VipNumber":0,"ProNumber":0,"SM_IndustryType":100,"SaoBei_State":0,"SaoBei_Message":null,"SM_BusinessName":null,"SM_BranchName":null,"SM_WXState":0,"SM_BusinessType":null,"SM_OffsetType":0,"SM_WXMessage":null,"SM_WXPoiId":null}],"UM_CreateTime":null,"UM_UpdateState":null,"ShopID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","RoleName":null,"RoleID":"9ebe2180-9071-4b16-8d31-2e3395e0b782","MenuInfoList":[{"GID":"44c5a445-ac4e-47aa-8efa-984aac438a8e","MM_Name":"公众号授权","MM_Sort":0,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXSet/WXAuthorization.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"4e750e4c-fea4-4ab4-a6e6-69de660bf84c","MM_Name":"商品列表","MM_Sort":1,"MM_Code":"1","MM_ParentID":"cc61b484-6041-4e6a-af66-463cdf3fa18b","MM_Type":1,"MM_LinkUrl":"/WebUI/Goods/GList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"44caf268-5929-4e0f-a5a6-66ac3f7a2086","MM_Name":"素材管理","MM_Sort":5,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXSet/WNewsManage/MaterialIndex.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"a91eda85-4385-443a-a127-746dbc57161c","MM_Name":"套餐列表","MM_Sort":6,"MM_Code":"1","MM_ParentID":"cc61b484-6041-4e6a-af66-463cdf3fa18b","MM_Type":1,"MM_LinkUrl":"/WebUI/Goods/GProductComboList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"f6939068-bd30-408d-93e3-9c7e337e5f07","MM_Name":"粉丝管理","MM_Sort":7,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXMember/WFans/WFansManage.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"22cff015-9ea6-49c3-b7ab-dc44860ebc9b","MM_Name":"消息记录","MM_Sort":7,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXSet/WMessageRecord/WIndex.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"59270ba7-8b0c-473b-8145-6cff87dc46b7","MM_Name":"微官网设置","MM_Sort":9,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXMicroWeb/WMicroWebSetting.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"a36ea9f4-63ad-43e3-9d13-d987dd25cd52","MM_Name":"销售订单记录","MM_Sort":90,"MM_Code":"1","MM_ParentID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Type":1,"MM_LinkUrl":"/WebUI/Order/OrderList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"fc7148e0-7170-4a26-8dc0-78dfbff71605","MM_Name":"参数设置","MM_Sort":98,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/System/SystemParam.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"d0113b7e-b65b-45da-8d13-14c494358189","MM_Name":"会员账户记录","MM_Sort":99,"MM_Code":"1","MM_ParentID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Type":1,"MM_LinkUrl":"/WebUI/Report/MemberAccountReportList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"c35866db-3b48-4f52-bfec-156d2991cb7a","MM_Name":"微信预约","MM_Sort":100,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXMember/WXReservationProject/Index.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"bf5258fb-7df8-4ce1-8ec2-53e34d8a0c62","MM_Name":"群发消息","MM_Sort":100,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXSet/WMassMessage/WMassMessageList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"06bb5ce3-6147-4ceb-82fd-4f288af9997f","MM_Name":"消费收银","MM_Sort":100,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"","MM_Icon":"menu-ico-cost","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b0b40e2d-2d68-48b5-8020-754dbd2813ec","MM_Name":"新增会员","MM_Sort":100,"MM_Code":"1","MM_ParentID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MRegister.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b54cb2fd-4ced-4f7e-8d6f-df6121a093f1","MM_Name":"微店订单","MM_Sort":100,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXOrder/WOrderIndex.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"6c734eb4-2070-4bdc-8fba-f7ffc8e1b96f","MM_Name":"库存管理","MM_Sort":100,"MM_Code":"1","MM_ParentID":"cc61b484-6041-4e6a-af66-463cdf3fa18b","MM_Type":1,"MM_LinkUrl":"/WebUI/Goods/GProductManage.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b2b8e2e4-4a6b-45cd-8e52-8338fa4e6139","MM_Name":"会员卡设置","MM_Sort":100,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXMember/MemberCard/MemberCardSet.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"bfac89b3-0eb7-483e-aece-a8faf147b199","MM_Name":"微店管理","MM_Sort":100,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXSet/WShop/WShopIndex.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"a6dcc3b0-addd-4831-971a-5ce92fe31a3a","MM_Name":"用户交班记录","MM_Sort":101,"MM_Code":"1","MM_ParentID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Type":1,"MM_LinkUrl":"/WebUI/Report/EmployeeExchangeReport.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"30512bb0-160a-41b3-b7d4-8ec0bb549091","MM_Name":"推荐返利记录","MM_Sort":103,"MM_Code":"1","MM_ParentID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Type":1,"MM_LinkUrl":"/WebUI/Report/RecommendRebateList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"29a89987-fdf7-4638-a01b-220c854c07cf","MM_Name":"扫码对账单","MM_Sort":107,"MM_Code":"1","MM_ParentID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Type":1,"MM_LinkUrl":"/WebUI/Order/OBarCodePayOrder.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"0c8f96a2-b286-4d53-8072-4301f6920578","MM_Name":"商品分析","MM_Sort":109,"MM_Code":"1","MM_ParentID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Type":1,"MM_LinkUrl":"/WebUI/Report/CommodityReportList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"587e5309-96f0-476b-855d-9e03b3bf3fb9","MM_Name":"商品消费","MM_Sort":110,"MM_Code":"1X0","MM_ParentID":"06bb5ce3-6147-4ceb-82fd-4f288af9997f","MM_Type":1,"MM_LinkUrl":"/WebUI/Order/OCommodifyConsume.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"6b29fe5e-d019-4623-bd36-d3ef5b074c88","MM_Name":"员工分析","MM_Sort":113,"MM_Code":"500","MM_ParentID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Type":1,"MM_LinkUrl":"/WebUI/Report/EmployeeCommission.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"ce6acebe-1363-40c0-b8eb-f8e594c8f9a8","MM_Name":"综合统计","MM_Sort":115,"MM_Code":"1","MM_ParentID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Type":1,"MM_LinkUrl":"/WebUI/Report/SyntheticDataCount.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"d0e3ae78-bf7d-406d-baf0-e3b4fee8964d","MM_Name":"快速消费","MM_Sort":120,"MM_Code":"1","MM_ParentID":"06bb5ce3-6147-4ceb-82fd-4f288af9997f","MM_Type":1,"MM_LinkUrl":"/WebUI/Order/OFastConsume.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"6fc63fea-1496-4637-88db-580bbbbd3397","MM_Name":"计次消费","MM_Sort":130,"MM_Code":"600","MM_ParentID":"06bb5ce3-6147-4ceb-82fd-4f288af9997f","MM_Type":1,"MM_LinkUrl":"/WebUI/Order/OTimesCountConsume.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"6fc93fea-1426-4537-88db-580bbd3265","MM_Name":"快速计次","MM_Sort":140,"MM_Code":"600","MM_ParentID":"06bb5ce3-6147-4ceb-82fd-4f288af9997f","MM_Type":1,"MM_LinkUrl":"/WebUI/Order/OFastTimesCount.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"35c47814-a918-43c9-8f21-7c2b78045498","MM_Name":"房台消费","MM_Sort":170,"MM_Code":"700","MM_ParentID":"06bb5ce3-6147-4ceb-82fd-4f288af9997f","MM_Type":1,"MM_LinkUrl":"/WebUI/TimingConsume/RoomConsumption.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"c4637013-b504-4893-8994-579824eec24d","MM_Name":"计时消费","MM_Sort":190,"MM_Code":"800","MM_ParentID":"06bb5ce3-6147-4ceb-82fd-4f288af9997f","MM_Type":1,"MM_LinkUrl":"/WebUI/TimeConsumption/Timingconsumption.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"fc7198e0-7560-4a26-8ac0-78dfbff73633","MM_Name":"打印设置","MM_Sort":200,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/Print/PrintSet.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b0f53a86-9e73-4761-9cbb-b1d11d094d57","MM_Name":"会员列表","MM_Sort":200,"MM_Code":"1","MM_ParentID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"f14c24c4-8bf8-4b64-9fb7-534dadb77e63","MM_Name":"提成设置","MM_Sort":201,"MM_Code":"500","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/Staff/TipStaffIndex.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"9d6da8b1-55ab-2545-abbe-42e709bdff16","MM_Name":"会员充值","MM_Sort":201,"MM_Code":"1","MM_ParentID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MBalanceMage.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"c89abf28-56fd-45d0-90df-fcb24126635a","MM_Name":"提醒设置","MM_Sort":202,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/Remind/SysRemind.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"35a0559b-700e-4027-88af-3fd060248ca8","MM_Name":"会员充次","MM_Sort":202,"MM_Code":"600","MM_ParentID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MRechargeTimesCount.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"40d3b5a7-7d05-4793-bc06-17a341666c72","MM_Name":"房台管理","MM_Sort":203,"MM_Code":"700","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/System/HouseManageList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"aa5289ec-8528-469a-8587-438799e11306","MM_Name":"积分变动","MM_Sort":204,"MM_Code":"1","MM_ParentID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MPointChange.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"82984923-9ce2-497c-bc69-ff7ef89d5508","MM_Name":"计时管理","MM_Sort":204,"MM_Code":"800","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/TimeConsumption/TimingManage.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"336dd897-551e-4517-8542-67795937fb78","MM_Name":"计次规则","MM_Sort":204,"MM_Code":"600","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/TimeConsumption/WouldRulesList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"22261471-42a3-4076-ba04-a761e1d464d5","MM_Name":"签到管理","MM_Sort":205,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MemberCheckInProjectList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b0f53a86-9e73-4761-9cbb-b1d11d094d57123","MM_Name":"标签管理","MM_Sort":206,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MLabelList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"8953fdc7-9d81-40fa-bdc3-63c006f8b4da","MM_Name":"店铺管理","MM_Sort":207,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/Shop/ShopList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"11596c6a-1a35-42df-8c3a-0aa626a011d0","MM_Name":"用户管理","MM_Sort":208,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/Shop/SUser.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"76d1bb4c-44f4-43d4-ae71-1aa54013eaaf","MM_Name":"员工管理","MM_Sort":209,"MM_Code":"500","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/Shop/SStaff.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"fc7198e0-1125-4a26-8ac0-78dfbff54662","MM_Name":"数据安全","MM_Sort":210,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/System/BackUp.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"fc7198e0-1125-4a26-8ac0-78dfbff54661","MM_Name":"自定义属性","MM_Sort":211,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/System/CustomFieldsList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"e38aeb32-d92d-4aa4-9bc7-3e56e9a31049","MM_Name":"支付设置","MM_Sort":212,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/System/PaymentSet.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Name":"会员管理","MM_Sort":260,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"","MM_Icon":"menu-ico-mber","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"f2c806a6-69de-4a80-a2f9-f056ea7eafc3","MM_Name":"会员等级","MM_Sort":269,"MM_Code":"1","MM_ParentID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MGradeList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b2ace90a-45a4-4432-9c3f-50a716e63f0a","MM_Name":"会员签到","MM_Sort":280,"MM_Code":"1","MM_ParentID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MemberCheckInFast.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"9f48b762-07d5-42f8-9794-98a8ea24e82a","MM_Name":"批量操作","MM_Sort":290,"MM_Code":"1","MM_ParentID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MBatchOperatingBar.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"e199f051-0ba1-4dc2-a819-87e1cf64a359","MM_Name":"商品配置","MM_Sort":300,"MM_Code":"","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/System/ProductConfig.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"cc61b484-6041-4e6a-af66-463cdf3fa18b","MM_Name":"商品管理","MM_Sort":300,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"","MM_Icon":"menu-ico-good","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b1c54fff-9501-4982-a335-79e761c9639a","MM_Name":"短信管理","MM_Sort":330,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"/WebUI/Sms/SSms.html","MM_Icon":"menu-ico-msg","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"38162b62-fdb6-4d40-ac75-2de6767984ac","MM_Name":"支出管理","MM_Sort":340,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"/WebUI/Expenses/ExpensesBar.html","MM_Icon":"menu-ico-expense","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"c15f452a-c8b1-4b18-9ba9-ed78537abce3","MM_Name":"会员营销","MM_Sort":400,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"","MM_Icon":"menu-ico-market","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b4e19ad8-917c-4cf0-8f45-bffb8e4cae7b","MM_Name":"优惠活动","MM_Sort":400,"MM_Code":"1","MM_ParentID":"c15f452a-c8b1-4b18-9ba9-ed78537abce3","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MConsumePackageList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"75b46aa8-2583-4e83-b203-71f8f21699be","MM_Name":"提醒列表","MM_Sort":405,"MM_Code":"1","MM_ParentID":"c15f452a-c8b1-4b18-9ba9-ed78537abce3","MM_Type":1,"MM_LinkUrl":"/WebUI/Remind/RemindList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b0f53a86-9e73-4761-9cbb-b1d11d01254","MM_Name":"快捷充值","MM_Sort":410,"MM_Code":"1","MM_ParentID":"c15f452a-c8b1-4b18-9ba9-ed78537abce3","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MRechargePackageList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"72e59ef2-df33-4031-93f7-211f471f5efe","MM_Name":"积分兑换","MM_Sort":420,"MM_Code":"1","MM_ParentID":"c15f452a-c8b1-4b18-9ba9-ed78537abce3","MM_Type":1,"MM_LinkUrl":"/WebUI/Integral/IExchange.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"04f6196b-da1a-458c-a9c2-868206dca5f9","MM_Name":"优惠券","MM_Sort":440,"MM_Code":"1","MM_ParentID":"c15f452a-c8b1-4b18-9ba9-ed78537abce3","MM_Type":1,"MM_LinkUrl":"/WebUI/Coupon/CouponList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Name":"报表管理","MM_Sort":500,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"","MM_Icon":"menu-ico-report","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Name":"微信设置","MM_Sort":900,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"","MM_Icon":"menu-ico-wechat","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Name":"系统设置","MM_Sort":990,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"/WebUI/System/SystemPageSet.html","MM_Icon":"menu-ico-sysset","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"daf9a919-d2eb-465f-ad5f-1adbacfdba8d","MM_Name":"公用资源","MM_Sort":1000,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"公用资源","MM_Icon":null,"MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null}],"MenuResourceList":null,"EM_GID":null,"EM_Name":null,"RM_Name":null,"UM_State":null,"UM_ChatHead":"/img/hpic/hpic-2.png"}
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

    public static class DataBean implements Serializable{
        /**
         * UM_OriginalAccount : 18328578333
         * AuthorityList : []
         * UM_Number : null
         * Agents : {"GID":"PlatformUser","AG_Name":"云上铺","AG_CreateTime":null,"AG_Domain":"pc.yunvip123.com","AG_SoftwareName":"云上铺","AG_LogoUrl":"http://img.yunvip123.com/OEM_IMAGE/0327660b-3dce-4cda-9f6b-c6ed5360a110.jpeg","AG_Type":2,"PCUrl":"","AG_GoodLimit":100,"AG_MberLimit":100}
         * UM_ThirdPartyOpenID : null
         * AG_GID : PlatformUser
         * Merchant_No :
         * Termina_Token :
         * Termina_ID : null
         * UM_Unionid : null
         * UM_OpenID : null
         * UM_RegSource : null
         * UM_RegSourceParam : null
         * UM_RegIP : null
         * GID : 1e505b65-9182-453e-9a37-4e7221ec3505
         * UM_Acount : 18328578333
         * UM_Pwd : null
         * UM_Name : 分号1
         * UM_Contact :
         * UM_Right : null
         * UM_IsLock : 0
         * UM_Remark :
         * UM_IP : 171.217.61.89
         * UM_LoginTime : null
         * UM_Creator : 销售001
         * UM_UpdateTime : 2018-11-19 14:27:07
         * UM_IsAmin : 0
         * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
         * ShopList : [{"SM_MaxVip":10000,"SM_MaxProduct":10000,"SM_MaxStaff":50,"SM_SersionLife":"5","SM_TextOptimization":"","SF_Code":"","SM_FunctionList":"","FunctionList":null,"SM_Code":null,"SM_DefaultCode":null,"GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SM_Name":"jll2","SM_Contacter":"6545646","SM_Phone":"18328578333","SM_Addr":"","SM_Remark":"","SM_State":0,"SM_UpdateTime":"2019-04-10 14:55:27","SM_Picture":"/img/head.png","SM_Creator":"1058346971@qq.com","SM_XLong":null,"SM_YLat":null,"SM_Industry":"汽车美容","SM_Range":"","SM_Country":null,"SM_Province":"山西省","SM_Disctrict":"矿区","SM_DetailAddr":"","SM_MapAddr":null,"SM_UpdateState":1,"SM_AcountNum":10,"SM_Type":1,"SM_EndTime":"2023-11-19 13:55:18","SM_CreateTime":"2018-06-29 15:45:53","SM_City":"大同市","VipNumber":0,"ProNumber":0,"SM_IndustryType":100,"SaoBei_State":0,"SaoBei_Message":null,"SM_BusinessName":null,"SM_BranchName":null,"SM_WXState":0,"SM_BusinessType":null,"SM_OffsetType":0,"SM_WXMessage":null,"SM_WXPoiId":null}]
         * UM_CreateTime : null
         * UM_UpdateState : null
         * ShopID : 4a7b1141-8ca3-4bef-961f-ffd153357823
         * SM_Name : jll2
         * RoleName : null
         * RoleID : 9ebe2180-9071-4b16-8d31-2e3395e0b782
         * MenuInfoList : [{"GID":"44c5a445-ac4e-47aa-8efa-984aac438a8e","MM_Name":"公众号授权","MM_Sort":0,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXSet/WXAuthorization.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"4e750e4c-fea4-4ab4-a6e6-69de660bf84c","MM_Name":"商品列表","MM_Sort":1,"MM_Code":"1","MM_ParentID":"cc61b484-6041-4e6a-af66-463cdf3fa18b","MM_Type":1,"MM_LinkUrl":"/WebUI/Goods/GList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"44caf268-5929-4e0f-a5a6-66ac3f7a2086","MM_Name":"素材管理","MM_Sort":5,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXSet/WNewsManage/MaterialIndex.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"a91eda85-4385-443a-a127-746dbc57161c","MM_Name":"套餐列表","MM_Sort":6,"MM_Code":"1","MM_ParentID":"cc61b484-6041-4e6a-af66-463cdf3fa18b","MM_Type":1,"MM_LinkUrl":"/WebUI/Goods/GProductComboList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"f6939068-bd30-408d-93e3-9c7e337e5f07","MM_Name":"粉丝管理","MM_Sort":7,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXMember/WFans/WFansManage.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"22cff015-9ea6-49c3-b7ab-dc44860ebc9b","MM_Name":"消息记录","MM_Sort":7,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXSet/WMessageRecord/WIndex.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"59270ba7-8b0c-473b-8145-6cff87dc46b7","MM_Name":"微官网设置","MM_Sort":9,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXMicroWeb/WMicroWebSetting.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"a36ea9f4-63ad-43e3-9d13-d987dd25cd52","MM_Name":"销售订单记录","MM_Sort":90,"MM_Code":"1","MM_ParentID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Type":1,"MM_LinkUrl":"/WebUI/Order/OrderList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"fc7148e0-7170-4a26-8dc0-78dfbff71605","MM_Name":"参数设置","MM_Sort":98,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/System/SystemParam.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"d0113b7e-b65b-45da-8d13-14c494358189","MM_Name":"会员账户记录","MM_Sort":99,"MM_Code":"1","MM_ParentID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Type":1,"MM_LinkUrl":"/WebUI/Report/MemberAccountReportList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"c35866db-3b48-4f52-bfec-156d2991cb7a","MM_Name":"微信预约","MM_Sort":100,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXMember/WXReservationProject/Index.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"bf5258fb-7df8-4ce1-8ec2-53e34d8a0c62","MM_Name":"群发消息","MM_Sort":100,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXSet/WMassMessage/WMassMessageList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"06bb5ce3-6147-4ceb-82fd-4f288af9997f","MM_Name":"消费收银","MM_Sort":100,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"","MM_Icon":"menu-ico-cost","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b0b40e2d-2d68-48b5-8020-754dbd2813ec","MM_Name":"新增会员","MM_Sort":100,"MM_Code":"1","MM_ParentID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MRegister.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b54cb2fd-4ced-4f7e-8d6f-df6121a093f1","MM_Name":"微店订单","MM_Sort":100,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXOrder/WOrderIndex.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"6c734eb4-2070-4bdc-8fba-f7ffc8e1b96f","MM_Name":"库存管理","MM_Sort":100,"MM_Code":"1","MM_ParentID":"cc61b484-6041-4e6a-af66-463cdf3fa18b","MM_Type":1,"MM_LinkUrl":"/WebUI/Goods/GProductManage.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b2b8e2e4-4a6b-45cd-8e52-8338fa4e6139","MM_Name":"会员卡设置","MM_Sort":100,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXMember/MemberCard/MemberCardSet.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"bfac89b3-0eb7-483e-aece-a8faf147b199","MM_Name":"微店管理","MM_Sort":100,"MM_Code":"1","MM_ParentID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Type":1,"MM_LinkUrl":"/WebUI/WXSet/WShop/WShopIndex.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"a6dcc3b0-addd-4831-971a-5ce92fe31a3a","MM_Name":"用户交班记录","MM_Sort":101,"MM_Code":"1","MM_ParentID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Type":1,"MM_LinkUrl":"/WebUI/Report/EmployeeExchangeReport.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"30512bb0-160a-41b3-b7d4-8ec0bb549091","MM_Name":"推荐返利记录","MM_Sort":103,"MM_Code":"1","MM_ParentID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Type":1,"MM_LinkUrl":"/WebUI/Report/RecommendRebateList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"29a89987-fdf7-4638-a01b-220c854c07cf","MM_Name":"扫码对账单","MM_Sort":107,"MM_Code":"1","MM_ParentID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Type":1,"MM_LinkUrl":"/WebUI/Order/OBarCodePayOrder.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"0c8f96a2-b286-4d53-8072-4301f6920578","MM_Name":"商品分析","MM_Sort":109,"MM_Code":"1","MM_ParentID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Type":1,"MM_LinkUrl":"/WebUI/Report/CommodityReportList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"587e5309-96f0-476b-855d-9e03b3bf3fb9","MM_Name":"商品消费","MM_Sort":110,"MM_Code":"1X0","MM_ParentID":"06bb5ce3-6147-4ceb-82fd-4f288af9997f","MM_Type":1,"MM_LinkUrl":"/WebUI/Order/OCommodifyConsume.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"6b29fe5e-d019-4623-bd36-d3ef5b074c88","MM_Name":"员工分析","MM_Sort":113,"MM_Code":"500","MM_ParentID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Type":1,"MM_LinkUrl":"/WebUI/Report/EmployeeCommission.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"ce6acebe-1363-40c0-b8eb-f8e594c8f9a8","MM_Name":"综合统计","MM_Sort":115,"MM_Code":"1","MM_ParentID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Type":1,"MM_LinkUrl":"/WebUI/Report/SyntheticDataCount.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"d0e3ae78-bf7d-406d-baf0-e3b4fee8964d","MM_Name":"快速消费","MM_Sort":120,"MM_Code":"1","MM_ParentID":"06bb5ce3-6147-4ceb-82fd-4f288af9997f","MM_Type":1,"MM_LinkUrl":"/WebUI/Order/OFastConsume.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"6fc63fea-1496-4637-88db-580bbbbd3397","MM_Name":"计次消费","MM_Sort":130,"MM_Code":"600","MM_ParentID":"06bb5ce3-6147-4ceb-82fd-4f288af9997f","MM_Type":1,"MM_LinkUrl":"/WebUI/Order/OTimesCountConsume.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"6fc93fea-1426-4537-88db-580bbd3265","MM_Name":"快速计次","MM_Sort":140,"MM_Code":"600","MM_ParentID":"06bb5ce3-6147-4ceb-82fd-4f288af9997f","MM_Type":1,"MM_LinkUrl":"/WebUI/Order/OFastTimesCount.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"35c47814-a918-43c9-8f21-7c2b78045498","MM_Name":"房台消费","MM_Sort":170,"MM_Code":"700","MM_ParentID":"06bb5ce3-6147-4ceb-82fd-4f288af9997f","MM_Type":1,"MM_LinkUrl":"/WebUI/TimingConsume/RoomConsumption.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"c4637013-b504-4893-8994-579824eec24d","MM_Name":"计时消费","MM_Sort":190,"MM_Code":"800","MM_ParentID":"06bb5ce3-6147-4ceb-82fd-4f288af9997f","MM_Type":1,"MM_LinkUrl":"/WebUI/TimeConsumption/Timingconsumption.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"fc7198e0-7560-4a26-8ac0-78dfbff73633","MM_Name":"打印设置","MM_Sort":200,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/Print/PrintSet.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b0f53a86-9e73-4761-9cbb-b1d11d094d57","MM_Name":"会员列表","MM_Sort":200,"MM_Code":"1","MM_ParentID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"f14c24c4-8bf8-4b64-9fb7-534dadb77e63","MM_Name":"提成设置","MM_Sort":201,"MM_Code":"500","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/Staff/TipStaffIndex.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"9d6da8b1-55ab-2545-abbe-42e709bdff16","MM_Name":"会员充值","MM_Sort":201,"MM_Code":"1","MM_ParentID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MBalanceMage.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"c89abf28-56fd-45d0-90df-fcb24126635a","MM_Name":"提醒设置","MM_Sort":202,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/Remind/SysRemind.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"35a0559b-700e-4027-88af-3fd060248ca8","MM_Name":"会员充次","MM_Sort":202,"MM_Code":"600","MM_ParentID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MRechargeTimesCount.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"40d3b5a7-7d05-4793-bc06-17a341666c72","MM_Name":"房台管理","MM_Sort":203,"MM_Code":"700","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/System/HouseManageList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"aa5289ec-8528-469a-8587-438799e11306","MM_Name":"积分变动","MM_Sort":204,"MM_Code":"1","MM_ParentID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MPointChange.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"82984923-9ce2-497c-bc69-ff7ef89d5508","MM_Name":"计时管理","MM_Sort":204,"MM_Code":"800","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/TimeConsumption/TimingManage.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"336dd897-551e-4517-8542-67795937fb78","MM_Name":"计次规则","MM_Sort":204,"MM_Code":"600","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/TimeConsumption/WouldRulesList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"22261471-42a3-4076-ba04-a761e1d464d5","MM_Name":"签到管理","MM_Sort":205,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MemberCheckInProjectList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b0f53a86-9e73-4761-9cbb-b1d11d094d57123","MM_Name":"标签管理","MM_Sort":206,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MLabelList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"8953fdc7-9d81-40fa-bdc3-63c006f8b4da","MM_Name":"店铺管理","MM_Sort":207,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/Shop/ShopList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"11596c6a-1a35-42df-8c3a-0aa626a011d0","MM_Name":"用户管理","MM_Sort":208,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/Shop/SUser.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"76d1bb4c-44f4-43d4-ae71-1aa54013eaaf","MM_Name":"员工管理","MM_Sort":209,"MM_Code":"500","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/Shop/SStaff.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"fc7198e0-1125-4a26-8ac0-78dfbff54662","MM_Name":"数据安全","MM_Sort":210,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/System/BackUp.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"fc7198e0-1125-4a26-8ac0-78dfbff54661","MM_Name":"自定义属性","MM_Sort":211,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/System/CustomFieldsList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"e38aeb32-d92d-4aa4-9bc7-3e56e9a31049","MM_Name":"支付设置","MM_Sort":212,"MM_Code":"1","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/System/PaymentSet.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Name":"会员管理","MM_Sort":260,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"","MM_Icon":"menu-ico-mber","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"f2c806a6-69de-4a80-a2f9-f056ea7eafc3","MM_Name":"会员等级","MM_Sort":269,"MM_Code":"1","MM_ParentID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MGradeList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b2ace90a-45a4-4432-9c3f-50a716e63f0a","MM_Name":"会员签到","MM_Sort":280,"MM_Code":"1","MM_ParentID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MemberCheckInFast.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"9f48b762-07d5-42f8-9794-98a8ea24e82a","MM_Name":"批量操作","MM_Sort":290,"MM_Code":"1","MM_ParentID":"358c4299-8a42-40a6-8345-03d4d4e81038","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MBatchOperatingBar.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"e199f051-0ba1-4dc2-a819-87e1cf64a359","MM_Name":"商品配置","MM_Sort":300,"MM_Code":"","MM_ParentID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Type":1,"MM_LinkUrl":"/WebUI/System/ProductConfig.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"cc61b484-6041-4e6a-af66-463cdf3fa18b","MM_Name":"商品管理","MM_Sort":300,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"","MM_Icon":"menu-ico-good","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b1c54fff-9501-4982-a335-79e761c9639a","MM_Name":"短信管理","MM_Sort":330,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"/WebUI/Sms/SSms.html","MM_Icon":"menu-ico-msg","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"38162b62-fdb6-4d40-ac75-2de6767984ac","MM_Name":"支出管理","MM_Sort":340,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"/WebUI/Expenses/ExpensesBar.html","MM_Icon":"menu-ico-expense","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"c15f452a-c8b1-4b18-9ba9-ed78537abce3","MM_Name":"会员营销","MM_Sort":400,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"","MM_Icon":"menu-ico-market","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b4e19ad8-917c-4cf0-8f45-bffb8e4cae7b","MM_Name":"优惠活动","MM_Sort":400,"MM_Code":"1","MM_ParentID":"c15f452a-c8b1-4b18-9ba9-ed78537abce3","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MConsumePackageList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"75b46aa8-2583-4e83-b203-71f8f21699be","MM_Name":"提醒列表","MM_Sort":405,"MM_Code":"1","MM_ParentID":"c15f452a-c8b1-4b18-9ba9-ed78537abce3","MM_Type":1,"MM_LinkUrl":"/WebUI/Remind/RemindList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"b0f53a86-9e73-4761-9cbb-b1d11d01254","MM_Name":"快捷充值","MM_Sort":410,"MM_Code":"1","MM_ParentID":"c15f452a-c8b1-4b18-9ba9-ed78537abce3","MM_Type":1,"MM_LinkUrl":"/WebUI/Member/MRechargePackageList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"72e59ef2-df33-4031-93f7-211f471f5efe","MM_Name":"积分兑换","MM_Sort":420,"MM_Code":"1","MM_ParentID":"c15f452a-c8b1-4b18-9ba9-ed78537abce3","MM_Type":1,"MM_LinkUrl":"/WebUI/Integral/IExchange.shtml","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"04f6196b-da1a-458c-a9c2-868206dca5f9","MM_Name":"优惠券","MM_Sort":440,"MM_Code":"1","MM_ParentID":"c15f452a-c8b1-4b18-9ba9-ed78537abce3","MM_Type":1,"MM_LinkUrl":"/WebUI/Coupon/CouponList.html","MM_Icon":"","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"c15f322a-c8b1-4b18-8ba9-ed78537abce2","MM_Name":"报表管理","MM_Sort":500,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"","MM_Icon":"menu-ico-report","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"3dc84aba-238f-41aa-84f0-be042120d9f8","MM_Name":"微信设置","MM_Sort":900,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"","MM_Icon":"menu-ico-wechat","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"33da8118-5f1e-4791-836e-75de6a7c5681","MM_Name":"系统设置","MM_Sort":990,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"/WebUI/System/SystemPageSet.html","MM_Icon":"menu-ico-sysset","MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null},{"GID":"daf9a919-d2eb-465f-ad5f-1adbacfdba8d","MM_Name":"公用资源","MM_Sort":1000,"MM_Code":"1","MM_ParentID":"","MM_Type":1,"MM_LinkUrl":"公用资源","MM_Icon":null,"MM_Remark":null,"MM_CreateTime":null,"MM_Creator":null}]
         * MenuResourceList : null
         * EM_GID : null
         * EM_Name : null
         * RM_Name : null
         * UM_State : null
         * UM_ChatHead : /img/hpic/hpic-2.png
         */

        private String UM_OriginalAccount;
        private Object UM_Number;
        private AgentsBean Agents;
        private Object UM_ThirdPartyOpenID;
        private String AG_GID;
        private String Merchant_No;
        private String Termina_Token;
        private Object Termina_ID;
        private Object UM_Unionid;
        private Object UM_OpenID;
        private Object UM_RegSource;
        private Object UM_RegSourceParam;
        private Object UM_RegIP;
        private String GID;
        private String UM_Acount;
        private String UM_Pwd;
        private String UM_Name;
        private String UM_Contact;
        private Object UM_Right;
        private int UM_IsLock;
        private String UM_Remark;
        private String UM_IP;
        private Object UM_LoginTime;
        private String UM_Creator;
        private String UM_UpdateTime;
        private int UM_IsAmin;
        private String CY_GID;
        private Object UM_CreateTime;
        private Object UM_UpdateState;
        private String ShopID;
        private String SM_Name;
        private Object RoleName;
        private String RoleID;
        private Object MenuResourceList;
        private Object EM_GID;
        private Object EM_Name;
        private Object RM_Name;
        private Object UM_State;
        private String UM_ChatHead;
        private List<?> AuthorityList;
        private List<ShopListBean> ShopList;
        private List<MenuInfoListBean> MenuInfoList;
        private String SessionId;

        public String getSessionId() {
            return SessionId;
        }

        public void setSessionId(String sessionId) {
            SessionId = sessionId;
        }


        public String getUM_OriginalAccount() {
            return UM_OriginalAccount;
        }

        public void setUM_OriginalAccount(String UM_OriginalAccount) {
            this.UM_OriginalAccount = UM_OriginalAccount;
        }

        public Object getUM_Number() {
            return UM_Number;
        }

        public void setUM_Number(Object UM_Number) {
            this.UM_Number = UM_Number;
        }

        public AgentsBean getAgents() {
            return Agents;
        }

        public void setAgents(AgentsBean Agents) {
            this.Agents = Agents;
        }

        public Object getUM_ThirdPartyOpenID() {
            return UM_ThirdPartyOpenID;
        }

        public void setUM_ThirdPartyOpenID(Object UM_ThirdPartyOpenID) {
            this.UM_ThirdPartyOpenID = UM_ThirdPartyOpenID;
        }

        public String getAG_GID() {
            return AG_GID;
        }

        public void setAG_GID(String AG_GID) {
            this.AG_GID = AG_GID;
        }

        public String getMerchant_No() {
            return Merchant_No;
        }

        public void setMerchant_No(String Merchant_No) {
            this.Merchant_No = Merchant_No;
        }

        public String getTermina_Token() {
            return Termina_Token;
        }

        public void setTermina_Token(String Termina_Token) {
            this.Termina_Token = Termina_Token;
        }

        public Object getTermina_ID() {
            return Termina_ID;
        }

        public void setTermina_ID(Object Termina_ID) {
            this.Termina_ID = Termina_ID;
        }

        public Object getUM_Unionid() {
            return UM_Unionid;
        }

        public void setUM_Unionid(Object UM_Unionid) {
            this.UM_Unionid = UM_Unionid;
        }

        public Object getUM_OpenID() {
            return UM_OpenID;
        }

        public void setUM_OpenID(Object UM_OpenID) {
            this.UM_OpenID = UM_OpenID;
        }

        public Object getUM_RegSource() {
            return UM_RegSource;
        }

        public void setUM_RegSource(Object UM_RegSource) {
            this.UM_RegSource = UM_RegSource;
        }

        public Object getUM_RegSourceParam() {
            return UM_RegSourceParam;
        }

        public void setUM_RegSourceParam(Object UM_RegSourceParam) {
            this.UM_RegSourceParam = UM_RegSourceParam;
        }

        public Object getUM_RegIP() {
            return UM_RegIP;
        }

        public void setUM_RegIP(Object UM_RegIP) {
            this.UM_RegIP = UM_RegIP;
        }

        public String getGID() {
            return GID;
        }

        public void setGID(String GID) {
            this.GID = GID;
        }

        public String getUM_Acount() {
            return UM_Acount;
        }

        public void setUM_Acount(String UM_Acount) {
            this.UM_Acount = UM_Acount;
        }

        public String getUM_Pwd() {
            return UM_Pwd;
        }

        public void setUM_Pwd(String UM_Pwd) {
            this.UM_Pwd = UM_Pwd;
        }

        public String getUM_Name() {
            return UM_Name;
        }

        public void setUM_Name(String UM_Name) {
            this.UM_Name = UM_Name;
        }

        public String getUM_Contact() {
            return UM_Contact;
        }

        public void setUM_Contact(String UM_Contact) {
            this.UM_Contact = UM_Contact;
        }

        public Object getUM_Right() {
            return UM_Right;
        }

        public void setUM_Right(Object UM_Right) {
            this.UM_Right = UM_Right;
        }

        public int getUM_IsLock() {
            return UM_IsLock;
        }

        public void setUM_IsLock(int UM_IsLock) {
            this.UM_IsLock = UM_IsLock;
        }

        public String getUM_Remark() {
            return UM_Remark;
        }

        public void setUM_Remark(String UM_Remark) {
            this.UM_Remark = UM_Remark;
        }

        public String getUM_IP() {
            return UM_IP;
        }

        public void setUM_IP(String UM_IP) {
            this.UM_IP = UM_IP;
        }

        public Object getUM_LoginTime() {
            return UM_LoginTime;
        }

        public void setUM_LoginTime(Object UM_LoginTime) {
            this.UM_LoginTime = UM_LoginTime;
        }

        public String getUM_Creator() {
            return UM_Creator;
        }

        public void setUM_Creator(String UM_Creator) {
            this.UM_Creator = UM_Creator;
        }

        public String getUM_UpdateTime() {
            return UM_UpdateTime;
        }

        public void setUM_UpdateTime(String UM_UpdateTime) {
            this.UM_UpdateTime = UM_UpdateTime;
        }

        public int getUM_IsAmin() {
            return UM_IsAmin;
        }

        public void setUM_IsAmin(int UM_IsAmin) {
            this.UM_IsAmin = UM_IsAmin;
        }

        public String getCY_GID() {
            return CY_GID;
        }

        public void setCY_GID(String CY_GID) {
            this.CY_GID = CY_GID;
        }

        public Object getUM_CreateTime() {
            return UM_CreateTime;
        }

        public void setUM_CreateTime(Object UM_CreateTime) {
            this.UM_CreateTime = UM_CreateTime;
        }

        public Object getUM_UpdateState() {
            return UM_UpdateState;
        }

        public void setUM_UpdateState(Object UM_UpdateState) {
            this.UM_UpdateState = UM_UpdateState;
        }

        public String getShopID() {
            return ShopID;
        }

        public void setShopID(String ShopID) {
            this.ShopID = ShopID;
        }

        public String getSM_Name() {
            return SM_Name;
        }

        public void setSM_Name(String SM_Name) {
            this.SM_Name = SM_Name;
        }

        public Object getRoleName() {
            return RoleName;
        }

        public void setRoleName(Object RoleName) {
            this.RoleName = RoleName;
        }

        public String getRoleID() {
            return RoleID;
        }

        public void setRoleID(String RoleID) {
            this.RoleID = RoleID;
        }

        public Object getMenuResourceList() {
            return MenuResourceList;
        }

        public void setMenuResourceList(Object MenuResourceList) {
            this.MenuResourceList = MenuResourceList;
        }

        public Object getEM_GID() {
            return EM_GID;
        }

        public void setEM_GID(Object EM_GID) {
            this.EM_GID = EM_GID;
        }

        public Object getEM_Name() {
            return EM_Name;
        }

        public void setEM_Name(Object EM_Name) {
            this.EM_Name = EM_Name;
        }

        public Object getRM_Name() {
            return RM_Name;
        }

        public void setRM_Name(Object RM_Name) {
            this.RM_Name = RM_Name;
        }

        public Object getUM_State() {
            return UM_State;
        }

        public void setUM_State(Object UM_State) {
            this.UM_State = UM_State;
        }

        public String getUM_ChatHead() {
            return UM_ChatHead;
        }

        public void setUM_ChatHead(String UM_ChatHead) {
            this.UM_ChatHead = UM_ChatHead;
        }

        public List<?> getAuthorityList() {
            return AuthorityList;
        }

        public void setAuthorityList(List<?> AuthorityList) {
            this.AuthorityList = AuthorityList;
        }

        public List<ShopListBean> getShopList() {
            return ShopList;
        }

        public void setShopList(List<ShopListBean> ShopList) {
            this.ShopList = ShopList;
        }

        public List<MenuInfoListBean> getMenuInfoList() {
            return MenuInfoList;
        }

        public void setMenuInfoList(List<MenuInfoListBean> MenuInfoList) {
            this.MenuInfoList = MenuInfoList;
        }

        public static class AgentsBean implements Serializable{
            /**
             * GID : PlatformUser
             * AG_Name : 云上铺
             * AG_CreateTime : null
             * AG_Domain : pc.yunvip123.com
             * AG_SoftwareName : 云上铺
             * AG_LogoUrl : http://img.yunvip123.com/OEM_IMAGE/0327660b-3dce-4cda-9f6b-c6ed5360a110.jpeg
             * AG_Type : 2
             * PCUrl :
             * AG_GoodLimit : 100
             * AG_MberLimit : 100
             */

            private String GID;
            private String AG_Name;
            private Object AG_CreateTime;
            private String AG_Domain;
            private String AG_SoftwareName;
            private String AG_LogoUrl;
            private int AG_Type;
            private String PCUrl;
            private int AG_GoodLimit;
            private int AG_MberLimit;

            public String getGID() {
                return GID;
            }

            public void setGID(String GID) {
                this.GID = GID;
            }

            public String getAG_Name() {
                return AG_Name;
            }

            public void setAG_Name(String AG_Name) {
                this.AG_Name = AG_Name;
            }

            public Object getAG_CreateTime() {
                return AG_CreateTime;
            }

            public void setAG_CreateTime(Object AG_CreateTime) {
                this.AG_CreateTime = AG_CreateTime;
            }

            public String getAG_Domain() {
                return AG_Domain;
            }

            public void setAG_Domain(String AG_Domain) {
                this.AG_Domain = AG_Domain;
            }

            public String getAG_SoftwareName() {
                return AG_SoftwareName;
            }

            public void setAG_SoftwareName(String AG_SoftwareName) {
                this.AG_SoftwareName = AG_SoftwareName;
            }

            public String getAG_LogoUrl() {
                return AG_LogoUrl;
            }

            public void setAG_LogoUrl(String AG_LogoUrl) {
                this.AG_LogoUrl = AG_LogoUrl;
            }

            public int getAG_Type() {
                return AG_Type;
            }

            public void setAG_Type(int AG_Type) {
                this.AG_Type = AG_Type;
            }

            public String getPCUrl() {
                return PCUrl;
            }

            public void setPCUrl(String PCUrl) {
                this.PCUrl = PCUrl;
            }

            public int getAG_GoodLimit() {
                return AG_GoodLimit;
            }

            public void setAG_GoodLimit(int AG_GoodLimit) {
                this.AG_GoodLimit = AG_GoodLimit;
            }

            public int getAG_MberLimit() {
                return AG_MberLimit;
            }

            public void setAG_MberLimit(int AG_MberLimit) {
                this.AG_MberLimit = AG_MberLimit;
            }
        }

        public static class ShopListBean  implements Serializable{
            /**
             * SM_MaxVip : 10000
             * SM_MaxProduct : 10000
             * SM_MaxStaff : 50
             * SM_SersionLife : 5
             * SM_TextOptimization :
             * SF_Code :
             * SM_FunctionList :
             * FunctionList : null
             * SM_Code : null
             * SM_DefaultCode : null
             * GID : 4a7b1141-8ca3-4bef-961f-ffd153357823
             * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
             * SM_Name : jll2
             * SM_Contacter : 6545646
             * SM_Phone : 18328578333
             * SM_Addr :
             * SM_Remark :
             * SM_State : 0
             * SM_UpdateTime : 2019-04-10 14:55:27
             * SM_Picture : /img/head.png
             * SM_Creator : 1058346971@qq.com
             * SM_XLong : null
             * SM_YLat : null
             * SM_Industry : 汽车美容
             * SM_Range :
             * SM_Country : null
             * SM_Province : 山西省
             * SM_Disctrict : 矿区
             * SM_DetailAddr :
             * SM_MapAddr : null
             * SM_UpdateState : 1
             * SM_AcountNum : 10
             * SM_Type : 1
             * SM_EndTime : 2023-11-19 13:55:18
             * SM_CreateTime : 2018-06-29 15:45:53
             * SM_City : 大同市
             * VipNumber : 0
             * ProNumber : 0
             * SM_IndustryType : 100
             * SaoBei_State : 0
             * SaoBei_Message : null
             * SM_BusinessName : null
             * SM_BranchName : null
             * SM_WXState : 0
             * SM_BusinessType : null
             * SM_OffsetType : 0
             * SM_WXMessage : null
             * SM_WXPoiId : null
             */

            private int SM_MaxVip;
            private int SM_MaxProduct;
            private int SM_MaxStaff;
            private String SM_SersionLife;
            private String SM_TextOptimization;
            private String SF_Code;
            private String SM_FunctionList;
            private Object FunctionList;
            private Object SM_Code;
            private Object SM_DefaultCode;
            private String GID;
            private String CY_GID;
            private String SM_Name;
            private String SM_Contacter;
            private String SM_Phone;
            private String SM_Addr;
            private String SM_Remark;
            private int SM_State;
            private String SM_UpdateTime;
            private String SM_Picture;
            private String SM_Creator;
            private Object SM_XLong;
            private Object SM_YLat;
            private String SM_Industry;
            private String SM_Range;
            private Object SM_Country;
            private String SM_Province;
            private String SM_Disctrict;
            private String SM_DetailAddr;
            private Object SM_MapAddr;
            private int SM_UpdateState;
            private int SM_AcountNum;
            private int SM_Type;
            private String SM_EndTime;
            private String SM_CreateTime;
            private String SM_City;
            private int VipNumber;
            private int ProNumber;
            private int SM_IndustryType;
            private int SaoBei_State;
            private Object SaoBei_Message;
            private Object SM_BusinessName;
            private Object SM_BranchName;
            private int SM_WXState;
            private Object SM_BusinessType;
            private int SM_OffsetType;
            private Object SM_WXMessage;
            private Object SM_WXPoiId;

            public int getSM_MaxVip() {
                return SM_MaxVip;
            }

            public void setSM_MaxVip(int SM_MaxVip) {
                this.SM_MaxVip = SM_MaxVip;
            }

            public int getSM_MaxProduct() {
                return SM_MaxProduct;
            }

            public void setSM_MaxProduct(int SM_MaxProduct) {
                this.SM_MaxProduct = SM_MaxProduct;
            }

            public int getSM_MaxStaff() {
                return SM_MaxStaff;
            }

            public void setSM_MaxStaff(int SM_MaxStaff) {
                this.SM_MaxStaff = SM_MaxStaff;
            }

            public String getSM_SersionLife() {
                return SM_SersionLife;
            }

            public void setSM_SersionLife(String SM_SersionLife) {
                this.SM_SersionLife = SM_SersionLife;
            }

            public String getSM_TextOptimization() {
                return SM_TextOptimization;
            }

            public void setSM_TextOptimization(String SM_TextOptimization) {
                this.SM_TextOptimization = SM_TextOptimization;
            }

            public String getSF_Code() {
                return SF_Code;
            }

            public void setSF_Code(String SF_Code) {
                this.SF_Code = SF_Code;
            }

            public String getSM_FunctionList() {
                return SM_FunctionList;
            }

            public void setSM_FunctionList(String SM_FunctionList) {
                this.SM_FunctionList = SM_FunctionList;
            }

            public Object getFunctionList() {
                return FunctionList;
            }

            public void setFunctionList(Object FunctionList) {
                this.FunctionList = FunctionList;
            }

            public Object getSM_Code() {
                return SM_Code;
            }

            public void setSM_Code(Object SM_Code) {
                this.SM_Code = SM_Code;
            }

            public Object getSM_DefaultCode() {
                return SM_DefaultCode;
            }

            public void setSM_DefaultCode(Object SM_DefaultCode) {
                this.SM_DefaultCode = SM_DefaultCode;
            }

            public String getGID() {
                return GID;
            }

            public void setGID(String GID) {
                this.GID = GID;
            }

            public String getCY_GID() {
                return CY_GID;
            }

            public void setCY_GID(String CY_GID) {
                this.CY_GID = CY_GID;
            }

            public String getSM_Name() {
                return SM_Name;
            }

            public void setSM_Name(String SM_Name) {
                this.SM_Name = SM_Name;
            }

            public String getSM_Contacter() {
                return SM_Contacter;
            }

            public void setSM_Contacter(String SM_Contacter) {
                this.SM_Contacter = SM_Contacter;
            }

            public String getSM_Phone() {
                return SM_Phone;
            }

            public void setSM_Phone(String SM_Phone) {
                this.SM_Phone = SM_Phone;
            }

            public String getSM_Addr() {
                return SM_Addr;
            }

            public void setSM_Addr(String SM_Addr) {
                this.SM_Addr = SM_Addr;
            }

            public String getSM_Remark() {
                return SM_Remark;
            }

            public void setSM_Remark(String SM_Remark) {
                this.SM_Remark = SM_Remark;
            }

            public int getSM_State() {
                return SM_State;
            }

            public void setSM_State(int SM_State) {
                this.SM_State = SM_State;
            }

            public String getSM_UpdateTime() {
                return SM_UpdateTime;
            }

            public void setSM_UpdateTime(String SM_UpdateTime) {
                this.SM_UpdateTime = SM_UpdateTime;
            }

            public String getSM_Picture() {
                return SM_Picture;
            }

            public void setSM_Picture(String SM_Picture) {
                this.SM_Picture = SM_Picture;
            }

            public String getSM_Creator() {
                return SM_Creator;
            }

            public void setSM_Creator(String SM_Creator) {
                this.SM_Creator = SM_Creator;
            }

            public Object getSM_XLong() {
                return SM_XLong;
            }

            public void setSM_XLong(Object SM_XLong) {
                this.SM_XLong = SM_XLong;
            }

            public Object getSM_YLat() {
                return SM_YLat;
            }

            public void setSM_YLat(Object SM_YLat) {
                this.SM_YLat = SM_YLat;
            }

            public String getSM_Industry() {
                return SM_Industry;
            }

            public void setSM_Industry(String SM_Industry) {
                this.SM_Industry = SM_Industry;
            }

            public String getSM_Range() {
                return SM_Range;
            }

            public void setSM_Range(String SM_Range) {
                this.SM_Range = SM_Range;
            }

            public Object getSM_Country() {
                return SM_Country;
            }

            public void setSM_Country(Object SM_Country) {
                this.SM_Country = SM_Country;
            }

            public String getSM_Province() {
                return SM_Province;
            }

            public void setSM_Province(String SM_Province) {
                this.SM_Province = SM_Province;
            }

            public String getSM_Disctrict() {
                return SM_Disctrict;
            }

            public void setSM_Disctrict(String SM_Disctrict) {
                this.SM_Disctrict = SM_Disctrict;
            }

            public String getSM_DetailAddr() {
                return SM_DetailAddr;
            }

            public void setSM_DetailAddr(String SM_DetailAddr) {
                this.SM_DetailAddr = SM_DetailAddr;
            }

            public Object getSM_MapAddr() {
                return SM_MapAddr;
            }

            public void setSM_MapAddr(Object SM_MapAddr) {
                this.SM_MapAddr = SM_MapAddr;
            }

            public int getSM_UpdateState() {
                return SM_UpdateState;
            }

            public void setSM_UpdateState(int SM_UpdateState) {
                this.SM_UpdateState = SM_UpdateState;
            }

            public int getSM_AcountNum() {
                return SM_AcountNum;
            }

            public void setSM_AcountNum(int SM_AcountNum) {
                this.SM_AcountNum = SM_AcountNum;
            }

            public int getSM_Type() {
                return SM_Type;
            }

            public void setSM_Type(int SM_Type) {
                this.SM_Type = SM_Type;
            }

            public String getSM_EndTime() {
                return SM_EndTime;
            }

            public void setSM_EndTime(String SM_EndTime) {
                this.SM_EndTime = SM_EndTime;
            }

            public String getSM_CreateTime() {
                return SM_CreateTime;
            }

            public void setSM_CreateTime(String SM_CreateTime) {
                this.SM_CreateTime = SM_CreateTime;
            }

            public String getSM_City() {
                return SM_City;
            }

            public void setSM_City(String SM_City) {
                this.SM_City = SM_City;
            }

            public int getVipNumber() {
                return VipNumber;
            }

            public void setVipNumber(int VipNumber) {
                this.VipNumber = VipNumber;
            }

            public int getProNumber() {
                return ProNumber;
            }

            public void setProNumber(int ProNumber) {
                this.ProNumber = ProNumber;
            }

            public int getSM_IndustryType() {
                return SM_IndustryType;
            }

            public void setSM_IndustryType(int SM_IndustryType) {
                this.SM_IndustryType = SM_IndustryType;
            }

            public int getSaoBei_State() {
                return SaoBei_State;
            }

            public void setSaoBei_State(int SaoBei_State) {
                this.SaoBei_State = SaoBei_State;
            }

            public Object getSaoBei_Message() {
                return SaoBei_Message;
            }

            public void setSaoBei_Message(Object SaoBei_Message) {
                this.SaoBei_Message = SaoBei_Message;
            }

            public Object getSM_BusinessName() {
                return SM_BusinessName;
            }

            public void setSM_BusinessName(Object SM_BusinessName) {
                this.SM_BusinessName = SM_BusinessName;
            }

            public Object getSM_BranchName() {
                return SM_BranchName;
            }

            public void setSM_BranchName(Object SM_BranchName) {
                this.SM_BranchName = SM_BranchName;
            }

            public int getSM_WXState() {
                return SM_WXState;
            }

            public void setSM_WXState(int SM_WXState) {
                this.SM_WXState = SM_WXState;
            }

            public Object getSM_BusinessType() {
                return SM_BusinessType;
            }

            public void setSM_BusinessType(Object SM_BusinessType) {
                this.SM_BusinessType = SM_BusinessType;
            }

            public int getSM_OffsetType() {
                return SM_OffsetType;
            }

            public void setSM_OffsetType(int SM_OffsetType) {
                this.SM_OffsetType = SM_OffsetType;
            }

            public Object getSM_WXMessage() {
                return SM_WXMessage;
            }

            public void setSM_WXMessage(Object SM_WXMessage) {
                this.SM_WXMessage = SM_WXMessage;
            }

            public Object getSM_WXPoiId() {
                return SM_WXPoiId;
            }

            public void setSM_WXPoiId(Object SM_WXPoiId) {
                this.SM_WXPoiId = SM_WXPoiId;
            }
        }

        public static class MenuInfoListBean  implements Serializable{
            /**
             * GID : 44c5a445-ac4e-47aa-8efa-984aac438a8e
             * MM_Name : 公众号授权
             * MM_Sort : 0
             * MM_Code : 1
             * MM_ParentID : 3dc84aba-238f-41aa-84f0-be042120d9f8
             * MM_Type : 1
             * MM_LinkUrl : /WebUI/WXSet/WXAuthorization.html
             * MM_Icon :
             * MM_Remark : null
             * MM_CreateTime : null
             * MM_Creator : null
             */

            private String GID;
            private String MM_Name;
            private int MM_Sort;
            private String MM_Code;
            private String MM_ParentID;
            private int MM_Type;
            private String MM_LinkUrl;
            private String MM_Icon;
            private Object MM_Remark;
            private Object MM_CreateTime;
            private Object MM_Creator;

            public String getGID() {
                return GID;
            }

            public void setGID(String GID) {
                this.GID = GID;
            }

            public String getMM_Name() {
                return MM_Name;
            }

            public void setMM_Name(String MM_Name) {
                this.MM_Name = MM_Name;
            }

            public int getMM_Sort() {
                return MM_Sort;
            }

            public void setMM_Sort(int MM_Sort) {
                this.MM_Sort = MM_Sort;
            }

            public String getMM_Code() {
                return MM_Code;
            }

            public void setMM_Code(String MM_Code) {
                this.MM_Code = MM_Code;
            }

            public String getMM_ParentID() {
                return MM_ParentID;
            }

            public void setMM_ParentID(String MM_ParentID) {
                this.MM_ParentID = MM_ParentID;
            }

            public int getMM_Type() {
                return MM_Type;
            }

            public void setMM_Type(int MM_Type) {
                this.MM_Type = MM_Type;
            }

            public String getMM_LinkUrl() {
                return MM_LinkUrl;
            }

            public void setMM_LinkUrl(String MM_LinkUrl) {
                this.MM_LinkUrl = MM_LinkUrl;
            }

            public String getMM_Icon() {
                return MM_Icon;
            }

            public void setMM_Icon(String MM_Icon) {
                this.MM_Icon = MM_Icon;
            }

            public Object getMM_Remark() {
                return MM_Remark;
            }

            public void setMM_Remark(Object MM_Remark) {
                this.MM_Remark = MM_Remark;
            }

            public Object getMM_CreateTime() {
                return MM_CreateTime;
            }

            public void setMM_CreateTime(Object MM_CreateTime) {
                this.MM_CreateTime = MM_CreateTime;
            }

            public Object getMM_Creator() {
                return MM_Creator;
            }

            public void setMM_Creator(Object MM_Creator) {
                this.MM_Creator = MM_Creator;
            }
        }
    }
}
