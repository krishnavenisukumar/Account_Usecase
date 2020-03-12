package com.account.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.Exception.AccountNotFoundException;
import com.account.Exception.CustomerNotFoundException;
import com.account.Exception.NoSufficientAmountException;
import com.account.entities.Account;
import com.account.entities.Customer;
import com.account.formbean.AccountUpdate;
import com.account.repository.AccountRepo;
import com.account.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo accountRepository;

	@Override
	public Account createAccount(Account account) {

		Account account2 = accountRepository.save(account);

		return account2;
	}

	@Override
	public Account updateAccount(AccountUpdate accountUpdate) {

		Account account = accountRepository.findById(accountUpdate.getAccountnumber())
				.orElseThrow(AccountNotFoundException::new);
		account.setAccountNumber(accountUpdate.getAccountnumber());
		accountRepository.save(account);
		return account;
	}

	@Override
	public void deleteAccount(Long acc_num) {
		Account accountToBeDeleted = accountRepository.findById(acc_num).orElseThrow(AccountNotFoundException::new);
		accountRepository.delete(accountToBeDeleted);

	}

	@Override
	public List<Account> retriveAccount(String ifsc) {

		List<Account> accounts = accountRepository.findByIfsc(ifsc);
		return accounts;

	}

	@Override
	public Account AccountretriveAccountUsingAccountNo(Long accountNumber) {
		Account accounts = accountRepository.findById(accountNumber).orElseThrow(AccountNotFoundException::new);
		return accounts;

	}

	@Override
	public Account getAccountByAccountNumber(Long accountno) {
		return accountRepository.findById(accountno).orElseThrow(AccountNotFoundException::new);
	}

}
