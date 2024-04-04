package org.mine.patientmanagment.interfacepackage;

import org.mine.patientmanagment.model.Patients;

import java.util.List;

import java.util.List;

public interface PatientService {
    List<Patients> getAllPatients();
    Patients savePatient(Patients patient);

    Patients getPatientById(Long id);

    Patients updatePatient(Patients patient);

    void deletePatientById(Long id);
}
