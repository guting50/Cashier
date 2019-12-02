package com.wycd.yushangpu.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by YSL on 2018-08-28.
 * 登录获取所有相关数据设置
 */

public class ReportMessageBean implements Serializable {


    /**
     * success : true
     * code : null
     * msg : 执行成功
     * data : {"GetCustomFieldsVIP":[{"CF_GID":"34f6c04b-e516-42f5-902a-f7b31f9bcf7a","CF_FieldName":"办卡日期","CF_FieldType":"日期","CF_ItemsValue":"","CF_Value":"","CF_Required":"是","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","VIP_GID":"1","CF_CreateUser":"销售001","CF_CreateTime":"2018-10-29 15:40:27","CF_Order":5,"CF_IsShowVIP":1},{"CF_GID":"e6c3df23-8580-4cfd-9e42-98f916db9f94","CF_FieldName":"潜","CF_FieldType":"文本","CF_ItemsValue":"","CF_Value":"","CF_Required":"是","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","VIP_GID":"1","CF_CreateUser":"销售001","CF_CreateTime":"2018-11-07 10:05:03","CF_Order":6,"CF_IsShowVIP":1}],"GetCustomFields":[{"CF_Order":3,"CF_GID":"d024aa5c-63ef-4ca3-b316-0cad2dc3965b","CF_FieldName":"备注","CF_FieldType":"文本","CF_ItemsValue":"","CF_Value":"","CF_Required":"是","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","VIP_GID":"","PM_GID":"1","CF_CreateUser":"销售001","CF_CreateTime":"2018-10-30 09:24:01"}],"GetLoginHistoryList":[{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-30 14:20:57","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-30 14:20:34","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-30 12:01:15","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-30 11:39:16","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.132.254","LM_Area":"未能解析IP:124.14.132.254","LM_Time":"2019-03-30 11:35:02","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.132.254","LM_Area":"未能解析IP:124.14.132.254","LM_Time":"2019-03-29 20:49:21","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.132.254","LM_Area":"未能解析IP:124.14.132.254","LM_Time":"2019-03-29 20:36:57","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.132.254","LM_Area":"未能解析IP:124.14.132.254","LM_Time":"2019-03-29 16:04:47","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-28 16:58:37","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-28 16:58:15","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-28 16:11:45","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-28 15:58:40","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-28 15:49:04","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-28 10:37:13","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-28 10:36:44","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-28 09:49:19","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-28 09:43:20","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-28 09:39:28","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"223.104.215.245","LM_Area":"未能解析IP:223.104.215.245","LM_Time":"2019-03-27 11:18:23","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"182.148.200.63","LM_Area":"未能解析IP:182.148.200.63","LM_Time":"2019-03-27 08:09:58","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 17:46:12","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-26 17:27:15","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 15:07:59","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 14:57:03","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-26 14:54:23","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 11:11:50","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 11:00:36","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 10:59:03","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 10:46:51","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 10:43:50","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 10:41:01","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-26 10:13:16","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 09:43:55","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 17:17:29","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:48:46","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:45:18","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:43:22","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:29:43","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:24:22","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:20:08","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:16:55","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:11:04","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:08:49","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 12:01:49","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-22 17:59:54","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-22 17:57:53","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-22 17:51:44","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-22 17:45:14","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-22 17:39:02","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-22 17:32:57","LM_Type":"苹果APP"}],"GetSysSwitchList":[{"SS_Value":null,"GID":"4f3aefbe-172e-4839-b81e-3ace7da00007","SS_Name":"会员卡号同手机号","SS_Code":"201","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":1},{"SS_Value":null,"GID":"80253331-6990-4ae2-9d35-85aa3a685e15","SS_Name":"添加会员","SS_Code":"001","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:49","CY_GID":null,"SS_Sort":1},{"SS_Value":null,"GID":"ebd1df1e-d674-412c-b426-936ac3a92527","SS_Name":"现金支付","SS_Code":"101","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":1},{"SS_Value":null,"GID":"24773a53-0254-4bc1-9210-1874868ce252","SS_Name":"手机号可重复","SS_Code":"213","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-11-20 12:05:06","CY_GID":null,"SS_Sort":2},{"SS_Value":null,"GID":"b3972e71-cce4-472f-b2eb-1f92b372034d","SS_Name":"会员充值","SS_Code":"002","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:49","CY_GID":null,"SS_Sort":2},{"SS_Value":null,"GID":"c3003fac-f894-4fce-9614-69a0c2653abb","SS_Name":"余额支付","SS_Code":"102","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":2},{"SS_Value":null,"GID":"e6db7829-665b-46ea-8f4b-ea1acab74101","SS_Name":"初始金额和初始积分","SS_Code":"203","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":2},{"SS_Value":null,"GID":"5edf13ec-20c6-4aa8-917f-455098360008","SS_Name":"微信记账","SS_Code":"105","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":3},{"SS_Value":null,"GID":"a9e0855f-18d5-475b-a9af-62e7d4849c92","SS_Name":"会员卡卡面卡号","SS_Code":"208","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":3},{"SS_Value":null,"GID":"dc13679f-6df5-4800-9573-e29bd841dae6","SS_Name":"会员充次","SS_Code":"003","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:49","CY_GID":null,"SS_Sort":3},{"SS_Value":null,"GID":"4279b4a7-98c0-4a42-a0d8-c7e96fa23ad7","SS_Name":"会员查询弹窗","SS_Code":"209","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":4},{"SS_Value":null,"GID":"601696e4-aca4-46e5-87f6-5f3d7f84353e","SS_Name":"会员升级","SS_Code":"004","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:49","CY_GID":null,"SS_Sort":4},{"SS_Value":null,"GID":"c21488f7-c1cf-423d-a541-ca89d3873024","SS_Name":"支付宝记账","SS_Code":"106","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":4},{"SS_Value":null,"GID":"2e35a983-712f-40d8-9972-11dcad4443e6","SS_Name":"会员降级","SS_Code":"005","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":5},{"SS_Value":null,"GID":"957f6691-98b5-4309-80cb-e7e2d2cb692d","SS_Name":"是否显示它店会员","SS_Code":"210","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":5},{"SS_Value":null,"GID":"b3ca03da-9189-4d6a-820c-1f24587d43ef","SS_Name":"银联支付","SS_Code":"103","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":5},{"SS_Value":null,"GID":"169d2551-a906-497d-b48d-c1e1da64fe8b","SS_Name":"积分清零","SS_Code":"006","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":6},{"SS_Value":null,"GID":"58193ebf-29a2-42ee-9c32-773363e2d40c","SS_Name":"优惠券","SS_Code":"110","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":6},{"SS_Value":null,"GID":"84d75a71-2974-4b9e-ae36-be529fca5a63","SS_Name":"是否必填手机号","SS_Code":"211","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-06 11:29:14","CY_GID":null,"SS_Sort":6},{"SS_Value":null,"GID":"f66d5b86-25a1-480d-8725-607a4c4e2be7","SS_Name":"员工提成","SS_Code":"301","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":6},{"SS_Value":null,"GID":"441c0bde-c896-4062-bf6b-509e801bd58d","SS_Name":"扫码支付","SS_Code":"111","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":7},{"SS_Value":null,"GID":"cf58b330-5f4d-4e80-85ca-c2b460862ed4","SS_Name":"积分变动","SS_Code":"007","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":7},{"SS_Value":null,"GID":"f2a5ad42-5e71-41e3-bd7e-ec7031571d22","SS_Name":"折后金额修改","SS_Code":"601","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":7},{"SS_Value":null,"GID":"4f2f2774-606a-447a-947f-9e2dcfd8602f","SS_Name":"修改密码","SS_Code":"008","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":8},{"SS_Value":null,"GID":"5991e139-3fc3-413c-a903-cdd40c8241d8","SS_Name":"其他支付","SS_Code":"113","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-20 15:30:53","CY_GID":null,"SS_Sort":8},{"SS_Value":null,"GID":"91195107-8a02-400b-b6ac-9416b5586030","SS_Name":"医保卡支付","SS_Code":"112","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":8},{"SS_Value":null,"GID":"a2914265-a881-4e66-95c0-5a9abe877ec5","SS_Name":"计次消费规则","SS_Code":"212","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-11-20 12:05:06","CY_GID":null,"SS_Sort":8},{"SS_Value":"123456","GID":"d9501b35-00e5-4ed8-8218-c2012f69e3e9","SS_Name":"开卡初始密码","SS_Code":"202","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":8},{"SS_Value":null,"GID":"025763ce-14c5-4c99-b69d-bb027bf3a57d","SS_Name":"消费密码验证","SS_Code":"204","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":9},{"SS_Value":null,"GID":"0fcf5355-1e24-472a-988e-67b612dfadb9","SS_Name":"必须刷卡","SS_Code":"214","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2019-01-16 10:40:59","CY_GID":null,"SS_Sort":9},{"SS_Value":"10","GID":"838ed745-51ea-4300-8153-ff8b30dc0171","SS_Name":"积分支付","SS_Code":"107","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":9},{"SS_Value":null,"GID":"85acdc2d-5e09-488e-8009-d53cf5ac3ebf","SS_Name":"会员挂失","SS_Code":"009","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":9},{"SS_Value":"100","GID":"081a3850-4db5-43df-a362-0ebbd4d34a44","SS_Name":"积分支付限制","SS_Code":"109","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":10},{"SS_Value":null,"GID":"33717552-b3be-4f9b-9ff3-c9dfdf467751","SS_Name":"转账密码验证","SS_Code":"205","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":10},{"SS_Value":null,"GID":"f200acd3-0bc9-44d1-ab38-ab453b29d526","SS_Name":"快速消费","SS_Code":"010","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":10},{"SS_Value":"XJZF","GID":"00cdab7e-c09b-4d93-8192-07dea54afd67","SS_Name":"默认支付","SS_Code":"108","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":11},{"SS_Value":null,"GID":"322129b8-6935-41cb-8dda-d42d0ddf28dc","SS_Name":"商品消费","SS_Code":"011","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":11},{"SS_Value":null,"GID":"af20faab-9cdb-4b09-ae92-3667a17054b1","SS_Name":"兑换密码验证","SS_Code":"206","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":11},{"SS_Value":null,"GID":"43df8118-e572-4821-a1d8-6d39bcab15ef","SS_Name":"计次消费","SS_Code":"012","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":12},{"SS_Value":null,"GID":"9cb968c1-02ba-44ae-b4e2-917d9dcb6fb4","SS_Name":"换卡密码验证","SS_Code":"207","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":12},{"SS_Value":"123456","GID":"cb3fb011-2e0d-492b-b00f-1d0eae05ec58","SS_Name":"撤单密码","SS_Code":"215","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2019-01-16 10:40:59","CY_GID":null,"SS_Sort":12},{"SS_Value":"0","GID":"0a7d2549-d251-4b44-a612-81f328f85253","SS_Name":"会员推荐提成","SS_Code":"503","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":13},{"SS_Value":null,"GID":"373854cc-6634-4fec-9df4-bd1f356cff2f","SS_Name":"礼品兑换","SS_Code":"013","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":13},{"SS_Value":null,"GID":"2fcdbd40-45be-4d06-8251-6f2debb1f1e5","SS_Name":"生日提醒","SS_Code":"014","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":14},{"SS_Value":"100","GID":"7e595591-f403-4dcb-801b-8a6f08aac913","SS_Name":"会员消费提成","SS_Code":"501","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":14},{"SS_Value":null,"GID":"84fae984-3ab8-4407-8386-f9525c5dcea6","SS_Name":"到期提醒","SS_Code":"016","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":15},{"SS_Value":"100","GID":"bbf14fee-1701-4954-8544-9dff993d7b4e","SS_Name":"会员获得积分提成","SS_Code":"502","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":15},{"SS_Value":null,"GID":"0c7375cd-276f-4eb8-80ba-3d84c6697025","SS_Name":"刷卡登记","SS_Code":"017","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":16},{"SS_Value":null,"GID":"675b54c8-4cbe-447f-866f-0aeb4ff95f5e","SS_Name":"房台消费","SS_Code":"018","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":17},{"SS_Value":null,"GID":"a1f9ed91-4567-4b88-a1e1-4b34fef790c2","SS_Name":"套餐消费","SS_Code":"019","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":18},{"SS_Value":null,"GID":"c34c2cb9-e35d-4b52-9507-2e51923cd3f6","SS_Name":"开启客显","SS_Code":"701","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-11-20 12:05:06","CY_GID":null,"SS_Sort":19},{"SS_Value":null,"GID":"f533fe88-dd39-46bf-90d6-de488894418f","SS_Name":"计时消费","SS_Code":"021","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":19},{"SS_Value":"COM1","GID":"8fd678ff-4328-429b-9233-605495202e18","SS_Name":"通讯端口","SS_Code":"702","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-11-20 12:05:06","CY_GID":null,"SS_Sort":20},{"SS_Value":"2400","GID":"bb174463-3d04-45bb-ae83-19691337f533","SS_Name":"波特率","SS_Code":"703","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-11-20 12:05:06","CY_GID":null,"SS_Sort":21}],"VIPGradeList":[{"VG_IsDownLock":0,"VG_UpDownType":0,"VG_NextGradeName":"默认等级","VG_NextGradeGID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_LastGradeName":"","VG_LastGradeGID":"","US_ValueMax":9,"VG_IsTimeTimes":1,"GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","US_Code":"IntegerFulfil","US_Value":1,"VG_Name":"等级","VG_Code":"","VG_CardAmount":10,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":1,"VG_IsAccount":0,"VG_IsIntegral":0,"VG_IsDiscount":0,"VG_IsCount":0,"VG_IsTime":1,"VG_IsTimeNum":1,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":0,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":1,"GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","US_Code":"IntegerFulfil","US_Value":0,"VG_Name":"默认等级","VG_Code":"","VG_CardAmount":0,"VG_InitialAmount":10,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":1,"VG_IsTimeNum":1,"VG_IsTimeUnit":"年","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":0,"RS_CMoney":1,"RS_Value":1,"VS_CMoney":1,"VS_Value":1,"US_Name":"积分达到","Settings":[{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[{"SR_Timer":null,"SR_TimeUnit":null,"GID":"3d4f5b35-d08a-4ce9-a784-70f654cb552d","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"5fe0bfd4-9d16-42ad-ace9-73650ad95151","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"4545蜂屯蚁附"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"44840b05-4eff-4902-8895-2410e37f4663","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"2efb8c23-0aed-41a2-a8b2-9c2bc0cedd72","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"礼品商品004"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"4d33f095-f243-457c-80eb-758ab855ed99","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"ab05706d-3879-44dd-9893-5df2f326e684","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"服务商品007"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"5f02d2f1-b0ab-436f-8539-637b802819a6","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"f809d722-18b5-4f7f-9ac7-fa0d7ad9a0ff","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"服务商品007"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"7341fb78-b666-429a-a134-f4207bb8b432","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"d97d845e-29be-4379-8da4-a4dfe999e30c","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"精品SPA"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"79f28bf1-866e-493e-9844-7156659fca96","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"d48d17a5-0997-4cf4-a305-52b89a6ade6f","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"服务商品"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"7f3a3abd-9003-43d3-abcb-2586f10a04c2","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"1afe9c05-a4be-4dc7-a868-c66df9be3467","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"撒飒飒"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"8675d521-3f9c-4bac-8be1-3de814a49078","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"7808802b-b91d-4bb0-9a3e-23fb6fef9f4b","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"174563发"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"a1ed4d95-18b7-4435-8a57-a77c78d5ceb2","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"7320ddfe-e4f5-49f5-bf17-83c77436901d","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"服务1840"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"a6d3d530-a617-4ea0-b36d-02b2c111ea34","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"118a4f60-a2b5-4a7e-b47d-6f4d2b801379","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"好11"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"c08ac1b6-9c3f-4ee3-b19e-6a591aeb3b90","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"67c264d0-7001-48b9-8bd6-e0ba65218b07","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"豆浆"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"c1cf3a1c-f4a2-464b-b19f-3a27a8025fca","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"41633c1f-216a-4c34-b211-fbcf3c3f38c9","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"2133"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"c90a585c-d696-4b05-86eb-b85b8499e6f8","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"858f4dd1-cd1a-4b66-b2a0-2b697d2c7c11","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"跑腿吃鸡"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"cd47cbbb-29ca-4f55-933e-3e5adb716e6b","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"378c63e4-2a68-4f90-a2ee-916a95d3fc63","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"SPA"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"d5045555-74fa-4368-96d3-e84c0b421e1a","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"2b641154-14e5-40f1-875e-7fb8a71ecc3d","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"服务商品"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"f40c6f6d-5eed-408c-975c-6aaffa5558b0","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"c084d0b0-f7cf-4621-a5f8-1914512803c7","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"精品理发"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"f4582529-3d8f-435c-a5fd-8b2c6a8eb263","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"7ace77f3-219b-4680-993f-ea1fc5e543bc","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"1010"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"f77ef771-69ae-45de-8dc6-46972b73a6a0","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"aed40e84-f94f-431e-a844-10de63a8d792","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"配吃"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"fca4c30a-48b1-450d-81d9-2ff342bfee92","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"05e16475-eb20-4a4f-9760-c870b9c3f8d4","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"按摩"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"ff58385c-3c3e-48b4-976f-894efe8cbdea","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"f3755ad8-3dfe-446c-9995-3ba4d1a2548c","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"服务商品"}]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":12,"GID":"94f2d09b-d29d-4807-8853-481c8b780781","US_Code":"IntegerFulfil","US_Value":5,"VG_Name":"积分","VG_Code":"","VG_CardAmount":0,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":0,"VG_IsTimeNum":212,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":0,"RS_CMoney":1,"RS_Value":1,"VS_CMoney":1,"VS_Value":1,"US_Name":"积分达到","Settings":[{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":1,"GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","US_Code":"IntegerFulfil","US_Value":10,"VG_Name":"临时会员1天","VG_Code":"","VG_CardAmount":10,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":0,"VG_IsDiscount":0,"VG_IsCount":1,"VG_IsTime":1,"VG_IsTimeNum":1,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":0,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":11,"GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","US_Code":null,"US_Value":11,"VG_Name":"等级编辑测试2","VG_Code":"","VG_CardAmount":10,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":0,"VG_IsIntegral":0,"VG_IsDiscount":0,"VG_IsCount":0,"VG_IsTime":1,"VG_IsTimeNum":12,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":100,"VG_DiscountRuleType":1,"DS_Value":100,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":null,"Settings":[{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":null,"GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","US_Code":"IntegerFulfil","US_Value":12,"VG_Name":"等级测试","VG_Code":"1","VG_CardAmount":10,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":0,"VG_IsIntegral":0,"VG_IsDiscount":0,"VG_IsCount":0,"VG_IsTime":1,"VG_IsTimeNum":null,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":0,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":null,"GID":"954a0f21-cb44-485a-8b7d-e850f258862a","US_Code":"IntegerFulfil","US_Value":20,"VG_Name":"黄金会员","VG_Code":"","VG_CardAmount":20,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":1,"VG_IsTimeNum":3333,"VG_IsTimeUnit":"年","VG_Remark":"","VG_IntegralUniformRuleValue":1,"VG_IntegralRuleType":0,"VG_DiscountUniformRuleValue":10,"VG_DiscountRuleType":0,"DS_Value":10,"RS_CMoney":1,"RS_Value":1,"VS_CMoney":1,"VS_Value":1,"US_Name":"积分达到","Settings":[{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":null,"GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","US_Code":"IntegerFulfil","US_Value":50,"VG_Name":"铂金","VG_Code":"","VG_CardAmount":50,"VG_InitialAmount":0,"VG_InitialIntegral":4,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":0,"VG_IsTimeNum":null,"VG_IsTimeUnit":null,"VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":1,"VG_DiscountRuleType":0,"DS_Value":50,"RS_CMoney":1,"RS_Value":1,"VS_CMoney":1,"VS_Value":1,"US_Name":"积分达到","Settings":[{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":1,"GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","US_Code":"IntegerFulfil","US_Value":101,"VG_Name":"会员等级编辑测试6","VG_Code":"6469871365","VG_CardAmount":10,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":0,"VG_IsIntegral":0,"VG_IsDiscount":0,"VG_IsCount":0,"VG_IsTime":1,"VG_IsTimeNum":1,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":0,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":0,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":null,"GID":"9692a1da-d658-4b2e-896b-4cc72825846b","US_Code":"IntegerFulfil","US_Value":200,"VG_Name":"一个月限时卡","VG_Code":"","VG_CardAmount":200,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":0,"VG_IsDiscount":0,"VG_IsCount":0,"VG_IsTime":1,"VG_IsTimeNum":1,"VG_IsTimeUnit":"月","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":0,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":null,"GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","US_Code":"IntegerFulfil","US_Value":500,"VG_Name":"砖石","VG_Code":"","VG_CardAmount":500,"VG_InitialAmount":500,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":0,"VG_IsTimeNum":null,"VG_IsTimeUnit":null,"VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":1,"RS_CMoney":0,"RS_Value":1,"VS_CMoney":1,"VS_Value":1,"US_Name":"积分达到","Settings":[{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":1,"GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","US_Code":"IntegerFulfil","US_Value":1000,"VG_Name":"等级测试001","VG_Code":"545","VG_CardAmount":100,"VG_InitialAmount":100,"VG_InitialIntegral":100,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":1,"VG_IsTimeNum":1111,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":1,"VG_IntegralRuleType":0,"VG_DiscountUniformRuleValue":1,"VG_DiscountRuleType":0,"DS_Value":1,"RS_CMoney":1,"RS_Value":1,"VS_CMoney":1,"VS_Value":1,"US_Name":"积分达到","Settings":[{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":null,"GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","US_Code":"IntegerFulfil","US_Value":10000,"VG_Name":"至尊","VG_Code":"1","VG_CardAmount":10000,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":1,"VG_IsTimeNum":null,"VG_IsTimeUnit":null,"VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":60,"VG_DiscountRuleType":0,"DS_Value":60,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":null,"GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","US_Code":"IntegerFulfil","US_Value":10101,"VG_Name":"会员等级编辑确认","VG_Code":"4654","VG_CardAmount":10,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":0,"VG_IsIntegral":0,"VG_IsDiscount":0,"VG_IsCount":0,"VG_IsTime":1,"VG_IsTimeNum":1,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":0,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":0,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":1,"GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","US_Code":"IntegerFulfil","US_Value":100100,"VG_Name":"显示等级","VG_Code":"","VG_CardAmount":0,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":1,"VG_IsTimeNum":1,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":100,"VG_DiscountRuleType":0,"DS_Value":100,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":null,"GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","US_Code":"IntegerFulfil","US_Value":1534648,"VG_Name":"商品折扣50一元一分","VG_Code":"","VG_CardAmount":0,"VG_InitialAmount":10,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":0,"VG_IsTimeNum":null,"VG_IsTimeUnit":null,"VG_Remark":"","VG_IntegralUniformRuleValue":1,"VG_IntegralRuleType":0,"VG_DiscountUniformRuleValue":50,"VG_DiscountRuleType":0,"DS_Value":100,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]}],"Emplist":[{"GID":"0f87e1fc-d8a0-4681-88e6-64bf08b0b15a","SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":null,"DM_GID":"473c9d88-d53c-40d5-9896-e9df345cb585","EM_Code":"335","EM_Name":"C位狙击吃鸡手","EM_Sex":0,"EM_Phone":"","EM_Addr":"","EM_Remark":"","EM_UpdateTime":"2018-08-29 16:44:38","EM_Creator":"销售001","EM_Birthday":null,"SM_Name":"jll2","DM_Name":"吃鸡小分队","EM_TipCard":1,"EM_TipRecharge":0,"EM_TipChargeTime":0,"EM_TipGoodsConsume":0,"EM_TipFastConsume":0,"EM_TipTimesConsume":0,"EM_TipComboConsume":1,"EM_TipTimingConsume":0,"EM_TipHouseConsume":0},{"GID":"264cc97a-5757-44d5-9152-90499daefe9b","SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":null,"DM_GID":"506400d2-dd4c-45a3-8c8e-ab964a8c3cf6","EM_Code":"646","EM_Name":"营销全部","EM_Sex":0,"EM_Phone":"","EM_Addr":"","EM_Remark":"","EM_UpdateTime":"2018-08-29 16:33:55","EM_Creator":"销售001","EM_Birthday":null,"SM_Name":"jll2","DM_Name":"营销","EM_TipCard":1,"EM_TipRecharge":1,"EM_TipChargeTime":1,"EM_TipGoodsConsume":1,"EM_TipFastConsume":1,"EM_TipTimesConsume":1,"EM_TipComboConsume":1,"EM_TipTimingConsume":0,"EM_TipHouseConsume":0},{"GID":"358985a7-d1af-4cd9-b123-4c95bf7d9f8e","SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":null,"DM_GID":"142ec34a-2451-4af4-bd84-aebd2c6ce713","EM_Code":"56464654","EM_Name":"售卡","EM_Sex":0,"EM_Phone":"","EM_Addr":"","EM_Remark":"","EM_UpdateTime":"2018-08-29 16:30:39","EM_Creator":"1058346971@qq.com","EM_Birthday":null,"SM_Name":"jll2","DM_Name":"销售","EM_TipCard":1,"EM_TipRecharge":0,"EM_TipChargeTime":0,"EM_TipGoodsConsume":0,"EM_TipFastConsume":0,"EM_TipTimesConsume":0,"EM_TipComboConsume":0,"EM_TipTimingConsume":0,"EM_TipHouseConsume":0},{"GID":"3859a1da-2ad3-4ad7-905d-26c55b3e21c8","SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":null,"DM_GID":"142ec34a-2451-4af4-bd84-aebd2c6ce713","EM_Code":"001","EM_Name":"售卡、充值","EM_Sex":0,"EM_Phone":"","EM_Addr":"","EM_Remark":"","EM_UpdateTime":"2018-08-29 16:31:15","EM_Creator":"1058346971@qq.com","EM_Birthday":null,"SM_Name":"jll2","DM_Name":"销售","EM_TipCard":1,"EM_TipRecharge":1,"EM_TipChargeTime":0,"EM_TipGoodsConsume":0,"EM_TipFastConsume":0,"EM_TipTimesConsume":0,"EM_TipComboConsume":0,"EM_TipTimingConsume":0,"EM_TipHouseConsume":0},{"GID":"7fdcc265-4e24-470a-89a2-8370c32688d0","SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":null,"DM_GID":"142ec34a-2451-4af4-bd84-aebd2c6ce713","EM_Code":"5465","EM_Name":"充值、充次","EM_Sex":0,"EM_Phone":"","EM_Addr":"","EM_Remark":"","EM_UpdateTime":"2018-08-29 16:31:35","EM_Creator":"1058346971@qq.com","EM_Birthday":null,"SM_Name":"jll2","DM_Name":"销售","EM_TipCard":0,"EM_TipRecharge":1,"EM_TipChargeTime":1,"EM_TipGoodsConsume":0,"EM_TipFastConsume":0,"EM_TipTimesConsume":0,"EM_TipComboConsume":0,"EM_TipTimingConsume":0,"EM_TipHouseConsume":0},{"GID":"ae2f5e62-aec7-4ec2-9d37-1a60259fa980","SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":null,"DM_GID":"142ec34a-2451-4af4-bd84-aebd2c6ce713","EM_Code":"65","EM_Name":"商品、快速消费","EM_Sex":1,"EM_Phone":"","EM_Addr":"","EM_Remark":"","EM_UpdateTime":"2018-08-29 16:32:06","EM_Creator":"1058346971@qq.com","EM_Birthday":null,"SM_Name":"jll2","DM_Name":"销售","EM_TipCard":0,"EM_TipRecharge":0,"EM_TipChargeTime":0,"EM_TipGoodsConsume":1,"EM_TipFastConsume":1,"EM_TipTimesConsume":0,"EM_TipComboConsume":0,"EM_TipTimingConsume":0,"EM_TipHouseConsume":0},{"GID":"d2d840fd-d5a3-4c03-91cd-f6136e8e47f0","SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":null,"DM_GID":"142ec34a-2451-4af4-bd84-aebd2c6ce713","EM_Code":"5","EM_Name":"全部","EM_Sex":1,"EM_Phone":"","EM_Addr":"","EM_Remark":"","EM_UpdateTime":"2018-08-29 16:32:40","EM_Creator":"1058346971@qq.com","EM_Birthday":null,"SM_Name":"jll2","DM_Name":"销售","EM_TipCard":1,"EM_TipRecharge":1,"EM_TipChargeTime":1,"EM_TipGoodsConsume":1,"EM_TipFastConsume":1,"EM_TipTimesConsume":1,"EM_TipComboConsume":1,"EM_TipTimingConsume":0,"EM_TipHouseConsume":0}],"DepartmentList":[{"GID":"506400d2-dd4c-45a3-8c8e-ab964a8c3cf6","CY_GID":null,"DM_Name":"营销","DM_Remark":"","DM_UpdateTime":"2018-06-29 16:07:23","DM_Creator":"1058346971@qq.com"},{"GID":"142ec34a-2451-4af4-bd84-aebd2c6ce713","CY_GID":null,"DM_Name":"销售","DM_Remark":"","DM_UpdateTime":"2018-06-29 16:07:43","DM_Creator":"1058346971@qq.com"},{"GID":"473c9d88-d53c-40d5-9896-e9df345cb585","CY_GID":null,"DM_Name":"吃鸡小分队","DM_Remark":"","DM_UpdateTime":"2018-08-29 16:43:50","DM_Creator":"销售001"}],"ShopList":[{"SM_DefaultCode":null,"GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SM_Name":"jll2","SM_Contacter":"6545646","SM_Phone":"18328578333","SM_Addr":"","SM_Remark":"","SM_State":0,"SM_UpdateTime":"2019-01-22 11:12:08","SM_Picture":"/img/head.png","SM_Creator":"1058346971@qq.com","SM_XLong":null,"SM_YLat":null,"SM_Industry":"汽车美容","SM_Range":"","SM_Country":null,"SM_Province":"四川省","SM_Disctrict":"龙泉驿区","SM_DetailAddr":"","SM_MapAddr":null,"SM_UpdateState":1,"SM_AcountNum":10,"SM_Type":15,"SM_EndTime":"2023-11-19 13:55:18","SM_CreateTime":"2018-06-29 15:45:53","SM_City":"中国","VipNumber":0,"ProNumber":0,"SM_IndustryType":100,"SaoBei_State":0,"SaoBei_Message":null}],"DeductRule":[{"SS_CouponPayValue":0,"SS_CouponPayUnit":"%","SS_GoodOrCombo":0,"SS_GoodTypeGID":"000000","SS_GoodTypeName":"所有分类","GID":"e88178a3-42dc-43e3-8ed9-1a80c389729a","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SS_Type":10,"SS_ProductGID":"000000","SS_ProductName":"所有产品","SS_GradeGID":"000002","SS_GradeName":"会员","SS_ShopGID":"000000","SS_ShopName":"所有店铺","SS_DepartmentGID":"000000","SS_DepartmentName":"所有部门","SS_Mode":10,"SS_Value":10,"SS_Unit":"%","SS_BalancePayValue":0,"SS_BalancePayUnit":"%","SS_PointPayValue":0,"SS_PointPayUnit":"%","SS_OtherPayValue":0,"SS_OtherPayUnit":"%","SS_Remark":"","SS_UpdateTime":"2018-06-29 16:03:35"},{"SS_CouponPayValue":0,"SS_CouponPayUnit":"%","SS_GoodOrCombo":0,"SS_GoodTypeGID":"000000","SS_GoodTypeName":"所有分类","GID":"2a3d1a38-acfe-49fe-99a8-7f932f5b0e09","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SS_Type":20,"SS_ProductGID":"000000","SS_ProductName":"所有产品","SS_GradeGID":"000000","SS_GradeName":"全部","SS_ShopGID":"000000","SS_ShopName":"所有店铺","SS_DepartmentGID":"000000","SS_DepartmentName":"所有部门","SS_Mode":10,"SS_Value":10,"SS_Unit":"%","SS_BalancePayValue":0,"SS_BalancePayUnit":"%","SS_PointPayValue":0,"SS_PointPayUnit":"%","SS_OtherPayValue":0,"SS_OtherPayUnit":"%","SS_Remark":"","SS_UpdateTime":"2018-06-29 16:04:29"},{"SS_CouponPayValue":0,"SS_CouponPayUnit":"%","SS_GoodOrCombo":0,"SS_GoodTypeGID":"000000","SS_GoodTypeName":"所有分类","GID":"323caefb-f1bd-49a7-92b6-a8e84150ccb6","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SS_Type":30,"SS_ProductGID":"000000","SS_ProductName":"所有产品","SS_GradeGID":"000000","SS_GradeName":"全部","SS_ShopGID":"000000","SS_ShopName":"所有店铺","SS_DepartmentGID":"000000","SS_DepartmentName":"所有部门","SS_Mode":20,"SS_Value":10,"SS_Unit":"%","SS_BalancePayValue":0,"SS_BalancePayUnit":"%","SS_PointPayValue":0,"SS_PointPayUnit":"%","SS_OtherPayValue":0,"SS_OtherPayUnit":"%","SS_Remark":"","SS_UpdateTime":"2018-06-29 16:04:57"},{"SS_CouponPayValue":10,"SS_CouponPayUnit":"%","SS_GoodOrCombo":0,"SS_GoodTypeGID":"000000","SS_GoodTypeName":"所有分类","GID":"d4bd207d-ed86-445c-8c2f-400e81f2d58a","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SS_Type":40,"SS_ProductGID":"000000","SS_ProductName":"所有产品","SS_GradeGID":"000000","SS_GradeName":"全部","SS_ShopGID":"000000","SS_ShopName":"所有店铺","SS_DepartmentGID":"000000","SS_DepartmentName":"所有部门","SS_Mode":10,"SS_Value":0,"SS_Unit":"%","SS_BalancePayValue":10,"SS_BalancePayUnit":"%","SS_PointPayValue":10,"SS_PointPayUnit":"%","SS_OtherPayValue":10,"SS_OtherPayUnit":"%","SS_Remark":"","SS_UpdateTime":"2018-06-29 16:05:19"},{"SS_CouponPayValue":0,"SS_CouponPayUnit":"%","SS_GoodOrCombo":0,"SS_GoodTypeGID":"000000","SS_GoodTypeName":"所有分类","GID":"57a2d957-123a-4940-8dbb-2d7eb792aed9","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SS_Type":50,"SS_ProductGID":"000000","SS_ProductName":"所有产品","SS_GradeGID":"000000","SS_GradeName":"全部","SS_ShopGID":"000000","SS_ShopName":"所有店铺","SS_DepartmentGID":"000000","SS_DepartmentName":"所有部门","SS_Mode":20,"SS_Value":10,"SS_Unit":"%","SS_BalancePayValue":0,"SS_BalancePayUnit":"%","SS_PointPayValue":0,"SS_PointPayUnit":"%","SS_OtherPayValue":0,"SS_OtherPayUnit":"%","SS_Remark":"","SS_UpdateTime":"2018-06-29 16:05:33"},{"SS_CouponPayValue":0,"SS_CouponPayUnit":"%","SS_GoodOrCombo":0,"SS_GoodTypeGID":"000000","SS_GoodTypeName":"所有分类","GID":"4086cb49-5ab5-473f-9d5b-00973e6cd5db","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SS_Type":60,"SS_ProductGID":"000000","SS_ProductName":"所有产品","SS_GradeGID":"000000","SS_GradeName":"全部","SS_ShopGID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SS_ShopName":"默认店铺","SS_DepartmentGID":"000000","SS_DepartmentName":"所有部门","SS_Mode":10,"SS_Value":10,"SS_Unit":"元","SS_BalancePayValue":0,"SS_BalancePayUnit":"%","SS_PointPayValue":0,"SS_PointPayUnit":"%","SS_OtherPayValue":0,"SS_OtherPayUnit":"%","SS_Remark":"","SS_UpdateTime":"2018-06-29 16:05:43"},{"SS_CouponPayValue":0,"SS_CouponPayUnit":"%","SS_GoodOrCombo":0,"SS_GoodTypeGID":"000000","SS_GoodTypeName":"所有分类","GID":"c2c2be54-7bee-4fd1-b904-416994f929c7","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SS_Type":70,"SS_ProductGID":"000000","SS_ProductName":"所有产品","SS_GradeGID":"000000","SS_GradeName":"全部","SS_ShopGID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SS_ShopName":"默认店铺","SS_DepartmentGID":"000000","SS_DepartmentName":"所有部门","SS_Mode":20,"SS_Value":10,"SS_Unit":"%","SS_BalancePayValue":0,"SS_BalancePayUnit":"%","SS_PointPayValue":0,"SS_PointPayUnit":"%","SS_OtherPayValue":0,"SS_OtherPayUnit":"%","SS_Remark":"","SS_UpdateTime":"2018-06-29 16:05:50"}],"Active":[{"RP_Discount":9.99,"RP_IsOpen":1,"GID":"b852626a-002f-4cdc-a3fb-f7d56a9848fe","RP_Name":"3213","RP_Type":2,"RP_RechargeMoney":3211,"RP_GiveMoney":-1,"RP_GivePoint":10,"RP_ReduceMoney":-1,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"销售001","RP_CreateTime":"2018-11-16 10:36:59","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":7,"RP_IsOpen":1,"GID":"af32c42c-560f-4f35-a701-39673b7a4567","RP_Name":"7折","RP_Type":2,"RP_RechargeMoney":0,"RP_GiveMoney":-1,"RP_GivePoint":1,"RP_ReduceMoney":-1,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"销售001","RP_CreateTime":"2018-08-27 17:51:49","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":1,"RP_IsOpen":1,"GID":"28d7609b-452c-4793-92b1-0d7c21b9f909","RP_Name":"满10块打1折送10分","RP_Type":2,"RP_RechargeMoney":10,"RP_GiveMoney":-1,"RP_GivePoint":10,"RP_ReduceMoney":-1,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"销售001","RP_CreateTime":"2018-08-21 14:02:04","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"8bdf5f13-a60f-4711-8b7f-fbf5a29c28b8","RP_Name":"充10000送10000","RP_Type":1,"RP_RechargeMoney":10000,"RP_GiveMoney":10000,"RP_GivePoint":10000,"RP_ReduceMoney":0,"RP_ValidType":0,"RP_ValidWeekMonth":"1, 2, 3, 4, 5, 6, 7, 17, 18, 19, 20, 21, 25, 26, 27, 28","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"销售001","RP_CreateTime":"2018-08-02 17:08:34","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"880844b4-2c30-4827-9f80-3e577e9c2a5d","RP_Name":"满20送10积分","RP_Type":2,"RP_RechargeMoney":20,"RP_GiveMoney":0,"RP_GivePoint":10,"RP_ReduceMoney":0,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":1,"RP_Creator":"1058346971@qq.com","RP_CreateTime":"2018-07-05 15:26:29","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"b887e8f6-826a-4f0c-a975-aa8b19ce9611","RP_Name":"冲50送10送50积分","RP_Type":1,"RP_RechargeMoney":50,"RP_GiveMoney":10,"RP_GivePoint":50,"RP_ReduceMoney":0,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"1058346971@qq.com","RP_CreateTime":"2018-06-29 16:01:50","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"758ebaed-8557-406d-a5bc-e46463a98a66","RP_Name":"冲100送30","RP_Type":1,"RP_RechargeMoney":100,"RP_GiveMoney":30,"RP_GivePoint":0,"RP_ReduceMoney":0,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"1058346971@qq.com","RP_CreateTime":"2018-06-29 16:01:38","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"2db0ca14-9990-4bbd-a9ed-3b8abfe5ea2b","RP_Name":"冲100送100","RP_Type":1,"RP_RechargeMoney":100,"RP_GiveMoney":100,"RP_GivePoint":0,"RP_ReduceMoney":0,"RP_ValidType":4,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"1058346971@qq.com","RP_CreateTime":"2018-06-29 16:01:18","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"5f052bb9-7ccd-40a9-bb72-f0986d1adfe7","RP_Name":"满50减50","RP_Type":2,"RP_RechargeMoney":50,"RP_GiveMoney":0,"RP_GivePoint":0,"RP_ReduceMoney":50,"RP_ValidType":4,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"1058346971@qq.com","RP_CreateTime":"2018-06-29 16:00:24","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"ea9e6a22-7a05-499b-a3cf-a43b7bbc91c4","RP_Name":"满99送99积分","RP_Type":2,"RP_RechargeMoney":99,"RP_GiveMoney":0,"RP_GivePoint":99,"RP_ReduceMoney":0,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"1058346971@qq.com","RP_CreateTime":"2018-06-29 16:00:14","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"f9a3d250-9ac0-49ec-94bf-0033a762b1bb","RP_Name":"满59减10","RP_Type":2,"RP_RechargeMoney":59,"RP_GiveMoney":0,"RP_GivePoint":50,"RP_ReduceMoney":10,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"1058346971@qq.com","RP_CreateTime":"2018-06-29 15:59:31","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"48e661f8-8ce9-479d-b3b1-f8567a41e394","RP_Name":"满29减4","RP_Type":2,"RP_RechargeMoney":29,"RP_GiveMoney":0,"RP_GivePoint":0,"RP_ReduceMoney":4,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"1058346971@qq.com","RP_CreateTime":"2018-06-29 15:59:08","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null}],"MberList":null,"GoodsList":null,"Smssign":{"GID":"28c31384-47bf-48d0-8295-502b5326716f","SM_Name":"85785","SM_State":1,"SM_Remark":null,"SM_Creator":"1058346971@qq.com","SM_Update":"分号1","SM_CreatorTime":"2018-06-29 15:46:03","SM_UpdateTime":"2019-03-20 11:03:44","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823"},"PrintSet":{"PS_GID":"7308e3ca-6111-4989-be07-d447430857e4","PS_CYGID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","PS_SMGID":"4a7b1141-8ca3-4bef-961f-ffd153357823","PS_IsEnabled":1,"PS_IsPreview":0,"PS_PaperType":2,"PS_PrintTimes":"[{\"PT_Code\":\"FTXF\",\"PT_Times\":1},{\"PT_Code\":\"KSXF\",\"PT_Times\":1},{\"PT_Code\":\"HYCZ\",\"PT_Times\":1},{\"PT_Code\":\"JSXF\",\"PT_Times\":1},{\"PT_Code\":\"HYDJ\",\"PT_Times\":1},{\"PT_Code\":\"JFDH\",\"PT_Times\":1},{\"PT_Code\":\"SPXF\",\"PT_Times\":1},{\"PT_Code\":\"HYCC\",\"PT_Times\":1},{\"PT_Code\":\"JB\",\"PT_Times\":1},{\"PT_Code\":\"HYKK\",\"PT_Times\":1},{\"PT_Code\":\"JCXF\",\"PT_Times\":1},{\"PT_Code\":\"SPTH\",\"PT_Times\":1}]","PS_PrinterName":"XP-58","PS_StylusPrintingName":"","PS_IsMultiEnabled":null,"PS_MultiPaperType":null,"PS_MultiPrintTimes":null,"PrintTimesList":[{"PT_Code":"FTXF","PT_Times":1},{"PT_Code":"KSXF","PT_Times":1},{"PT_Code":"HYCZ","PT_Times":1},{"PT_Code":"JSXF","PT_Times":1},{"PT_Code":"HYDJ","PT_Times":1},{"PT_Code":"JFDH","PT_Times":1},{"PT_Code":"SPXF","PT_Times":1},{"PT_Code":"HYCC","PT_Times":1},{"PT_Code":"JB","PT_Times":1},{"PT_Code":"HYKK","PT_Times":1},{"PT_Code":"JCXF","PT_Times":1},{"PT_Code":"SPTH","PT_Times":1}],"MultiPrintTimesList":null}}
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

    public static class DataBean {
        /**
         * GetCustomFieldsVIP : [{"CF_GID":"34f6c04b-e516-42f5-902a-f7b31f9bcf7a","CF_FieldName":"办卡日期","CF_FieldType":"日期","CF_ItemsValue":"","CF_Value":"","CF_Required":"是","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","VIP_GID":"1","CF_CreateUser":"销售001","CF_CreateTime":"2018-10-29 15:40:27","CF_Order":5,"CF_IsShowVIP":1},{"CF_GID":"e6c3df23-8580-4cfd-9e42-98f916db9f94","CF_FieldName":"潜","CF_FieldType":"文本","CF_ItemsValue":"","CF_Value":"","CF_Required":"是","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","VIP_GID":"1","CF_CreateUser":"销售001","CF_CreateTime":"2018-11-07 10:05:03","CF_Order":6,"CF_IsShowVIP":1}]
         * GetCustomFields : [{"CF_Order":3,"CF_GID":"d024aa5c-63ef-4ca3-b316-0cad2dc3965b","CF_FieldName":"备注","CF_FieldType":"文本","CF_ItemsValue":"","CF_Value":"","CF_Required":"是","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","VIP_GID":"","PM_GID":"1","CF_CreateUser":"销售001","CF_CreateTime":"2018-10-30 09:24:01"}]
         * GetLoginHistoryList : [{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-30 14:20:57","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-30 14:20:34","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-30 12:01:15","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-30 11:39:16","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.132.254","LM_Area":"未能解析IP:124.14.132.254","LM_Time":"2019-03-30 11:35:02","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.132.254","LM_Area":"未能解析IP:124.14.132.254","LM_Time":"2019-03-29 20:49:21","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.132.254","LM_Area":"未能解析IP:124.14.132.254","LM_Time":"2019-03-29 20:36:57","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.132.254","LM_Area":"未能解析IP:124.14.132.254","LM_Time":"2019-03-29 16:04:47","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-28 16:58:37","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-28 16:58:15","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-28 16:11:45","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-28 15:58:40","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-28 15:49:04","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-28 10:37:13","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-28 10:36:44","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-28 09:49:19","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-28 09:43:20","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.70.29","LM_Area":"未能解析IP:171.216.70.29","LM_Time":"2019-03-28 09:39:28","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"223.104.215.245","LM_Area":"未能解析IP:223.104.215.245","LM_Time":"2019-03-27 11:18:23","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"182.148.200.63","LM_Area":"未能解析IP:182.148.200.63","LM_Time":"2019-03-27 08:09:58","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 17:46:12","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-26 17:27:15","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 15:07:59","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 14:57:03","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-26 14:54:23","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 11:11:50","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 11:00:36","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 10:59:03","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 10:46:51","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 10:43:50","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 10:41:01","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-26 10:13:16","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-26 09:43:55","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 17:17:29","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:48:46","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:45:18","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:43:22","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:29:43","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:24:22","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:20:08","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:16:55","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:11:04","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 15:08:49","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-25 12:01:49","LM_Type":"安卓APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-22 17:59:54","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-22 17:57:53","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-22 17:51:44","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-22 17:45:14","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"124.14.142.129","LM_Area":"未能解析IP:124.14.142.129","LM_Time":"2019-03-22 17:39:02","LM_Type":"苹果APP"},{"GID":null,"CY_GID":null,"SM_GID":null,"LM_Account":"18328578333","LM_IP":"171.216.69.188","LM_Area":"未能解析IP:171.216.69.188","LM_Time":"2019-03-22 17:32:57","LM_Type":"苹果APP"}]
         * GetSysSwitchList : [{"SS_Value":null,"GID":"4f3aefbe-172e-4839-b81e-3ace7da00007","SS_Name":"会员卡号同手机号","SS_Code":"201","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":1},{"SS_Value":null,"GID":"80253331-6990-4ae2-9d35-85aa3a685e15","SS_Name":"添加会员","SS_Code":"001","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:49","CY_GID":null,"SS_Sort":1},{"SS_Value":null,"GID":"ebd1df1e-d674-412c-b426-936ac3a92527","SS_Name":"现金支付","SS_Code":"101","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":1},{"SS_Value":null,"GID":"24773a53-0254-4bc1-9210-1874868ce252","SS_Name":"手机号可重复","SS_Code":"213","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-11-20 12:05:06","CY_GID":null,"SS_Sort":2},{"SS_Value":null,"GID":"b3972e71-cce4-472f-b2eb-1f92b372034d","SS_Name":"会员充值","SS_Code":"002","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:49","CY_GID":null,"SS_Sort":2},{"SS_Value":null,"GID":"c3003fac-f894-4fce-9614-69a0c2653abb","SS_Name":"余额支付","SS_Code":"102","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":2},{"SS_Value":null,"GID":"e6db7829-665b-46ea-8f4b-ea1acab74101","SS_Name":"初始金额和初始积分","SS_Code":"203","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":2},{"SS_Value":null,"GID":"5edf13ec-20c6-4aa8-917f-455098360008","SS_Name":"微信记账","SS_Code":"105","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":3},{"SS_Value":null,"GID":"a9e0855f-18d5-475b-a9af-62e7d4849c92","SS_Name":"会员卡卡面卡号","SS_Code":"208","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":3},{"SS_Value":null,"GID":"dc13679f-6df5-4800-9573-e29bd841dae6","SS_Name":"会员充次","SS_Code":"003","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:49","CY_GID":null,"SS_Sort":3},{"SS_Value":null,"GID":"4279b4a7-98c0-4a42-a0d8-c7e96fa23ad7","SS_Name":"会员查询弹窗","SS_Code":"209","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":4},{"SS_Value":null,"GID":"601696e4-aca4-46e5-87f6-5f3d7f84353e","SS_Name":"会员升级","SS_Code":"004","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:49","CY_GID":null,"SS_Sort":4},{"SS_Value":null,"GID":"c21488f7-c1cf-423d-a541-ca89d3873024","SS_Name":"支付宝记账","SS_Code":"106","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":4},{"SS_Value":null,"GID":"2e35a983-712f-40d8-9972-11dcad4443e6","SS_Name":"会员降级","SS_Code":"005","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":5},{"SS_Value":null,"GID":"957f6691-98b5-4309-80cb-e7e2d2cb692d","SS_Name":"是否显示它店会员","SS_Code":"210","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":5},{"SS_Value":null,"GID":"b3ca03da-9189-4d6a-820c-1f24587d43ef","SS_Name":"银联支付","SS_Code":"103","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":5},{"SS_Value":null,"GID":"169d2551-a906-497d-b48d-c1e1da64fe8b","SS_Name":"积分清零","SS_Code":"006","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":6},{"SS_Value":null,"GID":"58193ebf-29a2-42ee-9c32-773363e2d40c","SS_Name":"优惠券","SS_Code":"110","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":6},{"SS_Value":null,"GID":"84d75a71-2974-4b9e-ae36-be529fca5a63","SS_Name":"是否必填手机号","SS_Code":"211","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-06 11:29:14","CY_GID":null,"SS_Sort":6},{"SS_Value":null,"GID":"f66d5b86-25a1-480d-8725-607a4c4e2be7","SS_Name":"员工提成","SS_Code":"301","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":6},{"SS_Value":null,"GID":"441c0bde-c896-4062-bf6b-509e801bd58d","SS_Name":"扫码支付","SS_Code":"111","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":7},{"SS_Value":null,"GID":"cf58b330-5f4d-4e80-85ca-c2b460862ed4","SS_Name":"积分变动","SS_Code":"007","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":7},{"SS_Value":null,"GID":"f2a5ad42-5e71-41e3-bd7e-ec7031571d22","SS_Name":"折后金额修改","SS_Code":"601","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":7},{"SS_Value":null,"GID":"4f2f2774-606a-447a-947f-9e2dcfd8602f","SS_Name":"修改密码","SS_Code":"008","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":8},{"SS_Value":null,"GID":"5991e139-3fc3-413c-a903-cdd40c8241d8","SS_Name":"其他支付","SS_Code":"113","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-20 15:30:53","CY_GID":null,"SS_Sort":8},{"SS_Value":null,"GID":"91195107-8a02-400b-b6ac-9416b5586030","SS_Name":"医保卡支付","SS_Code":"112","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":8},{"SS_Value":null,"GID":"a2914265-a881-4e66-95c0-5a9abe877ec5","SS_Name":"计次消费规则","SS_Code":"212","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-11-20 12:05:06","CY_GID":null,"SS_Sort":8},{"SS_Value":"123456","GID":"d9501b35-00e5-4ed8-8218-c2012f69e3e9","SS_Name":"开卡初始密码","SS_Code":"202","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":8},{"SS_Value":null,"GID":"025763ce-14c5-4c99-b69d-bb027bf3a57d","SS_Name":"消费密码验证","SS_Code":"204","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":9},{"SS_Value":null,"GID":"0fcf5355-1e24-472a-988e-67b612dfadb9","SS_Name":"必须刷卡","SS_Code":"214","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2019-01-16 10:40:59","CY_GID":null,"SS_Sort":9},{"SS_Value":"10","GID":"838ed745-51ea-4300-8153-ff8b30dc0171","SS_Name":"积分支付","SS_Code":"107","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":9},{"SS_Value":null,"GID":"85acdc2d-5e09-488e-8009-d53cf5ac3ebf","SS_Name":"会员挂失","SS_Code":"009","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":9},{"SS_Value":"100","GID":"081a3850-4db5-43df-a362-0ebbd4d34a44","SS_Name":"积分支付限制","SS_Code":"109","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":10},{"SS_Value":null,"GID":"33717552-b3be-4f9b-9ff3-c9dfdf467751","SS_Name":"转账密码验证","SS_Code":"205","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":10},{"SS_Value":null,"GID":"f200acd3-0bc9-44d1-ab38-ab453b29d526","SS_Name":"快速消费","SS_Code":"010","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":10},{"SS_Value":"XJZF","GID":"00cdab7e-c09b-4d93-8192-07dea54afd67","SS_Name":"默认支付","SS_Code":"108","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:09:12","CY_GID":null,"SS_Sort":11},{"SS_Value":null,"GID":"322129b8-6935-41cb-8dda-d42d0ddf28dc","SS_Name":"商品消费","SS_Code":"011","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":11},{"SS_Value":null,"GID":"af20faab-9cdb-4b09-ae92-3667a17054b1","SS_Name":"兑换密码验证","SS_Code":"206","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":11},{"SS_Value":null,"GID":"43df8118-e572-4821-a1d8-6d39bcab15ef","SS_Name":"计次消费","SS_Code":"012","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":12},{"SS_Value":null,"GID":"9cb968c1-02ba-44ae-b4e2-917d9dcb6fb4","SS_Name":"换卡密码验证","SS_Code":"207","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":12},{"SS_Value":"123456","GID":"cb3fb011-2e0d-492b-b00f-1d0eae05ec58","SS_Name":"撤单密码","SS_Code":"215","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2019-01-16 10:40:59","CY_GID":null,"SS_Sort":12},{"SS_Value":"0","GID":"0a7d2549-d251-4b44-a612-81f328f85253","SS_Name":"会员推荐提成","SS_Code":"503","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":13},{"SS_Value":null,"GID":"373854cc-6634-4fec-9df4-bd1f356cff2f","SS_Name":"礼品兑换","SS_Code":"013","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":13},{"SS_Value":null,"GID":"2fcdbd40-45be-4d06-8251-6f2debb1f1e5","SS_Name":"生日提醒","SS_Code":"014","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":14},{"SS_Value":"100","GID":"7e595591-f403-4dcb-801b-8a6f08aac913","SS_Name":"会员消费提成","SS_Code":"501","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":14},{"SS_Value":null,"GID":"84fae984-3ab8-4407-8386-f9525c5dcea6","SS_Name":"到期提醒","SS_Code":"016","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":15},{"SS_Value":"100","GID":"bbf14fee-1701-4954-8544-9dff993d7b4e","SS_Name":"会员获得积分提成","SS_Code":"502","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-06-29 16:11:42","CY_GID":null,"SS_Sort":15},{"SS_Value":null,"GID":"0c7375cd-276f-4eb8-80ba-3d84c6697025","SS_Name":"刷卡登记","SS_Code":"017","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":16},{"SS_Value":null,"GID":"675b54c8-4cbe-447f-866f-0aeb4ff95f5e","SS_Name":"房台消费","SS_Code":"018","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":17},{"SS_Value":null,"GID":"a1f9ed91-4567-4b88-a1e1-4b34fef790c2","SS_Name":"套餐消费","SS_Code":"019","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":18},{"SS_Value":null,"GID":"c34c2cb9-e35d-4b52-9507-2e51923cd3f6","SS_Name":"开启客显","SS_Code":"701","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-11-20 12:05:06","CY_GID":null,"SS_Sort":19},{"SS_Value":null,"GID":"f533fe88-dd39-46bf-90d6-de488894418f","SS_Name":"计时消费","SS_Code":"021","SS_State":1,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-07-09 18:52:50","CY_GID":null,"SS_Sort":19},{"SS_Value":"COM1","GID":"8fd678ff-4328-429b-9233-605495202e18","SS_Name":"通讯端口","SS_Code":"702","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-11-20 12:05:06","CY_GID":null,"SS_Sort":20},{"SS_Value":"2400","GID":"bb174463-3d04-45bb-ae83-19691337f533","SS_Name":"波特率","SS_Code":"703","SS_State":0,"SS_Remark":null,"SS_Update":"1058346971@qq.com","SS_UpdateTime":"2018-11-20 12:05:06","CY_GID":null,"SS_Sort":21}]
         * VIPGradeList : [{"VG_IsDownLock":0,"VG_UpDownType":0,"VG_NextGradeName":"默认等级","VG_NextGradeGID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_LastGradeName":"","VG_LastGradeGID":"","US_ValueMax":9,"VG_IsTimeTimes":1,"GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","US_Code":"IntegerFulfil","US_Value":1,"VG_Name":"等级","VG_Code":"","VG_CardAmount":10,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":1,"VG_IsAccount":0,"VG_IsIntegral":0,"VG_IsDiscount":0,"VG_IsCount":0,"VG_IsTime":1,"VG_IsTimeNum":1,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":0,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":1,"GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","US_Code":"IntegerFulfil","US_Value":0,"VG_Name":"默认等级","VG_Code":"","VG_CardAmount":0,"VG_InitialAmount":10,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":1,"VG_IsTimeNum":1,"VG_IsTimeUnit":"年","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":0,"RS_CMoney":1,"RS_Value":1,"VS_CMoney":1,"VS_Value":1,"US_Name":"积分达到","Settings":[{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","VG_Name":"默认等级","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[{"SR_Timer":null,"SR_TimeUnit":null,"GID":"3d4f5b35-d08a-4ce9-a784-70f654cb552d","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"5fe0bfd4-9d16-42ad-ace9-73650ad95151","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"4545蜂屯蚁附"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"44840b05-4eff-4902-8895-2410e37f4663","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"2efb8c23-0aed-41a2-a8b2-9c2bc0cedd72","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"礼品商品004"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"4d33f095-f243-457c-80eb-758ab855ed99","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"ab05706d-3879-44dd-9893-5df2f326e684","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"服务商品007"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"5f02d2f1-b0ab-436f-8539-637b802819a6","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"f809d722-18b5-4f7f-9ac7-fa0d7ad9a0ff","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"服务商品007"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"7341fb78-b666-429a-a134-f4207bb8b432","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"d97d845e-29be-4379-8da4-a4dfe999e30c","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"精品SPA"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"79f28bf1-866e-493e-9844-7156659fca96","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"d48d17a5-0997-4cf4-a305-52b89a6ade6f","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"服务商品"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"7f3a3abd-9003-43d3-abcb-2586f10a04c2","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"1afe9c05-a4be-4dc7-a868-c66df9be3467","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"撒飒飒"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"8675d521-3f9c-4bac-8be1-3de814a49078","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"7808802b-b91d-4bb0-9a3e-23fb6fef9f4b","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"174563发"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"a1ed4d95-18b7-4435-8a57-a77c78d5ceb2","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"7320ddfe-e4f5-49f5-bf17-83c77436901d","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"服务1840"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"a6d3d530-a617-4ea0-b36d-02b2c111ea34","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"118a4f60-a2b5-4a7e-b47d-6f4d2b801379","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"好11"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"c08ac1b6-9c3f-4ee3-b19e-6a591aeb3b90","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"67c264d0-7001-48b9-8bd6-e0ba65218b07","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"豆浆"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"c1cf3a1c-f4a2-464b-b19f-3a27a8025fca","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"41633c1f-216a-4c34-b211-fbcf3c3f38c9","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"2133"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"c90a585c-d696-4b05-86eb-b85b8499e6f8","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"858f4dd1-cd1a-4b66-b2a0-2b697d2c7c11","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"跑腿吃鸡"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"cd47cbbb-29ca-4f55-933e-3e5adb716e6b","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"378c63e4-2a68-4f90-a2ee-916a95d3fc63","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"SPA"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"d5045555-74fa-4368-96d3-e84c0b421e1a","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"2b641154-14e5-40f1-875e-7fb8a71ecc3d","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"服务商品"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"f40c6f6d-5eed-408c-975c-6aaffa5558b0","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"c084d0b0-f7cf-4621-a5f8-1914512803c7","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"精品理发"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"f4582529-3d8f-435c-a5fd-8b2c6a8eb263","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"7ace77f3-219b-4680-993f-ea1fc5e543bc","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"1010"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"f77ef771-69ae-45de-8dc6-46972b73a6a0","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"aed40e84-f94f-431e-a844-10de63a8d792","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"配吃"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"fca4c30a-48b1-450d-81d9-2ff342bfee92","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"05e16475-eb20-4a4f-9760-c870b9c3f8d4","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"按摩"},{"SR_Timer":null,"SR_TimeUnit":null,"GID":"ff58385c-3c3e-48b4-976f-894efe8cbdea","VG_GID":"45a168cb-493e-43b7-8cfc-730ef4da27c7","SC_GD":"f3755ad8-3dfe-446c-9995-3ba4d1a2548c","SR_Number":1,"SR_UpdateTime":"2019-03-30 14:11:53","SG_Name":"服务商品"}]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":12,"GID":"94f2d09b-d29d-4807-8853-481c8b780781","US_Code":"IntegerFulfil","US_Value":5,"VG_Name":"积分","VG_Code":"","VG_CardAmount":0,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":0,"VG_IsTimeNum":212,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":0,"RS_CMoney":1,"RS_Value":1,"VS_CMoney":1,"VS_Value":1,"US_Name":"积分达到","Settings":[{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"94f2d09b-d29d-4807-8853-481c8b780781","VG_Name":"积分","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":2,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":1,"GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","US_Code":"IntegerFulfil","US_Value":10,"VG_Name":"临时会员1天","VG_Code":"","VG_CardAmount":10,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":0,"VG_IsDiscount":0,"VG_IsCount":1,"VG_IsTime":1,"VG_IsTimeNum":1,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":0,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"0ef0e3ed-c67d-45fc-bb73-4f40dca39e04","VG_Name":"临时会员1天","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":11,"GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","US_Code":null,"US_Value":11,"VG_Name":"等级编辑测试2","VG_Code":"","VG_CardAmount":10,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":0,"VG_IsIntegral":0,"VG_IsDiscount":0,"VG_IsCount":0,"VG_IsTime":1,"VG_IsTimeNum":12,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":100,"VG_DiscountRuleType":1,"DS_Value":100,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":null,"Settings":[{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"c02311a1-c6d3-487f-959e-14bae9c68c53","VG_Name":"等级编辑测试2","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":null,"GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","US_Code":"IntegerFulfil","US_Value":12,"VG_Name":"等级测试","VG_Code":"1","VG_CardAmount":10,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":0,"VG_IsIntegral":0,"VG_IsDiscount":0,"VG_IsCount":0,"VG_IsTime":1,"VG_IsTimeNum":null,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":0,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"efb5e84a-21d8-48cd-aff0-25eefc6db1be","VG_Name":"等级测试","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":null,"GID":"954a0f21-cb44-485a-8b7d-e850f258862a","US_Code":"IntegerFulfil","US_Value":20,"VG_Name":"黄金会员","VG_Code":"","VG_CardAmount":20,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":1,"VG_IsTimeNum":3333,"VG_IsTimeUnit":"年","VG_Remark":"","VG_IntegralUniformRuleValue":1,"VG_IntegralRuleType":0,"VG_DiscountUniformRuleValue":10,"VG_DiscountRuleType":0,"DS_Value":10,"RS_CMoney":1,"RS_Value":1,"VS_CMoney":1,"VS_Value":1,"US_Name":"积分达到","Settings":[{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"954a0f21-cb44-485a-8b7d-e850f258862a","VG_Name":"黄金会员","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":10,"VS_CMoney":1,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":null,"GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","US_Code":"IntegerFulfil","US_Value":50,"VG_Name":"铂金","VG_Code":"","VG_CardAmount":50,"VG_InitialAmount":0,"VG_InitialIntegral":4,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":0,"VG_IsTimeNum":null,"VG_IsTimeUnit":null,"VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":1,"VG_DiscountRuleType":0,"DS_Value":50,"RS_CMoney":1,"RS_Value":1,"VS_CMoney":1,"VS_Value":1,"US_Name":"积分达到","Settings":[{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"70b6bd32-ab60-4a96-9e1c-8a4c5d76c92e","VG_Name":"铂金","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":0,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":1,"GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","US_Code":"IntegerFulfil","US_Value":101,"VG_Name":"会员等级编辑测试6","VG_Code":"6469871365","VG_CardAmount":10,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":0,"VG_IsIntegral":0,"VG_IsDiscount":0,"VG_IsCount":0,"VG_IsTime":1,"VG_IsTimeNum":1,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":0,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":0,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"1b39ad19-08de-4ca0-8b94-6aabed1253b0","VG_Name":"会员等级编辑测试6","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":null,"GID":"9692a1da-d658-4b2e-896b-4cc72825846b","US_Code":"IntegerFulfil","US_Value":200,"VG_Name":"一个月限时卡","VG_Code":"","VG_CardAmount":200,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":0,"VG_IsDiscount":0,"VG_IsCount":0,"VG_IsTime":1,"VG_IsTimeNum":1,"VG_IsTimeUnit":"月","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":0,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"9692a1da-d658-4b2e-896b-4cc72825846b","VG_Name":"一个月限时卡","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":null,"GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","US_Code":"IntegerFulfil","US_Value":500,"VG_Name":"砖石","VG_Code":"","VG_CardAmount":500,"VG_InitialAmount":500,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":0,"VG_IsTimeNum":null,"VG_IsTimeUnit":null,"VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":1,"RS_CMoney":0,"RS_Value":1,"VS_CMoney":1,"VS_Value":1,"US_Name":"积分达到","Settings":[{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":90,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"4ec87dff-43c3-454b-97a2-c0257a2d93a1","VG_Name":"砖石","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":1,"GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","US_Code":"IntegerFulfil","US_Value":1000,"VG_Name":"等级测试001","VG_Code":"545","VG_CardAmount":100,"VG_InitialAmount":100,"VG_InitialIntegral":100,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":1,"VG_IsTimeNum":1111,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":1,"VG_IntegralRuleType":0,"VG_DiscountUniformRuleValue":1,"VG_DiscountRuleType":0,"DS_Value":1,"RS_CMoney":1,"RS_Value":1,"VS_CMoney":1,"VS_Value":1,"US_Name":"积分达到","Settings":[{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"1bf20634-827b-4064-8980-7b2b788fbaf2","VG_Name":"等级测试001","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":1,"VS_CMoney":1,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":null,"GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","US_Code":"IntegerFulfil","US_Value":10000,"VG_Name":"至尊","VG_Code":"1","VG_CardAmount":10000,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":1,"VG_IsTimeNum":null,"VG_IsTimeUnit":null,"VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":60,"VG_DiscountRuleType":0,"DS_Value":60,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":60,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"d0e280b3-c949-42b8-ac95-e9baacb040e8","VG_Name":"至尊","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":null,"GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","US_Code":"IntegerFulfil","US_Value":10101,"VG_Name":"会员等级编辑确认","VG_Code":"4654","VG_CardAmount":10,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":0,"VG_IsIntegral":0,"VG_IsDiscount":0,"VG_IsCount":0,"VG_IsTime":1,"VG_IsTimeNum":1,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":0,"VG_DiscountUniformRuleValue":0,"VG_DiscountRuleType":1,"DS_Value":0,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"07ccd551-d2e1-44a3-9f48-ac13b7fd0b51","VG_Name":"会员等级编辑确认","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":1,"GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","US_Code":"IntegerFulfil","US_Value":100100,"VG_Name":"显示等级","VG_Code":"","VG_CardAmount":0,"VG_InitialAmount":0,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":1,"VG_IsTimeNum":1,"VG_IsTimeUnit":"天","VG_Remark":"","VG_IntegralUniformRuleValue":0,"VG_IntegralRuleType":1,"VG_DiscountUniformRuleValue":100,"VG_DiscountRuleType":0,"DS_Value":100,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"6bbb633e-1817-4e28-adff-bd815e64be7d","VG_Name":"显示等级","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":1,"VS_Number":0,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]},{"VG_IsDownLock":0,"VG_UpDownType":null,"VG_NextGradeName":null,"VG_NextGradeGID":null,"VG_LastGradeName":null,"VG_LastGradeGID":null,"US_ValueMax":null,"VG_IsTimeTimes":null,"GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","US_Code":"IntegerFulfil","US_Value":1534648,"VG_Name":"商品折扣50一元一分","VG_Code":"","VG_CardAmount":0,"VG_InitialAmount":10,"VG_InitialIntegral":0,"VG_IsLock":0,"VG_IsAccount":1,"VG_IsIntegral":1,"VG_IsDiscount":1,"VG_IsCount":1,"VG_IsTime":0,"VG_IsTimeNum":null,"VG_IsTimeUnit":null,"VG_Remark":"","VG_IntegralUniformRuleValue":1,"VG_IntegralRuleType":0,"VG_DiscountUniformRuleValue":50,"VG_DiscountRuleType":0,"DS_Value":100,"RS_CMoney":0,"RS_Value":0,"VS_CMoney":0,"VS_Value":0,"US_Name":"积分达到","Settings":[{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"79a2559c-c2ef-4580-b9a6-bb020e008841","VG_Name":"商品折扣50一元一分","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":50,"VS_CMoney":1,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}],"InitServiceList":[]}]
         * Emplist : [{"GID":"0f87e1fc-d8a0-4681-88e6-64bf08b0b15a","SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":null,"DM_GID":"473c9d88-d53c-40d5-9896-e9df345cb585","EM_Code":"335","EM_Name":"C位狙击吃鸡手","EM_Sex":0,"EM_Phone":"","EM_Addr":"","EM_Remark":"","EM_UpdateTime":"2018-08-29 16:44:38","EM_Creator":"销售001","EM_Birthday":null,"SM_Name":"jll2","DM_Name":"吃鸡小分队","EM_TipCard":1,"EM_TipRecharge":0,"EM_TipChargeTime":0,"EM_TipGoodsConsume":0,"EM_TipFastConsume":0,"EM_TipTimesConsume":0,"EM_TipComboConsume":1,"EM_TipTimingConsume":0,"EM_TipHouseConsume":0},{"GID":"264cc97a-5757-44d5-9152-90499daefe9b","SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":null,"DM_GID":"506400d2-dd4c-45a3-8c8e-ab964a8c3cf6","EM_Code":"646","EM_Name":"营销全部","EM_Sex":0,"EM_Phone":"","EM_Addr":"","EM_Remark":"","EM_UpdateTime":"2018-08-29 16:33:55","EM_Creator":"销售001","EM_Birthday":null,"SM_Name":"jll2","DM_Name":"营销","EM_TipCard":1,"EM_TipRecharge":1,"EM_TipChargeTime":1,"EM_TipGoodsConsume":1,"EM_TipFastConsume":1,"EM_TipTimesConsume":1,"EM_TipComboConsume":1,"EM_TipTimingConsume":0,"EM_TipHouseConsume":0},{"GID":"358985a7-d1af-4cd9-b123-4c95bf7d9f8e","SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":null,"DM_GID":"142ec34a-2451-4af4-bd84-aebd2c6ce713","EM_Code":"56464654","EM_Name":"售卡","EM_Sex":0,"EM_Phone":"","EM_Addr":"","EM_Remark":"","EM_UpdateTime":"2018-08-29 16:30:39","EM_Creator":"1058346971@qq.com","EM_Birthday":null,"SM_Name":"jll2","DM_Name":"销售","EM_TipCard":1,"EM_TipRecharge":0,"EM_TipChargeTime":0,"EM_TipGoodsConsume":0,"EM_TipFastConsume":0,"EM_TipTimesConsume":0,"EM_TipComboConsume":0,"EM_TipTimingConsume":0,"EM_TipHouseConsume":0},{"GID":"3859a1da-2ad3-4ad7-905d-26c55b3e21c8","SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":null,"DM_GID":"142ec34a-2451-4af4-bd84-aebd2c6ce713","EM_Code":"001","EM_Name":"售卡、充值","EM_Sex":0,"EM_Phone":"","EM_Addr":"","EM_Remark":"","EM_UpdateTime":"2018-08-29 16:31:15","EM_Creator":"1058346971@qq.com","EM_Birthday":null,"SM_Name":"jll2","DM_Name":"销售","EM_TipCard":1,"EM_TipRecharge":1,"EM_TipChargeTime":0,"EM_TipGoodsConsume":0,"EM_TipFastConsume":0,"EM_TipTimesConsume":0,"EM_TipComboConsume":0,"EM_TipTimingConsume":0,"EM_TipHouseConsume":0},{"GID":"7fdcc265-4e24-470a-89a2-8370c32688d0","SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":null,"DM_GID":"142ec34a-2451-4af4-bd84-aebd2c6ce713","EM_Code":"5465","EM_Name":"充值、充次","EM_Sex":0,"EM_Phone":"","EM_Addr":"","EM_Remark":"","EM_UpdateTime":"2018-08-29 16:31:35","EM_Creator":"1058346971@qq.com","EM_Birthday":null,"SM_Name":"jll2","DM_Name":"销售","EM_TipCard":0,"EM_TipRecharge":1,"EM_TipChargeTime":1,"EM_TipGoodsConsume":0,"EM_TipFastConsume":0,"EM_TipTimesConsume":0,"EM_TipComboConsume":0,"EM_TipTimingConsume":0,"EM_TipHouseConsume":0},{"GID":"ae2f5e62-aec7-4ec2-9d37-1a60259fa980","SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":null,"DM_GID":"142ec34a-2451-4af4-bd84-aebd2c6ce713","EM_Code":"65","EM_Name":"商品、快速消费","EM_Sex":1,"EM_Phone":"","EM_Addr":"","EM_Remark":"","EM_UpdateTime":"2018-08-29 16:32:06","EM_Creator":"1058346971@qq.com","EM_Birthday":null,"SM_Name":"jll2","DM_Name":"销售","EM_TipCard":0,"EM_TipRecharge":0,"EM_TipChargeTime":0,"EM_TipGoodsConsume":1,"EM_TipFastConsume":1,"EM_TipTimesConsume":0,"EM_TipComboConsume":0,"EM_TipTimingConsume":0,"EM_TipHouseConsume":0},{"GID":"d2d840fd-d5a3-4c03-91cd-f6136e8e47f0","SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":null,"DM_GID":"142ec34a-2451-4af4-bd84-aebd2c6ce713","EM_Code":"5","EM_Name":"全部","EM_Sex":1,"EM_Phone":"","EM_Addr":"","EM_Remark":"","EM_UpdateTime":"2018-08-29 16:32:40","EM_Creator":"1058346971@qq.com","EM_Birthday":null,"SM_Name":"jll2","DM_Name":"销售","EM_TipCard":1,"EM_TipRecharge":1,"EM_TipChargeTime":1,"EM_TipGoodsConsume":1,"EM_TipFastConsume":1,"EM_TipTimesConsume":1,"EM_TipComboConsume":1,"EM_TipTimingConsume":0,"EM_TipHouseConsume":0}]
         * DepartmentList : [{"GID":"506400d2-dd4c-45a3-8c8e-ab964a8c3cf6","CY_GID":null,"DM_Name":"营销","DM_Remark":"","DM_UpdateTime":"2018-06-29 16:07:23","DM_Creator":"1058346971@qq.com"},{"GID":"142ec34a-2451-4af4-bd84-aebd2c6ce713","CY_GID":null,"DM_Name":"销售","DM_Remark":"","DM_UpdateTime":"2018-06-29 16:07:43","DM_Creator":"1058346971@qq.com"},{"GID":"473c9d88-d53c-40d5-9896-e9df345cb585","CY_GID":null,"DM_Name":"吃鸡小分队","DM_Remark":"","DM_UpdateTime":"2018-08-29 16:43:50","DM_Creator":"销售001"}]
         * ShopList : [{"SM_DefaultCode":null,"GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SM_Name":"jll2","SM_Contacter":"6545646","SM_Phone":"18328578333","SM_Addr":"","SM_Remark":"","SM_State":0,"SM_UpdateTime":"2019-01-22 11:12:08","SM_Picture":"/img/head.png","SM_Creator":"1058346971@qq.com","SM_XLong":null,"SM_YLat":null,"SM_Industry":"汽车美容","SM_Range":"","SM_Country":null,"SM_Province":"四川省","SM_Disctrict":"龙泉驿区","SM_DetailAddr":"","SM_MapAddr":null,"SM_UpdateState":1,"SM_AcountNum":10,"SM_Type":15,"SM_EndTime":"2023-11-19 13:55:18","SM_CreateTime":"2018-06-29 15:45:53","SM_City":"中国","VipNumber":0,"ProNumber":0,"SM_IndustryType":100,"SaoBei_State":0,"SaoBei_Message":null}]
         * DeductRule : [{"SS_CouponPayValue":0,"SS_CouponPayUnit":"%","SS_GoodOrCombo":0,"SS_GoodTypeGID":"000000","SS_GoodTypeName":"所有分类","GID":"e88178a3-42dc-43e3-8ed9-1a80c389729a","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SS_Type":10,"SS_ProductGID":"000000","SS_ProductName":"所有产品","SS_GradeGID":"000002","SS_GradeName":"会员","SS_ShopGID":"000000","SS_ShopName":"所有店铺","SS_DepartmentGID":"000000","SS_DepartmentName":"所有部门","SS_Mode":10,"SS_Value":10,"SS_Unit":"%","SS_BalancePayValue":0,"SS_BalancePayUnit":"%","SS_PointPayValue":0,"SS_PointPayUnit":"%","SS_OtherPayValue":0,"SS_OtherPayUnit":"%","SS_Remark":"","SS_UpdateTime":"2018-06-29 16:03:35"},{"SS_CouponPayValue":0,"SS_CouponPayUnit":"%","SS_GoodOrCombo":0,"SS_GoodTypeGID":"000000","SS_GoodTypeName":"所有分类","GID":"2a3d1a38-acfe-49fe-99a8-7f932f5b0e09","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SS_Type":20,"SS_ProductGID":"000000","SS_ProductName":"所有产品","SS_GradeGID":"000000","SS_GradeName":"全部","SS_ShopGID":"000000","SS_ShopName":"所有店铺","SS_DepartmentGID":"000000","SS_DepartmentName":"所有部门","SS_Mode":10,"SS_Value":10,"SS_Unit":"%","SS_BalancePayValue":0,"SS_BalancePayUnit":"%","SS_PointPayValue":0,"SS_PointPayUnit":"%","SS_OtherPayValue":0,"SS_OtherPayUnit":"%","SS_Remark":"","SS_UpdateTime":"2018-06-29 16:04:29"},{"SS_CouponPayValue":0,"SS_CouponPayUnit":"%","SS_GoodOrCombo":0,"SS_GoodTypeGID":"000000","SS_GoodTypeName":"所有分类","GID":"323caefb-f1bd-49a7-92b6-a8e84150ccb6","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SS_Type":30,"SS_ProductGID":"000000","SS_ProductName":"所有产品","SS_GradeGID":"000000","SS_GradeName":"全部","SS_ShopGID":"000000","SS_ShopName":"所有店铺","SS_DepartmentGID":"000000","SS_DepartmentName":"所有部门","SS_Mode":20,"SS_Value":10,"SS_Unit":"%","SS_BalancePayValue":0,"SS_BalancePayUnit":"%","SS_PointPayValue":0,"SS_PointPayUnit":"%","SS_OtherPayValue":0,"SS_OtherPayUnit":"%","SS_Remark":"","SS_UpdateTime":"2018-06-29 16:04:57"},{"SS_CouponPayValue":10,"SS_CouponPayUnit":"%","SS_GoodOrCombo":0,"SS_GoodTypeGID":"000000","SS_GoodTypeName":"所有分类","GID":"d4bd207d-ed86-445c-8c2f-400e81f2d58a","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SS_Type":40,"SS_ProductGID":"000000","SS_ProductName":"所有产品","SS_GradeGID":"000000","SS_GradeName":"全部","SS_ShopGID":"000000","SS_ShopName":"所有店铺","SS_DepartmentGID":"000000","SS_DepartmentName":"所有部门","SS_Mode":10,"SS_Value":0,"SS_Unit":"%","SS_BalancePayValue":10,"SS_BalancePayUnit":"%","SS_PointPayValue":10,"SS_PointPayUnit":"%","SS_OtherPayValue":10,"SS_OtherPayUnit":"%","SS_Remark":"","SS_UpdateTime":"2018-06-29 16:05:19"},{"SS_CouponPayValue":0,"SS_CouponPayUnit":"%","SS_GoodOrCombo":0,"SS_GoodTypeGID":"000000","SS_GoodTypeName":"所有分类","GID":"57a2d957-123a-4940-8dbb-2d7eb792aed9","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SS_Type":50,"SS_ProductGID":"000000","SS_ProductName":"所有产品","SS_GradeGID":"000000","SS_GradeName":"全部","SS_ShopGID":"000000","SS_ShopName":"所有店铺","SS_DepartmentGID":"000000","SS_DepartmentName":"所有部门","SS_Mode":20,"SS_Value":10,"SS_Unit":"%","SS_BalancePayValue":0,"SS_BalancePayUnit":"%","SS_PointPayValue":0,"SS_PointPayUnit":"%","SS_OtherPayValue":0,"SS_OtherPayUnit":"%","SS_Remark":"","SS_UpdateTime":"2018-06-29 16:05:33"},{"SS_CouponPayValue":0,"SS_CouponPayUnit":"%","SS_GoodOrCombo":0,"SS_GoodTypeGID":"000000","SS_GoodTypeName":"所有分类","GID":"4086cb49-5ab5-473f-9d5b-00973e6cd5db","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SS_Type":60,"SS_ProductGID":"000000","SS_ProductName":"所有产品","SS_GradeGID":"000000","SS_GradeName":"全部","SS_ShopGID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SS_ShopName":"默认店铺","SS_DepartmentGID":"000000","SS_DepartmentName":"所有部门","SS_Mode":10,"SS_Value":10,"SS_Unit":"元","SS_BalancePayValue":0,"SS_BalancePayUnit":"%","SS_PointPayValue":0,"SS_PointPayUnit":"%","SS_OtherPayValue":0,"SS_OtherPayUnit":"%","SS_Remark":"","SS_UpdateTime":"2018-06-29 16:05:43"},{"SS_CouponPayValue":0,"SS_CouponPayUnit":"%","SS_GoodOrCombo":0,"SS_GoodTypeGID":"000000","SS_GoodTypeName":"所有分类","GID":"c2c2be54-7bee-4fd1-b904-416994f929c7","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SS_Type":70,"SS_ProductGID":"000000","SS_ProductName":"所有产品","SS_GradeGID":"000000","SS_GradeName":"全部","SS_ShopGID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SS_ShopName":"默认店铺","SS_DepartmentGID":"000000","SS_DepartmentName":"所有部门","SS_Mode":20,"SS_Value":10,"SS_Unit":"%","SS_BalancePayValue":0,"SS_BalancePayUnit":"%","SS_PointPayValue":0,"SS_PointPayUnit":"%","SS_OtherPayValue":0,"SS_OtherPayUnit":"%","SS_Remark":"","SS_UpdateTime":"2018-06-29 16:05:50"}]
         * Active : [{"RP_Discount":9.99,"RP_IsOpen":1,"GID":"b852626a-002f-4cdc-a3fb-f7d56a9848fe","RP_Name":"3213","RP_Type":2,"RP_RechargeMoney":3211,"RP_GiveMoney":-1,"RP_GivePoint":10,"RP_ReduceMoney":-1,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"销售001","RP_CreateTime":"2018-11-16 10:36:59","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":7,"RP_IsOpen":1,"GID":"af32c42c-560f-4f35-a701-39673b7a4567","RP_Name":"7折","RP_Type":2,"RP_RechargeMoney":0,"RP_GiveMoney":-1,"RP_GivePoint":1,"RP_ReduceMoney":-1,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"销售001","RP_CreateTime":"2018-08-27 17:51:49","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":1,"RP_IsOpen":1,"GID":"28d7609b-452c-4793-92b1-0d7c21b9f909","RP_Name":"满10块打1折送10分","RP_Type":2,"RP_RechargeMoney":10,"RP_GiveMoney":-1,"RP_GivePoint":10,"RP_ReduceMoney":-1,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"销售001","RP_CreateTime":"2018-08-21 14:02:04","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"8bdf5f13-a60f-4711-8b7f-fbf5a29c28b8","RP_Name":"充10000送10000","RP_Type":1,"RP_RechargeMoney":10000,"RP_GiveMoney":10000,"RP_GivePoint":10000,"RP_ReduceMoney":0,"RP_ValidType":0,"RP_ValidWeekMonth":"1, 2, 3, 4, 5, 6, 7, 17, 18, 19, 20, 21, 25, 26, 27, 28","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"销售001","RP_CreateTime":"2018-08-02 17:08:34","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"880844b4-2c30-4827-9f80-3e577e9c2a5d","RP_Name":"满20送10积分","RP_Type":2,"RP_RechargeMoney":20,"RP_GiveMoney":0,"RP_GivePoint":10,"RP_ReduceMoney":0,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":1,"RP_Creator":"1058346971@qq.com","RP_CreateTime":"2018-07-05 15:26:29","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"b887e8f6-826a-4f0c-a975-aa8b19ce9611","RP_Name":"冲50送10送50积分","RP_Type":1,"RP_RechargeMoney":50,"RP_GiveMoney":10,"RP_GivePoint":50,"RP_ReduceMoney":0,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"1058346971@qq.com","RP_CreateTime":"2018-06-29 16:01:50","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"758ebaed-8557-406d-a5bc-e46463a98a66","RP_Name":"冲100送30","RP_Type":1,"RP_RechargeMoney":100,"RP_GiveMoney":30,"RP_GivePoint":0,"RP_ReduceMoney":0,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"1058346971@qq.com","RP_CreateTime":"2018-06-29 16:01:38","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"2db0ca14-9990-4bbd-a9ed-3b8abfe5ea2b","RP_Name":"冲100送100","RP_Type":1,"RP_RechargeMoney":100,"RP_GiveMoney":100,"RP_GivePoint":0,"RP_ReduceMoney":0,"RP_ValidType":4,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"1058346971@qq.com","RP_CreateTime":"2018-06-29 16:01:18","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"5f052bb9-7ccd-40a9-bb72-f0986d1adfe7","RP_Name":"满50减50","RP_Type":2,"RP_RechargeMoney":50,"RP_GiveMoney":0,"RP_GivePoint":0,"RP_ReduceMoney":50,"RP_ValidType":4,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"1058346971@qq.com","RP_CreateTime":"2018-06-29 16:00:24","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"ea9e6a22-7a05-499b-a3cf-a43b7bbc91c4","RP_Name":"满99送99积分","RP_Type":2,"RP_RechargeMoney":99,"RP_GiveMoney":0,"RP_GivePoint":99,"RP_ReduceMoney":0,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"1058346971@qq.com","RP_CreateTime":"2018-06-29 16:00:14","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"f9a3d250-9ac0-49ec-94bf-0033a762b1bb","RP_Name":"满59减10","RP_Type":2,"RP_RechargeMoney":59,"RP_GiveMoney":0,"RP_GivePoint":50,"RP_ReduceMoney":10,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"1058346971@qq.com","RP_CreateTime":"2018-06-29 15:59:31","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null},{"RP_Discount":0,"RP_IsOpen":1,"GID":"48e661f8-8ce9-479d-b3b1-f8567a41e394","RP_Name":"满29减4","RP_Type":2,"RP_RechargeMoney":29,"RP_GiveMoney":0,"RP_GivePoint":0,"RP_ReduceMoney":4,"RP_ValidType":0,"RP_ValidWeekMonth":"","RP_ValidStartTime":null,"RP_ValidEndTime":null,"RP_ISDouble":0,"RP_Creator":"1058346971@qq.com","RP_CreateTime":"2018-06-29 15:59:08","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","RP_Remark":null}]
         * MberList : null
         * GoodsList : null
         * Smssign : {"GID":"28c31384-47bf-48d0-8295-502b5326716f","SM_Name":"85785","SM_State":1,"SM_Remark":null,"SM_Creator":"1058346971@qq.com","SM_Update":"分号1","SM_CreatorTime":"2018-06-29 15:46:03","SM_UpdateTime":"2019-03-20 11:03:44","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823"}
         * PrintSet : {"PS_GID":"7308e3ca-6111-4989-be07-d447430857e4","PS_CYGID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","PS_SMGID":"4a7b1141-8ca3-4bef-961f-ffd153357823","PS_IsEnabled":1,"PS_IsPreview":0,"PS_PaperType":2,"PS_PrintTimes":"[{\"PT_Code\":\"FTXF\",\"PT_Times\":1},{\"PT_Code\":\"KSXF\",\"PT_Times\":1},{\"PT_Code\":\"HYCZ\",\"PT_Times\":1},{\"PT_Code\":\"JSXF\",\"PT_Times\":1},{\"PT_Code\":\"HYDJ\",\"PT_Times\":1},{\"PT_Code\":\"JFDH\",\"PT_Times\":1},{\"PT_Code\":\"SPXF\",\"PT_Times\":1},{\"PT_Code\":\"HYCC\",\"PT_Times\":1},{\"PT_Code\":\"JB\",\"PT_Times\":1},{\"PT_Code\":\"HYKK\",\"PT_Times\":1},{\"PT_Code\":\"JCXF\",\"PT_Times\":1},{\"PT_Code\":\"SPTH\",\"PT_Times\":1}]","PS_PrinterName":"XP-58","PS_StylusPrintingName":"","PS_IsMultiEnabled":null,"PS_MultiPaperType":null,"PS_MultiPrintTimes":null,"PrintTimesList":[{"PT_Code":"FTXF","PT_Times":1},{"PT_Code":"KSXF","PT_Times":1},{"PT_Code":"HYCZ","PT_Times":1},{"PT_Code":"JSXF","PT_Times":1},{"PT_Code":"HYDJ","PT_Times":1},{"PT_Code":"JFDH","PT_Times":1},{"PT_Code":"SPXF","PT_Times":1},{"PT_Code":"HYCC","PT_Times":1},{"PT_Code":"JB","PT_Times":1},{"PT_Code":"HYKK","PT_Times":1},{"PT_Code":"JCXF","PT_Times":1},{"PT_Code":"SPTH","PT_Times":1}],"MultiPrintTimesList":null}
         */

