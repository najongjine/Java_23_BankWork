package com.biz.bank.exec;

import java.util.Scanner;

public class BankExec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int intBalance=100_000;
		String strAccNum="0001";
		
		System.out.println("===================================");
		System.out.println("광한루 은행");
		System.out.println("===================================");
		System.out.println("1.조회 2.입금 3.출금 0.종료");
		System.out.println("===================================");
		System.out.print("선택>>");
		String strMenu=scanner.nextLine();
		int intMenu=Integer.valueOf(strMenu);
		
		if(intMenu==0) {
			System.out.println("업무종료");
			return;
		}
		else if(intMenu==1) {
			System.out.println("계좌조회");
			/*
			 * 1. 계좌번호 입력받기
			 * 2.일치하는 계좌내역 보여주기
			 */
			System.out.print("계좌번호>>");
			String strAccKeyIn=scanner.nextLine();
			if(strAccKeyIn.equalsIgnoreCase(strAccNum)) {
				System.out.println("=================================");
				System.out.printf("계좌번회 %s",strAccNum);
				System.out.printf("잔고:%d\n",intBalance);
				System.out.println("==================================");
			}else {
				System.out.println("계좌 번호가 없습니다!!");
			}
		}
		else if(intMenu==3) {
			System.out.println("입금처리");
			System.out.print("계좌번호>>");
			String strAccKeyIn=scanner.nextLine();
			if(strAccKeyIn.equalsIgnoreCase(strAccNum)) {
				System.out.println("=================================");
				System.out.printf("계좌번회 %s",strAccNum);
				System.out.printf("잔고:%d\n",intBalance);
				System.out.println("==================================");
				System.out.print("입금액>>");
				String strInput=scanner.nextLine();
				int intInput=Integer.valueOf(strInput);
				intBalance+=intInput;
			}else {
				System.out.println("계좌 번호가 없습니다!!");
			}
		}
		else if(intMenu==3) {
			System.out.println("출금처리");
			System.out.print("계좌번호>>");
			String strAccKeyIn=scanner.nextLine();
			if(strAccKeyIn.equalsIgnoreCase(strAccNum)) {
				System.out.println("=================================");
				System.out.printf("계좌번회 %s",strAccNum);
				System.out.printf("잔고:%d\n",intBalance);
				System.out.println("==================================");
				System.out.print("출금액>>");
				String strOutput=scanner.nextLine();
				int intOutput=Integer.valueOf(strOutput);
				if(intBalance>=intOutput) {
					intBalance-=intOutput;
				}else {
					System.out.println("잔액부족!! 출금불가!!");
				}
			}else {
				System.out.println("계좌 번호가 없습니다!!");
			}
		}
	}

}
