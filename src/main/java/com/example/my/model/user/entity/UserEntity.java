package com.example.my.model.user.entity;

import com.example.my.model.todo.entity.TodoEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "`USER`")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @Column(name = "update_date")
    private Instant updateDate;

    @Column(name = "delete_date")
    private Instant deleteDate;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private List<UserRoleEntity> userRoleEntityList;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private List<TodoEntity> todoEntityList;
}
