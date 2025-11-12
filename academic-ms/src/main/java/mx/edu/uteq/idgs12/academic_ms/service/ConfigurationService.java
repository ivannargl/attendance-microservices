package mx.edu.uteq.idgs12.academic_ms.service;

import mx.edu.uteq.idgs12.academic_ms.entity.Configuration;
import mx.edu.uteq.idgs12.academic_ms.repository.ConfigurationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    public ConfigurationService(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    public List<Configuration> getAll() {
        return configurationRepository.findAll();
    }
}