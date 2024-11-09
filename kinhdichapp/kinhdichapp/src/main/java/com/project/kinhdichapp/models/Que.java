package com.project.kinhdichapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ques")
@Data // To String
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Que {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // khi insert vao thi se autoincrement by 1
    private Long id;

    @Column(name = "que_name")
    private String queName;

    @Column(name = "hao_1")
    private int haoOne;

    @Column(name = "hao_2")
    private int haoTwo;

    @Column(name = "hao_3")
    private int haoThree;

    @Column(name = "hao_4")
    private int haoFour;

    @Column(name = "hao_5")
    private int haoFive;

    @Column(name = "hao_6")
    private int haoSix;

    @Column(name = "type_que")
    private String typeQue;

    @ManyToOne
    @JoinColumn(name= "cung_ngoai_quai")
    private Cung cungNgoaiQuai;

    @ManyToOne
    @JoinColumn(name= "cung_noi_quai")
    private Cung cungNoiQuai;

    @ManyToOne
    @JoinColumn(name = "cung_id")
    private Cung cung;

    @ManyToOne
    @JoinColumn(name = "nguhanh_id")
    private NguHanh nguHanh;

    @OneToOne
    @JoinColumn(name = "quetuoi_id")
    private QueTuoi queTuoi;

    @ManyToOne
    @JoinColumn(name="the_ung")
    private  TheUng theUng;

    @ManyToOne
    @JoinColumn(name = "luc_than")
    private LucThan lucThan;

    // Su dung de truyen ngươc lại bên frontend
    @Column(name = "dong_1")
    private int dongOne;

    @Column(name = "dong_2")
    private int dongTwo;

    @Column(name = "dong_3")
    private int dongThree;

    @Column(name = "dong_4")
    private int dongFour;

    @Column(name = "dong_5")
    private int dongFive;

    @Column(name = "dong_6")
    private int dongSix;

}

