package com.notification.smsservice.repositories;

import com.notification.smsservice.entities.SMSMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SMSMessageRepository extends JpaRepository<SMSMessage, Long> {
  Optional<SMSMessage> findByClientId(final Long clientId);
}
