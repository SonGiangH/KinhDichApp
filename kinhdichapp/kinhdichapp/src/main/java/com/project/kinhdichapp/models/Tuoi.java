package com.project.kinhdichapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tuoi")
@Data // To String
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tuoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // khi insert vao thi se autoincrement by 1
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "nguhanh_id")
    private NguHanh nguHanh;
}
