package fs.miaad.tp2_daoudi_halima.service;

import fs.miaad.tp2_daoudi_halima.entities.Consultation;
import fs.miaad.tp2_daoudi_halima.entities.Medecin;
import fs.miaad.tp2_daoudi_halima.entities.Patient;
import fs.miaad.tp2_daoudi_halima.entities.RendezVous;
import fs.miaad.tp2_daoudi_halima.repository.ConsultationRepository;
import fs.miaad.tp2_daoudi_halima.repository.MedecinRepository;
import fs.miaad.tp2_daoudi_halima.repository.PatientRepository;
import fs.miaad.tp2_daoudi_halima.repository.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public IHospitalServiceImpl(PatientRepository p, MedecinRepository m, RendezVousRepository r, ConsultationRepository c) {
        this.patientRepository = p;
        this.medecinRepository = m;
        this.rendezVousRepository = r;
        this.consultationRepository = c;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
