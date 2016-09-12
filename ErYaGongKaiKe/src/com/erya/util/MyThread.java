package com.erya.util;

/**
 * Thread
 * 
 * @author 戴贵茂
 * @version 1.0
 * @create date 2014-3-13 下午10:01:04
 */
public class MyThread {
	public static void sleep(long time) {
		try {
			java.lang.Thread.sleep(time);
		} catch (Exception e) {
		}
	}
}
