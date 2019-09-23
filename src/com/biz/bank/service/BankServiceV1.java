package com.biz.bank.service;

import java.util.Scanner;

public class BankServiceV1 {
	Scanner scanner=null;
	int intBalance=0;
	String strAccNum;
	
	public BankServiceV1() {
		super();
		// TODO Auto-generated constructor stub
		scanner=new Scanner(System.in);
	}
	

	public BankServiceV1(String strAccNum,  int intBalance) {
		super();
		this.intBalance = intBalance;
		this.strAccNum = strAccNum;
		scanner=new Scanner(System.in);
	}


	public boolean viewAcc() {
		System.out.print("계좌번호>>");
		String strAccKeyIn=scanner.nextLine();
		if(!strAccKeyIn.equalsIgnoreCase(strAccNum)) {
			return false;
		}
		System.out.println("=================================");
		System.out.printf("계좌번회 %s",strAccNum);
		System.out.printf("잔고:%d\n",intBalance);
		System.out.println("==================================");
		return true;
	}
	public void input() throws NumberFormatException{
		boolean bStatus=viewAcc();
		if(bStatus==false) { System.out.println("입금처리 불가");return;}
		
		System.out.println("입금처리");
		System.out.println("===================================");
		System.out.print("입금액>>");
		String strInput=scanner.nextLine();
		int intInput=Integer.valueOf(strInput);
		intBalance+=intInput;
		
	}
	public void output() throws NumberFormatException{
		boolean bStatus=viewAcc();
		if(bStatus==false) {System.out.println("출금처리 불가");return;}
		
		System.out.println("출금처리");
		System.out.println("====================================");
		System.out.print("출금액>>");
		String strOutput=scanner.nextLine();
		int intOutput=Integer.valueOf(strOutput);
		if(intBalance>=intOutput) {
			intBalance-=intOutput;
		}else {
			System.out.println("잔액부족!! 출금거부!!");
		}
		
	}
}
