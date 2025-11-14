package mx.edu.uteq.idgs12.academic_ms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.edu.uteq.idgs12.academic_ms.entity.Division;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Integer> {
    List<Division> findByUniversity_IdUniversity(Integer idUniversity);
    List<Division> findByStatusTrue();
    
}
