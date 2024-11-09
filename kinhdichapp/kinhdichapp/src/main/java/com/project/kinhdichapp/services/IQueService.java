package com.project.kinhdichapp.services;

import com.project.kinhdichapp.dtos.QueDTO;
import com.project.kinhdichapp.models.Que;

import java.util.List;
import java.util.Optional;

public interface IQueService {
    // Tìm quẻ Gốc
    Optional<Que> getQueByDTO (QueDTO queDTO);

    // Show all quẻ
    List<Que> getAllQue();

    // Tìm quẻ biến
    Optional<Que> getQueBienDTO(QueDTO queDTO);
}
