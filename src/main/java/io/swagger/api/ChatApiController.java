package io.swagger.api;

import io.swagger.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.dialogflow.v2.QueryResult;
import io.swagger.annotations.*;
import io.swagger.model.DetectIntentTexts;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.annotation.security.PermitAll;
import org.springframework.security.access.prepost.PreAuthorize;
import org.threeten.bp.OffsetDateTime;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-12T16:03:36.994Z[GMT]")
@Controller
public class ChatApiController implements ChatApi {

    private static final Logger log = LoggerFactory.getLogger(ChatApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ChatApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Message>> chatIdGet(@ApiParam(value = "The customer id",required=true) @PathVariable("id") Long id) {
        //T - Here simply insert a query that gets the list of messages of a certain customer ID
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<Message>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Message> submitMessage(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Message body) {
        //Querying the google Dialogflow API to get an answer to the message
        String accept = request.getHeader("Accept");
        
        //transforming the message object to a list, for compatibility with the google API requirements
        List<String> texts = new ArrayList<>();
        texts.add(body.getText());
        
        //Detecting which Intent matches the given message and returning the Answer
        DetectIntentTexts dit = new DetectIntentTexts();
        Map<String, QueryResult> response = new HashMap<String, QueryResult>();
        try {
            //Calling the function to our google Dialogflow project
            response = dit.detectIntentTexts("kasebot-de43d", texts, "1", "en-US");
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ChatApiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //converting the response back to the Message object
        //T - please link these to the Messages table
        //T - I'll need to add some use cases to change some things on the database
        //if messageResponse is "Okay, I will mark this case as resolved/unresolved/In progress
        //  Then change the case status to that
        //if messageResponse is "Okay, I will create a new case for you"
        //  Then create a new case for the user ID
        String messageResponse = response.get(body.getText()).getFulfillmentText();
        Message message = new Message();
        message.setText(messageResponse);
        message.setId(1L);
        OffsetDateTime dateTime = OffsetDateTime.now();
        message.setMsgDateTime(dateTime);
        
        return new ResponseEntity<Message>(message, HttpStatus.NOT_IMPLEMENTED);
    }

}
