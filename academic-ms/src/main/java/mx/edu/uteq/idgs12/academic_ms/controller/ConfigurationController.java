package mx.edu.uteq.idgs12.academic_ms.controller;

import mx.edu.uteq.idgs12.academic_ms.entity.Configuration;
import mx.edu.uteq.idgs12.academic_ms.service.ConfigurationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/university/{idUniversity}")
    public List<Configuration> getByUniversity(@PathVariable Integer idUniversity) {
        return configurationService.getByUniversity(idUniversity);
    }
}