package com.banking.admin_module.model.enums;

public enum ErrorCode {
    ERR_INVALID_ARGUMENT("ERR_INVALID_ARGUMENT", "Invalid argument provided."),
    ERR_ENTITY_NOT_FOUND("ERR_ENTITY_NOT_FOUND", "The requested entity was not found."),
    USER_NOT_FOUND("USER_NOT_FOUND", "The specified user was not found."),
    BRANCH_NOT_FOUND("BRANCH_NOT_FOUND", "The specified branch was not found."),
    GROUP_NOT_FOUND("GROUP_NOT_FOUND","group not found"  ),
    REPORTING_GROUP_NOT_FOUND("REPORTING_GROUP_NOT_FOUND", "The specified reporting group was not found."),
    INVALID_INPUT("INVALID_INPUT","The provided input is invalid."),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR","An unexpected error occurred. Please try again later.");

    private final String code;
    private final String description;

    ErrorCode(String code, String description) {
        this.code = code;
        this.description  = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
