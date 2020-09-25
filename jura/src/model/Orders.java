package model;

import java.sql.Date;

public class Orders {
	private int o_num;
	private String c_id;
	private String o_add;
	private String o_how;
	private Date date;
	private int o_price;
	private String o_sta;
	public int getO_num() {
		return o_num;
	}
	public void setO_num(int o_num) {
		this.o_num = o_num;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getO_add() {
		return o_add;
	}
	public void setO_add(String o_add) {
		this.o_add = o_add;
	}
	
	public String getO_how() {
		return o_how;
	}
	public void setO_how(String o_how) {
		this.o_how = o_how;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getO_price() {
		return o_price;
	}
	public void setO_price(int o_price) {
		this.o_price = o_price;
	}
	public String getO_sta() {
		return o_sta;
	}
	public void setO_sta(String o_sta) {
		this.o_sta = o_sta;
	}
	
	
}
