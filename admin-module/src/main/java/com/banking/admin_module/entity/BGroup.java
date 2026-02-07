package com.banking.admin_module.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "business_groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BGroup {

    @Id
    private String id;

    @Column(nullable = false, unique= true)
    private String code;


    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    // One-to-One relationship with BGMapping
    @OneToOne(mappedBy = "businessGroup", cascade = CascadeType.ALL)
    private BGMapping bgMapping;
}
