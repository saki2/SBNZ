package com.ftn.sbnz.model;

public enum ThreatType {
    // Root types
    DOS_DDOS("DoS/DDoS", "Denial-of-Service and Distributed Denial-of-Service attacks aim to overwhelm systems with traffic.", "Implement rate limiting, traffic filtering, and use DDoS protection services."),
    PHISHING("Phishing", "Phishing attacks attempt to trick individuals into providing sensitive information.", "Educate users and use email filtering and authentication."),
    XSS_ATTACK("XSS Attack", "Cross-Site Scripting attacks inject malicious scripts into webpages.", "Sanitize user inputs, use content security policies, and validate all inputs."),
    DEPENDENCY_INJECTION("Dependency Injection", "Attacks that exploit vulnerabilities in code dependencies.", "Keep libraries and drivers updated and use dependency checkers."),
    INSIDER_THREATS("Insider Threats", "Threats posed by malicious insiders with legitimate access.", "Monitor user activities, implement strict access controls, and use data loss prevention tools."),
    TROJAN("Trojan", "Malware disguised as legitimate software.", "Use antivirus software, keep systems updated, and monitor network traffic."),
    UNAUTHORIZED_ACCESS("Unauthorized Access", "Access to systems or data without permission.", "Implement multi-factor authentication, enforce strong password policies, and monitor login attempts."),
    MITM("Man In The Middle", "Interception and manipulation of communications between two parties.", "Use secure communication protocols, enforce HTTPS, and monitor session activities."),
    SYSTEM_FAILURE("System Failure", "Failures in system components leading to downtime or data loss.", "Implement redundant systems and regular backups."),
    RANSOMWARE("Ransomware", "Malware that encrypts data and demands ransom for decryption.", "Maintain regular backups and use anti-ransomware tools."),
    MALWARE("Malware", "Malicious software designed to cause harm.", "Maintain regular backups, use antivirus software, and keep systems updated."),
    
    // Subtypes for DoS/DDoS
    DOS("DoS", "Denial-of-Service attacks flood a system with traffic to render it unusable.", "Implement rate limiting and traffic filtering."),
    DDOS("DDoS", "Distributed Denial-of-Service attacks use multiple systems to attack a single target.", "Deploy DDoS protection services."),
    
    // Subtypes for DoS
    FLOOD_ATTACK("Flood Attack", "A type of DoS attack that floods the network with excessive traffic.", "Implement rate limiting and traffic filtering."),
    LOGIC_ATTACK("Logic Attack", "A DoS attack that exploits software bugs or vulnerabilities to crash the system.", "Patch software and use intrusion detection systems."),
    
    // Subtypes for DDoS
    AMPLIFICATION_ATTACK("Amplification Attack", "A DDoS attack that uses amplified responses from legitimate services to flood the target.", "Deploy DDoS protection services."),
    BOTNET_ATTACK("Botnet Attack", "A DDoS attack launched by a network of compromised computers.", "Monitor network traffic and use anti-botnet technologies."),
    
    // Subtypes for Phishing
    EMAIL_PHISHING("Email Phishing", "Phishing attempts sent via email to trick users into providing sensitive information.", "Educate users about phishing and use email filtering."),
    SPEAR_PHISHING("Spear Phishing", "Targeted phishing attacks aimed at specific individuals or organizations.", "Use email authentication methods and educate users."),
    
    // Subtypes for XSS Attack
    STORED_XSS("Stored XSS", "Malicious scripts stored on a server and executed when a user accesses the infected page.", "Sanitize user inputs and use content security policies."),
    REFLECTED_XSS("Reflected XSS", "Malicious scripts reflected off a web server, often via URL parameters.", "Validate and sanitize all inputs."),
    
    // Subtypes for Dependency Injection
    LIBRARY_INJECTION("Library Injection", "Injection attacks targeting libraries or frameworks.", "Keep libraries updated and use dependency checkers."),
    DRIVER_INJECTION("Driver Injection", "Injection attacks targeting system drivers.", "Use secure drivers and keep them updated."),
    
    // Subtypes for Insider Threats
    SABOTAGE("Sabotage", "Intentional damage to systems or data by an insider.", "Monitor user activities and implement strict access controls."),
    DATA_THEFT("Data Theft", "Unauthorized access and exfiltration of sensitive data by an insider.", "Use data loss prevention tools and monitor data access."),
    
    // Subtypes for Trojan
    BACKDOOR_TROJAN("Backdoor Trojan", "Trojan that provides unauthorized remote access to a system.", "Use antivirus software and monitor network traffic."),
    EXPLOIT_TROJAN("Exploit Trojan", "Trojan that exploits system vulnerabilities to perform malicious activities.", "Keep systems updated and use intrusion detection systems."),
    BANKING_TROJAN("Banking Trojan", "Trojan that targets financial information and transactions.", "Use secure banking practices and monitor financial transactions."),
    
