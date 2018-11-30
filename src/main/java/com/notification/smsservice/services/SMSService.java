package com.notification.smsservice.services;

import com.notification.smsservice.entities.SMSMessage;
import com.notification.smsservice.repositories.SMSMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SMSService {
  private final SMSMessageRepository smsMessageRepository;

  public SMSService(final SMSMessageRepository smsMessageRepository) {
    super();
    this.smsMessageRepository = smsMessageRepository;
  }

  public List<SMSMessage> fetchAllSMSs() {
    return this.smsMessageRepository.findAll();
  }

  public Optional<SMSMessage> findSMSById(final Long smsId) {

    return this.smsMessageRepository.findById(smsId);
  }

  public Optional<SMSMessage> getContactInfoByClientId(final Long clientId) {
    return this.smsMessageRepository.findByClientId(clientId);
  }

  public void removeSMS(final Long smsId) {
  }

  public SMSMessage saveSMS(final SMSMessage smsMessage) {

    return null;
  }
}
