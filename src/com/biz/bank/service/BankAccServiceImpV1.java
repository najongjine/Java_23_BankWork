package com.biz.bank.service;

import java.util.Scanner;

import com.biz.bank.domain.BankAccVO;

public class BankAccServiceImpV1 implements BankAccService{
	BankAccVO bankAccVO;
	Scanner scanner;

	public BankAccServiceImpV1(String strNum, int intBalance) {
		super();
		// TODO Auto-generated constructor stub
		bankAccVO=new BankAccVO();
		scanner=new Scanner(System.in);
		bankAccVO.setNum(strNum);
		bankAccVO.setBalance(intBalance);
	}
	
	public BankAccServiceImpV1(BankAccVO bankAccVO, Scanner scanner) {
		super();
		this.bankAccVO = bankAccVO;
		this.scanner = scanner;
	}

	public boolean viewAcc() {
		System.out.print("계좌번호>>");
		String strAccNum=scanner.nextLine();
		if(!strAccNum.equalsIgnoreCase(bankAccVO.getNum())) {
			System.out.println("계좌번호가 오류!!");
			return false;
		}
		System.out.println("===================");
		System.out.println("계좌번호:"+bankAccVO.getNum());
		System.out.println("최종잔액:"+bankAccVO.getBalance());
		System.out.println("최종거래:"+bankAccVO.getLastDate());
		System.out.println("비고:"+bankAccVO.getRemark());
		System.out.println("===================");
		return true;
	}
	public void input() {
		if(!viewAcc()) {//계좌번호가 없으면 강제끝
			return;
		}
		System.out.print("입금액>>");
		String strInput=scanner.nextLine();
		int intInput=Integer.valueOf(strInput);
		bankAccVO.setBalance(bankAccVO.getBalance()+intInput);
		
	}
	public void output() {
		if(!viewAcc()) {//계좌번호가 없으면 강제끝
			return;
		}
		System.out.print("출금액>>");
		String strOutput=scanner.nextLine();
		int intOutput=Integer.valueOf(strOutput);
		if(bankAccVO.getBalance()<intOutput) {
			System.out.println("잔고부족!!");
			return;
		}
		bankAccVO.setBalance(bankAccVO.getBalance()-intOutput);
	}
}
