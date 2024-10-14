package com.ziumks.badda.repository.base.sysmonitoring;

import com.ziumks.badda.model.entity.base.SysMonitoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Entity, JpaRepository 상속받아 간단하게 구현.
 *
 * @author 이상민
 * @since  2024.05.21 16:30
 */
@Repository("sysMonitoringRepository")
public interface SysMonitoringRepository extends JpaRepository<SysMonitoring, Integer>, SysMonitoringRepositoryCustom {}
