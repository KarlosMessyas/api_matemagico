package br.com.matemagico.mapper;

import br.com.matemagico.domain.Activity;
import br.com.matemagico.domain.Progress;
import br.com.matemagico.domain.StudentProfile;
import br.com.matemagico.controller.request.ProgressRequestDTO;
import br.com.matemagico.controller.response.ProgressResponseDTO;

public class ProgressMapper {

    public static Progress toEntity(ProgressRequestDTO dto, StudentProfile student, Activity activity) {
        Progress progress = new Progress();
        progress.setCorrectAnswers(dto.getCorrectAnswers());
        progress.setWrongAnswers(dto.getWrongAnswers());
        progress.setScore(dto.getScore());
        progress.setStudent(student);
        progress.setActivity(activity);
        return progress;
    }

    public static ProgressResponseDTO toResponse(Progress progress) {
        return new ProgressResponseDTO(
                progress.getId(),
                progress.getCorrectAnswers(),
                progress.getWrongAnswers(),
                progress.getScore(),
                progress.getStudent().getId(),
                progress.getActivity().getId()
        );
    }
}