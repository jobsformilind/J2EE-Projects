package com.test.bank

class BankAccount {

	private balance

	BankAccount(openingBalance) {
		balance = openingBalance
	}

	def void withdraw(amount) {
		if(amount > balance) {
			throw new InsufficientFundsException()
		}
		balance -= amount
	}

	def void depoit(amount) {
		balance +=amount
	}
}
