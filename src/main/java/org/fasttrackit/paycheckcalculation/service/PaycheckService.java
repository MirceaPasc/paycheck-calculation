package org.fasttrackit.paycheckcalculation.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.paycheckcalculation.domain.Paycheck;
import org.fasttrackit.paycheckcalculation.persistence.PaycheckRepository;
import org.fasttrackit.paycheckcalculation.transfer.CreatePaycheckRequest;
import org.fasttrackit.paycheckcalculation.transfer.GetPaycheckRequest;
import org.fasttrackit.paycheckcalculation.transfer.PaycheckResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaycheckService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaycheckService.class);

    private final PaycheckRepository paycheckRepository;
    private final ObjectMapper objectMapper;


    @Autowired
    public PaycheckService(PaycheckRepository paycheckRepository, ObjectMapper objectMapper) {
        this.paycheckRepository = paycheckRepository;
        this.objectMapper = objectMapper;
    }


    public Paycheck createPaycheck(CreatePaycheckRequest request) {
          LOGGER.info("Creating paycheck {}", request);
          Paycheck paycheck = objectMapper.convertValue(request, Paycheck.class);
          paycheck.setSocialSecurity(request.getGrossPay() * 0.20);
          paycheck.setMedicalInsurance(request.getGrossPay() * 0.10);
          paycheck.setIncomeTax(request.getGrossPay() * 0.10);
          paycheck.setNetPay(request.getGrossPay() - (paycheck.getSocialSecurity() + paycheck.getIncomeTax() + paycheck.getMedicalInsurance()));
          return paycheckRepository.save(paycheck);
    }

    public Paycheck getPaycheck(long id) throws Exception {
        LOGGER.info("Retrieving paycheck {}", id);
        return paycheckRepository.findById(id).orElseThrow(Exception::new);
    }

       public Page<PaycheckResponse> getPaychecks(GetPaycheckRequest request, Pageable pageable ) {
           LOGGER.info("Retrieving paychecks {}", request);
           Page<Paycheck> paychecks ;

           if (request.getName() != null){
           paychecks = paycheckRepository.findByName(request.getName(), pageable);}

           else {
               paychecks = paycheckRepository.findAll(pageable);
           }

           List<PaycheckResponse> paycheckResponses = new ArrayList<>();

           for (Paycheck paycheck : paychecks.getContent()) {
               PaycheckResponse paycheckResponse = new PaycheckResponse();
               paycheckResponse.setId(paycheck.getId());
               paycheckResponse.setName(paycheck.getName());
               paycheckResponse.setGrossPay(paycheck.getGrossPay());
               paycheckResponse.setIncomeTax(paycheck.getIncomeTax());
               paycheckResponse.setMedicalInsurance(paycheck.getMedicalInsurance());
               paycheckResponse.setSocialSecurity(paycheck.getSocialSecurity());
               paycheckResponse.setNetPay(paycheck.getNetPay());
               paycheckResponse.setDate(paycheck.getDate());

               paycheckResponses.add(paycheckResponse);
           }

           return new PageImpl<>(paycheckResponses, pageable, paychecks.getTotalElements());
       }

    public void deletePaycheck(long id) {
        LOGGER.info("Deleting paycheck {}", id);
        paycheckRepository.deleteById(id);
        LOGGER.info("Deleted paycheck {}", id);

    }
}