        private Object MberList;
        private Object GoodsList;
        private SmssignBean Smssign;
        private PrintSetBean PrintSet;
        private List<GetCustomFieldsVIPBean> GetCustomFieldsVIP;
        private List<GetCustomFieldsBean> GetCustomFields;
        private List<GetLoginHistoryListBean> GetLoginHistoryList;
        private List<GetSysSwitchListBean> GetSysSwitchList;
        private List<VIPGradeListBean> VIPGradeList;
        private List<EmplistBean> Emplist;
        private List<DepartmentListBean> DepartmentList;
        private List<ShopListBean> ShopList;
        private List<DeductRuleBean> DeductRule;
        private List<ActiveBean> Active;

        public Object getMberList() {
            return MberList;
        }

        public void setMberList(Object MberList) {
            this.MberList = MberList;
        }

        public Object getGoodsList() {
            return GoodsList;
        }

        public void setGoodsList(Object GoodsList) {
            this.GoodsList = GoodsList;
        }

        public SmssignBean getSmssign() {
            return Smssign;
        }

        public void setSmssign(SmssignBean Smssign) {
            this.Smssign = Smssign;
        }

        public PrintSetBean getPrintSet() {
            return PrintSet;
        }

        public void setPrintSet(PrintSetBean PrintSet) {
            this.PrintSet = PrintSet;
        }

