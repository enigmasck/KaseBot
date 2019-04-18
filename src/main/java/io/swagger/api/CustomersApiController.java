package io.swagger.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import io.swagger.model.Login;
import io.swagger.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;   
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import io.swagger.model.UserCustRepository;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;

/*
Name: CustomersApiController
Purpose: The CustomerApiController handles all the business logic related to the 
customers of the application. It enables them to onboard, by creating a new account,
view their account details, update details on their own account, and delete their account.
Managers also have access to this business logic in order to view customer accounts
and manager them as well.
*/
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-12T16:03:36.994Z[GMT]")
@Controller
public class CustomersApiController implements CustomersApi {

    private static final Logger log = LoggerFactory.getLogger(CustomersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private UserCustRepository userCustRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public CustomersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    /*
    Name: createCustomer
    Purpose: This method allows a new user to create a customer account. It requires
    for the email and password to be more than 3 characters in length. 
    */
    public ResponseEntity<Void> createCustomer(@ApiParam(value = "" ,required=true )  @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        
        //check to see if user email already exists
        List<User> testEmail = userCustRepository.findByEmail(body.getEmail());
        if(testEmail.size() > 0 ){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

        if(body != null && body.getEmail().length() > 3 && body.getPassword().length() > 3){
            userCustRepository.save(body);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
    /*
    Name: customersCustIdDelete
    Purpose: This method enables a customer or manager to delete a customer 
    account. In regards to a customer it would be to delete their own account.
    */
    public ResponseEntity<Void> customersCustIdDelete(@ApiParam(value = "The user ID",required=true) @PathVariable("custId") Integer custId) {
        String accept = request.getHeader("Accept");
        try{
            userCustRepository.deleteById(custId);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    /*
    Name: customersCustIdGet
    Purpose: This method provides functionality for a customer or manager to view
    a specific customer. For a customer it would be their own profile information.
    It requires a userId in the resource.
    */
    public ResponseEntity<User> customersCustIdGet(@ApiParam(value = "The user ID",required=true) @PathVariable("custId") Integer custId) {
        String accept = request.getHeader("Accept");
        Optional<User> cust = userCustRepository.findById(custId);
        if(cust.isPresent() == true)
            return new ResponseEntity<User>(cust.get(),HttpStatus.OK);
        else
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST); 
    }
    
    /*
    Name: customersCustIdPut
    Purpose: This method enables a manager or customer to update their account
    information, such as a email or password.
    */
    public ResponseEntity<Void> customersCustIdPut(@ApiParam(value = "" ,required=true )  @Valid @RequestBody User body,@ApiParam(value = "The user ID",required=true) @PathVariable("custId") Integer custId) {
        String accept = request.getHeader("Accept");
        
        Optional<User> oldUser = userCustRepository.findById(custId);
        
        if(oldUser.isPresent()){
            
            if(body != null && !oldUser.get().equals(body)){
                oldUser.get().updateUserFields(body);
                userCustRepository.save(oldUser.get());
                return new ResponseEntity<Void>(HttpStatus.CREATED);
            }else{
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            }

        }else{
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        
    }
    
    /*
    Name: customersGet
    Purpose: Returns all customers that a manager can request to view.
    */
    public ResponseEntity<List<User>> customersGet() {
        String accept = request.getHeader("Accept");
        List<User> custList = Lists.newArrayList(userCustRepository.findAll());
        if(custList != null)
            return new ResponseEntity<List<User>>(custList,HttpStatus.OK);
        else
            return new ResponseEntity<List<User>>(HttpStatus.BAD_REQUEST); 
    }
    

}
