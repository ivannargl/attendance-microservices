package mx.edu.uteq.idgs12.academic_ms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import mx.edu.uteq.idgs12.academic_ms.dto.DivisionDTO;
import mx.edu.uteq.idgs12.academic_ms.entity.Division;
import mx.edu.uteq.idgs12.academic_ms.repository.DivisionRepository;


@Repository
public class DivisionService {
    private final DivisionRepository divisionRepository;


    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public List<DivisionDTO> getAll() {
        return divisionRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<DivisionDTO> getAllActive() {
        return divisionRepository.findByStatusTrue()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    
    @Transactional
    public DivisionDTO updateStatus(Integer id, Boolean status) {
        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Division not found with ID: " + id));
        division.setStatus(status);
        return toDTO(divisionRepository.save(division));
    }

    private DivisionDTO toDTO(Division division) {
        DivisionDTO dto = new DivisionDTO();
        dto.setIdDivision(division.getIdDivision());
        dto.setIdUniversity(division.getUniversity().getIdUniversity());
        dto.setCode(division.getCode());
        dto.setName(division.getName());
        dto.setDescription(division.getDescription());
        dto.setStatus(division.getStatus());
        return dto;
    }

}
