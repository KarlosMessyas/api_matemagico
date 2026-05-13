package br.com.matemagico.mapper;

import br.com.matemagico.domain.Progress;
import br.com.matemagico.controller.response.ProgressResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ProgressMapper {

    public static ProgressResponseDTO toResponse(Progress entity) {
        if (entity == null) {
            return null;
        }

        ProgressResponseDTO dto = new ProgressResponseDTO();
        dto.setId(entity.getId());
        dto.setStudentId(entity.getStudent().getId());
        dto.setActivityId(entity.getActivity().getId());

        dto.setCorrectAnswers(entity.getCorrectAnswers());
        dto.setWrongAnswers(entity.getWrongAnswers());
        dto.setScore(entity.getScore());
        dto.setTimeSpentInSeconds(entity.getTimeSpentInSeconds());
        dto.setCompletionDate(entity.getCompletionDate());

        dto.setCorrect(entity.getCorrectAnswers() > 0);

        return dto;
    }
}