package br.com.matemagico.mapper;

import br.com.matemagico.domain.StudentProfile;
import br.com.matemagico.domain.User;
import br.com.matemagico.controller.request.StudentProfileRequestDTO;
import br.com.matemagico.controller.response.StudentProfileResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentProfileMapper {

    public static StudentProfile toEntity(StudentProfileRequestDTO dto, User user) {
        StudentProfile entity = new StudentProfile();
        entity.setUser(user);
        entity.setLevel(dto.getLevel());
        entity.setAge(dto.getAge());
        entity.setAutismLevel(dto.getAutismLevel());

        entity.setHyperfocus(dto.getHyperfocus());
        entity.setAvatar(dto.getAvatar());
        entity.setThemeColor(dto.getThemeColor());
        entity.setFontSize(dto.getFontSize());
        entity.setSoundSensitivity(dto.getSoundSensitivity());
        entity.setColorSensitivity(dto.getColorSensitivity());

        return entity;
    }

    public static StudentProfileResponseDTO toResponse(StudentProfile entity) {
        if (entity == null) {
            return null;
        }

        StudentProfileResponseDTO dto = new StudentProfileResponseDTO();
        dto.setId(entity.getId());
        dto.setLevel(entity.getLevel());
        dto.setAge(entity.getAge());
        dto.setAutismLevel(entity.getAutismLevel());

        dto.setHyperfocus(entity.getHyperfocus());
        dto.setAvatar(entity.getAvatar());
        dto.setThemeColor(entity.getThemeColor());
        dto.setFontSize(entity.getFontSize());
        dto.setSoundSensitivity(entity.getSoundSensitivity());
        dto.setColorSensitivity(entity.getColorSensitivity());

        dto.setUserId(entity.getUser().getId());

        return dto;
    }
}