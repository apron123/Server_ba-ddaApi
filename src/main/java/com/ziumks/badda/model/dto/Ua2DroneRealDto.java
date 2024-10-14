package com.ziumks.badda.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * 기지경계용 드론 항적 데이터 DTO
 *
 * @author  이상민
 * @since   2024.08.1 16:30
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Schema(name = "ua2_drone_real", description = "기지경계용 드론 항적 데이터")
public class Ua2DroneRealDto {

    @Schema(description = "드론 ID")
    private String id;

    @Schema(description = "위경도")
    private Coordinate coordinate;

    @Schema(description = "방향")
    private Direction direction;

    @Schema(description = "회전")
    private Rotate rotate;

    @Schema(description = "드론 상태")
    private int status;

    @Schema(description = "수집 일시")
    private long timestamp;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Schema(name = "coordinate")
    public static class Coordinate {

        @Schema(description = "위도")
        private double latitude;

        @Schema(description = "경도")
        private double longitude;

        @Schema(description = "고도")
        private double altitude;

    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Schema(name = "direction")
    public static class Direction {

        @Schema(description = "방위각")
        private double azimuth;

        @Schema(description = "지상 속도")
        private double groundSpeed;

    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Schema(name = "rotate")
    public static class Rotate {

        @Schema(description = "롤")
        private double roll;

        @Schema(description = "피치")
        private double pitch;

        @Schema(description = "요")
        private double yaw;

    }

}






