package com.banking.admin_module.model.entity;

import com.banking.admin_module.model.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import com.banking.admin_module.model.enums.isMainBranch;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Branches")
public class Branch {
    @Id
    @GeneratedValue()
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;

    @Column(nullable = false, unique = true)
    private String branchName;

    @Column
    private String branchCode;

    @Column(nullable = false, unique = true)
    private String branchNameLocal;

    @Column(nullable = false, unique = true)
    private String adress;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column
    private isMainBranch isMainBranch;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt; // Use java.time API types

}
