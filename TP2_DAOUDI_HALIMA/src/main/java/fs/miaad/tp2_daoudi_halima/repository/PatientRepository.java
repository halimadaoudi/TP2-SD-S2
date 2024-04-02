package fs.miaad.tp2_daoudi_halima.repository;

import fs.miaad.tp2_daoudi_halima.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String nom);
    List<Patient> findByMalade(boolean malade);
    // List<Patient> findByScoreGreaterThan(int x)
    @Query("select p from Patient p where p.score >= :x ")
    List<Patient> SupScore(@Param("x") int sc);
}


