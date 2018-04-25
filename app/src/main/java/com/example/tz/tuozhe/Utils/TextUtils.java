package com.example.tz.tuozhe.Utils;

public class TextUtils {
	
	public static boolean isEmpty(String src){
		if(src == null){
			return true;
		}
		if(src.trim().length() == 0){
			return true;
		}
		if ("null".equals(src)) {
			return true;
		}
		return false;
	}
	
}
