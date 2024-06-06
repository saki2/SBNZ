package com.ftn.sbnz.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.Alarm;
import com.ftn.sbnz.model.LogEntry;
import com.ftn.sbnz.util.DebugAgendaEventListener;

@Service
public class LogReceiverService {
    private static final Logger log = LoggerFactory.getLogger(LogReceiverService.class);
    private KieSession kSession;


    public LogReceiverService(){
        try {
            KieServices ks = KieServices.Factory.get();
            KieContainer kc = ks.getKieClasspathContainer();
            this.kSession = kc.newKieSession("basicRules");

            if (this.kSession != null) {
                this.kSession.addEventListener(new DebugAgendaEventListener());
            } else {
                log.error("Failed to create KieSession");
            }
        } catch (Exception e) {
            log.error("Error initializing KieSession: ", e);
        }
    }

    // ispisuje log
    public void receiveLog(LogEntry logEntry) {
        log.info("Received LogEntry: {} {} {}", logEntry.getId(), logEntry.getLogType(), logEntry.getSource());
        if (this.kSession != null) {
            this.kSession.insert(logEntry);
            int fired = kSession.fireAllRules();
            log.info("Number of rules fired: {}", fired);
        } else {
            log.error("KieSession is null. Cannot insert log entry.");
        }
    }

    public static void alarmAdmin(Alarm alarm) {
        log.warn("Admin alert: {}", alarm);
    }
}
