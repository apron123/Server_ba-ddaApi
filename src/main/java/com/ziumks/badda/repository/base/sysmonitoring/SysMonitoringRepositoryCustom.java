package com.ziumks.badda.repository.base.sysmonitoring;

import com.ziumks.badda.model.dto.common.SysMonitoringDto;

/**
 * Query Dsl 메소드 작성
 *
 * @author 이상민
 * @since  2024.05.21 16:30
 */
public interface SysMonitoringRepositoryCustom {

    long updateBySchemaNameAndTableName(SysMonitoringDto sysMonitoringDto);

}
