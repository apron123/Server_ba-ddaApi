package com.ziumks.badda.controller;

import com.ziumks.badda.exception.NoRowsAffectedException;
import com.ziumks.badda.model.dto.common.SysMonitoringDto;
import com.ziumks.badda.service.MessageService;
import com.ziumks.badda.service.SysMonitoringService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

/**
 * 체계별 데이터 수집 상태 컨트롤러
 * 공통 비행단 사용
 *
 * @author  이상민
 * @since   2024.06.13 16:30
 */
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/sys")
@RestController("sysMonitoringController")
@Tag(name = "SysMonitoring API", description = "체계별 데이터 수집 모니터링 컨트롤러")
public class SysMonitoringController {

    private final SysMonitoringService sysMonitoringService;
    private final MessageService messageService;

    @Operation(summary = "체계 데이터 수집 상태 등록", description = "스키마 명, 테이블 명 기준으로 체계 데이터 수집 상태 등록",
            responses = {
                    @ApiResponse(responseCode = "200", description = "등록 성공", content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
                    @ApiResponse(responseCode = "500", description = "등록 실패", content = @Content(schema = @Schema(implementation = ResponseEntity.class)))
            })
    @PostMapping("/create")
    public ResponseEntity<String> create(
            @Parameter(description  = "수집 상태 업데이트 Flag", required = true) @RequestBody @Valid SysMonitoringDto sysMonitoringDto) {
        sysMonitoringService.insert(sysMonitoringDto);
        return ResponseEntity.ok(messageService.get200());
    }

    @Operation(summary = "체계별 데이터 수집 상태 업데이트", description = "스키마 명, 테이블 명 기준으로 체계별 데이터 수집 상태 업데이트",
            responses = {
                    @ApiResponse(responseCode = "200", description = "업데이트 성공", content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
                    @ApiResponse(responseCode = "500", description = "업데이트 실패", content = @Content(schema = @Schema(implementation = ResponseEntity.class)))
            })
    @PutMapping("/update")
    public CompletableFuture<ResponseEntity<String>> updateStatus(
            @Parameter(description  = "수집 상태 업데이트 Flag", required = true) @RequestBody @Valid SysMonitoringDto sysMonitoringDto) throws Exception {
        return sysMonitoringService.updateStatus(sysMonitoringDto)
                .thenApply(result -> {
                    if (result == 0) {
                        throw new NoRowsAffectedException(messageService.getNoRows());
                    }
                    return ResponseEntity.ok(messageService.get200());
                });
    }

}
