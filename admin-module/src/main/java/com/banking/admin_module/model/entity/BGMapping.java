package com.banking.admin_module.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user_business_group_mappings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BGMapping {

    @Id
    private String id;

    // ManyToOne → AppUser
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties("bgMappings")
    private AppUser user;

    @Column(name = "bank_id", nullable = false)
    private String bankId;

    // One-to-One with BGroup
    @OneToOne
    @JoinColumn(name = "business_group_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties("bgMapping")
    private BGroup businessGroup;

    // ManyToOne with ReportingGroup
    @ManyToOne
    @JoinColumn(name = "reporting_group_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties("bgMappings")
    private ReportingGroup reportingGroup;

    @Column(name = "group_id")
    private String groupId; // Future use

    @Column(name = "category_id")
    private String categoryId; // Future use
}