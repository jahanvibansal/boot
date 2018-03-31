package com.infotech.service.impl;

import org.springframework.stereotype.Service;

import com.infotech.aop.aspect.Auditable;
import com.infotech.aop.aspect.Auditable.AuditDestination;
import com.infotech.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Auditable(AuditDestination.FILE_SYSTEM)
	@Override
	public void updateAccountBalance(Account account,Long amount){
		System.out.println("Account No:"+account.getAccountNumber()+", Amount:"+amount);
	}
}
