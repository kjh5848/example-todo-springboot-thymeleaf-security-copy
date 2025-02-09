package com.example.my.domain.todo.dto.res;

import com.example.my.model.todo.entity.TodoEntity;
import com.example.my.util.UtilFunction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ResTodoDTO {

    private List<Todo> todoList;
    private List<Todo> doneList;

    public static ResTodoDTO of(List<TodoEntity> todoEntityList) {
        return ResTodoDTO.builder()
                .todoList(
                        todoEntityList.stream()
                                .filter(todoEntity -> todoEntity.getDoneYn().equals("N"))
                                .map(todoEntity -> Todo.fromEntity(todoEntity))
                                .toList())
                .doneList(
                        todoEntityList.stream()
                                .filter(todoEntity -> todoEntity.getDoneYn().equals("Y"))
                                .map(todoEntity -> Todo.fromEntity(todoEntity))
                                .toList())
                .build();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Todo {

        private Long id;
        private String content;
        private String doneYn;
        private String createDate;

        public static Todo fromEntity(TodoEntity todoEntity) {
            return Todo.builder()
                    .id(todoEntity.getId())
                    .content(todoEntity.getContent())
                    .doneYn(todoEntity.getDoneYn())
                    .createDate( // 타임리프 템플릿이라 시간대를 서버의 시간대로 지정
                            UtilFunction.getZonedDateTimeStringBy(
                                    todoEntity.getCreateDate(),
                                    ZoneId.systemDefault(),
                                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                            )
                    )
                    .build();
        }
    }
}
