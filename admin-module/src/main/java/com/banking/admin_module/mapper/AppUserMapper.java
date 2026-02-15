package com.banking.admin_module.mapper;

import com.banking.admin_module.model.dto.AppUser.request.CreateAppUserRequest;
import com.banking.admin_module.model.dto.AppUser.request.UpdateAppUserRequest;
import com.banking.admin_module.model.dto.AppUser.response.AppUserResponse;
import com.banking.admin_module.model.entity.AppUser;
import com.banking.admin_module.model.entity.Bank;
import com.banking.admin_module.model.entity.Branch;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppUserMapper {

    // ========== CREATE ==========

    @Mapping(target = "id", expression = "java(generateUserId())")
    @Mapping(target = "bank", source = "bankId", qualifiedByName = "mapBank")
    @Mapping(target = "branch", source = "branchId", qualifiedByName = "mapBranch")
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "isOverrideChecker", expression = "java(booleanToString(request.isOverrideChecker()))")
    @Mapping(target = "blockStatus", constant = "0")
    @Mapping(target = "firstTimeLoginFlag", constant = "1")
    @Mapping(target = "isActiveFlag", constant = "1")
    @Mapping(target = "softDelFlag", constant = "0")
    @Mapping(target = "countAttempts", constant = "0")
    @Mapping(target = "createdTime", expression = "java(now())")
    @Mapping(target = "bgMappings", ignore = true)
    @Mapping(target = "userGroups", ignore = true)
    AppUser toEntity(CreateAppUserRequest request);

    // ========== UPDATE ==========

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "loginName", ignore = true)
    @Mapping(target = "bank", source = "bankId", qualifiedByName = "mapBank")
    @Mapping(target = "branch", source = "branchId", qualifiedByName = "mapBranch")
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "isOverrideChecker", expression = "java(booleanToString(request.isOverrideChecker()))")
    @Mapping(target = "blockStatus", expression = "java(booleanToString(request.isBlocked()))")
    @Mapping(target = "isActiveFlag", expression = "java(booleanToString(request.isActive()))")
    @Mapping(target = "modifiedTime", expression = "java(now())")
    @Mapping(target = "bgMappings", ignore = true)
    @Mapping(target = "userGroups", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget AppUser entity, UpdateAppUserRequest request);

    // ========== TO RESPONSE ==========

    @Mapping(target = "bankId", source = "bank.id")
    @Mapping(target = "bankName", source = "bank.name")
    @Mapping(target = "branchId", source = "branch.id")
    @Mapping(target = "branchName", source = "branch.branchName")  // Fixed: was branch.name
    @Mapping(target = "isOverrideChecker", expression = "java(stringToBoolean(entity.getIsOverrideChecker()))")
    @Mapping(target = "isBlocked", expression = "java(stringToBoolean(entity.getBlockStatus()))")
    @Mapping(target = "isActive", expression = "java(stringToBoolean(entity.getIsActiveFlag()))")
    AppUserResponse toResponse(AppUser entity);

    List<AppUserResponse> toResponseList(List<AppUser> entities);

    // ========== HELPER METHODS ==========

    @Named("mapBank")
    default Bank mapBank(Long bankId) {
        if (bankId == null) return null;
        Bank bank = new Bank();
        bank.setId(bankId);
        return bank;
    }

    @Named("mapBranch")
    default Branch mapBranch(Long branchId) {
        if (branchId == null) return null;
        Branch branch = new Branch();
        branch.setId(branchId);
        return branch;
    }

    default String generateUserId() {
        return UUID.randomUUID().toString();
    }

    default LocalDateTime now() {
        return LocalDateTime.now();
    }

    default String booleanToString(Boolean value) {
        if (value == null) return "0";
        return value ? "1" : "0";
    }

    default Boolean stringToBoolean(String value) {
        return value != null && value.equals("1");
    }
}