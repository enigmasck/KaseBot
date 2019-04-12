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


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-12T16:03:36.994Z[GMT]")
@Controller
@PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
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

    public ResponseEntity<Void> createCustomer(@ApiParam(value = "" ,required=true )  @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> customersCustIdDelete(@ApiParam(value = "The user ID",required=true) @PathVariable("custId") Integer custId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<User> customersCustIdGet(@ApiParam(value = "The user ID",required=true) @PathVariable("custId") Integer custId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    public ResponseEntity<Void> customersCustIdPut(@ApiParam(value = "" ,required=true )  @Valid @RequestBody User body,@ApiParam(value = "The user ID",required=true) @PathVariable("custId") Integer custId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<User>> customersGet() {
        String accept = request.getHeader("Accept");
        List<User> custList = Lists.newArrayList(userCustRepository.findAll());
        return new ResponseEntity<List<User>>(custList,HttpStatus.NOT_IMPLEMENTED);
        //return new ResponseEntity<List<User>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> loginCustomer(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Login body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
