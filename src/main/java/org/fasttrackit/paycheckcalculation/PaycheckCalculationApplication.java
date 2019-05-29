package org.fasttrackit.paycheckcalculation;

import org.fasttrackit.paycheckcalculation.domain.Paycheck;
import org.fasttrackit.paycheckcalculation.persistence.PaycheckRepository;
import org.fasttrackit.paycheckcalculation.service.PaycheckService;
import org.fasttrackit.paycheckcalculation.transfer.CreatePaycheckRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaycheckCalculationApplication {

	public static void main(String[] args) {SpringApplication.run(PaycheckCalculationApplication.class, args);}


}
