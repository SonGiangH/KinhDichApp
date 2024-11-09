package com.project.kinhdichapp.controllers;

import com.project.kinhdichapp.dtos.QueDTO;
import com.project.kinhdichapp.models.Que;
import com.project.kinhdichapp.models.ResponseObject;
import com.project.kinhdichapp.services.IQueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/kinhdich")
@RequiredArgsConstructor
public class QueControllers {

    private final IQueService queService;

    // Get All Que
    @CrossOrigin(origins = "*")
    @GetMapping("/ques") //http://localhost:8088/api/v1/kinhdich/ques
    public ResponseEntity<ResponseObject> getAllQues() {

        List<Que> allQues = queService.getAllQue();

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Show all Que successfully !", allQues)
        );
    }

    // Get que by 6 hao, tham số truyền vào là 1 đối tượng (6 hào) => DATA TRANSFER OBJECT = Request Object
    @CrossOrigin(origins = "*")
    @PostMapping("/que") //http://localhost:8088/api/v1/kinhdich/que
    public ResponseEntity<ResponseObject> getQueByDTO(@RequestBody QueDTO queDTO,
                                                      BindingResult result) {
        // Check error messages
        if (result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("Failed", "Không tìm thấy quẻ", errorMessages)
            );
        }

        // Trả về Que Goc , Que Bien (neu co')
        // Tạo đối tượng chứa cả Quẻ Gốc và Quẻ Biến
        Map<String, Object> queData = new HashMap<>();
        queData.put("QueGoc", queService.getQueByDTO(queDTO));
        queData.put("QueBien", queService.getQueBienDTO(queDTO));

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Successfully!", queData)
        );
    }

}
