package com.biz.bank.exec;

import java.util.Scanner;

import com.biz.bank.service.BankAccService;
import com.biz.bank.service.BankAccServiceImpV2;

public class BankAccEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccService bs=new BankAccServiceImpV2();
		Scanner scanner=new Scanner(System.in);
		String strBookFile="src/com/biz/bank/계좌원장.txt";
		
		while(true) {
			System.out.println("================================");
			System.out.println("test 은행 V2");
			System.out.println("================================");
			System.out.println("1.조회 2.입금 3.출금 0.종료");
			System.out.print("압무선택>>");
			String strMenu=scanner.nextLine();
			int intMenu=Integer.valueOf(strMenu);
			try {
				if(intMenu==0) {
					bs.writeAccBook(strBookFile);
					break;
				}
				if(intMenu==1) bs.viewAcc();
				else if(intMenu==2) bs.input();
				else if(intMenu==3)bs.output();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("업무종료");
	}

}
