package mx.edu.uteq.idgs12.academic_ms.service;

import java.util.List;
import java.util.Optional;

import mx.edu.uteq.idgs12.academic_ms.entity.Configuration;
import mx.edu.uteq.idgs12.academic_ms.repository.ConfigurationRepository;
import mx.edu.uteq.idgs12.academic_ms.repository.UniversityRepository;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {
    private final ConfigurationRepository configurationRepository;

    public ConfigurationService(ConfigurationRepository configurationRepository,
            UniversityRepository universityRepository) {
        this.configurationRepository = configurationRepository;

    }

    public List<Configuration> getAll() {
        return configurationRepository.findAll();
    }

    public Optional<Configuration> getById(Integer id) {
        return configurationRepository.findById(id);
    }
}
