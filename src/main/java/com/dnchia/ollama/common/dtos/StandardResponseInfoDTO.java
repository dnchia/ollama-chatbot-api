package com.dnchia.ollama.common.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StandardResponseInfoDTO {

    private Boolean success;
    private Integer status;
    private String info;
}
