package com.ziumks.badda.service;

import com.ziumks.badda.model.dto.FmsDataDto;
import com.ziumks.badda.model.entity.base.FmsData;
import com.ziumks.badda.model.mapper.ModelMapper;
import com.ziumks.badda.repository.base.fms.FmsRepository;
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
 * fms 데이터 저장 서비스 로직
 *
 * @author  이상민
 * @since   2024.05.21 16:30
 */
@Slf4j
@RequiredArgsConstructor
@Service("fmsService")
public class FmsService {

    private final CommonService commonService;

    private final FmsRepository fmsRepository;

    private final ModelMapper mapper;

    /**
     * fms 센서 데이터 저장하는 메서드
     *
     * @param   fmsDataDtoList  fms 센서 데이터 리스트
     */
    @Async
    @Transactional(transactionManager = tx_manager)
    public void insert(List<FmsDataDto> fmsDataDtoList) throws Exception {
        commonService.insert(fmsDataDtoList.stream()
                .map(fmsDataDto -> mapper.toEntity(fmsDataDto.createFmsId()))
                .collect(Collectors.toList()), Utils.getTableName(FmsData.class), fmsRepository);
    }

}