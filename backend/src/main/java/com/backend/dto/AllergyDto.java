package com.backend.dto;

public class AllergyDto {
    private Long allergy_id;
    private String allergy_name;

    public AllergyDto() {
    }

    public AllergyDto(Long allergy_id, String allergy_name) {
        this.allergy_id = allergy_id;
        this.allergy_name = allergy_name;
    }

    public Long getAllergy_id() {
        return allergy_id;
    }

    public void setAllergy_id(Long allergy_id) {
        this.allergy_id = allergy_id;
    }

    public String getAllergy_name() {
        return allergy_name;
    }

    public void setAllergy_name(String allergy_name) {
        this.allergy_name = allergy_name;
    }
}
