package com.ziumks.badda.repository.base.sysmonitoring;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.ziumks.badda.model.dto.common.SysMonitoringDto;
import com.ziumks.badda.model.entity.base.QSysMonitoring;
import com.ziumks.badda.util.enums.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Query Dsl Override 매서드 작성
 * QEntity 서치 에러시, mvn clean compile 할 것
 *
 * @author 이상민
 * @since  2024.05.21 16:30
 */
@Slf4j
@RequiredArgsConstructor
public class SysMonitoringRepositoryCustomImpl implements SysMonitoringRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private static final QSysMonitoring qSysMonitoring = QSysMonitoring.sysMonitoring;

    @Override
    public long updateBySchemaNameAndTableName(SysMonitoringDto sysMonitoringDto) {

        // 기본 업데이트 쿼리
        JPAUpdateClause updateClause = queryFactory.update(qSysMonitoring)
                .set(qSysMonitoring.collectorStatus, sysMonitoringDto.getCollectorStatus())
                .set(qSysMonitoring.collectorTime, sysMonitoringDto.getCollectorTime())
                .set(qSysMonitoring.dataStatus, sysMonitoringDto.getDataStatus())
                .set(qSysMonitoring.crawlerStatus, sysMonitoringDto.getCrawlerStatus())
                .set(qSysMonitoring.saveStatus, sysMonitoringDto.getSaveStatus())
                .set(qSysMonitoring.elasticStatus, sysMonitoringDto.getElasticStatus());

        // dataStatus가 "up"일 경우에만 dataTime을 갱신
        if (sysMonitoringDto.getDataStatus().equalsIgnoreCase(Status.UP.getValue())) {
            updateClause.set(qSysMonitoring.dataTime, sysMonitoringDto.getDataTime());
        }

        // 조건 설정
        BooleanBuilder builder = new BooleanBuilder();
        // 서브쿼리로 join 조건을 추가
        JPAQuery<Integer> subQuery = queryFactory.select(qSysMonitoring.sysTableInfo.seq)
                .from(qSysMonitoring.sysTableInfo)
                .where(qSysMonitoring.sysTableInfo.schemaName.eq(sysMonitoringDto.getSchemaName())
                        .and(qSysMonitoring.sysTableInfo.tableName.eq(sysMonitoringDto.getTableName())));

        // 서브쿼리 결과를 사용하여 업데이트 조건 설정
        builder.and(qSysMonitoring.sysTableInfo.seq.eq(subQuery));

        // 업데이트 실행
        return updateClause.where(builder).execute();
    }

}
