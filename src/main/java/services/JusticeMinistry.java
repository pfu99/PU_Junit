package services;
/**
 * External services involved in procedures from population
 */
public interface JusticeMinistry { // External service for the Justice Ministry
    CriminalRecordCertf6 getCriminalRecordCertf (Citizen persD, Goal g)
            throws DigitalSignatureException,ConnectException7;