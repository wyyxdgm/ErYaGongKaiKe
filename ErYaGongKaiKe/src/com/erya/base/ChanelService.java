package com.erya.base;

import java.util.List;
import java.util.Map;

import com.erya.ctr.MouseController;
import com.erya.util.MyThread;
import com.erya.util.ReadFileToObjects;

public class ChanelService {
	public static final String CHANEL_01 = "GOON_01";
	public static final String CHANEL_02 = "GOON_02";
	public static final String CHANEL_03 = "GOON_03";
	public static final String CHANEL_04 = "GOON_04";
	public static final String BAR_TOP = "BAR_TOP";
	public static final String BAR_DOWN = "BAR_DOWN";
	public static final String BAR_TOP2 = "BAR_TOP2";
	public static final String BAR_DOWN2 = "BAR_DOWN2";
	public static final String EXIT = "EXIT";
	public static final String MYDUTY = "MYDUTY";
	private static Map<String, String> res;
	static {
		ReadFileToObjects rfto = new ReadFileToObjects("data\\positions.txt",
				true, false);
		ChanelService.res = rfto.MapFromFile();
	}

	public static void doChanels(List<String> chanels) {
		while (true) {
			int line = 0;
			for (String chanel : chanels) {
				line++;
				if (chanel.equals("1")) {
					System.out.println("看第一部");
					dochanel(ChanelService.res.get(ChanelService.CHANEL_01));
				} else if (chanel.equals("2")) {
					System.out.println("看第二部");
					dochanel(ChanelService.res.get(ChanelService.CHANEL_02));
				} else if (chanel.equals("3")) {
					System.out.println("看第三部");
					dochanel(ChanelService.res.get(ChanelService.CHANEL_03));
				} else if (chanel.equals("4")) {
					MouseController.Drag(new Rectangle(res.get(BAR_TOP)),
							new Rectangle(res.get(BAR_DOWN)));
					System.out.println("看第四部");
					dochanel(ChanelService.res.get(ChanelService.CHANEL_04));
				} else {
					System.out.println("第" + line
							+ "行出错！(请输入1到4之间的整数，且每个数占一行！)");
				}
			}
		}
	}

	private static void dochanel(String recInfo) {
		// System.out.println(recInfo);
		MouseController.Click(MouseController.left, new Rectangle(recInfo));
		MyThread.sleep(5 * 1000 * 60);
		doMyDuty();
		MyThread.sleep(5 * 1000);
	}

	public static void exit() {
		System.out.println("退出");
		// System.out.println(ChanelService.res.get(ChanelService.EXIT));
		MouseController.Click(MouseController.left, new Rectangle(
				ChanelService.res.get(ChanelService.EXIT)));

	}

	private static void doMyDuty() {
		// 上移
		MouseController.Drag(new Rectangle(res.get(BAR_DOWN2)), new Rectangle(
				res.get(BAR_TOP2)));
		System.out.println("选择我的任务");
		// System.out.println(ChanelService.res.get(ChanelService.MYDUTY));
		MouseController.Click(MouseController.left, new Rectangle(
				ChanelService.res.get(ChanelService.MYDUTY)));
	}
}
