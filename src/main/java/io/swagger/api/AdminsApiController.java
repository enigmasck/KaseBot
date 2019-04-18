package io.swagger.api;

import io.swagger.model.Login;
import io.swagger.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import io.swagger.annotations.*;
import io.swagger.model.Administrator;
import io.swagger.model.AdministratorRepository;
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
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

/*
Name: AdminsApiController
Purpose: The AdminsApiController handles all the business logic related to the 
managers of the application. It enables them to onboard, by creating a new account,
view their account details, update details on their own account, and delete their account.
*/
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-12T16:03:36.994Z[GMT]")
@Controller
public class AdminsApiController implements AdminsApi {

    private static final Logger log = LoggerFactory.getLogger(AdminsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private AdministratorRepository adminRepo;

    @org.springframework.beans.factory.annotation.Autowired
    public AdminsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    
    /*
    Name: adminsAdminIdDelete
    Purpose: Enables a manager to delete their own account.
    */
    public ResponseEntity<Void> adminsAdminIdDelete(@ApiParam(value = "The admin ID",required=true) @PathVariable("adminId") Integer adminId) {
        String accept = request.getHeader("Accept");
        try{
            adminRepo.deleteById(adminId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        
    }

    /*
    Name: adminsAdminIdGet
    Purpose: This method enables a manager to get their account details of their
    own account.
    */
    public ResponseEntity<Administrator> adminsAdminIdGet(@ApiParam(value = "The admin ID",required=true) @PathVariable("adminId") Integer adminId) {
        String accept = request.getHeader("Accept");
        Optional<Administrator> admin = adminRepo.findById(adminId);
        if(admin.isPresent() == true)
            return new ResponseEntity<Administrator>(admin.get(),HttpStatus.OK);
        else
            return new ResponseEntity<Administrator>(HttpStatus.BAD_REQUEST); 
    }

    /*
    Name: adminsAdminIdPut
    Purpose: This method enables a manager to update their account details
    */
    public ResponseEntity<Void> adminsAdminIdPut(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Administrator body,@ApiParam(value = "The admin ID",required=true) @PathVariable("adminId") Integer adminId) {
        String accept = request.getHeader("Accept");
        Optional<Administrator> oldAdmin = adminRepo.findById(adminId);
        
        if(oldAdmin.isPresent()){
            
            if(body != null && !oldAdmin.get().equals(body)){
                oldAdmin.get().updateUserFields(body);
                adminRepo.save(oldAdmin.get());
                return new ResponseEntity<Void>(HttpStatus.CREATED);
            }else{
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            }

        }else{
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        
    }

    /*
    Name: adminsGet 
    Purpose: The purpose of this method is to allow manager to view details of 
    all other manager accounts.
    */
    public ResponseEntity<List<Administrator>> adminsGet() {
        String accept = request.getHeader("Accept");
        List<Administrator> adminList = Lists.newArrayList(adminRepo.findAll());
        if(adminList != null)
            return new ResponseEntity<List<Administrator>>(adminList,HttpStatus.OK);
        else
            return new ResponseEntity<List<Administrator>>(HttpStatus.BAD_REQUEST); 
    }

    /*
    Name: createAdmin
    Purpose: The purpose of this method is to enable a manager to create a new 
    account.
    */
    public ResponseEntity<Void> createAdmin(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Administrator body) {
        String accept = request.getHeader("Accept");
        //check to see if admin login already exists
        List<Administrator> testLogin = adminRepo.findByLoginName(body.getLoginName());
        if(testLogin.size() > 0 ){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

        if(body != null && body.getLoginName().length() > 3 && body.getPassword().length() > 3){
            try{
                adminRepo.save(body);
                return new ResponseEntity<Void>(HttpStatus.CREATED);
            }catch(Exception e){
                System.out.println(e);
            }
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

}
