package com.ziumks.badda.repository.base.drone;

import com.ziumks.badda.model.entity.base.Ua2DroneReal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Entity, JpaRepository 상속받아 간단하게 구현.
 *
 * @author 이상민
 * @since  2024.05.21 16:30
 */
@Repository("ua2DroneRepository")
public interface Ua2DroneRepository extends JpaRepository<Ua2DroneReal, Long>, DroneRepositoryCustom {}
