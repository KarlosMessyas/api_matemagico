package br.com.matemagico.mapper;

import br.com.matemagico.domain.StudentProfile;
import br.com.matemagico.domain.User;
import br.com.matemagico.controller.request.StudentProfileRequestDTO;
import br.com.matemagico.controller.response.StudentProfileResponseDTO;

public class StudentProfileMapper {

    public static StudentProfile toEntity(StudentProfileRequestDTO dto, User user) {
        StudentProfile profile = new StudentProfile();
        profile.setLevel(dto.getLevel());
        profile.setPreferences(dto.getPreferences());
        profile.setUser(user);
        profile.setAutismLevel(dto.getAutismLevel());
        profile.setAge(dto.getAge());
        profile.setSoundSensitivity(dto.getSoundSensitivity());
        profile.setColorSensitivity(dto.getColorSensitivity());
        return profile;
    }

    public static StudentProfileResponseDTO toResponse(StudentProfile profile) {
        return new StudentProfileResponseDTO(
                profile.getId(),
                profile.getLevel(),
                profile.getPreferences(),
                profile.getUser().getId(),
                profile.getAutismLevel(),
                profile.getAge(),
                profile.getSoundSensitivity(),
                profile.getColorSensitivity()
        );
    }
}