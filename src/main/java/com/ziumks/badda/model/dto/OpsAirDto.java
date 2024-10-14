package com.ziumks.badda.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * 소형급 무인항공기 드론 항적 데이터 DTO
 *
 * @author  이상민
 * @since   2024.05.21 16:30
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Schema(name = "ops_air", description = "소형급 무인항공기 드론 항적 데이터")
public class OpsAirDto {

    @Schema(description = "드론 ID")
    private String id;

    @Schema(description = "위도")
    private double latitude;

    @Schema(description = "경도")
    private double longitude;

    @Schema(description = "고도")
    private double altitude;

    @Schema(description = "방위각")
    private double azimuth;

    @Schema(description = "속도")
    private double speed;

    @Schema(description = "롤")
    private double roll;

    @Schema(description = "피치")
    private double pitch;

    @Schema(description = "요")
    private double yaw;

    @Schema(description = "드론 상태")
    private int status;

    @Schema(description = "수집 일시")
    private long timestamp;

}
