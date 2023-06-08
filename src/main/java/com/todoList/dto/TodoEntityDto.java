package com.todoList.dto;

import com.sun.istack.NotNull;
import com.todoList.domain.entity.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntityDto {
    @NotNull
    private Long id;

    private String title;

    private String content;
    private String imageURl;
    private int progressCount;

    private int colorCount;
    private String createdDate;
    private String modifiedDate;

    public TodoEntityDto (TodoEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.imageURl = entity.getImageURl();
        this.progressCount = entity.getProgressCount();
        this.colorCount = entity.getColorCount();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }

    public TodoEntity toEntity() {
        return TodoEntity.builder()
                .title(title)
                .content(content)
                .imageURl(imageURl)
                .progressCount(progressCount)
                .colorCount(colorCount)
                .build();
    }
}
