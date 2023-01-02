package services;

import exceptions.ConnectException;
import exceptions.DigitalSignatureException;
import publicadministration.Citizen;
import publicadministration.CriminalRecordCertf;
import enums.Goal;

/**
 * External services involved in procedures from population
 */
public interface JusticeMinistry { // External service for the Justice Ministry
    CriminalRecordCertf getCriminalRecordCertf(Citizen persD, Goal g)
            throws DigitalSignatureException, ConnectException;
}