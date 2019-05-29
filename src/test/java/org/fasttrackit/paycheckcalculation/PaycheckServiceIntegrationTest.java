package org.fasttrackit.paycheckcalculation;

import org.fasttrackit.paycheckcalculation.domain.Paycheck;
import org.fasttrackit.paycheckcalculation.service.PaycheckService;
import org.fasttrackit.paycheckcalculation.transfer.CreatePaycheckRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaycheckServiceIntegrationTest {

    @Autowired
    private PaycheckService paycheckService;

    public Paycheck createPaycheck() {
        CreatePaycheckRequest request = new CreatePaycheckRequest();

        request.setGrossPay(2000);
        request.setName("Pasc Mircea");
        return paycheckService.createPaycheck(request);

    }

}
