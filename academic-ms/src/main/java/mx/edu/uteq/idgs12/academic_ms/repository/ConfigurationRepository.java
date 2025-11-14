package mx.edu.uteq.idgs12.academic_ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.uteq.idgs12.academic_ms.entity.Configuration;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Integer> {
    List<Configuration> findByUniversity_IdUniversity(Integer idUniversity);
}

