package com.ziumks.badda.service;

import com.ziumks.badda.config.api.CommonApiProperties;
import com.ziumks.badda.config.database.DatabaseProperties;
import com.ziumks.badda.model.dto.common.BulkRequestDto;
import com.ziumks.badda.model.dto.common.BulkResponseDto;
import com.ziumks.badda.model.dto.common.SysMonitoringDto;
import com.ziumks.badda.model.mapper.SerDeMapper;
import com.ziumks.badda.util.Utils;
import com.ziumks.badda.util.enums.SysStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service("commonService")
public class CommonService {

    private final SysMonitoringService sysMonitoringService;

    private final DatabaseProperties databaseProps;

    private final CommonApiProperties commonApiProps;

    private final SerDeMapper serDeMapper;

    /**
     * 데이터 저장하는 메서드
     *
     * @param   entityList      엔티티 리스트
     * @param   tablaName       테이블 명
     * @param   jpaRepository   JPA 레파지토리
     */
    public <T> void insert(List<T> entityList, String tablaName, JpaRepository jpaRepository) throws Exception {

        SysMonitoringDto sysMonitoringDto = SysMonitoringDto.builder()
                .schemaName(databaseProps.getBase().getSchema())
                .tableName(tablaName)
                .build();

        log.info("=========== Insert {} start ============ ", tablaName);
        log.info("thread name : {}", Thread.currentThread().getName());

        try {
            if (!entityList.isEmpty()) {
                // 크롤러 상태 업데이트
                sysMonitoringDto.updateStatus(SysStatus.CRAWLER);
                // 성공한 엔티티만 bulk insert
                List<T> savedList = jpaRepository.saveAll(entityList);
                if (!savedList.isEmpty()) {
                    // 세이브 상태 업데이트
                    sysMonitoringDto.updateStatus(SysStatus.SAVE);
                    log.info("Insert success : " + savedList.size());
                    // 벌크 인설트
                    BulkResponseDto bulkResponseDto = Utils.sendInsertBulk(
                            commonApiProps.getBulk().getUrl(),
                            BulkRequestDto.builder()
                                    .dataList(savedList.stream()
                                            .map(serDeMapper::toMap)
                                            .collect(Collectors.toList()))
                                    .indexName(sysMonitoringDto.getSchemaName() + "_" + sysMonitoringDto.getTableName())
                                    .docId(Utils.getIdName(savedList.get(0).getClass())) // 사용된 엔티티의 클래스에서 ID 이름을 가져옵니다
                                    .tableName(sysMonitoringDto.getTableName())
                                    .build()
                    );
                    if (bulkResponseDto.getResponseCode() == 200) {
                        // 엘라스틱 상태 업데이트
                        sysMonitoringDto.updateStatus(SysStatus.ELASTIC);
                    }
                }
            }
        } finally {
            sysMonitoringService.updateStatus(sysMonitoringDto);
            log.info("=========== Insert {} end ============ ", tablaName);
        }
    }

}
