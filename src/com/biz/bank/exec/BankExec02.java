package com.biz.bank.exec;

import java.util.Scanner;

import com.biz.bank.service.BankServiceV1;

public class BankExec02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankServiceV1 bs=null;
		Scanner scanner=new Scanner(System.in);
		int intBalance=100_000;
		String strAccNum="0001";
		
		bs=new BankServiceV1(strAccNum,intBalance);
		while(true) {
			System.out.println("===================================");
			System.out.println("광한루 은행");
			System.out.println("===================================");
			System.out.println("1.조회 2.입금 3.출금 0.종료");
			System.out.println("===================================");
			System.out.print("선택>>");
			String strMenu=scanner.nextLine();
			int intMenu=Integer.valueOf(strMenu);
			if(intMenu==0) {
				System.out.println("업무 종료.");
				return;
			}
			else if(intMenu==1) {
				//계좌조회
				bs.viewAcc();
			}
			else if(intMenu==2) {
				//입금처리
				bs.input();
			}
			else if(intMenu==3) {
				//출금처리
				bs.output();
			}
		}
	}

}
