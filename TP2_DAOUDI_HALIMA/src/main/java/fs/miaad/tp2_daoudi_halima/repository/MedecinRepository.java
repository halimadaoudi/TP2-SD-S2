package fs.miaad.tp2_daoudi_halima.repository;

import fs.miaad.tp2_daoudi_halima.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);
}
