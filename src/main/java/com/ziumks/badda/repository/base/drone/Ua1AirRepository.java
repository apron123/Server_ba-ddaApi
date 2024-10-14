package com.ziumks.badda.repository.base.drone;

import com.ziumks.badda.model.entity.base.Ua1Air;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Entity, JpaRepository 상속받아 간단하게 구현.
 *
 * @author 이상민
 * @since  2024.05.21 16:30
 */
@Repository("ua1AirRepository")
public interface Ua1AirRepository extends JpaRepository<Ua1Air, Long>, DroneRepositoryCustom {}
