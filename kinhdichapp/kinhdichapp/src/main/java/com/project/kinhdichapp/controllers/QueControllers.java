package com.project.kinhdichapp.controllers;

import com.project.kinhdichapp.algorithym.Lunar;
import com.project.kinhdichapp.algorithym.LunarSolarConverter;
import com.project.kinhdichapp.algorithym.Solar;
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

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
        // Xử lý Date time convert từ dương lịch sang âm lịch , và trả về Can Chi
        Solar solar = new Solar();
        String selectedTime = queDTO.getSelectedTime();
        Date selectedDate = queDTO.getSelectedDate();  // Or your specific date object
        LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // convert Date

        solar.solarYear = localDate.getYear();
        solar.solarMonth = localDate.getMonthValue();
        solar.solarDay = localDate.getDayOfMonth();

        // Chuyển từ dương lịch sang âm lịch
        Lunar lunar = LunarSolarConverter.SolarToLunar(solar);

        // Trả về Que Goc , Que Bien (neu co')
        // Tạo đối tượng chứa cả Quẻ Gốc và Quẻ Biến
        Map<String, Object> queData = new HashMap<>();
        queData.put("QueGoc", queService.getQueByDTO(queDTO));
        queData.put("QueBien", queService.getQueBienDTO(queDTO));
        queData.put("AmLich", lunar);
        queData.put("DuongLich", solar);
        queData.put("GioLapQue", selectedTime);

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Successfully!", queData)
        );
    }

}
