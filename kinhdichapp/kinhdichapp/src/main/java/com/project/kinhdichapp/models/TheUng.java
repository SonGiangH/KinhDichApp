package com.project.kinhdichapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theung")
@Data // To String
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheUng {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // khi insert vao thi se autoincrement by 1
    private Long id;

    @Column(name = "hao_1")
    private String pos1;

    @Column(name = "hao_2")
    private String pos2;

    @Column(name = "hao_3")
    private String pos3;

    @Column(name = "hao_4")
    private String pos4;

    @Column(name = "hao_5")
    private String pos5;

    @Column(name = "hao_6")
    private String pos6;
}
