package org.samy.bankspringbatch;

import java.text.SimpleDateFormat;

import org.samy.bankspringbatch.dao.BankTransaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

//@Component  // en enlevant cette annotation cela signifie qu'il n'est pas instancié
public class BankTransactionItemProcessor implements ItemProcessor<BankTransaction,BankTransaction>{
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
	

	@Override
	public BankTransaction process(BankTransaction bankTransaction) throws Exception {

		bankTransaction.setTransactionDate(dateFormat.parse(bankTransaction.getStrTransactionDate()));		
		
		return bankTransaction;
	}

}
