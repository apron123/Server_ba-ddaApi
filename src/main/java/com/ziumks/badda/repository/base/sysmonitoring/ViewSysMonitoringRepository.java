package com.ziumks.badda.repository.base.sysmonitoring;

import com.ziumks.badda.model.entity.base.view.ViewSysMonitoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Entity, JpaRepository 상속받아 간단하게 구현.
 *
 * @author 이상민
 * @since  2024.05.21 16:30
 */
@Repository("viewSysMonitoringRepository")
public interface ViewSysMonitoringRepository extends JpaRepository<ViewSysMonitoring, Integer> {

    Optional<ViewSysMonitoring> findBySchemaNameAndTableName(String schemaName, String tableName);

}
