package com.biz.bank.domain;
/*
 * 계좌번호 String num
 * 현잔액 int balance
 * 최종거래 String lastDate
 * 거래방법 String remark
 * ----------------------------------------
 * 계좌번호	현잔액	최종거래	거래방법
 */
public class BankAccVO {
	String num;
	int balance;
	String lastDate;
	String remark;
	
	public BankAccVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BankAccVO(String num, int balance, String lastDate, String remark) {
		super();
		this.num = num;
		this.balance = balance;
		this.lastDate = lastDate;
		this.remark = remark;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
