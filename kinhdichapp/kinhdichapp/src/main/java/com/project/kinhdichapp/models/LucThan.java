package com.project.kinhdichapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lucthan")
@Data // To String
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LucThan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // khi insert vao thi se autoincrement by 1
    private Long id;

    @Column(name = "hao_1")
    private String hao1;

    @Column(name = "hao_2")
    private String hao2;

    @Column(name = "hao_3")
    private String hao3;

    @Column(name = "hao_4")
    private String hao4;

    @Column(name = "hao_5")
    private String hao5;

    @Column(name = "hao_6")
    private String hao6;

    @Column(name = "phucthan_1")
    private String phuc1;

    @Column(name = "phucthan_2")
    private String phuc2;

    @Column(name = "phucthan_3")
    private String phuc3;

    @Column(name = "phucthan_4")
    private String phuc4;

    @Column(name = "phucthan_5")
    private String phuc5;

    @Column(name = "phucthan_6")
    private String phuc6;
}
