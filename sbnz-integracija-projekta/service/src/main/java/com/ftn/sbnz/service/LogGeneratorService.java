package com.ftn.sbnz.service;

import java.util.Date;
import java.util.Random;

import com.ftn.sbnz.model.LogEntry;
import com.ftn.sbnz.model.LogType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class LogGeneratorService {
    private static final Logger log = LoggerFactory.getLogger(LogGeneratorService.class);
    private static final Random random = new Random();
    private static int idCounter = 0;

    @Autowired
    private LogReceiverService logReceiverService;

    // salje svakih 5 sekundi request na LogReceiver log je generisan random 
    @Scheduled(fixedRate = 5000)
    public void generateLog() {
        LogEntry logEntry = new LogEntry(
                idCounter++,
                new Date(),
                "Source-" + random.nextInt(100),
                "192.168.1." + random.nextInt(256),
                LogType.values()[random.nextInt(LogType.values().length)],
                "Random log content " + random.nextInt(1000)
        );
        logReceiverService.receiveLog(logEntry);
    }
}
