package org.samy.bankspringbatch;

import org.samy.bankspringbatch.dao.BankTransaction;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing // permt de charger un exsemble de lignes de spring batch
public class SpringBatchConfig {
	
	@Autowired private JobBuilderFactory jobBuilderFactory;
	@Autowired private StepBuilderFactory stepBuilderFactory;
	@Autowired private ItemReader<BankTransaction> bankTransactionItemReader;
	@Autowired private ItemWriter<BankTransaction> bankTransactionItemWriter;
	@Autowired private ItemProcessor<BankTransaction,BankTransaction> bankTransactionItemProcessor;
	
	
	
	public Job bankJob() {
		Step step1 = stepBuilderFactory.get("step-load-data")
				    .<BankTransaction,BankTransaction>chunk(100) // il faut absolument specifier le diamant <BankTransaction,BankTransaction>
				    .reader(bankTransactionItemReader)
				    .processor(bankTransactionItemProcessor)
				    .writer(bankTransactionItemWriter)
				    .build();
		
		return jobBuilderFactory.get("bank-data-loader-job")
				.start(step1).build();	
		
	}
	
	
	public FlatFileItemReader<BankTransaction> flatFileItemReader(@Value("${inputFile}") String inputFile){// @Value("${inputFile}")  permet d'injecter une valeur qui provient du fichier application.properties, l'annotation @Value permet d'aller chercher dans le fichier de ressources
		
		
		
	}
	
	

}
