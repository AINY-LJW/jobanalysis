package com.comment.common.intf;

/**
 * 
 * 简述部分:公司规模
 *
 * @author WK
 * @version 2020年1月18日
 */
public enum CompanySizeEnum {
	ONE(1, "1-50人"),
	TWO(2, "50-100人"),
	THREE(3, "100-300人"),
	FORE(4, "300-500人"),
	FIVE(5, "500-1000人"),
	SIX(6, "1000-10000人"),
	SEVEN(7, "10000人以上"),;

	private int value;

	private String title;

	private CompanySizeEnum(int value, String title) {
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
		for (CompanySizeEnum en : values()) {
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
