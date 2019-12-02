package com.wycd.yushangpu.tools;

import com.wycd.yushangpu.bean.Home;

import java.util.Comparator;



public class PinyinComparator implements Comparator<Home> {

	@Override
	public int compare(Home lhs, Home rhs) {
		// TODO Auto-generated method stub
		return sort(lhs, rhs);
	}

	private int sort(Home lhs, Home rhs) {
		// 获取ascii值
		int lhs_ascii = lhs.FirstPinYin.toUpperCase().charAt(0);
		int rhs_ascii = rhs.FirstPinYin.toUpperCase().charAt(0);

//		Log.d("xxx",lhs_ascii+";"+rhs_ascii+";"+lhs.getFirstPinYin()+";"+rhs.getFirstPinYin());

		// 判断若不是字母，则排在字母之后
		if (lhs_ascii < 65 || lhs_ascii > 90)
			return 1;
		else if (rhs_ascii < 65 || rhs_ascii > 90)
			return -1;
		else
			return lhs.PinYin.compareTo(rhs.PinYin);
	}


}
