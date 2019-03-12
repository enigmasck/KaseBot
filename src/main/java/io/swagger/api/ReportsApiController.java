package io.swagger.api;

import io.swagger.model.AvgCaseDur;
import org.threeten.bp.LocalDate;
import io.swagger.model.Message;
import io.swagger.model.ModelCase;
import io.swagger.model.ResolOnUnresol;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-12T16:03:36.994Z[GMT]")
@Controller
public class ReportsApiController implements ReportsApi {

    private static final Logger log = LoggerFactory.getLogger(ReportsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

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
        return new ResponseEntity<ResolOnUnresol>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ModelCase>> reportsSearchCaseGet(@ApiParam(value = "") @Valid @RequestParam(value = "CaseID", required = false) Long caseID,@ApiParam(value = "") @Valid @RequestParam(value = "CustomerID", required = false) Long customerID,@ApiParam(value = "") @Valid @RequestParam(value = "firstName", required = false) String firstName,@ApiParam(value = "") @Valid @RequestParam(value = "lastName", required = false) String lastName,@ApiParam(value = "") @Valid @RequestParam(value = "date", required = false) LocalDate date,@ApiParam(value = "") @Valid @RequestParam(value = "keyWord", required = false) String keyWord) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<ModelCase>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Message>> reportsViewMessageCaseIdGet(@ApiParam(value = "The case Id",required=true) @PathVariable("caseId") Long caseId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<Message>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