        public List<GetCustomFieldsVIPBean> getGetCustomFieldsVIP() {
            return GetCustomFieldsVIP;
        }

        public void setGetCustomFieldsVIP(List<GetCustomFieldsVIPBean> GetCustomFieldsVIP) {
            this.GetCustomFieldsVIP = GetCustomFieldsVIP;
        }

        public List<GetCustomFieldsBean> getGetCustomFields() {
            return GetCustomFields;
        }

        public void setGetCustomFields(List<GetCustomFieldsBean> GetCustomFields) {
            this.GetCustomFields = GetCustomFields;
        }

        public List<GetLoginHistoryListBean> getGetLoginHistoryList() {
            return GetLoginHistoryList;
        }

        public void setGetLoginHistoryList(List<GetLoginHistoryListBean> GetLoginHistoryList) {
            this.GetLoginHistoryList = GetLoginHistoryList;
        }

        public List<GetSysSwitchListBean> getGetSysSwitchList() {
            return GetSysSwitchList;
        }

        public void setGetSysSwitchList(List<GetSysSwitchListBean> GetSysSwitchList) {
            this.GetSysSwitchList = GetSysSwitchList;
        }

        public List<VIPGradeListBean> getVIPGradeList() {
            return VIPGradeList;
        }

        public void setVIPGradeList(List<VIPGradeListBean> VIPGradeList) {
            this.VIPGradeList = VIPGradeList;
        }

