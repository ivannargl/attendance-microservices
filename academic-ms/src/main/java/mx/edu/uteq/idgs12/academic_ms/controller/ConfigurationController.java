package mx.edu.uteq.idgs12.academic_ms.controller;
import java.util.List;
import java.util.Optional;

import mx.edu.uteq.idgs12.academic_ms.entity.Configuration;
import mx.edu.uteq.idgs12.academic_ms.service.ConfigurationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/configurations")
public class ConfigurationController {

    private final ConfigurationService configurationService;
    
    public ConfigurationController(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }
    @GetMapping
    public List<Configuration> getAll() {
        return configurationService.getAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Configuration> getById(@PathVariable Integer id) {
        Optional<Configuration> config = configurationService.getById(id);
        return config.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
