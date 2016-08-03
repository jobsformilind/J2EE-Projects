package com.test.spring.base;

import org.springframework.transaction.support.TransactionSynchronizationManager;

public class Utils {

	public static void printTrasactionDetails(String msg) {
		boolean active = TransactionSynchronizationManager.isActualTransactionActive();
		System.out.println("----- " + msg + "------------");
		System.out.println("Trasaction active: " + active);
		if (active) {
			System.out.println("Trasaction Name " + TransactionSynchronizationManager.getCurrentTransactionName());
			System.out.println("Trasaction Level " + TransactionSynchronizationManager.getCurrentTransactionIsolationLevel());
		}
		System.out.println("-------------------------");
	}
}
