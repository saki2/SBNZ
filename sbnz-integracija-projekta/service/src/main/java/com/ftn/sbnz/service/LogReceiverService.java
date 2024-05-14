package com.ftn.sbnz.service;

import com.ftn.sbnz.model.LogEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogReceiverService {
    private static final Logger log = LoggerFactory.getLogger(LogReceiverService.class);

    public void receiveLog(LogEntry logEntry) {
        log.info("Received LogEntry: {}", logEntry);
    }
}
