package com.backend.dto.request;

public class PasswordUpdateRequest {
    private String newPassword;

    public PasswordUpdateRequest() {
    }

    public PasswordUpdateRequest(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
