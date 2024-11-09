package com.project.kinhdichapp.models;

// Bang Cung

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cungs")
@Data // To String
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // khi insert vao thi se autoincrement by 1
    private Long id;


    @Column(name = "cung_name")
    private String cungName;

    @Column(name = "hao_1")
    private int hao1;

    @Column(name = "hao_2")
    private int hao2;

    @Column(name = "hao_3")
    private int hao3;

    @Column(name = "nguhanh_id")
    private int nguHanhId;

}
