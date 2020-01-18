package com.comment.common.intf;

public enum GenderEnum {
	MAN(0, "男"),
	WOMAN(1, "女"),
	UNKNOW(2, "未知"),;

	private int value;

	private String title;

	private GenderEnum(int value, String title) {
		this.value = value;
		this.title = title;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
