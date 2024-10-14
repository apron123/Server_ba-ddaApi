package com.ziumks.badda.controller;


import com.ziumks.badda.model.dto.OpsAirDto;
import com.ziumks.badda.model.dto.Ua2DroneRealDto;
import com.ziumks.badda.service.DroneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 체계별 드론 데이터 수신 컨트롤러
 * 공통 비행단 사용
 *
 * @author  이상민
 * @since   2024.06.13 16:30
 */
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController("droneController")
@Tag(name = "Drone API ", description = "기지경계용, 임무분야별, 소형급 무인항공기 등 드론 관련 체계 데이터 수집 컨트롤러")
public class DroneController {

    private final DroneService droneService;

    @PostMapping("/uas2")
    @Operation(summary = "소형급 무인항공기 드론데이터 수신 등록", description = "소형급 무인항공기(ops_air) 드론데이터 리스트를 수신하여 등록")
    public void createOpsAir(@RequestBody List<OpsAirDto> opsAirDtoList) throws Exception {
        droneService.insert(opsAirDtoList);
    }

    @PostMapping("/uas1")
    @Operation(summary = "기지경계용 드론데이터 수신 등록", description = "기지경계용(ua2) 드론데이터 리스트를 수신하여 등록")
    public void createUa2(@RequestBody List<Ua2DroneRealDto> ua2DroneRealDtoList) throws Exception {
        droneService.insertUa2(ua2DroneRealDtoList);
    }

}