        public List<EmplistBean> getEmplist() {
            return Emplist;
        }

        public void setEmplist(List<EmplistBean> Emplist) {
            this.Emplist = Emplist;
        }

        public List<DepartmentListBean> getDepartmentList() {
            return DepartmentList;
        }

        public void setDepartmentList(List<DepartmentListBean> DepartmentList) {
            this.DepartmentList = DepartmentList;
        }

        public List<ShopListBean> getShopList() {
            return ShopList;
        }

        public void setShopList(List<ShopListBean> ShopList) {
            this.ShopList = ShopList;
        }

        public List<DeductRuleBean> getDeductRule() {
            return DeductRule;
        }

        public void setDeductRule(List<DeductRuleBean> DeductRule) {
            this.DeductRule = DeductRule;
        }

        public List<ActiveBean> getActive() {
            return Active;
        }

        public void setActive(List<ActiveBean> Active) {
            this.Active = Active;
        }

        public static class SmssignBean implements Serializable {
            /**
             * GID : 28c31384-47bf-48d0-8295-502b5326716f
             * SM_Name : 85785
             * SM_State : 1
             * SM_Remark : null
             * SM_Creator : 1058346971@qq.com
             * SM_Update : 分号1
             * SM_CreatorTime : 2018-06-29 15:46:03
             * SM_UpdateTime : 2019-03-20 11:03:44
             * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
             * SM_GID : 4a7b1141-8ca3-4bef-961f-ffd153357823
             */

