package com.finanzen.enums;

public enum ExpenseType {	
	
    DELIVERY("delivery"),
    HOME("home"),
    ONLINE_SHIPPING("onlineShopping"),
    OTHERS("others"),
    OUTINGS("outings"),
    SPORT("sport"),
    STREAMING("streaming"),
    STUDY("study"),
    SUPERMARKET("supermarket"),
    TRANSPORT("transport"),
    VIDEOGAMES("videogames");

	private String value;
	
    private ExpenseType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

