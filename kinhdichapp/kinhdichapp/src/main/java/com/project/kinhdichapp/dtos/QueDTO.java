package com.project.kinhdichapp.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@Data // To String
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QueDTO {

    @JsonProperty("hao_1")
    @NotNull(message = "Chọn hào !")
    private int hao1;

    @JsonProperty("hao_2")
    @NotNull(message = "Chọn hào !")
    private int hao2;

    @JsonProperty("hao_3")
    @NotNull(message = "Chọn hào !")
    private int hao3;

    @JsonProperty("hao_4")
    @NotNull(message = "Chọn hào !")
    private int hao4;

    @JsonProperty("hao_5")
    @NotNull(message = "Chọn hào !")
    private int hao5;

    @JsonProperty("hao_6")
    @NotNull(message = "Chọn hào !")
    private int hao6;

    @JsonProperty("dong_1")
    private int dong1;

    @JsonProperty("dong_2")
    private int dong2;

    @JsonProperty("dong_3")
    private int dong3;

    @JsonProperty("dong_4")
    private int dong4;

    @JsonProperty("dong_5")
    private int dong5;

    @JsonProperty("dong_6")
    private int dong6;

    // Constructor sao chép
    public QueDTO(QueDTO clone) {
        this.hao1 = clone.hao1;
        this.hao2 = clone.hao2;
        this.hao3 = clone.hao3;
        this.hao4 = clone.hao4;
        this.hao5 = clone.hao5;
        this.hao6 = clone.hao6;
        this.dong1 = clone.dong1;
        this.dong2 = clone.dong2;
        this.dong3 = clone.dong3;
        this.dong4 = clone.dong4;
        this.dong5 = clone.dong5;
        this.dong6 = clone.dong6;
    }
}
