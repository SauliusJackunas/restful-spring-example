package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Defining a rest controller
@RestController
public class ibanService {

  // Requesting mapping to a specified link making it to return the JSON format
  @RequestMapping(value = "/validate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  // Defining method name, return type, and forcing to enter IBAN to get immediate validation
  public String getValidation(@RequestParam(required = true) String iban) {

    //Validating given IBAN
    boolean isValid = HelperClass.validateIban(iban);
    //Pre-setting the format in which will the results be displayed
    String pattern = "{ \"iban\" : \"%s\", \"valid\" : \"%b\" }";
    //Passing values to the pattern
    String json = String.format(pattern, iban, isValid);
    //Returning the results to console, for double checking.
    System.out.println(json);
    //Returning the results to the web page. 
    return json;
  }
}
