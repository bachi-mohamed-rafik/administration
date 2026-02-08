package com.banking.admin_module.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
@Table(name = "groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Group {

    @Id
    private String id;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column
    private String url;

    @Column(length = 500)
    private String description;

    // OneToMany → UserGroup
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("group")
    private List<UserGroup> userGroups;

    // OneToMany → Permission (Group has many permissions)
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("group")
    private List<Permission> permissions;
}