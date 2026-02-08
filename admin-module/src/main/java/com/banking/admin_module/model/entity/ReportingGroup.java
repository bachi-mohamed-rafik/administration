package com.banking.admin_module.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
@Table(name = "reporting_groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ReportingGroup {

    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    // One ReportingGroup has many BGMappings
    @OneToMany(mappedBy = "reportingGroup", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("reportingGroup")
    private List<BGMapping> bgMappings;
}