    // Subtypes for Unauthorized Access
    CREDENTIAL_STUFFING("Credential Stuffing", "Using stolen credentials to gain unauthorized access.", "Implement multi-factor authentication and monitor login attempts."),
    PASSWORD_SPRAYING("Password Spraying", "Attempting a few commonly used passwords on many accounts.", "Enforce strong password policies and monitor login attempts."),
    
    // Subtypes for MITM
    SESSION_HIJACKING("Session Hijacking", "Taking over a valid session between a client and server.", "Use secure communication protocols and monitor session activities."),
    SSL_STRIPPING("SSL Stripping", "Downgrading HTTPS connections to HTTP to intercept data.", "Enforce HTTPS and use HSTS (HTTP Strict Transport Security)."),
    
    // Subtypes for Ransomware
    CRYPTO_RANSOMWARE("Crypto Ransomware", "Ransomware that encrypts data files.", "Maintain regular backups and use anti-ransomware tools."),
    LOCKER_RANSOMWARE("Locker Ransomware", "Ransomware that locks the user out of the system.", "Maintain regular backups and use anti-ransomware tools.");
    
    private final String name;
    private final String description;
    private final String mitigation;
    private ThreatType parent;
    private ThreatType[] subTypes;

    ThreatType(String name, String description, String mitigation) {
        this.name = name;
        this.description = description;
        this.mitigation = mitigation;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getMitigation() {
        return mitigation;
    }

    public ThreatType getParent() {
        return parent;
    }

    public void setParent(ThreatType parent) {
        this.parent = parent;
    }

    public ThreatType[] getSubTypes() {
        return subTypes;
    }

    public void setSubTypes(ThreatType[] subTypes) {
        this.subTypes = subTypes;
    }

    public void handleThreat() {
        System.out.println("Handling threat: " + description);
        // Implementacija specifična za svaki tip pretnje
    }

    // Statički blok za inicijalizaciju podtipova i roditelja
    static {
        DOS_DDOS.setSubTypes(new ThreatType[]{DOS, DDOS});
        DOS.setParent(DOS_DDOS);
        DOS.setSubTypes(new ThreatType[]{FLOOD_ATTACK, LOGIC_ATTACK});
        DDOS.setParent(DOS_DDOS);
        DDOS.setSubTypes(new ThreatType[]{AMPLIFICATION_ATTACK, BOTNET_ATTACK});
        
        PHISHING.setSubTypes(new ThreatType[]{EMAIL_PHISHING, SPEAR_PHISHING});
        EMAIL_PHISHING.setParent(PHISHING);
        SPEAR_PHISHING.setParent(PHISHING);
        
        XSS_ATTACK.setSubTypes(new ThreatType[]{STORED_XSS, REFLECTED_XSS});
        STORED_XSS.setParent(XSS_ATTACK);
        REFLECTED_XSS.setParent(XSS_ATTACK);
        
        DEPENDENCY_INJECTION.setSubTypes(new ThreatType[]{LIBRARY_INJECTION, DRIVER_INJECTION});
        LIBRARY_INJECTION.setParent(DEPENDENCY_INJECTION);
        DRIVER_INJECTION.setParent(DEPENDENCY_INJECTION);
        
        INSIDER_THREATS.setSubTypes(new ThreatType[]{SABOTAGE, DATA_THEFT});
        SABOTAGE.setParent(INSIDER_THREATS);
        DATA_THEFT.setParent(INSIDER_THREATS);
        
        TROJAN.setSubTypes(new ThreatType[]{BACKDOOR_TROJAN, EXPLOIT_TROJAN, BANKING_TROJAN});
        BACKDOOR_TROJAN.setParent(TROJAN);
        EXPLOIT_TROJAN.setParent(TROJAN);
        BANKING_TROJAN.setParent(TROJAN);
        
        UNAUTHORIZED_ACCESS.setSubTypes(new ThreatType[]{CREDENTIAL_STUFFING, PASSWORD_SPRAYING});
        CREDENTIAL_STUFFING.setParent(UNAUTHORIZED_ACCESS);
        PASSWORD_SPRAYING.setParent(UNAUTHORIZED_ACCESS);
        
        MITM.setSubTypes(new ThreatType[]{SESSION_HIJACKING, SSL_STRIPPING});
        SESSION_HIJACKING.setParent(MITM);
        SSL_STRIPPING.setParent(MITM);
        
        RANSOMWARE.setSubTypes(new ThreatType[]{CRYPTO_RANSOMWARE, LOCKER_RANSOMWARE});
        CRYPTO_RANSOMWARE.setParent(RANSOMWARE);
        LOCKER_RANSOMWARE.setParent(RANSOMWARE);
        
        MALWARE.setSubTypes(new ThreatType[]{RANSOMWARE, TROJAN});
        RANSOMWARE.setParent(MALWARE);
        TROJAN.setParent(MALWARE);
    }
}