            private String GID;
            private String SM_Name;
            private int SM_State;
            private Object SM_Remark;
            private String SM_Creator;
            private String SM_Update;
            private String SM_CreatorTime;
            private String SM_UpdateTime;
            private String CY_GID;
            private String SM_GID;

            public String getGID() {
                return GID;
            }

            public void setGID(String GID) {
                this.GID = GID;
            }

            public String getSM_Name() {
                return SM_Name;
            }

            public void setSM_Name(String SM_Name) {
                this.SM_Name = SM_Name;
            }

            public int getSM_State() {
                return SM_State;
            }

            public void setSM_State(int SM_State) {
                this.SM_State = SM_State;
            }

            public Object getSM_Remark() {
                return SM_Remark;
            }

            public void setSM_Remark(Object SM_Remark) {
                this.SM_Remark = SM_Remark;
            }

            public String getSM_Creator() {
                return SM_Creator;
            }

            public void setSM_Creator(String SM_Creator) {
                this.SM_Creator = SM_Creator;
            }

            public String getSM_Update() {
                return SM_Update;
            }

            public void setSM_Update(String SM_Update) {
                this.SM_Update = SM_Update;
            }

            public String getSM_CreatorTime() {
                return SM_CreatorTime;
            }

            public void setSM_CreatorTime(String SM_CreatorTime) {
                this.SM_CreatorTime = SM_CreatorTime;
            }

