package org.fasttrackit.paycheckcalculation.persistence;

import org.fasttrackit.paycheckcalculation.domain.Paycheck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaycheckRepository extends PagingAndSortingRepository<Paycheck, Long> {

    Page<Paycheck> findByName(String name, Pageable pageable);
}
