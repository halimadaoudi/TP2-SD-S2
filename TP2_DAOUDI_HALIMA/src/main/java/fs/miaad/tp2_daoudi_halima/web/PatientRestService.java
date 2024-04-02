package fs.miaad.tp2_daoudi_halima.web;

import fs.miaad.tp2_daoudi_halima.entities.Patient;
import fs.miaad.tp2_daoudi_halima.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestService {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> patients(){
        return patientRepository.findAll();
    }
    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable Long id){
        return patientRepository.findById(id).orElse(null);
    }
}
