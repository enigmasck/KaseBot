package io.swagger.api;

import io.swagger.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.dialogflow.v2.QueryResult;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<Message>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Message> submitMessage(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Message body) {
        String accept = request.getHeader("Accept");
        List<String> texts = new ArrayList<>();
        /*texts.add(message);
        
        Map<String, QueryResult> map = detectIntentTexts("kasebot-de43d", texts, String sessionId,String languageCode);*/
        return new ResponseEntity<Message>(HttpStatus.NOT_IMPLEMENTED);
    }

}
