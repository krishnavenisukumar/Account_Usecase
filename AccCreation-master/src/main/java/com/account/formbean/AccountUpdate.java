package com.account.formbean;

public class AccountUpdate {
	
private Long accountnumber;
	private double balance;
	private boolean active;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean account_status) {
		this.active = account_status;
	}
	

	public Long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(Long accountnumber) {
		this.accountnumber = accountnumber;
	}

	
	public AccountUpdate(Long accountnumber, double balance, boolean active) {
		super();
		this.accountnumber = accountnumber;
		this.balance = balance;
		this.active = active;
	}

	public AccountUpdate() {
		super();

	}

}
