package com.test.bank

class BankAccountTest extends GroovyTestCase {
	private account

	void setUp() {
		account = new BankAccount(20)
	}

	void tearDown() {
		account = null;
	}

	void testDeposit() {
		account.depoit(10)
		assert 30 == account.balance
	}

	void testWithdraw() {
		account.withdraw(10)
		assert 10 == account.balance
	}

	void testMoreWithdraw() {
		shouldFail (InsufficientFundsException) {  account.withdraw(25) }
	}
}
