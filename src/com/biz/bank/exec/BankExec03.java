package com.biz.bank.exec;

import java.util.Scanner;

import com.biz.bank.service.BankAccService;

public class BankExec03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccService bs=null;
		Scanner scanner=new Scanner(System.in);
		int intBalance=100_000;
		String strAccNum="0001";
		
		bs=new BankAccService(strAccNum,intBalance);
		while(true) {
			System.out.println("===================================");
			System.out.println("test 은행 V1");
			System.out.println("===================================");
			System.out.println("1.조회 2.입금 3.출금 0.종료");
			System.out.println("===================================");
			System.out.print("선택>>");
			String strMenu=scanner.nextLine();
			int intMenu=Integer.valueOf(strMenu);
			switch (intMenu) {
			case 1:
				System.out.println("계좌조회");
				bs.viewAcc();
				break;
			case 2:
				System.out.println("입금처리");
				bs.input();
				break;
			case 3:
				System.out.println("출금처리");
				bs.output();
				break;
			case 0:
				System.out.println("업무종료");
				return;
			default:
				System.out.println("메뉴선택을 잘못하셨습니다.");
				break;
			}
		}
	}

}
