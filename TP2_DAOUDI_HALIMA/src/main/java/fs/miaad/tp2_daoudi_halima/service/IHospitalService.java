package fs.miaad.tp2_daoudi_halima.service;
import fs.miaad.tp2_daoudi_halima.entities.Consultation;
import fs.miaad.tp2_daoudi_halima.entities.Medecin;
import fs.miaad.tp2_daoudi_halima.entities.Patient;
import fs.miaad.tp2_daoudi_halima.entities.RendezVous;
public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
