package org.mine.patientmanagment.repository;

import org.mine.patientmanagment.model.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface PatientRepository extends JpaRepository<Patients,Long> {
}
