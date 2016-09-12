package com.erya.base;

public class Rectangle {
	public Rectangle(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Rectangle(String info) {
		super();
		String[] xy = info.split(",");
		this.x = Integer.valueOf(xy[0]);
		this.y = Integer.valueOf(xy[1]);
	}

	public void add(int x, int y) {
		this.x += x;
		this.y += y;
	}

	public int x;
	public int y;

	@Override
	public String toString() {
		return x + "," + y;
	}

}
