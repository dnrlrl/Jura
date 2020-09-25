package model;

import java.sql.Date;

public class Customer {
	private String c_id;
	private String c_pass;
	private String c_name;
	private int add_num;
	private String c_address;
	private String c_tel;
	private String del;
	private Date joindate;
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_pass() {
		return c_pass;
	}
	public void setC_pass(String c_pass) {
		this.c_pass = c_pass;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public int getAdd_num() {
		return add_num;
	}
	public void setAdd_num(int add_num) {
		this.add_num = add_num;
	}
	public String getC_address() {
		return c_address;
	}
	public void setC_address(String c_address) {
		this.c_address = c_address;
	}
	public String getC_tel() {
		return c_tel;
	}
	public void setC_tel(String c_tel) {
		this.c_tel = c_tel;
	}

	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	
}
