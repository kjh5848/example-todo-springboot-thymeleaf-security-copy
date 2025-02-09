package com.example.my.model.todo.entity;

import com.example.my.model.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "TODO")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false, nullable = false)
    private UserEntity userEntity;

    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "done_yn", nullable = false)
    private String doneYn;

    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @Column(name = "update_date")
    private Instant updateDate;

    @Column(name = "delete_date")
    private Instant deleteDate;

    public void setDoneYn(String doneYn) {
        this.doneYn = doneYn;
        this.updateDate = Instant.now();
    }

    public void setDeleteDate(Instant deleteDate) {
        this.deleteDate = deleteDate;
    }
}
