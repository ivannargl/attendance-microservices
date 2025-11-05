package mx.edu.uteq.idgs12.academic_ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uteq.idgs12.academic_ms.dto.UniversityDTO;
import mx.edu.uteq.idgs12.academic_ms.entity.University;

import mx.edu.uteq.idgs12.academic_ms.repository.UniversityRepository;

@Service
public class UniversityService {

    private final UniversityRepository universityRepository;
   

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
        
    }

    public List<University> getAll() {
        return universityRepository.findAll();
    }

    public Optional<University> getById(Integer id) {
        return universityRepository.findById(id);
    }
    
    @Transactional
    public University save(UniversityDTO dto) {
        University university = new University();
        university.setIdUniversity(dto.getIdUniversity());
        university.setCode(dto.getCode());
        university.setName(dto.getName());
        university.setCampus(dto.getCampus());
        university.setAddress(dto.getAddress());
        university.setLogo(dto.getLogo());
        university.setEmail(dto.getEmail());
        university.setStatus(dto.getStatus() != null ? dto.getStatus() : true);

        University savedUniversity = universityRepository.save(university);

        return savedUniversity;
    }

}
