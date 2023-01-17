package com.todoList.domain.entity;

import com.todoList.domain.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TODO")
public class TodoEntity extends BaseTimeEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String title;

        @Column(length = 500)
        private String content;
        private String imageURl;
        private int progressCount;

        @Builder
        public TodoEntity(String title, String content, String imageURl, int progressCount) {
                this.title = title;
                this.content = content;
                this.imageURl = imageURl;
                this.progressCount = progressCount;
        }

        public void update(String title, String content, String imageURl, int progressCount) {
                this.title = title;
                this.content = content;
                this.imageURl = imageURl;
                this.progressCount = progressCount;
        }
}
