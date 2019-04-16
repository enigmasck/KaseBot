/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.model;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author sony
 */
public interface CaseInnerRepository extends CrudRepository<CaseInner, Integer>{
    List<CaseInner> findByCasesTypeContainingIgnoreCase(String caseType); 
    
    List<CaseInner> findByCasesNotesContainingIgnoreCase(String notes); 
    
    List<CaseInner> findByCustomerIdIn(Collection<Integer> custId);
    
    @Query(value="select cases_id, cases_type, cases_notes, cs.customer_id, cases_status, cast(cases_create_timestamp as char) as cases_create_timestamp "
            + "from kasebot.cases cs inner join kasebot.customer cus on cs.customer_id = cus.customer_id where lower(lname) like %?1%", nativeQuery=true)
    List<CaseInner> findByCasesCustomerLastName(String lname);

    @Query(value="select cases_id, cases_type, cases_notes, cs.customer_id, cases_status, cast(cases_create_timestamp as char) as cases_create_timestamp "
            + "from kasebot.cases cs inner join kasebot.customer cus on cs.customer_id = cus.customer_id where lower(fname) like %?1%", nativeQuery=true)
    List<CaseInner> findByCasesCustomerFirstName(String fname);
}
