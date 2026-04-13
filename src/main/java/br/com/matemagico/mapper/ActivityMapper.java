package br.com.matemagico.mapper;

import br.com.matemagico.domain.Activity;
import br.com.matemagico.controller.request.ActivityRequestDTO;
import br.com.matemagico.controller.response.ActivityResponseDTO;

public class ActivityMapper {

    public static Activity toEntity(ActivityRequestDTO dto) {
        Activity activity = new Activity();
        activity.setType(dto.getType());
        activity.setLevel(dto.getLevel());
        activity.setContent(dto.getContent());
        return activity;
    }

    public static ActivityResponseDTO toResponse(Activity activity) {
        return new ActivityResponseDTO(
                activity.getId(),
                activity.getType(),
                activity.getLevel(),
                activity.getContent()
        );
    }
}