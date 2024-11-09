package com.project.kinhdichapp.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quetuoi")
@Data // To String
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueTuoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // khi insert vao thi se autoincrement by 1
    private Long id;

    @Column(name = "que_name")
    private String queName;

    @ManyToOne
    @JoinColumn(name = "hao_1")
    private Tuoi tuoiHao1;

    @ManyToOne
    @JoinColumn(name = "hao_2")
    private Tuoi tuoiHao2;

    @ManyToOne
    @JoinColumn(name = "hao_3")
    private Tuoi tuoiHao3;

    @ManyToOne
    @JoinColumn(name = "hao_4")
    private Tuoi tuoiHao4;

    @ManyToOne
    @JoinColumn(name = "hao_5")
    private Tuoi tuoiHao5;

    @ManyToOne
    @JoinColumn(name = "hao_6")
    private Tuoi tuoiHao6;


}
