package com.biz.bank.service;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.biz.bank.domain.BankAccVO;

public class BankAccServiceImpV2 implements BankAccService {
	Map<String, BankAccVO> bankList;
	BankAccVO bankAccVO;
	Scanner scanner;
	
	public BankAccServiceImpV2() {
		super();
		// TODO Auto-generated constructor stub
		bankList=new TreeMap<String, BankAccVO>();
		scanner=new Scanner(System.in);
		for(int i=0;i<10;i++) {
			String strNum=String.format("%04d", i+1);
			BankAccVO bVO=new BankAccVO();
			bVO.setNum(strNum);
			bVO.setBalance(100000);
			bVO.setLastDate("2019-09-20");
			bVO.setRemark("신규");
			bankList.put(strNum, bVO);
		}
	}
	
	public BankAccServiceImpV2(Map<String, BankAccVO> bankList) {
		super();
		this.bankList = bankList;
	}

	@Override
	public boolean viewAcc() throws Exception {
		// TODO Auto-generated method stub
		System.out.print("계좌번호>>");
		String strNum=scanner.nextLine();
		bankAccVO=bankList.get(strNum);
		if(bankAccVO==null) {
			System.out.println("계좌정보 없음!!");
			return false;
		}
		System.out.println("===========================");
		System.out.println("계좌번호:"+bankAccVO.getNum());
		System.out.println("최종잔액:"+bankAccVO.getBalance());
		System.out.println("최종거래:"+bankAccVO.getLastDate());
		System.out.println("비고:"+bankAccVO.getRemark());
		System.out.println("===================================");
		return true;
	}

	@Override
	public void input() throws Exception {
		// TODO Auto-generated method stub
		viewAcc();
		if(bankAccVO==null) {
			return;
		}
		System.out.print("입금액>>");
		String strInputString=scanner.nextLine();
		int intInput=Integer.valueOf(strInputString);
		
		int intBalance=bankAccVO.getBalance();
		intBalance+=intInput;
		bankAccVO.setBalance(intBalance);
		bankAccVO.setRemark("입금");
		
		Date date=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		String strLastDate=sd.format(date);
		bankAccVO.setLastDate(strLastDate);
	}

	@Override
	public void output() throws Exception {
		// TODO Auto-generated method stub
		viewAcc();
		if(bankAccVO==null) {
			return;
		}
		System.out.print("출금액>>");
		String strOutput=scanner.nextLine();
		int intOutput=Integer.valueOf(strOutput);
		int intBalance=bankAccVO.getBalance();
		if(intBalance<intOutput) {
			System.out.println("잔액부족 출금불가!!");
			return;
		}
		intBalance-=intOutput;
		bankAccVO.setBalance(intBalance);
		bankAccVO.setRemark("출금");
		
		Date date=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		String strLastDate=sd.format(date);
		bankAccVO.setLastDate(strLastDate);
	}
	public void writeAccBook(String strBookFile) throws Exception{
		FileWriter fw;
		PrintWriter printWriter;
		fw=new FileWriter(strBookFile);
		printWriter=new PrintWriter(fw);
		
		Set<String> keys=bankList.keySet();
		for(String key:keys) {
			bankAccVO=bankList.get(key);
			printWriter.write(String.format("%s:%d:%s:%s\n",bankAccVO.getNum(),bankAccVO.getBalance(),bankAccVO.getLastDate(),bankAccVO.getRemark()));
			printWriter.flush();
		}
		printWriter.close();
	}

}
