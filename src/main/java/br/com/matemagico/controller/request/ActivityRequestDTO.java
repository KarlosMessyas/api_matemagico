package br.com.matemagico.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivityRequestDTO {

    private String type;
    private Integer level;
    private String content;
}