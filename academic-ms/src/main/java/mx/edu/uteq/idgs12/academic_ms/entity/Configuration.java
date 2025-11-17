package mx.edu.uteq.idgs12.academic_ms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConfiguration;

    @ManyToOne
    @JoinColumn(name = "idUniversity", nullable = false)
    private University university;

    @Column(length = 100, nullable = false)
    private String parameterName;

    @Column(length = 255)
    private String parameterValue;

    @Column(length = 255)
    private String description;
}
