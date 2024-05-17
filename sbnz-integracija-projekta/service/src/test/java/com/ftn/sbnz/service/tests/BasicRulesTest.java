package com.ftn.sbnz.service.tests;

import com.ftn.sbnz.model.Alarm;
import com.ftn.sbnz.model.LogEntry;
import com.ftn.sbnz.model.LogType;
import com.ftn.sbnz.model.Threat;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@SpringBootTest
class BasicRulesTest {

    private KieSession kieSession;

    @BeforeEach
    public void setup() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        kieSession = kieContainer.newKieSession("basicRules");

    }

    @Test
    void testTrojanVirusDetection() {
        LogEntry logEntry = new LogEntry(1, new Date(), "Source-1", "192.168.1.1", LogType.SystemLog, "execute setup");

        kieSession.insert(logEntry);
        kieSession.fireAllRules();

        List<Alarm> alarms = new ArrayList<>();
        for (Object obj : kieSession.getObjects()) {
            if (obj instanceof Alarm) {
                alarms.add((Alarm) obj);
            }
        }

        assertEquals(1, alarms.size());
    }

    @Test
    void testMitmDetection() {

        LogEntry logEntry1 = new LogEntry(1, new Date(), "Source-1", "192.168.1.1", LogType.SystemLog, "login attempt");
        LogEntry logEntry2 = new LogEntry(2, new Date(), "Source-1", "192.168.1.2", LogType.SecurityLog, "login attempt");

        kieSession.insert(logEntry1);
        kieSession.insert(logEntry2);
        kieSession.fireAllRules();

        List<Alarm> alarms = new ArrayList<>();
        for (Object obj : kieSession.getObjects()) {
            if (obj instanceof Alarm) {
                alarms.add((Alarm) obj);
            }
        }

        assertEquals(1, alarms.size());
    }

    @Test
    void testPhishingDetection() {

        LogEntry logEntry1 = new LogEntry(1, new Date(), "Source-1", "192.168.1.1", LogType.UserLog, "user login");
        LogEntry logEntry2 = new LogEntry(2, new Date(), "source-1-phish", "192.168.1.2", LogType.UserLog, "user login attempt");

        kieSession.insert(logEntry1);
        kieSession.insert(logEntry2);
        kieSession.fireAllRules();

        List<Alarm> alarms = new ArrayList<>();
        for (Object obj : kieSession.getObjects()) {
            if (obj instanceof Alarm) {
                alarms.add((Alarm) obj);
            }
        }

        assertEquals(1, alarms.size());
    }

    @Test
    void testDependencyInjectionDetection() {
        LogEntry logEntry = new LogEntry(1, new Date(), "Source-2", "192.168.1.3", LogType.SystemLog, "unauthorized dependency change");

        kieSession.insert(logEntry);
        kieSession.fireAllRules();

        List<Alarm> alarms = new ArrayList<>();
        for (Object obj : kieSession.getObjects()) {
            if (obj instanceof Alarm) {
                alarms.add((Alarm) obj);
            }
        }

        assertEquals(1, alarms.size());
    }
}
