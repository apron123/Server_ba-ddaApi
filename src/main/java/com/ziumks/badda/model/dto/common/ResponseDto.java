package com.ziumks.badda.model.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.http.HttpStatus;

/**
 * 공통 response DTO
 *
 * @author  김주현
 * @since   2024.05.21 16:30
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Schema(name = "response", description = "공통 response")
public class ResponseDto<T> {

    @Schema(description = "응답 상태 코드", example = "200")
    private int resultCode;

    @Schema(description = "응답 데이터", example = " ")
    private T resultData;

    @Schema(description = "응답 메세지", example = " ")
    private String resultMsg;

    @Schema(description = "응답 성공 여부", example = "true")
    private boolean resultFlag;

    public ResponseDto(T resultData) {
        this.resultCode = HttpStatus.OK.value();
        this.resultData = resultData;
        this.resultFlag = true;
    }

    public ResponseDto(HttpStatus httpStatus) {
        this.resultCode = httpStatus.value();
        this.resultMsg = httpStatus.getReasonPhrase();
        this.resultFlag = httpStatus.value() == 200;
    }

}
