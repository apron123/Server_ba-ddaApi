package com.ziumks.badda.repository.base.drone;

import com.ziumks.badda.model.entity.base.OpsAir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Entity, JpaRepository 상속받아 간단하게 구현.
 *
 * @author 이상민
 * @since  2024.05.21 16:30
 */
@Repository("opsAirRepository")
public interface OpsAirRepository extends JpaRepository<OpsAir, Long>, DroneRepositoryCustom {}
