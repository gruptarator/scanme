package com.backend.dto.converter;

import com.backend.dto.AllergyDto;
import com.backend.model.Allergy;
import org.springframework.stereotype.Component;

@Component
public class AllergyConverter {

    public AllergyDto convertToDto(Allergy allergy) {
        if (allergy == null) return null;

        AllergyDto allergyDto = new AllergyDto();
        allergyDto.setAllergy_id(allergy.getId());
        allergyDto.setAllergy_name(allergy.getName());
        return allergyDto;
    }

}
