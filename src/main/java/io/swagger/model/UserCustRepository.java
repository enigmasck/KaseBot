/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserCustRepository extends CrudRepository<User, Integer> {
    List<User> findByEmail(String email);
    
}