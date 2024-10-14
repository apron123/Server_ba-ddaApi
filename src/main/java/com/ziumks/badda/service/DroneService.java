package com.ziumks.badda.service;

import com.ziumks.badda.model.dto.OpsAirDto;
import com.ziumks.badda.model.dto.Ua2DroneRealDto;
import com.ziumks.badda.model.entity.base.OpsAir;
import com.ziumks.badda.model.entity.base.Ua2DroneReal;
import com.ziumks.badda.model.mapper.ModelMapper;
import com.ziumks.badda.repository.base.drone.OpsAirRepository;
import com.ziumks.badda.repository.base.drone.Ua2DroneRepository;
import com.ziumks.badda.util.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.ziumks.badda.config.database.DatabaseConstants.BaseDatabase.tx_manager;

/**
 * 드론 데이터 저장 서비스 로직
 *
 * @author  이상민
 * @since   2024.05.21 16:30
 */
@Slf4j
@RequiredArgsConstructor
@Service("droneService")
public class DroneService {

    private final CommonService commonService;

    private final Ua2DroneRepository ua2DroneRepository;

    private final OpsAirRepository opsAirRepository;

    private final ModelMapper mapper;

    /**
     * 소형급 무인항공기 드론 데이터 저장하는 메서드
     *
     * @param   droneList  드론 데이터 리스트
     */
    @Async
    @Transactional(transactionManager = tx_manager)
    public void insert(List<OpsAirDto> droneList) throws Exception {
        commonService.insert(droneList.stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList()), Utils.getTableName(OpsAir.class), opsAirRepository);
    }

    /**
     * 기지경계용 드론 데이터 저장하는 메서드
     *
     * @param   droneList  드론 데이터 리스트
     */
    @Async
    @Transactional(transactionManager = tx_manager)
    public void insertUa2(List<Ua2DroneRealDto> droneList) throws Exception {
        commonService.insert(droneList.stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList()), Utils.getTableName(Ua2DroneReal.class), ua2DroneRepository);
    }

}
