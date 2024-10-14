package com.ziumks.badda.sysmonitoring;

//import com.ziumks.badda.config.api.CommonApiProperties;
//import com.ziumks.badda.config.database.DatabaseProperties;
//import com.ziumks.badda.model.dto.common.BulkResponseDto;
//import com.ziumks.badda.repository.base.sysmonitoring.SysMonitoringRepository;
//import com.ziumks.badda.service.SysMonitoringService;
//import com.ziumks.badda.util.Utils;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockedStatic;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.lenient;
//import static org.mockito.Mockito.mockStatic;
//
//@ExtendWith(MockitoExtension.class)
//@DisplayName("시스템 모니터링 서비스 테스트")
//class TestSysMonitoringService {
//
//    @InjectMocks
//    private SysMonitoringService sysMonitoringService;
//
//    @Mock
//    private SysMonitoringRepository sysMonitoringRepository;
//
//    @Mock
//    private DatabaseProperties databaseProps;
//
//    @Mock
//    private CommonApiProperties commonApiProps;
//
//    private final MockedStatic<Utils> mCommonMethod = mockStatic(Utils.class);
//
//    @BeforeEach
//    public void init() {
//
//        // Mocking database props
//        DatabaseProperties.Base base = new DatabaseProperties.Base();
//        base.setSchema("morkingSchema");
//        lenient().when(databaseProps.getBase()).thenReturn(base);
//
//        // Mocking api props
//        CommonApiProperties.Bulk bulk = new CommonApiProperties.Bulk();
//        bulk.setUrl("morkingBulkUrl");
//        lenient().when(commonApiProps.getBulk()).thenReturn(bulk);
//
//        // Morking sendInsertBulk
//        BulkResponseDto bulkResponseDto = BulkResponseDto.builder()
//                .responseCode(200)
//                .build();
//        mCommonMethod.when(()-> Utils.sendInsertBulk(anyString(), any())).thenReturn(bulkResponseDto);
//
//    }

//    @Test
//    @DisplayName("시스템 모니터링 업데이트 테스트 - 성공")
//    void testUpdateSysMonitoringStatus_Success() {
//
//        // Given
//        SysMonitoringDto sysMonitoringDto = SysMonitoringDto.builder()
//                .schemaName("test_schema")
//                .tableName("test_table")
//                .build();
//
//        // When
//        when(sysMonitoringRepository.updateBySchemaNameAndTableName(any(), any())).thenReturn(1L);
//
//        // Then
//        assertDoesNotThrow(() -> sysMonitoringService.updateStatus(sysMonitoringDto));
//
//    }

//    @Test
//    @DisplayName("시스템 모니터링 업데이트 테스트 - 실패")
//    void testUpdateSysMonitoringStatus_Failure() {
//
//        // Given
//        SysMonitoringDto sysMonitoringDto = SysMonitoringDto.builder()
//                .schemaName("test_schema")
//                .tableName("test_table")
//                .build();
//
//        // When
//        when(sysMonitoringRepository.updateBySchemaNameAndTableName(any(), any())).thenReturn(0L);
//        when(sysMonitoringRepository.save(any())).thenReturn(null);
//
//        // Then
//        assertDoesNotThrow(() -> sysMonitoringService.updateStatus(sysMonitoringDto));
//
//    }

//    @Test
//    @DisplayName("시스템 모니터링 콜렉터 상태 업데이트 테스트 - 성공")
//    void testUpdateSysMonitoringCollectorStatus_Success() {
//
//        // Given
//        List<SysMonitoring> SysMonitoringList = new ArrayList<>();
//        sysTableInfoList.add(SysTableInfo.builder()
//                        .baseSchemaName("test_schema")
//                        .baseTableName("test_table")
//                        .systemName("test_system")
//                        .crawlerStatus(1)
//                        .saveStatus(1)
//                        .elasticStatus(1)
//                        .tableDescription("test")
//                        .collectorStatus("up")
//                        .collectorTime(Timestamp.valueOf("2024-06-09 10:20:30.0"))
//                        .dataStatus("down")
//                        .msg("test msg")
//                        .tableNm("test")
//                        .pkNm("id")
//                        .build());
//
//        // When
//        when(sysMonitoringRepository.findAll()).thenReturn(sysTableInfoList);
//        when(sysMonitoringRepository.saveAll(any())).thenReturn(sysTableInfoList);
//
//        // Then
//        assertDoesNotThrow(() -> sysMonitoringService.updateSysMonitoringCollectorStatus());
//
//    }
//
//    @Test
//    @DisplayName("시스템 모니터링 콜렉터 상태 업데이트 테스트 - 실패")
//    void testUpdateSysMonitoringCollectorStatus_Failure() {
//
//        // Given
//        List<SysTableInfo> sysTableInfoList = new ArrayList<>();
//        sysTableInfoList.add(SysTableInfo.builder()
//                .baseSchemaName("test_schema")
//                .baseTableName("test_table")
//                .systemName("test_system")
//                .crawlerStatus(1)
//                .saveStatus(1)
//                .elasticStatus(1)
//                .tableDescription("test")
//                .collectorStatus("down")
//                .dataStatus("down")
//                .msg("test msg")
//                .tableNm("test")
//                .pkNm("id")
//                .build());
//
//        // When
//        when(sysMonitoringRepository.findAll()).thenReturn(sysTableInfoList);
//
//        // Then
//        assertDoesNotThrow(() -> sysMonitoringService.updateSysMonitoringCollectorStatus());
//
//    }

//}
