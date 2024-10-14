package com.ziumks.badda.controller;

import com.ziumks.badda.model.dto.FmsDataDto;
import com.ziumks.badda.service.FmsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * fms 데이터 수신 컨트롤러
 * 20 비행단 사용
 *
 * @author  이상민
 * @since   2024.06.13 16:30
 */
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@Tag(name = "FMS API", description = "fms 데이터 수신 컨트롤러")
public class FmsController {

    private final FmsService fmsService;

    @PostMapping("/fms")
    @Operation(summary = "fms 데이터 수신 등록", description = "fms 데이터 리스트를 수신하여 등록")
    public void createFms( @RequestBody List<FmsDataDto> fmsDataDtoList) throws Exception {
        fmsService.insert(fmsDataDtoList);
    }

}
