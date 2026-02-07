package com.banking.admin_module.entity;

import com.banking.admin_module.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name ;

    @Column(nullable = false, unique = false)
    private String description;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Branch> branches;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Currency currencyId; //FK currency

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Country countryId; //FK currency

    @Column(nullable = false, unique = false)
    private Boolean nettingAllowedFlag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private BfsiGroup bfsiGroup;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status; //Enum 0 ou 1

    @Column(nullable = true, unique = false)
    private String nameLocal;

    @Column(nullable = true, unique = false)
    private String bankLogo;

}
