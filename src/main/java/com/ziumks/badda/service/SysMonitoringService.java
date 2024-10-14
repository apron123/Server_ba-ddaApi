package com.ziumks.badda.service;

import com.ziumks.badda.config.api.CommonApiProperties;
import com.ziumks.badda.config.database.DatabaseProperties;
import com.ziumks.badda.exception.NoRowsAffectedException;
import com.ziumks.badda.model.dto.common.BulkRequestDto;
import com.ziumks.badda.model.dto.common.SysMonitoringDto;
import com.ziumks.badda.model.entity.base.SysMonitoring;
import com.ziumks.badda.model.mapper.ModelMapper;
import com.ziumks.badda.model.mapper.SerDeMapper;
import com.ziumks.badda.repository.base.sysmonitoring.SysMonitoringRepository;
import com.ziumks.badda.repository.base.sysmonitoring.SysTableInfoRepository;
import com.ziumks.badda.repository.base.sysmonitoring.ViewSysMonitoringRepository;
import com.ziumks.badda.util.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.ziumks.badda.config.database.DatabaseConstants.BaseDatabase.tx_manager;

/**
 * 시스템 모니터링 상태 데이터 업데이트 서비스 로직
 *
 * @author  이상민
 * @since   2024.05.21 16:30
 */
@Slf4j
@Service("sysMonitoringService")
@RequiredArgsConstructor
public class SysMonitoringService {

    private final SysMonitoringRepository sysMonitoringRepository;

    private final SysTableInfoRepository sysTableInfoRepository;

    private final ViewSysMonitoringRepository vSysMonitoringRepository;

    private final ModelMapper mapper;

    private final SerDeMapper serDeMapper;

    private final DatabaseProperties databaseProps;

    private final CommonApiProperties commonApiProps;

    private final MessageService messageService;

    /**
     * 체계 데이터 수집 상태 등록 매서드
     *
     * @param   sysMonitoringDto  체계 수집 플래그 DTO
     */
    @Transactional(transactionManager = tx_manager)
    public void insert(SysMonitoringDto sysMonitoringDto) throws NoRowsAffectedException {
        sysTableInfoRepository.findBySchemaNameAndTableName(sysMonitoringDto.getSchemaName(), sysMonitoringDto.getTableName())
                .map(sysTableInfo -> sysMonitoringRepository.save(mapper.toEntity(sysMonitoringDto).setSysTableInfoSeq(sysTableInfo.getSeq())))
                .orElseThrow(() -> new NoRowsAffectedException(messageService.getNoRows()));
    }

    /**
     * 체계 데이터 수집 상태 업데이트 매서드
     *
     * @param   sysMonitoringDto    체계 수집 플래그 DTO
     * @return  CompletableFuture<Long> 비동기 업데이트 성공 수
     */
    @Async
    @Transactional(transactionManager = tx_manager)
    public CompletableFuture<Long> updateStatus(SysMonitoringDto sysMonitoringDto) throws Exception {
        return CompletableFuture.completedFuture(sysMonitoringRepository.updateBySchemaNameAndTableName(sysMonitoringDto.updateDataStatus()));
    }

    /**
     * 체계 데이터 수집 시간을 체크하여 컬렉터 상태 업데이트 매서드
     */
    @Async
    @Transactional(transactionManager = tx_manager)
    public void updateCollectorStatus() throws Exception {
        // 컬렉터 상태 업데이트할 엔티티 필터링
        List<SysMonitoring> filteredList = sysMonitoringRepository.findAll().stream()
                .filter(sysMonitoring -> sysMonitoring.getCollectorTime() != null)
                .filter(sysMonitoring -> Duration.between(sysMonitoring.getCollectorTime(), LocalDateTime.now()).compareTo(Duration.of(2, ChronoUnit.DAYS)) >= 0)
                .map(SysMonitoring::updateCollectorStatusDown)
                .collect(Collectors.toList());
        if (filteredList.isEmpty()) {
            return;
        }
        // 저장된 ID값 가져오기
        Set<Integer> ids = sysMonitoringRepository.saveAll(filteredList).stream()
                .map(SysMonitoring::getSeq)
                .collect(Collectors.toSet());
        // 업데이트 성공한 엔티티만 bulk insert
        if (!ids.isEmpty()) {
            String tableName = Utils.getTableName(SysMonitoring.class);
            Utils.sendInsertBulk(
                commonApiProps.getBulk().getUrl(),
                BulkRequestDto.builder()
                        .dataList(vSysMonitoringRepository.findAllById(ids).stream()
                                .map(serDeMapper::toMap)
                                .collect(Collectors.toList()))
                        .indexName(databaseProps.getBase().getSchema() + "_" + tableName)
                        .docId(Utils.getIdName(SysMonitoring.class))
                        .tableName(tableName)
                        .build()
            );
        }
    }

}
