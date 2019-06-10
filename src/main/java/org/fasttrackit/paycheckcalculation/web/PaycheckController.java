package org.fasttrackit.paycheckcalculation.web;


import org.fasttrackit.paycheckcalculation.domain.Paycheck;
import org.fasttrackit.paycheckcalculation.service.PaycheckService;
import org.fasttrackit.paycheckcalculation.transfer.CreatePaycheckRequest;
import org.fasttrackit.paycheckcalculation.transfer.GetPaycheckRequest;
import org.fasttrackit.paycheckcalculation.transfer.PaycheckResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/paycheck")
@CrossOrigin
public class PaycheckController {

    private final PaycheckService paycheckService;

    @Autowired
    public PaycheckController(PaycheckService paycheckService) {
        this.paycheckService = paycheckService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Paycheck> getPaycheck(@PathVariable("id") long id) throws Exception {
        Paycheck response = paycheckService.getPaycheck(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<PaycheckResponse>> getPaychecks(@Valid GetPaycheckRequest request, Pageable pageable){
        Page<PaycheckResponse> response = paycheckService.getPaychecks(request, pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Paycheck> createPaycheck (@RequestBody @Valid CreatePaycheckRequest request){
        Paycheck response = paycheckService.createPaycheck(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deletePaycheck(@PathVariable long id) {
        paycheckService.deletePaycheck(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}
