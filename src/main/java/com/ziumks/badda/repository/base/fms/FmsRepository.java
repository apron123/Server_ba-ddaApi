package com.ziumks.badda.repository.base.fms;

import com.ziumks.badda.model.entity.base.FmsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Entity, JpaRepository 상속받아 간단하게 구현.
 *
 * @author 이상민
 * @since  2024.05.21 16:30
 */
@Repository("fmsRepository")
public interface FmsRepository extends JpaRepository<FmsData, String>, FmsRepositoryCustom {}
