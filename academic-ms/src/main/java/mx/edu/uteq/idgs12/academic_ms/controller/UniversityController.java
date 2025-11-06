package mx.edu.uteq.idgs12.academic_ms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.uteq.idgs12.academic_ms.dto.UniversityDTO;
import mx.edu.uteq.idgs12.academic_ms.entity.University;
import mx.edu.uteq.idgs12.academic_ms.service.UniversityService;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public List<University> getAll() {
        return universityService.getAll();
    }

   


    @GetMapping("/{id}")
    public ResponseEntity<University> getById(@PathVariable Integer id) {
        Optional<University> university = universityService.getById(id);
        return university.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<University> update(@PathVariable Integer id, @RequestBody UniversityDTO dto) {
        dto.setIdUniversity(id);
        return ResponseEntity.ok(universityService.save(dto));
    }
}
