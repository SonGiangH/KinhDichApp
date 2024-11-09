package com.project.kinhdichapp.services;

import com.project.kinhdichapp.dtos.QueDTO;
import com.project.kinhdichapp.models.Que;
import com.project.kinhdichapp.repositories.QueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //khong can tao constructor trong moi method nua
public class QueService implements IQueService {

    private final QueRepository queRepository;

    // Tìm quẻ gốc
    @Override
    public Optional<Que> getQueByDTO(QueDTO queDTO) {
        List<Que> existingQues = queRepository.findAll();

        Optional<Que> matchingQue = existingQues.stream().filter(que -> que.getHaoOne() == queDTO.getHao1()
                                        && que.getHaoTwo() == queDTO.getHao2()
                                        && que.getHaoThree() == queDTO.getHao3()
                                        && que.getHaoFour() == queDTO.getHao4()
                                        && que.getHaoFive() == queDTO.getHao5()
                                        && que.getHaoSix() == queDTO.getHao6()).findFirst();
         if (matchingQue.isPresent()) {
                matchingQue.get().setDongOne(queDTO.getDong1());
                matchingQue.get().setDongTwo(queDTO.getDong2());
                matchingQue.get().setDongThree(queDTO.getDong3());
                matchingQue.get().setDongFour(queDTO.getDong4());
                matchingQue.get().setDongFive(queDTO.getDong5());
                matchingQue.get().setDongSix(queDTO.getDong6());
         }

        return matchingQue;
    }

    // Tìm tất cả 64 quẻ
    @Override
    public List<Que> getAllQue() {
        return queRepository.findAll();
    }

    // Tìm quẻ biến
    @Override
    public Optional<Que> getQueBienDTO(QueDTO queDTO) {
        // Tra ve null neu que goc khong co hao dong
        if (queDTO.getDong1() == 0 &&
                queDTO.getDong2() == 0 &&
                queDTO.getDong3() == 0 &&
                queDTO.getDong4() == 0 &&
                queDTO.getDong5() == 0 &&
                queDTO.getDong6() == 0
        )   return Optional.empty();

        // Tạo bản sao của QueDTO để tránh thay đổi giá trị ban đầu
        QueDTO queDTOClone = new QueDTO(queDTO);

        // Check hào nào động của queDTOClone và lật giá trị tương ứng
        if (queDTOClone.getDong1() == 1) queDTOClone.setHao1(flip(queDTOClone.getHao1()));
        if (queDTOClone.getDong2() == 1) queDTOClone.setHao2(flip(queDTOClone.getHao2()));
        if (queDTOClone.getDong3() == 1) queDTOClone.setHao3(flip(queDTOClone.getHao3()));
        if (queDTOClone.getDong4() == 1) queDTOClone.setHao4(flip(queDTOClone.getHao4()));
        if (queDTOClone.getDong5() == 1) queDTOClone.setHao5(flip(queDTOClone.getHao5()));
        if (queDTOClone.getDong6() == 1) queDTOClone.setHao6(flip(queDTOClone.getHao6()));

        // Tìm quẻ biến dựa trên DTO mới
        return getQueByDTO(queDTOClone);
    }

    private int flip(int haoValue) {
        return haoValue == 0 ? 1 :0;
    }
}
