package com.project.kinhdichapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nguhanh")
@Data // To String
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NguHanh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // khi insert vao thi se autoincrement by 1
    private Long id;

    @Column(name = "name")
    private String nguHanhName;
}
