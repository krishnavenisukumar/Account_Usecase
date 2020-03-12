package com.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.entities.Account;
import com.account.entities.Customer;
import com.account.formbean.AccountForm;
import com.account.formbean.AccountUpdate;
import com.account.service.AccountService;

@RestController
@RequestMapping(path = "/account_controller")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping(path = "createaccount")
	public ResponseEntity<Account> createAccount(@RequestBody AccountForm form) {
		Account account = new Account(form.getIfsc(), form.getBalance(), form.isActive(), form.getAccountType());
		return new ResponseEntity<Account>(accountService.createAccount(account), HttpStatus.OK);

	}

	@PutMapping(path = "updateaccount")
	public ResponseEntity<Account> updateAccount(@PathVariable(name = "accountNumber") Long accountNumber,@RequestBody AccountUpdate accountUpdate) {
		Account account = accountService.getAccountByAccountNumber(accountNumber);
		account.setAccountNumber(accountUpdate.getAccountnumber());
		account.setBalance(accountUpdate.getBalance());
		return new ResponseEntity<Account>(accountService.updateAccount(accountUpdate), HttpStatus.ACCEPTED);

	}
	
	
	/*@DeleteMapping(path = "deleteaccount/{accountNumber}")
	public ResponseEntity<Account> deleteAccount(@PathVariable(name = "accountNumber") Long accountNumber) {
		accountService.deleteAccount(accountNumber);
		return new ResponseEntity<Account>(HttpStatus.OK);
	}*/

	/*@GetMapping(path = "account/{accountNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> getAccByAccNum(@PathVariable(name = "accountNumber") Long accountNumber) {

		List<Account> accounts = (List<Account>) accountService.AccountretriveAccountUsingAccountNo(accountNumber);
		return new ResponseEntity<Account>(HttpStatus.OK);

	}*/

	/*@GetMapping(path = "account/{ifsc}")
	public ResponseEntity<List<Account>> getAccountsByIfsc(@PathVariable(name = "ifsc") String ifsc) {
		List<Account> accounts = accountService.retriveAccount(ifsc);
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);

	}*/
}
