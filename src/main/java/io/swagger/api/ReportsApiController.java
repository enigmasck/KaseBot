package io.swagger.api;

import io.swagger.model.AvgCaseDur;
import org.threeten.bp.LocalDate;
import io.swagger.model.Message;
import io.swagger.model.ModelCase;
import io.swagger.model.ResolOnUnresol;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import io.swagger.annotations.*;
import io.swagger.dao.DAO;
import io.swagger.model.CaseInner;
import io.swagger.model.CaseInnerRepository;
import io.swagger.model.MessageRepository;
import io.swagger.model.ResUnRes;
import io.swagger.model.ResolOnUnresolInner;
import io.swagger.model.ResolOnUnresolInnerRepository;
import io.swagger.model.ResolOnUnresolRepository;
import io.swagger.model.User;
import io.swagger.model.UserCustRepository;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.threeten.bp.Month;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-12T16:03:36.994Z[GMT]")
@Controller
/*
Name: ReportsAiController
Purpose: This controller handles the business logic involved with case statistics.
It can display average case duration, number of resolved and unresolved cases,
and searching of cases by first name, last name, and keyword.
*/
public class ReportsApiController implements ReportsApi {

    private static final Logger log = LoggerFactory.getLogger(ReportsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private ResolOnUnresolInnerRepository resolveRepo;
    
    @Autowired
    private CaseInnerRepository caseInRepo;
    
    @Autowired
    private UserCustRepository userCustRepo;
    
    @Autowired
    private MessageRepository msgRepo;
    
    private DAO dao = new DAO();

    @org.springframework.beans.factory.annotation.Autowired
    public ReportsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    /*
    TODO - FUNCTIONALITY NOT AVAILABLE YET. WILL SHIP IN V2
    Name: reportsAvgCaseDurGet
    Purpose: This method enables a manager to view reports of the average case duration.
    The data is pulled from a view in the database. It is calculated in real-time.
    A case duration is considered by calculating the data difference between
    the case creation and the last message of the case.
    */
    public ResponseEntity<AvgCaseDur> reportsAvgCaseDurGet() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<AvgCaseDur>(HttpStatus.NOT_IMPLEMENTED);
    }

    /*
    Name: reportsResolOnUnresolTimeGet
    Purpose: The purpose of this method is to get a count of the cases by the 
    whether the case was resolved, unresolved, or in progress
    */
    public ResponseEntity<List<ResolOnUnresol>> reportsResolOnUnresolTimeGet() {
        String accept = request.getHeader("Accept");
       
        List<ResolOnUnresolInner> resolveList = Lists.newArrayList(resolveRepo.findAll());
               
        return new ResponseEntity<List<ResolOnUnresol>>((MultiValueMap<String, String>) resolveList, HttpStatus.OK);
    }

    /*
    Name: reportsSearchCaseGet
    Purpose: This method provides functionality to a manger to search cases by
    first name, last name, or by keyword. It is also utilized by the chat bot
    to get listings of cases when a customer is inquiring for help.
    */
    public ResponseEntity<List<CaseInner>> reportsSearchCaseGet(@ApiParam(value = "") @Valid @RequestParam(value = "CaseID", required = false) Integer caseID,@ApiParam(value = "") @Valid @RequestParam(value = "CustomerID", required = false) Long customerID,@ApiParam(value = "") @Valid @RequestParam(value = "firstName", required = false) String firstName,@ApiParam(value = "") @Valid @RequestParam(value = "lastName", required = false) String lastName,@ApiParam(value = "") @Valid @RequestParam(value = "date", required = false) LocalDate date,@ApiParam(value = "") @Valid @RequestParam(value = "keyWord", required = false) String keyWord) {
        String accept = request.getHeader("Accept");
        
        try{
            if(firstName.equals("")){
                firstName = "";
            }
        }catch(Exception e){firstName = "";}
        
        try{
            if(lastName.equals("")){
                lastName = "";
            }
        }catch(Exception e){lastName = "";}
        
        try{
            if(keyWord.equals("")){
                keyWord = "";
            }
        }catch(Exception e){keyWord = "";}
        
        
        if(!firstName.equals("")){        
            List<CaseInner> casesByFirstName = caseInRepo.findByCasesCustomerFirstName(firstName);
            
            return new ResponseEntity<List<CaseInner>>(casesByFirstName,HttpStatus.OK);
        }
        
        
        if(!lastName.equals("")){        
            List<CaseInner> casesByLname = caseInRepo.findByCasesCustomerLastName(lastName);
            
            return new ResponseEntity<List<CaseInner>>(casesByLname,HttpStatus.OK);
        }
        

        if(!keyWord.equals("")){
            try{
                List<CaseInner> caseByKeyword = caseInRepo.findByCasesNotesContainingIgnoreCase(keyWord);
                return new ResponseEntity<List<CaseInner>>(caseByKeyword,HttpStatus.OK);
            }catch(Exception e){
                return new ResponseEntity<List<CaseInner>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        
        return new ResponseEntity<List<CaseInner>>(HttpStatus.BAD_REQUEST);
    }
    /*
    Name: reportsViewMessageCaseIdGet
    Purpose: This method provides functionality to a manager so they get view 
    messages of a particular case.
    */
    public ResponseEntity<List<Message>> reportsViewMessageCaseIdGet(@ApiParam(value = "The case Id",required=true) @PathVariable("caseId") Long caseId) {
        String accept = request.getHeader("Accept");
        
        List<Integer> msgId = new ArrayList();
        msgId.add((int) (long)caseId);
        List<Message> mgs = (List<Message>) msgRepo.findAllById(msgId);
        
        return new ResponseEntity<List<Message>>(mgs,HttpStatus.OK);
    }
    
}
