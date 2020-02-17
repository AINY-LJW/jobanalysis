package com.comment.common.intf;

public enum SalaryEnum {
	ONE(0, "1-2000"),
	TWO(1, "2000-4000"),
	THREE(2, "4000-6000"),
	FORE(3, "6000-8000"),
	FIVE(4, "8000-10000"),
	SIX(5, "10000-20000"),
	SEVEN(6, "20000以上"),;
	private int value;
	
	private String title;

	private SalaryEnum(int value, String title) {
		this.value = value;
		this.title = title;
	}
	/**
	 * 根据int获取值
	 * TODO
	 * @param 
	 * @return String
	 */
	public static String getTitle(int code) {
		for (SalaryEnum en : values()) {
			if (en.getValue() == code) {
				return en.getTitle();
			}
		}
		return null;
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
