package com.dnchia.ollama.chat;

import com.dnchia.ollama.chat.dtos.MessageDTO;
import com.dnchia.ollama.chat.dtos.UserQuestionDTO;
import com.dnchia.ollama.common.dtos.StandardResponseDTO;
import com.dnchia.ollama.common.dtos.StandardResponseInfoDTO;
import org.springframework.ai.chat.client.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/chat")
@CrossOrigin("*")
public class ChatV1RestController {

    private final ChatClient springAIchatClient;

    public ChatV1RestController(ChatClient.Builder chatClientBuilder) {
        this.springAIchatClient = chatClientBuilder.build();
    }

    @GetMapping("/ping")
    public StandardResponseDTO<?> getPing() {
        return okResponse("Pong", new MessageDTO("Pong body"));
    }

    @PostMapping("/question")
    public StandardResponseDTO<?> makeQuestion(@RequestBody UserQuestionDTO userQuestionDTO) {
        ChatClient.ChatClientRequestSpec userRequest = this.springAIchatClient.prompt().user(userQuestionDTO.getTextContent());

        ChatClient.CallResponseSpec response = userRequest.call();
        return okResponse("Successful response", new MessageDTO(response.content()));
    }

    private StandardResponseDTO<?> okResponse(String info, Object data) {
        return new StandardResponseDTO<>(
                new StandardResponseInfoDTO(true, HttpStatus.OK.value(), info),
                data
        );
    }
}
