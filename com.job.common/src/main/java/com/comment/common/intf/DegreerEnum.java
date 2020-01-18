package com.comment.common.intf;

public enum DegreerEnum {
	ONE(0, "大专及以下(大专，中专，高中，初中，中技，职高，中职，高职)"),
	TWO(1, "本科(本科)"),
	THREE(2, "硕士及以上(硕士，博士，MBA，EMBA)"),;

	private int value;

	private String title;

	private DegreerEnum(int value, String title) {
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
		for (DegreerEnum en : values()) {
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
