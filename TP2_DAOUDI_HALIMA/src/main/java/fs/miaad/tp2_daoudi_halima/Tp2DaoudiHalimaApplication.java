package fs.miaad.tp2_daoudi_halima;

import fs.miaad.tp2_daoudi_halima.entities.*;
import fs.miaad.tp2_daoudi_halima.repository.ConsultationRepository;
import fs.miaad.tp2_daoudi_halima.repository.MedecinRepository;
import fs.miaad.tp2_daoudi_halima.repository.PatientRepository;
import fs.miaad.tp2_daoudi_halima.repository.RendezVousRepository;
import fs.miaad.tp2_daoudi_halima.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp2DaoudiHalimaApplication implements CommandLineRunner {

	@Autowired
	private IHospitalService iHospitalService;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private MedecinRepository medecinRepository;
    @Autowired
	private RendezVousRepository rendezVousRepository;
    @Autowired
	private ConsultationRepository consultationRepository;

	public static void main(String[] args) {

		SpringApplication.run(Tp2DaoudiHalimaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("HALIMA1","DAOUDI1", "HALIMA2" , "DAOUDI2").forEach(name->{
			Patient p = new Patient();
			p.setNom(name);
			p.setDateNaissance(new Date());
			p.setMalade(false);
			iHospitalService.savePatient(p);
		});
		Stream.of("YASMINE","AMINE", "HANANE" , "Youssef").forEach(name->{
			Medecin m = new Medecin();
			m.setNom(name);
			m.setEmail(name+"@gmail.com");
			m.setSpecialite(Math.random()>0.5 ? "Cardio" : "Dentiste");
			iHospitalService.saveMedecin(m);
		} );
		Patient patient = patientRepository.findByNom("HALIMA2");
		Medecin medecin = medecinRepository.findByNom("YASMINE");

		RendezVous rendezVous = new RendezVous();
		rendezVous.setDate(new Date());
		rendezVous.setStatus(StatusRDV.EnCours);
		rendezVous.setMedecin(medecin);
		rendezVous.setPatient(patient);
		iHospitalService.saveRDV(rendezVous);

		RendezVous rv = rendezVousRepository.findById(1L).orElse(null);
		Consultation consultation = new Consultation();
		consultation.setDateConsultation(rv.getDate());
		consultation.setRendezVous(rv);
		consultation.setRapport("Rapport de la consultation...");
		iHospitalService.saveConsultation(consultation);


//		patientRepository.save(new Patient(null,"HALIMA1", new Date(), true, 75));
//		patientRepository.save(new Patient(null,"HALIMA2", new Date(), false, 0));
//		patientRepository.save(new Patient(null,"HALIMA3", new Date(), true, 10));
//        // consulter tous les patients
//		List<Patient> patients = patientRepository.findAll();
//		System.out.println("Liste des patients : ");
//		for (Patient patient : patients) {
//			System.out.println(patient);
//		}
//		// Consulter un patient
//		Patient p = patientRepository.findById(Long.valueOf(1)).get();
//		System.out.println("***************");
//		System.out.println(p.getId());
//		System.out.println(p.getNom());
//		System.out.println(p.getDateNaissance());
//		System.out.println(p.isMalade());
//		System.out.println(p.getScore());
//		System.out.println("***************");
//		// Chercher des patients
//		List<Patient> patientsByMalades = patientRepository.findByMalade(true);
//		System.out.println("Liste des patients malades : ");
//		for (Patient patient : patientsByMalades) {
//			System.out.println(patient);
//		}
//		//  Mettre à jour un patient
//		Patient patientUpdate = patientRepository.findById(Long.valueOf(2)).get();
//		patientUpdate.setMalade(true);
//		patientUpdate.setScore(80);
//		patientRepository.save(patientUpdate);
//		System.out.println("Patient mis à jour avec succès : " + patientUpdate);
//
//		// score sup a 50
//		List<Patient> patientsScore = patientRepository.SupScore(50);
//		System.out.println("Liste des patients avec score plus 50 : ");
//		for (Patient patient : patientsScore) {
//			System.out.println(patient);
//		}
//
//		//  supprimer un patient
//		//patientRepository.delete(patientRepository.findById(Long.valueOf(3)).get());
//		if (! patientRepository.findById(Long.valueOf(3)).isPresent()) {
//			System.out.println("Patient supprimé avec succès. ");
//		}

	}
}
