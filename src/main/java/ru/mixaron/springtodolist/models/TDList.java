package ru.mixaron.springtodolist.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "list")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TDList {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Name cannot be null")
    private String name;

    @Column(name = "content")
    @NotEmpty(message = "Content cant be null")
    private String content;

    @Column(name = "is_completed")
    private boolean isCompleted;
}
