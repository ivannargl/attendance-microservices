package mx.edu.uteq.idgs12.academic_ms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.uteq.idgs12.academic_ms.entity.Division;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Integer> {
    
    Optional<Division> findByCodeAndUniversity_IdUniversity(String code, Integer idUniversity);
    
    boolean existsByCodeAndUniversity_IdUniversity(String code, Integer idUniversity);
}