package com.biz.bank.service;

import java.util.Scanner;

import com.biz.bank.domain.BankAccVO;

public interface BankAccService {
	//public BankAccServiceV1(String strNum, int intBalance);
	//public BankAccServiceV1(BankAccVO bankAccVO, Scanner scanner);
	public boolean viewAcc() throws Exception;
	public void input() throws Exception;
	public void output() throws Exception;
	public void writeAccBook(String strBookFile) throws Exception;
}
