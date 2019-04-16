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
import io.swagger.model.ResUnRes;
import io.swagger.model.ResolOnUnresolInner;
import io.swagger.model.ResolOnUnresolInnerRepository;
import io.swagger.model.ResolOnUnresolRepository;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.threeten.bp.Month;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-12T16:03:36.994Z[GMT]")
@Controller
public class ReportsApiController implements ReportsApi {

    private static final Logger log = LoggerFactory.getLogger(ReportsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    //@Autowired
    private ResolOnUnresolInnerRepository ResolOnUnresolInnerRepository;
    
    @Autowired
    private CaseInnerRepository caseInRepo;
    
    private DAO dao = new DAO();

    @org.springframework.beans.factory.annotation.Autowired
    public ReportsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<AvgCaseDur> reportsAvgCaseDurGet() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<AvgCaseDur>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResolOnUnresol> reportsResolOnUnresolTimeGet() {
        String accept = request.getHeader("Accept");
        
        ArrayList<ResolOnUnresolInner> ResolOnUnresolList; 
        ResolOnUnresolList = Lists.newArrayList(ResolOnUnresolInnerRepository.findAll());
               
        //ResolOnUnresol rou = new ResolOnUnresol();
        //ResolOnUnresolInner roui = new ResolOnUnresolInner();
        
        //dates = SELECT DISTINCT date_time from Cases
        
        //roui.setTotalCases(Long.valueOf(23));
        //roui.setDateTime(LocalDate.of(2019, Month.of(3), 1));
        //roui.setStatus(ResUnRes.RESOLVED);
        
        //rou.add(roui);
        
        //if(rou == null)
         //   return new ResponseEntity<ResolOnUnresol>(HttpStatus.NOT_FOUND);
        //Response
        return new ResponseEntity<ResolOnUnresol>((ResolOnUnresol) ResolOnUnresolList, HttpStatus.OK);
    }

    public ResponseEntity<List<CaseInner>> reportsSearchCaseGet(@ApiParam(value = "") @Valid @RequestParam(value = "CaseID", required = false) Integer caseID,@ApiParam(value = "") @Valid @RequestParam(value = "CustomerID", required = false) Long customerID,@ApiParam(value = "") @Valid @RequestParam(value = "firstName", required = false) String firstName,@ApiParam(value = "") @Valid @RequestParam(value = "lastName", required = false) String lastName,@ApiParam(value = "") @Valid @RequestParam(value = "date", required = false) LocalDate date,@ApiParam(value = "") @Valid @RequestParam(value = "keyWord", required = false) String keyWord) {
        String accept = request.getHeader("Accept");
        
        try{
            /*List<CaseInner> casesByLname = caseInRepo.findByCasesCustomerLastName(lastName.toLowerCase());
            System.out.println(casesByLname.size());
            if(casesByLname.size() > 0)
                return new ResponseEntity<List<CaseInner>>(casesByLname,HttpStatus.OK);
            else
                return new ResponseEntity<List<CaseInner>>(HttpStatus.NOT_FOUND);*/
            List<CaseInner> caseByKeyword = caseInRepo.findByCasesNotesContainingIgnoreCase(keyWord);
            return new ResponseEntity<List<CaseInner>>(caseByKeyword,HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e);
        }
        
        return new ResponseEntity<List<CaseInner>>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Message>> reportsViewMessageCaseIdGet(@ApiParam(value = "The case Id",required=true) @PathVariable("caseId") Long caseId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<Message>>(HttpStatus.NOT_IMPLEMENTED);
    }
    
    /*@RequestMapping(path = "/report/casesNumberByStatus/{date}", method=RequestMethod.GET)
    public Map<String, Integer> getCode(@PathVariable String date) throws SQLException{
        return dao.getNumberOfCaseInDifferentStatus(date);
    }*/

}