            public String getSM_UpdateTime() {
                return SM_UpdateTime;
            }

            public void setSM_UpdateTime(String SM_UpdateTime) {
                this.SM_UpdateTime = SM_UpdateTime;
            }

            public String getCY_GID() {
                return CY_GID;
            }

            public void setCY_GID(String CY_GID) {
                this.CY_GID = CY_GID;
            }

            public String getSM_GID() {
                return SM_GID;
            }

            public void setSM_GID(String SM_GID) {
                this.SM_GID = SM_GID;
            }
        }

        public static class PrintSetBean implements Serializable {
            /**
             * PS_GID : 7308e3ca-6111-4989-be07-d447430857e4
             * PS_CYGID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
             * PS_SMGID : 4a7b1141-8ca3-4bef-961f-ffd153357823
             * PS_IsEnabled : 1
             * PS_IsPreview : 0
             * PS_PaperType : 2
             * PS_PrintTimes : [{"PT_Code":"FTXF","PT_Times":1},{"PT_Code":"KSXF","PT_Times":1},{"PT_Code":"HYCZ","PT_Times":1},{"PT_Code":"JSXF","PT_Times":1},{"PT_Code":"HYDJ","PT_Times":1},{"PT_Code":"JFDH","PT_Times":1},{"PT_Code":"SPXF","PT_Times":1},{"PT_Code":"HYCC","PT_Times":1},{"PT_Code":"JB","PT_Times":1},{"PT_Code":"HYKK","PT_Times":1},{"PT_Code":"JCXF","PT_Times":1},{"PT_Code":"SPTH","PT_Times":1}]
             * PS_PrinterName : XP-58
             * PS_StylusPrintingName :
             * PS_IsMultiEnabled : null
             * PS_MultiPaperType : null
             * PS_MultiPrintTimes : null
             * PrintTimesList : [{"PT_Code":"FTXF","PT_Times":1},{"PT_Code":"KSXF","PT_Times":1},{"PT_Code":"HYCZ","PT_Times":1},{"PT_Code":"JSXF","PT_Times":1},{"PT_Code":"HYDJ","PT_Times":1},{"PT_Code":"JFDH","PT_Times":1},{"PT_Code":"SPXF","PT_Times":1},{"PT_Code":"HYCC","PT_Times":1},{"PT_Code":"JB","PT_Times":1},{"PT_Code":"HYKK","PT_Times":1},{"PT_Code":"JCXF","PT_Times":1},{"PT_Code":"SPTH","PT_Times":1}]
             * MultiPrintTimesList : null
             */

            private String PS_GID;
            private String PS_CYGID;
            private String PS_SMGID;
            private int PS_IsEnabled;
            private int PS_IsPreview;
            private int PS_PaperType;
            private String PS_PrintTimes;
            private String PS_PrinterName;
            private String PS_StylusPrintingName;
            private Object PS_IsMultiEnabled;
            private Object PS_MultiPaperType;
            private Object PS_MultiPrintTimes;
            private Object MultiPrintTimesList;
            private List<PrintTimesListBean> PrintTimesList;

            public String getPS_GID() {
                return PS_GID;
            }

            public void setPS_GID(String PS_GID) {
                this.PS_GID = PS_GID;
            }

            public String getPS_CYGID() {
                return PS_CYGID;
            }

            public void setPS_CYGID(String PS_CYGID) {
                this.PS_CYGID = PS_CYGID;
            }

            public String getPS_SMGID() {
                return PS_SMGID;
            }

            public void setPS_SMGID(String PS_SMGID) {
                this.PS_SMGID = PS_SMGID;
            }

            public int getPS_IsEnabled() {
                return PS_IsEnabled;
            }

            public void setPS_IsEnabled(int PS_IsEnabled) {
                this.PS_IsEnabled = PS_IsEnabled;
            }

            public int getPS_IsPreview() {
                return PS_IsPreview;
            }

            public void setPS_IsPreview(int PS_IsPreview) {
                this.PS_IsPreview = PS_IsPreview;
            }

            public int getPS_PaperType() {
                return PS_PaperType;
            }

            public void setPS_PaperType(int PS_PaperType) {
                this.PS_PaperType = PS_PaperType;
            }

            public String getPS_PrintTimes() {
                return PS_PrintTimes;
            }

            public void setPS_PrintTimes(String PS_PrintTimes) {
                this.PS_PrintTimes = PS_PrintTimes;
            }

            public String getPS_PrinterName() {
                return PS_PrinterName;
            }

            public void setPS_PrinterName(String PS_PrinterName) {
                this.PS_PrinterName = PS_PrinterName;
            }

            public String getPS_StylusPrintingName() {
                return PS_StylusPrintingName;
            }

            public void setPS_StylusPrintingName(String PS_StylusPrintingName) {
                this.PS_StylusPrintingName = PS_StylusPrintingName;
            }

            public Object getPS_IsMultiEnabled() {
                return PS_IsMultiEnabled;
            }

            public void setPS_IsMultiEnabled(Object PS_IsMultiEnabled) {
                this.PS_IsMultiEnabled = PS_IsMultiEnabled;
            }

            public Object getPS_MultiPaperType() {
                return PS_MultiPaperType;
            }

            public void setPS_MultiPaperType(Object PS_MultiPaperType) {
                this.PS_MultiPaperType = PS_MultiPaperType;
            }

            public Object getPS_MultiPrintTimes() {
                return PS_MultiPrintTimes;
            }

            public void setPS_MultiPrintTimes(Object PS_MultiPrintTimes) {
                this.PS_MultiPrintTimes = PS_MultiPrintTimes;
            }

            public Object getMultiPrintTimesList() {
                return MultiPrintTimesList;
            }

            public void setMultiPrintTimesList(Object MultiPrintTimesList) {
                this.MultiPrintTimesList = MultiPrintTimesList;
            }

            public List<PrintTimesListBean> getPrintTimesList() {
                return PrintTimesList;
            }

            public void setPrintTimesList(List<PrintTimesListBean> PrintTimesList) {
                this.PrintTimesList = PrintTimesList;
            }

            public static class PrintTimesListBean implements Serializable {
                /**
                 * PT_Code : FTXF
                 * PT_Times : 1
                 */

                private String PT_Code;
                private int PT_Times;

                public String getPT_Code() {
                    return PT_Code;
                }

                public void setPT_Code(String PT_Code) {
                    this.PT_Code = PT_Code;
                }

                public int getPT_Times() {
                    return PT_Times;
                }

                public void setPT_Times(int PT_Times) {
                    this.PT_Times = PT_Times;
                }
            }
        }

        public static class GetCustomFieldsVIPBean implements Serializable {
            /**
             * CF_GID : 34f6c04b-e516-42f5-902a-f7b31f9bcf7a
             * CF_FieldName : 办卡日期
             * CF_FieldType : 日期
             * CF_ItemsValue :
             * CF_Value :
             * CF_Required : 是
             * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
             * VIP_GID : 1
             * CF_CreateUser : 销售001
             * CF_CreateTime : 2018-10-29 15:40:27
             * CF_Order : 5
             * CF_IsShowVIP : 1
             */

            private String CF_GID;
            private String CF_FieldName;
            private String CF_FieldType;
            private String CF_ItemsValue;
            private String CF_Value;
            private String CF_Required;
            private String CY_GID;
            private String VIP_GID;
            private String CF_CreateUser;
            private String CF_CreateTime;
            private int CF_Order;
            private int CF_IsShowVIP;

            public String getM_ItemsValue() {
                return M_ItemsValue;
            }

            public void setM_ItemsValue(String m_ItemsValue) {
                M_ItemsValue = m_ItemsValue;
            }

            private String M_ItemsValue;

            public String getCF_GID() {
                return CF_GID;
            }

            public void setCF_GID(String CF_GID) {
                this.CF_GID = CF_GID;
            }

            public String getCF_FieldName() {
                return CF_FieldName;
            }

            public void setCF_FieldName(String CF_FieldName) {
                this.CF_FieldName = CF_FieldName;
            }

            public String getCF_FieldType() {
                return CF_FieldType;
            }

            public void setCF_FieldType(String CF_FieldType) {
                this.CF_FieldType = CF_FieldType;
            }

            public String getCF_ItemsValue() {
                return CF_ItemsValue;
            }

            public void setCF_ItemsValue(String CF_ItemsValue) {
                this.CF_ItemsValue = CF_ItemsValue;
            }

            public String getCF_Value() {
                return CF_Value;
            }

            public void setCF_Value(String CF_Value) {
                this.CF_Value = CF_Value;
            }

            public String getCF_Required() {
                return CF_Required;
            }

            public void setCF_Required(String CF_Required) {
                this.CF_Required = CF_Required;
            }

            public String getCY_GID() {
                return CY_GID;
            }

            public void setCY_GID(String CY_GID) {
                this.CY_GID = CY_GID;
            }

            public String getVIP_GID() {
                return VIP_GID;
            }

            public void setVIP_GID(String VIP_GID) {
                this.VIP_GID = VIP_GID;
            }

            public String getCF_CreateUser() {
                return CF_CreateUser;
            }

            public void setCF_CreateUser(String CF_CreateUser) {
                this.CF_CreateUser = CF_CreateUser;
            }

            public String getCF_CreateTime() {
                return CF_CreateTime;
            }

            public void setCF_CreateTime(String CF_CreateTime) {
                this.CF_CreateTime = CF_CreateTime;
            }

            public int getCF_Order() {
                return CF_Order;
            }

            public void setCF_Order(int CF_Order) {
                this.CF_Order = CF_Order;
            }

            public int getCF_IsShowVIP() {
                return CF_IsShowVIP;
            }

            public void setCF_IsShowVIP(int CF_IsShowVIP) {
                this.CF_IsShowVIP = CF_IsShowVIP;
            }
        }

        public static class GetCustomFieldsBean implements Serializable {
            /**
             * CF_Order : 3
             * CF_GID : d024aa5c-63ef-4ca3-b316-0cad2dc3965b
             * CF_FieldName : 备注
             * CF_FieldType : 文本
             * CF_ItemsValue :
             * CF_Value :
             * CF_Required : 是
             * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
             * VIP_GID :
             * PM_GID : 1
             * CF_CreateUser : 销售001
             * CF_CreateTime : 2018-10-30 09:24:01
             */

            private int CF_Order;
            private String CF_GID;
            private String CF_FieldName;
            private String CF_FieldType;
            private String CF_ItemsValue;
            private String CF_Value;
            private String CF_Required;
            private String CY_GID;
            private String VIP_GID;
            private String PM_GID;
            private String CF_CreateUser;
            private String CF_CreateTime;

            public int getCF_Order() {
                return CF_Order;
            }

            public void setCF_Order(int CF_Order) {
                this.CF_Order = CF_Order;
            }

            public String getCF_GID() {
                return CF_GID;
            }

            public void setCF_GID(String CF_GID) {
                this.CF_GID = CF_GID;
            }

            public String getCF_FieldName() {
                return CF_FieldName;
            }

            public void setCF_FieldName(String CF_FieldName) {
                this.CF_FieldName = CF_FieldName;
            }

            public String getCF_FieldType() {
                return CF_FieldType;
            }

            public void setCF_FieldType(String CF_FieldType) {
                this.CF_FieldType = CF_FieldType;
            }

            public String getCF_ItemsValue() {
                return CF_ItemsValue;
            }

            public void setCF_ItemsValue(String CF_ItemsValue) {
                this.CF_ItemsValue = CF_ItemsValue;
            }

            public String getCF_Value() {
                return CF_Value;
            }

            public void setCF_Value(String CF_Value) {
                this.CF_Value = CF_Value;
            }

            public String getCF_Required() {
                return CF_Required;
            }

            public void setCF_Required(String CF_Required) {
                this.CF_Required = CF_Required;
            }

            public String getCY_GID() {
                return CY_GID;
            }

            public void setCY_GID(String CY_GID) {
                this.CY_GID = CY_GID;
            }

            public String getVIP_GID() {
                return VIP_GID;
            }

            public void setVIP_GID(String VIP_GID) {
                this.VIP_GID = VIP_GID;
            }

            public String getPM_GID() {
                return PM_GID;
            }

            public void setPM_GID(String PM_GID) {
                this.PM_GID = PM_GID;
            }

            public String getCF_CreateUser() {
                return CF_CreateUser;
            }

            public void setCF_CreateUser(String CF_CreateUser) {
                this.CF_CreateUser = CF_CreateUser;
            }

            public String getCF_CreateTime() {
                return CF_CreateTime;
            }

            public void setCF_CreateTime(String CF_CreateTime) {
                this.CF_CreateTime = CF_CreateTime;
            }
        }

        public static class GetLoginHistoryListBean implements Serializable {
            /**
             * GID : null
             * CY_GID : null
             * SM_GID : null
             * LM_Account : 18328578333
             * LM_IP : 171.216.70.29
             * LM_Area : 未能解析IP:171.216.70.29
             * LM_Time : 2019-03-30 14:20:57
             * LM_Type : 苹果APP
             */

            private Object GID;
            private Object CY_GID;
            private Object SM_GID;
            private String LM_Account;
            private String LM_IP;
            private String LM_Area;
            private String LM_Time;
            private String LM_Type;

            public Object getGID() {
                return GID;
            }

            public void setGID(Object GID) {
                this.GID = GID;
            }

            public Object getCY_GID() {
                return CY_GID;
            }

            public void setCY_GID(Object CY_GID) {
                this.CY_GID = CY_GID;
            }

            public Object getSM_GID() {
                return SM_GID;
            }

            public void setSM_GID(Object SM_GID) {
                this.SM_GID = SM_GID;
            }

            public String getLM_Account() {
                return LM_Account;
            }

            public void setLM_Account(String LM_Account) {
                this.LM_Account = LM_Account;
            }

            public String getLM_IP() {
                return LM_IP;
            }

            public void setLM_IP(String LM_IP) {
                this.LM_IP = LM_IP;
            }

            public String getLM_Area() {
                return LM_Area;
            }

            public void setLM_Area(String LM_Area) {
                this.LM_Area = LM_Area;
            }

            public String getLM_Time() {
                return LM_Time;
            }

            public void setLM_Time(String LM_Time) {
                this.LM_Time = LM_Time;
            }

            public String getLM_Type() {
                return LM_Type;
            }

            public void setLM_Type(String LM_Type) {
                this.LM_Type = LM_Type;
            }
        }

        public static class GetSysSwitchListBean implements Serializable {
            /**
             * SS_Value : null
             * GID : 4f3aefbe-172e-4839-b81e-3ace7da00007
             * SS_Name : 会员卡号同手机号
             * SS_Code : 201
             * SS_State : 1
             * SS_Remark : null
             * SS_Update : 1058346971@qq.com
             * SS_UpdateTime : 2018-06-29 16:11:42
             * CY_GID : null
             * SS_Sort : 1
             */

            private String SS_Value;
            private String GID;
            private String SS_Name;
            private String SS_Code;
            private int SS_State;
            private Object SS_Remark;
            private String SS_Update;
            private String SS_UpdateTime;
            private Object CY_GID;
            private int SS_Sort;

            public String getSS_Value() {
                return SS_Value;
            }

            public void setSS_Value(String SS_Value) {
                this.SS_Value = SS_Value;
            }

            public String getGID() {
                return GID;
            }

            public void setGID(String GID) {
                this.GID = GID;
            }

            public String getSS_Name() {
                return SS_Name;
            }

            public void setSS_Name(String SS_Name) {
                this.SS_Name = SS_Name;
            }

