package com.tgc.vitrine.repository;

import com.tgc.vitrine.model.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {
    // Grace à JpaRepository, tu as déjà accès à :
    // .findAll(), .findById(), .save(), .delete(), etc.
}
