package com.notification.smsservice.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class SMSMessage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long identifier;
  @Column(unique = true)
  private Long clientId;
  private String sender;
  private String receiver;
  private String message;
  private Date createOn;

  public SMSMessage() {
    super();
    createOn = new Date();
  }

  public Long getIdentifier() {
    return identifier;
  }

  public void setIdentifier(Long identifier) {
    this.identifier = identifier;
  }

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getReceiver() {
    return receiver;
  }

  public void setReceiver(String receiver) {
    this.receiver = receiver;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Date getCreateOn() {
    return createOn;
  }

  public void setCreateOn(Date createOn) {
    this.createOn = createOn;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SMSMessage that = (SMSMessage) o;
    return Objects.equals(identifier, that.identifier) &&
            Objects.equals(clientId, that.clientId) &&
            Objects.equals(sender, that.sender) &&
            Objects.equals(receiver, that.receiver) &&
            Objects.equals(message, that.message) &&
            Objects.equals(createOn, that.createOn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifier, clientId, sender, receiver, message, createOn);
  }
}
