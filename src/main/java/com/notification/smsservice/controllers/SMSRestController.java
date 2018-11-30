package com.notification.smsservice.controllers;

import com.notification.smsservice.entities.SMSMessage;
import com.notification.smsservice.exceptions.ResourceNotFoundException;
import com.notification.smsservice.services.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sms")
public class SMSRestController {

  private final SMSService smsService;

  @Autowired
  public SMSRestController(final SMSService smsService) {
    super();
    this.smsService = smsService;
  }

  @GetMapping()
  public ResponseEntity<List<SMSMessage>> getSMSs(){
    List<SMSMessage> smsMessages = smsService.fetchAllSMSs();
    return new ResponseEntity<>(smsMessages, HttpStatus.OK);
  }
  @GetMapping("/{id}")
  public ResponseEntity<SMSMessage> getSMS(@PathVariable("id") final Long smsId){
    Optional<SMSMessage> optionalSMSMessage = smsService.findSMSById(smsId);
    if(!optionalSMSMessage.isPresent()){
      throw new ResourceNotFoundException("SMS Messsage with identifier: " + smsId + " not found!");
    }
    return new ResponseEntity<>(optionalSMSMessage.get(), HttpStatus.OK);
  }

  @GetMapping("clients/{clientId}")
  public ResponseEntity<SMSMessage> getContactInfoByClientId(@PathVariable("clientId") final Long clientId){
    Optional<SMSMessage> optionalSMSMessage = smsService.getContactInfoByClientId(clientId);
    return new ResponseEntity<>(optionalSMSMessage.get(), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> removeContactInfo(@PathVariable("id") final Long smsId){
    smsService.removeSMS(smsId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(path = {""},
          method = {RequestMethod.POST, RequestMethod.PUT}
          )
  public ResponseEntity<SMSMessage> saveUpdateContactInfo(@RequestBody final SMSMessage smsMessage){
    final SMSMessage savedSMSMessage = smsService.saveSMS(smsMessage);
    return new ResponseEntity<>(savedSMSMessage, HttpStatus.OK);
  }
}
