package mx.edu.uteq.idgs12.academic_ms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.edu.uteq.idgs12.academic_ms.entity.Configuration;
import mx.edu.uteq.idgs12.academic_ms.repository.ConfigurationRepository;

@Service
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    public ConfigurationService(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    public List<Configuration> getAll() {
        return configurationRepository.findAll();
    }

    public Optional<Configuration> getById(Integer id) {
        return configurationRepository.findById(id);
    }

    public List<Configuration> getByUniversity(Integer idUniversity) {
        return configurationRepository.findByUniversity_IdUniversity(idUniversity);
    }
}
