package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.mine.patientmanagment.model.Patients;
import org.mine.patientmanagment.interfacepackage.PatientService;

@Controller
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Handler method to handle list patients and return model and view
    @GetMapping("/patients")
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "patients";
    }

    @GetMapping("/patients/new")
    public String createPatientForm(Model model) {
        // Create patient object to hold patient form data
        Patients patient = new Patients();
        model.addAttribute("patient", patient);
        return "create_patient";
    }

    @PostMapping("/patients")
    public String savePatient(@ModelAttribute("patient") Patients patient) {
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

//    @GetMapping("/patients/edit/{id}")
//    public String editPatientForm(@PathVariable Long id, Model model) {
//        model.addAttribute("patient", patientService.getPatientById(id));
//        return "edit_patient";
//    }

    @PostMapping("/patients/{id}")
    public String updatePatient(@PathVariable Long id,
                                @ModelAttribute("patient") Patients patient,
                                Model model) {

        // Get patient from database by id
        Patients existingPatient = patientService.getPatientById(id);
        existingPatient.setId(id);
        existingPatient.setPatient_name(patient.getPatient_name());
        existingPatient.setAge(patient.getAge());
        existingPatient.setWeight(patient.getWeight());
        existingPatient.setTreatment(patient.getTreatment());

        // Save updated patient object
        patientService.updatePatient(existingPatient);
        return "redirect:/patients";
    }

    // Handler method to handle delete patient request
    @GetMapping("/patients/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatientById(id);
        return "redirect:/patients";
    }
}