            public String getSS_Code() {
                return SS_Code;
            }

            public void setSS_Code(String SS_Code) {
                this.SS_Code = SS_Code;
            }

            public int getSS_State() {
                return SS_State;
            }

            public void setSS_State(int SS_State) {
                this.SS_State = SS_State;
            }

            public Object getSS_Remark() {
                return SS_Remark;
            }

            public void setSS_Remark(Object SS_Remark) {
                this.SS_Remark = SS_Remark;
            }

            public String getSS_Update() {
                return SS_Update;
            }

            public void setSS_Update(String SS_Update) {
                this.SS_Update = SS_Update;
            }

            public String getSS_UpdateTime() {
                return SS_UpdateTime;
            }

            public void setSS_UpdateTime(String SS_UpdateTime) {
                this.SS_UpdateTime = SS_UpdateTime;
            }

            public Object getCY_GID() {
                return CY_GID;
            }

            public void setCY_GID(Object CY_GID) {
                this.CY_GID = CY_GID;
            }

            public int getSS_Sort() {
                return SS_Sort;
            }

            public void setSS_Sort(int SS_Sort) {
                this.SS_Sort = SS_Sort;
            }
        }

        public static class VIPGradeListBean implements Serializable {
            /**
             * VG_IsDownLock : 0
             * VG_UpDownType : 0
             * VG_NextGradeName : 默认等级
             * VG_NextGradeGID : 45a168cb-493e-43b7-8cfc-730ef4da27c7
             * VG_LastGradeName :
             * VG_LastGradeGID :
             * US_ValueMax : 9.0
             * VG_IsTimeTimes : 1
             * GID : 3df0f677-442e-43ef-8706-18a54d7a2ded
             * US_Code : IntegerFulfil
             * US_Value : 1.0
             * VG_Name : 等级
             * VG_Code :
             * VG_CardAmount : 10.0
             * VG_InitialAmount : 0.0
             * VG_InitialIntegral : 0.0
             * VG_IsLock : 1
             * VG_IsAccount : 0
             * VG_IsIntegral : 0
             * VG_IsDiscount : 0
             * VG_IsCount : 0
             * VG_IsTime : 1
             * VG_IsTimeNum : 1
             * VG_IsTimeUnit : 天
             * VG_Remark :
             * VG_IntegralUniformRuleValue : 0.0
             * VG_IntegralRuleType : 1
             * VG_DiscountUniformRuleValue : 0
             * VG_DiscountRuleType : 1
             * DS_Value : 0.0
             * RS_CMoney : 0.0
             * RS_Value : 0.0
             * VS_CMoney : 0.0
             * VS_Value : 0.0
             * US_Name : 积分达到
             * Settings : [{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"09945a52-1b71-481b-a49d-c78645270761","PT_Name":"普通商品类","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"0fa82ed2-b3d9-4dda-9929-c9221458edff","PT_Name":"花果","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"2dbddf40-bb15-44b2-880e-cfa9b70eb6a3","PT_Name":"跑腿","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"1827050f-221b-4797-941c-87dc0eb36872","PT_Name":"理发","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"e7af48e4-cdc1-4ef8-9100-d191962b0ad4","PT_Name":"名字就是要长一点","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"819d58ba-e338-4944-8c18-4152806ebe24","PT_Name":"大月饼礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"c4db81ee-addc-44d1-b98e-2a66ef409d13","PT_Name":"普通商品","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PT_Name":"粽子礼盒","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"8bc268c6-2bf5-4b54-9fee-31de87c90825","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"c545dd9b-0665-42b3-8fa1-5fd4b18060bb","PT_Name":"2222","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"638d56bd-d394-4b95-bbaa-3060d4a4e68f","PT_Name":"33333","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"d4132653-5d26-4275-bd88-6c8c15c47b64","PT_Name":"瓜","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"ca0c4564-5a78-424f-919a-06137fbee4a9","PT_Name":"2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"ae26522f-d0e8-48f9-a9a7-1d6d41077eaf","PT_Name":"帕子","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"7eed0611-de8b-49b8-a25e-b67a723b6d5d","PT_Name":"牙膏","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"865db4a8-e5d8-4457-af2d-f0288eb22802","PT_Name":"111","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"7747bdfa-0ff3-4405-86fc-29ee3ff142e3","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"1a77a45c-6a7c-4ab3-b865-5d4370e38bc7","PT_Name":"足疗","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"b5024fad-670d-45a2-834f-08a65f7552fe","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PT_Name":"牙刷","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"a4d67cbf-9268-4a29-aef2-76ddb81200ba","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PT_Name":"1","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":0,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"e122880a-765a-4dbd-afcf-f6c1eabcc278","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"2882bd96-202f-4f6b-9596-d7a64059ef76","PT_Name":"橘2","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll2","PT_Parent":"c8f7b670-0406-48c0-b228-285a6a1b8427","PT_SynType":"0"},{"VG_GID":"3df0f677-442e-43ef-8706-18a54d7a2ded","VG_Name":"等级","PT_GID":"764dcc5c-74ff-4bc3-90c3-3cf3152bfd0c","PT_Name":"积分","PT_Type":"商品","PD_Discount":100,"VS_CMoney":0,"VS_Number":1,"SM_GID":null,"SM_Name":null,"PT_Parent":"","PT_SynType":"1"}]
             * InitServiceList : []
             */

            private int VG_IsDownLock;
            private Integer VG_UpDownType;
            private String VG_NextGradeName;
            private String VG_NextGradeGID;
            private String VG_LastGradeName;
            private String VG_LastGradeGID;
            private String US_ValueMax;
            private Integer VG_IsTimeTimes;
            private String GID;
            private String US_Code;
            private double US_Value;
            private String VG_Name;
            private String VG_Code;
            private double VG_CardAmount;
            private double VG_InitialAmount;
            private double VG_InitialIntegral;
            private int VG_IsLock;
            private int VG_IsAccount;
            private int VG_IsIntegral;
            private int VG_IsDiscount;
            private int VG_IsCount;
            private int VG_IsTime;
            private String VG_IsTimeNum;
            private String VG_IsTimeUnit;
            private String VG_Remark;
            private double VG_IntegralUniformRuleValue;
            private int VG_IntegralRuleType;
            private int VG_DiscountUniformRuleValue;
            private int VG_DiscountRuleType;
            private double DS_Value;
            private double RS_CMoney;
            private double RS_Value;
            private double VS_CMoney;
            private double VS_Value;
            private String US_Name;
            private List<SettingsBean> Settings;
            private List<?> InitServiceList;

            public int getVG_IsDownLock() {
                return VG_IsDownLock;
            }

            public void setVG_IsDownLock(int VG_IsDownLock) {
                this.VG_IsDownLock = VG_IsDownLock;
            }

            public Integer getVG_UpDownType() {
                return VG_UpDownType;
            }

            public void setVG_UpDownType(Integer VG_UpDownType) {
                this.VG_UpDownType = VG_UpDownType;
            }

            public String getVG_NextGradeName() {
                return VG_NextGradeName;
            }

            public void setVG_NextGradeName(String VG_NextGradeName) {
                this.VG_NextGradeName = VG_NextGradeName;
            }

            public String getVG_NextGradeGID() {
                return VG_NextGradeGID;
            }

            public void setVG_NextGradeGID(String VG_NextGradeGID) {
                this.VG_NextGradeGID = VG_NextGradeGID;
            }

            public String getVG_LastGradeName() {
                return VG_LastGradeName;
            }

            public void setVG_LastGradeName(String VG_LastGradeName) {
                this.VG_LastGradeName = VG_LastGradeName;
            }

            public String getVG_LastGradeGID() {
                return VG_LastGradeGID;
            }

            public void setVG_LastGradeGID(String VG_LastGradeGID) {
                this.VG_LastGradeGID = VG_LastGradeGID;
            }

            public String getUS_ValueMax() {
                return US_ValueMax;
            }

            public void setUS_ValueMax(String US_ValueMax) {
                this.US_ValueMax = US_ValueMax;
            }

            public Integer getVG_IsTimeTimes() {
                return VG_IsTimeTimes;
            }

            public void setVG_IsTimeTimes(Integer VG_IsTimeTimes) {
                this.VG_IsTimeTimes = VG_IsTimeTimes;
            }

            public String getGID() {
                return GID;
            }

            public void setGID(String GID) {
                this.GID = GID;
            }

            public String getUS_Code() {
                return US_Code;
            }

            public void setUS_Code(String US_Code) {
                this.US_Code = US_Code;
            }

            public double getUS_Value() {
                return US_Value;
            }

            public void setUS_Value(double US_Value) {
                this.US_Value = US_Value;
            }

            public String getVG_Name() {
                return VG_Name;
            }

            public void setVG_Name(String VG_Name) {
                this.VG_Name = VG_Name;
            }

            public String getVG_Code() {
                return VG_Code;
            }

            public void setVG_Code(String VG_Code) {
                this.VG_Code = VG_Code;
            }

            public double getVG_CardAmount() {
                return VG_CardAmount;
            }

            public void setVG_CardAmount(double VG_CardAmount) {
                this.VG_CardAmount = VG_CardAmount;
            }

            public double getVG_InitialAmount() {
                return VG_InitialAmount;
            }

            public void setVG_InitialAmount(double VG_InitialAmount) {
                this.VG_InitialAmount = VG_InitialAmount;
            }

            public double getVG_InitialIntegral() {
                return VG_InitialIntegral;
            }

            public void setVG_InitialIntegral(double VG_InitialIntegral) {
                this.VG_InitialIntegral = VG_InitialIntegral;
            }

            public int getVG_IsLock() {
                return VG_IsLock;
            }

            public void setVG_IsLock(int VG_IsLock) {
                this.VG_IsLock = VG_IsLock;
            }

            public int getVG_IsAccount() {
                return VG_IsAccount;
            }

            public void setVG_IsAccount(int VG_IsAccount) {
                this.VG_IsAccount = VG_IsAccount;
            }

            public int getVG_IsIntegral() {
                return VG_IsIntegral;
            }

            public void setVG_IsIntegral(int VG_IsIntegral) {
                this.VG_IsIntegral = VG_IsIntegral;
            }

            public int getVG_IsDiscount() {
                return VG_IsDiscount;
            }

            public void setVG_IsDiscount(int VG_IsDiscount) {
                this.VG_IsDiscount = VG_IsDiscount;
            }

            public int getVG_IsCount() {
                return VG_IsCount;
            }

            public void setVG_IsCount(int VG_IsCount) {
                this.VG_IsCount = VG_IsCount;
            }

            public int getVG_IsTime() {
                return VG_IsTime;
            }

            public void setVG_IsTime(int VG_IsTime) {
                this.VG_IsTime = VG_IsTime;
            }

            public String getVG_IsTimeNum() {
                return VG_IsTimeNum;
            }

            public void setVG_IsTimeNum(String VG_IsTimeNum) {
                this.VG_IsTimeNum = VG_IsTimeNum;
            }

            public String getVG_IsTimeUnit() {
                return VG_IsTimeUnit;
            }

            public void setVG_IsTimeUnit(String VG_IsTimeUnit) {
                this.VG_IsTimeUnit = VG_IsTimeUnit;
            }

            public String getVG_Remark() {
                return VG_Remark;
            }

            public void setVG_Remark(String VG_Remark) {
                this.VG_Remark = VG_Remark;
            }

            public double getVG_IntegralUniformRuleValue() {
                return VG_IntegralUniformRuleValue;
            }

            public void setVG_IntegralUniformRuleValue(double VG_IntegralUniformRuleValue) {
                this.VG_IntegralUniformRuleValue = VG_IntegralUniformRuleValue;
            }

            public int getVG_IntegralRuleType() {
                return VG_IntegralRuleType;
            }

            public void setVG_IntegralRuleType(int VG_IntegralRuleType) {
                this.VG_IntegralRuleType = VG_IntegralRuleType;
            }

            public int getVG_DiscountUniformRuleValue() {
                return VG_DiscountUniformRuleValue;
            }

            public void setVG_DiscountUniformRuleValue(int VG_DiscountUniformRuleValue) {
                this.VG_DiscountUniformRuleValue = VG_DiscountUniformRuleValue;
            }

            public int getVG_DiscountRuleType() {
                return VG_DiscountRuleType;
            }

            public void setVG_DiscountRuleType(int VG_DiscountRuleType) {
                this.VG_DiscountRuleType = VG_DiscountRuleType;
            }

            public double getDS_Value() {
                return DS_Value;
            }

            public void setDS_Value(double DS_Value) {
                this.DS_Value = DS_Value;
            }

            public double getRS_CMoney() {
                return RS_CMoney;
            }

            public void setRS_CMoney(double RS_CMoney) {
                this.RS_CMoney = RS_CMoney;
            }

            public double getRS_Value() {
                return RS_Value;
            }

            public void setRS_Value(double RS_Value) {
                this.RS_Value = RS_Value;
            }

            public double getVS_CMoney() {
                return VS_CMoney;
            }

            public void setVS_CMoney(double VS_CMoney) {
                this.VS_CMoney = VS_CMoney;
            }

            public double getVS_Value() {
                return VS_Value;
            }

            public void setVS_Value(double VS_Value) {
                this.VS_Value = VS_Value;
            }

            public String getUS_Name() {
                return US_Name;
            }

            public void setUS_Name(String US_Name) {
                this.US_Name = US_Name;
            }

            public List<SettingsBean> getSettings() {
                return Settings;
            }

            public void setSettings(List<SettingsBean> Settings) {
                this.Settings = Settings;
            }

            public List<?> getInitServiceList() {
                return InitServiceList;
            }

            public void setInitServiceList(List<?> InitServiceList) {
                this.InitServiceList = InitServiceList;
            }

            public static class SettingsBean implements Serializable {
                /**
                 * VG_GID : 3df0f677-442e-43ef-8706-18a54d7a2ded
                 * VG_Name : 等级
                 * PT_GID : 09945a52-1b71-481b-a49d-c78645270761
                 * PT_Name : 普通商品类
                 * PT_Type : 商品
                 * PD_Discount : 100
                 * VS_CMoney : 0.0
                 * VS_Number : 0.0
                 * SM_GID : 4a7b1141-8ca3-4bef-961f-ffd153357823
                 * SM_Name : jll2
                 * PT_Parent :
                 * PT_SynType : 0
                 */

                private String VG_GID;
                private String VG_Name;
                private String PT_GID;
                private String PT_Name;
                private String PT_Type;
                private int PD_Discount;
                private double VS_CMoney;
                private double VS_Number;
                private String SM_GID;
                private String SM_Name;
                private String PT_Parent;
                private String PT_SynType;

                public String getVG_GID() {
                    return VG_GID;
                }

                public void setVG_GID(String VG_GID) {
                    this.VG_GID = VG_GID;
                }

                public String getVG_Name() {
                    return VG_Name;
                }

                public void setVG_Name(String VG_Name) {
                    this.VG_Name = VG_Name;
                }

                public String getPT_GID() {
                    return PT_GID;
                }

                public void setPT_GID(String PT_GID) {
                    this.PT_GID = PT_GID;
                }

                public String getPT_Name() {
                    return PT_Name;
                }

                public void setPT_Name(String PT_Name) {
                    this.PT_Name = PT_Name;
                }

                public String getPT_Type() {
                    return PT_Type;
                }

                public void setPT_Type(String PT_Type) {
                    this.PT_Type = PT_Type;
                }

                public int getPD_Discount() {
                    return PD_Discount;
                }

                public void setPD_Discount(int PD_Discount) {
                    this.PD_Discount = PD_Discount;
                }

                public double getVS_CMoney() {
                    return VS_CMoney;
                }

                public void setVS_CMoney(double VS_CMoney) {
                    this.VS_CMoney = VS_CMoney;
                }

                public double getVS_Number() {
                    return VS_Number;
                }

                public void setVS_Number(double VS_Number) {
                    this.VS_Number = VS_Number;
                }

                public String getSM_GID() {
                    return SM_GID;
                }

                public void setSM_GID(String SM_GID) {
                    this.SM_GID = SM_GID;
                }

                public String getSM_Name() {
                    return SM_Name;
                }

                public void setSM_Name(String SM_Name) {
                    this.SM_Name = SM_Name;
                }

                public String getPT_Parent() {
                    return PT_Parent;
                }

                public void setPT_Parent(String PT_Parent) {
                    this.PT_Parent = PT_Parent;
                }

                public String getPT_SynType() {
                    return PT_SynType;
                }

                public void setPT_SynType(String PT_SynType) {
                    this.PT_SynType = PT_SynType;
                }
            }
        }

        public static class EmplistBean implements Serializable {
            /**
             * GID : 0f87e1fc-d8a0-4681-88e6-64bf08b0b15a
             * SM_GID : 4a7b1141-8ca3-4bef-961f-ffd153357823
             * CY_GID : null
             * DM_GID : 473c9d88-d53c-40d5-9896-e9df345cb585
             * EM_Code : 335
             * EM_Name : C位狙击吃鸡手
             * EM_Sex : 0
             * EM_Phone :
             * EM_Addr :
             * EM_Remark :
             * EM_UpdateTime : 2018-08-29 16:44:38
             * EM_Creator : 销售001
             * EM_Birthday : null
             * SM_Name : jll2
             * DM_Name : 吃鸡小分队
             * EM_TipCard : 1
             * EM_TipRecharge : 0
             * EM_TipChargeTime : 0
             * EM_TipGoodsConsume : 0
             * EM_TipFastConsume : 0
             * EM_TipTimesConsume : 0
             * EM_TipComboConsume : 1
             * EM_TipTimingConsume : 0
             * EM_TipHouseConsume : 0
             */

            private String GID;
            private String SM_GID;
            private Object CY_GID;
            private String DM_GID;
            private String EM_Code;
            private String EM_Name;
            private int EM_Sex;
            private String EM_Phone;
            private String EM_Addr;
            private String EM_Remark;
            private String EM_UpdateTime;
            private String EM_Creator;
            private Object EM_Birthday;
            private String SM_Name;
            private String DM_Name;
            private int EM_TipCard;
            private int EM_TipRecharge;
            private int EM_TipChargeTime;
            private int EM_TipGoodsConsume;
            private int EM_TipFastConsume;
            private int EM_TipTimesConsume;
            private int EM_TipComboConsume;
            private int EM_TipTimingConsume;
            private int EM_TipHouseConsume;

            public boolean isCheck() {
                return isCheck;
            }

            public void setCheck(boolean check) {
                isCheck = check;
            }

            private boolean isCheck;

            public String getGID() {
                return GID;
            }

            public void setGID(String GID) {
                this.GID = GID;
            }

            public String getSM_GID() {
                return SM_GID;
            }

            public void setSM_GID(String SM_GID) {
                this.SM_GID = SM_GID;
            }

            public Object getCY_GID() {
                return CY_GID;
            }

