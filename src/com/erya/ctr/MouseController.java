package com.erya.ctr;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import com.erya.base.Rectangle;

/**
 * 鼠标控制者
 * 
 * @author 戴贵茂
 * @version 1.0
 * @create date 2014-3-4 下午6:02:40
 * 
 */
public class MouseController {
	public static final String left = "left";
	public static final String right = "right";
	public static Robot robot;
	static {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 按下鼠标
	 */
	public static void Press(String leftRight) {
		robot.delay(50);
		if (left.equalsIgnoreCase(leftRight)) {
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		} else if (right.equalsIgnoreCase(leftRight)) {
			robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		}
		robot.delay(50);
	}

	/**
	 * 放松鼠标
	 */
	public static void Release(String leftRight) {
		robot.delay(10);
		if (left.equalsIgnoreCase(leftRight)) {
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} else if (right.equalsIgnoreCase(leftRight)) {
			robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		}
	}

	public static void Move(int left_px, int top_px) {
		robot.mouseMove(left_px, top_px);
		robot.delay(1000);// 模拟
	}

	public static void Click(String leftRight, int left_px, int top_px) {
		Move(left_px, top_px);
		Click(leftRight);
	}

	public static void Click(String leftRight, Rectangle re) {
		Move(re.x, re.y);
		Click(leftRight);
	}

	public static void HeavyClick(String leftRight, int x, int y) {
		Move(x, y);
		HeavyClick(leftRight);
	}

	public static void HeavyDoubleClick(String leftRight, int left_px,
			int top_px) {
		Move(left_px, top_px);
		HeavyClick(leftRight);
		HeavyClick(leftRight);
	}

	public static void PressAndRelease(String leftRight, long ms, int x, int y) {
		MouseController.Move(x, y);
		MouseController.Press(leftRight);
		MouseController.Press(leftRight);
		MouseController.Sleep(ms);
		MouseController.Release(leftRight);
	}

	public static void HeavyClick(String leftRight) {
		MouseController.Press(leftRight);
		MouseController.Press(leftRight);
		MouseController.Sleep(300);
		MouseController.Release(leftRight);
	}

	public static void Sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void DoubleClick(String leftRight, int left_px, int top_px) {
		Move(left_px, top_px);
		DoubleClick(leftRight);
	}

	public static void DoubleClick(String leftRight) {
		Click(leftRight);
		Click(leftRight);
	}

	public static void Delay(int ms) {
		robot.delay(ms);
	}

	public static void Click(String leftRight) {
		robot.delay(20);
		if (left.equalsIgnoreCase(leftRight)) {
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(150);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} else if (right.equalsIgnoreCase(leftRight)) {
			robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
			robot.delay(150);
			robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		}
	}

	public static void Drag(Rectangle from, Rectangle to) {
		MouseController.Move(from.x, from.y);
		robot.delay(1000);
		MouseController.Press(MouseController.left);
		MouseController.Press(MouseController.left);
		MouseController.Move(to.x, to.y);
		MouseController.Release(MouseController.left);
		MouseController.Release(MouseController.left);
		System.out.println("Drag from " + from + " to " + to);
	}

}
