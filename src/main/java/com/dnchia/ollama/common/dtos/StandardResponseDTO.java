package com.dnchia.ollama.common.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponseDTO<T> {

    private StandardResponseInfoDTO info;
    private T data;
}