            public void setCY_GID(Object CY_GID) {
                this.CY_GID = CY_GID;
            }

            public String getDM_GID() {
                return DM_GID;
            }

            public void setDM_GID(String DM_GID) {
                this.DM_GID = DM_GID;
            }

            public String getEM_Code() {
                return EM_Code;
            }

            public void setEM_Code(String EM_Code) {
                this.EM_Code = EM_Code;
            }

            public String getEM_Name() {
                return EM_Name;
            }

            public void setEM_Name(String EM_Name) {
                this.EM_Name = EM_Name;
            }

            public int getEM_Sex() {
                return EM_Sex;
            }

            public void setEM_Sex(int EM_Sex) {
                this.EM_Sex = EM_Sex;
            }

            public String getEM_Phone() {
                return EM_Phone;
            }

            public void setEM_Phone(String EM_Phone) {
                this.EM_Phone = EM_Phone;
            }

            public String getEM_Addr() {
                return EM_Addr;
            }

            public void setEM_Addr(String EM_Addr) {
                this.EM_Addr = EM_Addr;
            }

            public String getEM_Remark() {
                return EM_Remark;
            }

            public void setEM_Remark(String EM_Remark) {
                this.EM_Remark = EM_Remark;
            }

            public String getEM_UpdateTime() {
                return EM_UpdateTime;
            }

            public void setEM_UpdateTime(String EM_UpdateTime) {
                this.EM_UpdateTime = EM_UpdateTime;
            }

            public String getEM_Creator() {
                return EM_Creator;
            }

            public void setEM_Creator(String EM_Creator) {
                this.EM_Creator = EM_Creator;
            }

            public Object getEM_Birthday() {
                return EM_Birthday;
            }

            public void setEM_Birthday(Object EM_Birthday) {
                this.EM_Birthday = EM_Birthday;
            }

            public String getSM_Name() {
                return SM_Name;
            }

            public void setSM_Name(String SM_Name) {
                this.SM_Name = SM_Name;
            }

            public String getDM_Name() {
                return DM_Name;
            }

            public void setDM_Name(String DM_Name) {
                this.DM_Name = DM_Name;
            }

            public int getEM_TipCard() {
                return EM_TipCard;
            }

            public void setEM_TipCard(int EM_TipCard) {
                this.EM_TipCard = EM_TipCard;
            }

            public int getEM_TipRecharge() {
                return EM_TipRecharge;
            }

            public void setEM_TipRecharge(int EM_TipRecharge) {
                this.EM_TipRecharge = EM_TipRecharge;
            }

            public int getEM_TipChargeTime() {
                return EM_TipChargeTime;
            }

            public void setEM_TipChargeTime(int EM_TipChargeTime) {
                this.EM_TipChargeTime = EM_TipChargeTime;
            }

            public int getEM_TipGoodsConsume() {
                return EM_TipGoodsConsume;
            }

            public void setEM_TipGoodsConsume(int EM_TipGoodsConsume) {
                this.EM_TipGoodsConsume = EM_TipGoodsConsume;
            }

            public int getEM_TipFastConsume() {
                return EM_TipFastConsume;
            }

            public void setEM_TipFastConsume(int EM_TipFastConsume) {
                this.EM_TipFastConsume = EM_TipFastConsume;
            }

            public int getEM_TipTimesConsume() {
                return EM_TipTimesConsume;
            }

            public void setEM_TipTimesConsume(int EM_TipTimesConsume) {
                this.EM_TipTimesConsume = EM_TipTimesConsume;
            }

            public int getEM_TipComboConsume() {
                return EM_TipComboConsume;
            }

            public void setEM_TipComboConsume(int EM_TipComboConsume) {
                this.EM_TipComboConsume = EM_TipComboConsume;
            }

            public int getEM_TipTimingConsume() {
                return EM_TipTimingConsume;
            }

            public void setEM_TipTimingConsume(int EM_TipTimingConsume) {
                this.EM_TipTimingConsume = EM_TipTimingConsume;
            }

            public int getEM_TipHouseConsume() {
                return EM_TipHouseConsume;
            }

            public void setEM_TipHouseConsume(int EM_TipHouseConsume) {
                this.EM_TipHouseConsume = EM_TipHouseConsume;
            }
        }

        public static class DepartmentListBean implements Serializable {
            /**
             * GID : 506400d2-dd4c-45a3-8c8e-ab964a8c3cf6
             * CY_GID : null
             * DM_Name : 营销
             * DM_Remark :
             * DM_UpdateTime : 2018-06-29 16:07:23
             * DM_Creator : 1058346971@qq.com
             */

            private String GID;
            private Object CY_GID;
            private String DM_Name;
            private String DM_Remark;
            private String DM_UpdateTime;
            private String DM_Creator;

            public boolean isCheck() {
                return check;
            }

            public void setCheck(boolean check) {
                this.check = check;
            }

            private boolean check;

            public String getGID() {
                return GID;
            }

            public void setGID(String GID) {
                this.GID = GID;
            }

            public Object getCY_GID() {
                return CY_GID;
            }

            public void setCY_GID(Object CY_GID) {
                this.CY_GID = CY_GID;
            }

            public String getDM_Name() {
                return DM_Name;
            }

            public void setDM_Name(String DM_Name) {
                this.DM_Name = DM_Name;
            }

            public String getDM_Remark() {
                return DM_Remark;
            }

            public void setDM_Remark(String DM_Remark) {
                this.DM_Remark = DM_Remark;
            }

            public String getDM_UpdateTime() {
                return DM_UpdateTime;
            }

            public void setDM_UpdateTime(String DM_UpdateTime) {
                this.DM_UpdateTime = DM_UpdateTime;
            }

            public String getDM_Creator() {
                return DM_Creator;
            }

            public void setDM_Creator(String DM_Creator) {
                this.DM_Creator = DM_Creator;
            }
        }

        public static class ShopListBean implements Serializable {
            /**
             * SM_DefaultCode : null
             * GID : 4a7b1141-8ca3-4bef-961f-ffd153357823
             * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
             * SM_Name : jll2
             * SM_Contacter : 6545646
             * SM_Phone : 18328578333
             * SM_Addr :
             * SM_Remark :
             * SM_State : 0
             * SM_UpdateTime : 2019-01-22 11:12:08
             * SM_Picture : /img/head.png
             * SM_Creator : 1058346971@qq.com
             * SM_XLong : null
             * SM_YLat : null
             * SM_Industry : 汽车美容
             * SM_Range :
             * SM_Country : null
             * SM_Province : 四川省
             * SM_Disctrict : 龙泉驿区
             * SM_DetailAddr :
             * SM_MapAddr : null
             * SM_UpdateState : 1
             * SM_AcountNum : 10
             * SM_Type : 15
             * SM_EndTime : 2023-11-19 13:55:18
             * SM_CreateTime : 2018-06-29 15:45:53
             * SM_City : 中国
             * VipNumber : 0
             * ProNumber : 0
             * SM_IndustryType : 100
             * SaoBei_State : 0
             * SaoBei_Message : null
             */

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
        }

        public static class DeductRuleBean implements Serializable {
            /**
             * SS_CouponPayValue : 0.0
             * SS_CouponPayUnit : %
             * SS_GoodOrCombo : 0
             * SS_GoodTypeGID : 000000
             * SS_GoodTypeName : 所有分类
             * GID : e88178a3-42dc-43e3-8ed9-1a80c389729a
             * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
             * SS_Type : 10
             * SS_ProductGID : 000000
             * SS_ProductName : 所有产品
             * SS_GradeGID : 000002
             * SS_GradeName : 会员
             * SS_ShopGID : 000000
             * SS_ShopName : 所有店铺
             * SS_DepartmentGID : 000000
             * SS_DepartmentName : 所有部门
             * SS_Mode : 10
             * SS_Value : 10.0
             * SS_Unit : %
             * SS_BalancePayValue : 0.0
             * SS_BalancePayUnit : %
             * SS_PointPayValue : 0.0
             * SS_PointPayUnit : %
             * SS_OtherPayValue : 0.0
             * SS_OtherPayUnit : %
             * SS_Remark :
             * SS_UpdateTime : 2018-06-29 16:03:35
             */

            private double SS_CouponPayValue;
            private String SS_CouponPayUnit;
            private int SS_GoodOrCombo;
            private String SS_GoodTypeGID;
            private String SS_GoodTypeName;
            private String GID;
            private String CY_GID;
            private int SS_Type;
            private String SS_ProductGID;
            private String SS_ProductName;
            private String SS_GradeGID;
            private String SS_GradeName;
            private String SS_ShopGID;
            private String SS_ShopName;
            private String SS_DepartmentGID;
            private String SS_DepartmentName;
            private int SS_Mode;
            private double SS_Value;
            private String SS_Unit;
            private double SS_BalancePayValue;
            private String SS_BalancePayUnit;
            private double SS_PointPayValue;
            private String SS_PointPayUnit;
            private double SS_OtherPayValue;
            private String SS_OtherPayUnit;
            private String SS_Remark;
            private String SS_UpdateTime;

            public double getSS_CouponPayValue() {
                return SS_CouponPayValue;
            }

            public void setSS_CouponPayValue(double SS_CouponPayValue) {
                this.SS_CouponPayValue = SS_CouponPayValue;
            }

            public String getSS_CouponPayUnit() {
                return SS_CouponPayUnit;
            }

            public void setSS_CouponPayUnit(String SS_CouponPayUnit) {
                this.SS_CouponPayUnit = SS_CouponPayUnit;
            }

            public int getSS_GoodOrCombo() {
                return SS_GoodOrCombo;
            }

            public void setSS_GoodOrCombo(int SS_GoodOrCombo) {
                this.SS_GoodOrCombo = SS_GoodOrCombo;
            }

            public String getSS_GoodTypeGID() {
                return SS_GoodTypeGID;
            }

            public void setSS_GoodTypeGID(String SS_GoodTypeGID) {
                this.SS_GoodTypeGID = SS_GoodTypeGID;
            }

            public String getSS_GoodTypeName() {
                return SS_GoodTypeName;
            }

            public void setSS_GoodTypeName(String SS_GoodTypeName) {
                this.SS_GoodTypeName = SS_GoodTypeName;
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

            public int getSS_Type() {
                return SS_Type;
            }

            public void setSS_Type(int SS_Type) {
                this.SS_Type = SS_Type;
            }

            public String getSS_ProductGID() {
                return SS_ProductGID;
            }

            public void setSS_ProductGID(String SS_ProductGID) {
                this.SS_ProductGID = SS_ProductGID;
            }

            public String getSS_ProductName() {
                return SS_ProductName;
            }

            public void setSS_ProductName(String SS_ProductName) {
                this.SS_ProductName = SS_ProductName;
            }

            public String getSS_GradeGID() {
                return SS_GradeGID;
            }

            public void setSS_GradeGID(String SS_GradeGID) {
                this.SS_GradeGID = SS_GradeGID;
            }

            public String getSS_GradeName() {
                return SS_GradeName;
            }

            public void setSS_GradeName(String SS_GradeName) {
                this.SS_GradeName = SS_GradeName;
            }

            public String getSS_ShopGID() {
                return SS_ShopGID;
            }

            public void setSS_ShopGID(String SS_ShopGID) {
                this.SS_ShopGID = SS_ShopGID;
            }

            public String getSS_ShopName() {
                return SS_ShopName;
            }

            public void setSS_ShopName(String SS_ShopName) {
                this.SS_ShopName = SS_ShopName;
            }

            public String getSS_DepartmentGID() {
                return SS_DepartmentGID;
            }

            public void setSS_DepartmentGID(String SS_DepartmentGID) {
                this.SS_DepartmentGID = SS_DepartmentGID;
            }

            public String getSS_DepartmentName() {
                return SS_DepartmentName;
            }

            public void setSS_DepartmentName(String SS_DepartmentName) {
                this.SS_DepartmentName = SS_DepartmentName;
            }

            public int getSS_Mode() {
                return SS_Mode;
            }

            public void setSS_Mode(int SS_Mode) {
                this.SS_Mode = SS_Mode;
            }

            public double getSS_Value() {
                return SS_Value;
            }

            public void setSS_Value(double SS_Value) {
                this.SS_Value = SS_Value;
            }

            public String getSS_Unit() {
                return SS_Unit;
            }

            public void setSS_Unit(String SS_Unit) {
                this.SS_Unit = SS_Unit;
            }

            public double getSS_BalancePayValue() {
                return SS_BalancePayValue;
            }

            public void setSS_BalancePayValue(double SS_BalancePayValue) {
                this.SS_BalancePayValue = SS_BalancePayValue;
            }

            public String getSS_BalancePayUnit() {
                return SS_BalancePayUnit;
            }

            public void setSS_BalancePayUnit(String SS_BalancePayUnit) {
                this.SS_BalancePayUnit = SS_BalancePayUnit;
            }

            public double getSS_PointPayValue() {
                return SS_PointPayValue;
            }

            public void setSS_PointPayValue(double SS_PointPayValue) {
                this.SS_PointPayValue = SS_PointPayValue;
            }

            public String getSS_PointPayUnit() {
                return SS_PointPayUnit;
            }

            public void setSS_PointPayUnit(String SS_PointPayUnit) {
                this.SS_PointPayUnit = SS_PointPayUnit;
            }

            public double getSS_OtherPayValue() {
                return SS_OtherPayValue;
            }

            public void setSS_OtherPayValue(double SS_OtherPayValue) {
                this.SS_OtherPayValue = SS_OtherPayValue;
            }

            public String getSS_OtherPayUnit() {
                return SS_OtherPayUnit;
            }

            public void setSS_OtherPayUnit(String SS_OtherPayUnit) {
                this.SS_OtherPayUnit = SS_OtherPayUnit;
            }

            public String getSS_Remark() {
                return SS_Remark;
            }

            public void setSS_Remark(String SS_Remark) {
                this.SS_Remark = SS_Remark;
            }

            public String getSS_UpdateTime() {
                return SS_UpdateTime;
            }

            public void setSS_UpdateTime(String SS_UpdateTime) {
                this.SS_UpdateTime = SS_UpdateTime;
            }
        }

        public static class ActiveBean implements Serializable {
            /**
             * RP_Discount : 9.99
             * RP_IsOpen : 1
             * GID : b852626a-002f-4cdc-a3fb-f7d56a9848fe
             * RP_Name : 3213
             * RP_Type : 2
             * RP_RechargeMoney : 3211.0
             * RP_GiveMoney : -1.0
             * RP_GivePoint : 10
             * RP_ReduceMoney : -1.0
             * RP_ValidType : 0
             * RP_ValidWeekMonth :
             * RP_ValidStartTime : null
             * RP_ValidEndTime : null
             * RP_ISDouble : 0
             * RP_Creator : 销售001
             * RP_CreateTime : 2018-11-16 10:36:59
             * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
             * RP_Remark : null
             */

            private double RP_Discount;
            private int RP_IsOpen;
            private String GID;
            private String RP_Name;
            private int RP_Type;
            private double RP_RechargeMoney;
            private double RP_GiveMoney;
            private int RP_GivePoint;
            private double RP_ReduceMoney;
            private int RP_ValidType;
            private String RP_ValidWeekMonth;
            private Object RP_ValidStartTime;
            private Object RP_ValidEndTime;
            private int RP_ISDouble;
            private String RP_Creator;
            private String RP_CreateTime;
            private String CY_GID;
            private Object RP_Remark;

            public double getRP_Discount() {
                return RP_Discount;
            }

            public void setRP_Discount(double RP_Discount) {
                this.RP_Discount = RP_Discount;
            }

            public int getRP_IsOpen() {
                return RP_IsOpen;
            }

            public void setRP_IsOpen(int RP_IsOpen) {
                this.RP_IsOpen = RP_IsOpen;
            }

            public String getGID() {
                return GID;
            }

            public void setGID(String GID) {
                this.GID = GID;
            }

            public String getRP_Name() {
                return RP_Name;
            }

            public void setRP_Name(String RP_Name) {
                this.RP_Name = RP_Name;
            }

            public int getRP_Type() {
                return RP_Type;
            }

            public void setRP_Type(int RP_Type) {
                this.RP_Type = RP_Type;
            }

            public double getRP_RechargeMoney() {
                return RP_RechargeMoney;
            }

            public void setRP_RechargeMoney(double RP_RechargeMoney) {
                this.RP_RechargeMoney = RP_RechargeMoney;
            }

            public double getRP_GiveMoney() {
                return RP_GiveMoney;
            }

            public void setRP_GiveMoney(double RP_GiveMoney) {
                this.RP_GiveMoney = RP_GiveMoney;
            }

            public int getRP_GivePoint() {
                return RP_GivePoint;
            }

            public void setRP_GivePoint(int RP_GivePoint) {
                this.RP_GivePoint = RP_GivePoint;
            }

            public double getRP_ReduceMoney() {
                return RP_ReduceMoney;
            }

            public void setRP_ReduceMoney(double RP_ReduceMoney) {
                this.RP_ReduceMoney = RP_ReduceMoney;
            }

            public int getRP_ValidType() {
                return RP_ValidType;
            }

            public void setRP_ValidType(int RP_ValidType) {
                this.RP_ValidType = RP_ValidType;
            }

            public String getRP_ValidWeekMonth() {
                return RP_ValidWeekMonth;
            }

            public void setRP_ValidWeekMonth(String RP_ValidWeekMonth) {
                this.RP_ValidWeekMonth = RP_ValidWeekMonth;
            }

            public Object getRP_ValidStartTime() {
                return RP_ValidStartTime;
            }

            public void setRP_ValidStartTime(Object RP_ValidStartTime) {
                this.RP_ValidStartTime = RP_ValidStartTime;
            }

            public Object getRP_ValidEndTime() {
                return RP_ValidEndTime;
            }

            public void setRP_ValidEndTime(Object RP_ValidEndTime) {
                this.RP_ValidEndTime = RP_ValidEndTime;
            }

            public int getRP_ISDouble() {
                return RP_ISDouble;
            }

            public void setRP_ISDouble(int RP_ISDouble) {
                this.RP_ISDouble = RP_ISDouble;
            }

            public String getRP_Creator() {
                return RP_Creator;
            }

            public void setRP_Creator(String RP_Creator) {
                this.RP_Creator = RP_Creator;
            }

            public String getRP_CreateTime() {
                return RP_CreateTime;
            }

            public void setRP_CreateTime(String RP_CreateTime) {
                this.RP_CreateTime = RP_CreateTime;
            }

            public String getCY_GID() {
                return CY_GID;
            }

            public void setCY_GID(String CY_GID) {
                this.CY_GID = CY_GID;
            }

            public Object getRP_Remark() {
                return RP_Remark;
            }

            public void setRP_Remark(Object RP_Remark) {
                this.RP_Remark = RP_Remark;
            }
        }
    }
}
