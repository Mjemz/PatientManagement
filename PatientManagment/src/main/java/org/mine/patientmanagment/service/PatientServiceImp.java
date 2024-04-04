package org.mine.patientmanagment.service;

import org.mine.patientmanagment.interfacepackage.PatientService;
import org.mine.patientmanagment.model.Patients;
import org.mine.patientmanagment.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
    public class PatientServiceImp implements PatientService {
    private  final PatientRepository repository;
    public PatientServiceImp(PatientRepository repository){
        super();
        this.repository=repository;
    }
    @Override
    public List<Patients> getAllPatients() {
        return repository.findAll();
    }
    @Override
    public Patients savePatient(Patients patient) {
            return repository.save(patient);
        }

    @Override
    public Patients getPatientById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Patients updatePatient(Patients patient) {
        return repository.save(patient);
    }

    @Override
    public void deletePatientById(Long id) {
        repository.deleteById(id);
    }

}

