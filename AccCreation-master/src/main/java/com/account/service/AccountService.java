package com.account.service;

import java.util.List;

import com.account.entities.Account;
import com.account.entities.Customer;
import com.account.formbean.AccountUpdate;

public interface AccountService {

	Account createAccount(Account account);

	Account updateAccount(AccountUpdate accountUpdate);

	public void deleteAccount(Long acc_num);
	
	Account getAccountByAccountNumber(Long accountno);

	// retrive using ifsc
	public List<Account> retriveAccount(String ifsc);

	// retrive using accountno
	public Account AccountretriveAccountUsingAccountNo(Long accountNumber);


}
