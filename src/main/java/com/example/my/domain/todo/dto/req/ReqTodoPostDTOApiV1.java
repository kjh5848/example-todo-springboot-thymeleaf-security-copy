package com.example.my.domain.todo.dto.req;

import com.example.my.model.todo.entity.TodoEntity;
import com.example.my.model.user.entity.UserEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReqTodoPostDTOApiV1 {

    @Valid
    @NotNull(message = "내용을 양식에 맞게 입력해주세요.")
    private Todo todo;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Todo {

        @NotBlank(message = "할 일을 입력해주세요.")
        private String content;

    }

    public TodoEntity toEntity(UserEntity userEntity) {
        return TodoEntity.builder()
                .userEntity(userEntity)
                .content(this.todo.getContent())
                .doneYn("N")
                .createDate(Instant.now())
                .build();
    }
}
