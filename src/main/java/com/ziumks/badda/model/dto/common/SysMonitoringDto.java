package com.ziumks.badda.model.dto.common;

import com.ziumks.badda.util.enums.Status;
import com.ziumks.badda.util.enums.SysStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 체계 수집 상태 체크 Flag DTO
 *
 * @author  이상민
 * @since   2024.07.08 12:00
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Schema(name = "sys_monitoring", description = "체계 수집 상태 데이터")
public class SysMonitoringDto {

    @Size(max = 50, message = "{valid.dto.size-max}")
    @NotBlank(message = "{valid.dto.not-blank}")
    @Schema(description = "스키마 명", example = "asp")
    private String schemaName;

    @Size(max = 100, message = "{valid.dto.size-max}")
    @NotBlank(message = "{valid.dto.not-blank}")
    @Schema(description = "테이블 명", example = "test")
    private String tableName;

    @Builder.Default
    @Schema(description = "크롤러 작동 여부")
    private int crawlerStatus = 0;

    @Builder.Default
    @Schema(description = "데이터 저장 여부")
    private int saveStatus = 0;

    @Builder.Default
    @Schema(description = "엘라스틱 저장 여부")
    private int elasticStatus = 0;

    @Schema(description = "메세지", accessMode = Schema.AccessMode.READ_ONLY)
    private String msg;

    @Builder.Default
    @Schema(description = "수집 크롤러 상태", accessMode = Schema.AccessMode.READ_ONLY)
    private String collectorStatus = Status.UP.getValue();

    @Builder.Default
    @Schema(description = "데이터 저장 상태", accessMode = Schema.AccessMode.READ_ONLY)
    private String dataStatus = Status.DOWN.getValue();

    @Builder.Default
    @Schema(description = "수집 크롤러 작동 일시", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime collectorTime = LocalDateTime.now();

    @Builder.Default
    @Schema(description = "데이터 저장 일시", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime dataTime = LocalDateTime.now();

    public void updateStatus(SysStatus status) {
        switch (status) {
            case CRAWLER:
                this.crawlerStatus = 1;
                break;

            case SAVE:
                this.saveStatus = 1;
                break;

            case ELASTIC:
                this.elasticStatus = 1;
                break;

            default:
                throw new IllegalArgumentException("Unexpected status(CRAWLER|SAVE|ELASTIC) : " + status);
        }
    }

    public SysMonitoringDto updateDataStatus() {
        if (this.saveStatus == 1) {
            this.dataStatus = Status.UP.getValue();
        }
        return this;
    }

}
