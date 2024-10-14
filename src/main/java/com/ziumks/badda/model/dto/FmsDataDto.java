package com.ziumks.badda.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * fms 센서 데이터 DTO
 *
 * @author  이상민
 * @since   2024.05.21 16:30
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Schema(name = "fms_data", description = "fms 센서 데이터")
public class FmsDataDto {

    @Schema(description = "데이터 순번")
    @JsonProperty("ID")
    private long id;

    @Schema(description = "데이터 생성 일자", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty("CreatedAt")
    private String createdAt;

    @Schema(description = "데이터 업데이트 일자", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty("UpdatedAt")
    private String updatedAt;

    @Schema(description = "데이터 삭제 일자", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty("DeletedAt")
    private String deletedAt;

    @Schema(description = "장비 번호")
    @JsonProperty("equip_seq")
    private double equipSeq;

    @Schema(description = "장비 명")
    @JsonProperty("equip_nm")
    private String equipNm;

    @Schema(description = "센서값에 대한 태그 명")
    @JsonProperty("tag_nm")
    private String tagNm;

    @Schema(description = "현재 센서값")
    @JsonProperty("current_value")
    private double currentValue;

    @Schema(description = "현재 상태")
    @JsonProperty("current_status")
    private double currentStatus;

    @Schema(description = "데이터 식별 ID", accessMode = Schema.AccessMode.READ_ONLY)
    private String fmsId;

    public FmsDataDto createFmsId() {
        this.fmsId = this.equipSeq + "_" + this.equipNm + "_" + this.tagNm;
        return this;
    }

}
