package com.ziumks.badda.fms;

//import com.ziumks.badda.config.api.CommonApiProperties;
//import com.ziumks.badda.config.database.DatabaseProperties;
//import com.ziumks.badda.repository.base.fms.FmsRepository;
//import com.ziumks.badda.service.FmsService;
//import com.ziumks.badda.service.SysMonitoringService;
//import com.ziumks.badda.util.Utils;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockedStatic;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.Mockito.mockStatic;
//
//@ExtendWith(MockitoExtension.class)
//@DisplayName("fms 데이터 수집 테스트")
//class TestFmsService {
//
//    @InjectMocks
//    private FmsService fmsService;
//
//    @Mock
//    private FmsRepository fmsRepository;
//
//    @Mock
//    private SysMonitoringService sysMonitoringService;
//
//    @Mock
//    private DatabaseProperties databaseProps;
//
//    @Mock
//    private CommonApiProperties commonApiProps;
//
//    private final MockedStatic<Utils> mCommonMethod = mockStatic(Utils.class);

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
//        CommonApiProperties.BaDda system = new CommonApiProperties.BaDda();
//        bulk.setUrl("morkingSysUrl");
//        lenient().when(commonApiProps.getBaDda()).thenReturn(system);
//
//        // Moking sendUpdateSys
//        lenient().when(sysMonitoringService.updateStatus(any())).thenReturn(null);
//
//        // Morking sendInsertBulk
//        BulkResponseDto bulkResponseDto = BulkResponseDto.builder()
//                .responseCode(200)
//                .build();
//        mCommonMethod.when(()-> Utils.sendInsertBulk(anyString(), any())).thenReturn(bulkResponseDto);
//
//    }

//    @Test
//    @DisplayName("fms 데이터 수집 로직 테스트 - 성공")
//    void testSetFmsDataSuccess() {
//
//        // Given
//        List<FmsDataDto> fmsDataDtoList = new ArrayList<>();
//        // 첫 번째 더미 데이터
//        FmsDataDto dto1 = FmsDataDto.builder()
//                .id(1L)
//                .createdAt("2023-01-01T00:00:00Z")
//                .updatedAt("2023-01-02T00:00:00Z")
//                .deletedAt("2023-01-03T00:00:00Z")
//                .equip_seq(1001.0)
//                .equip_nm("장비명1")
//                .tag_nm("태그명1")
//                .current_value(50.5)
//                .current_status("N")
//                .build();
//        // 두 번째 더미 데이터
//        FmsDataDto dto2 = FmsDataDto.builder()
//                .id(2L)
//                .createdAt("2023-02-01T00:00:00Z")
//                .updatedAt("2023-02-02T00:00:00Z")
//                .deletedAt("2023-02-03T00:00:00Z")
//                .equip_seq(1002.0)
//                .equip_nm("장비명2")
//                .tag_nm("태그명2")
//                .current_value(75.3)
//                .current_status("A")
//                .build();
//        fmsDataDtoList.add(dto1);
//        fmsDataDtoList.add(dto2);
//        // 엔티티 데이터
//        List<FmsData> fmsDataList = fmsDataDtoList.stream()
//                .map(FmsDataDto::toEntity)
//                .collect(Collectors.toList());
//
//
//        // When
//        when(fmsRepository.saveAll(anyList())).thenReturn(fmsDataList);
//
//        // Then
//        assertDoesNotThrow(() -> fmsService.setFmsData(fmsDataDtoList));
//
//    }
//
//    @Test
//    @DisplayName("fms 데이터 수집 로직 테스트 - 빈 리스트")
//    void testSetFmsDataEmpty() {
//
//        // Given
//        List<FmsDataDto> emptyList = new ArrayList<>();
//
//        // Then
//        assertDoesNotThrow(() -> fmsService.setFmsData(emptyList));
//
//    }
//
//    @Test
//    @DisplayName("fms 데이터 수집 로직 테스트 - 실패")
//    void testSetmedataFailure() {
//
//        // Given
//        List<FmsDataDto> fmsDataDtoList = new ArrayList<>();
//        // 첫 번째 더미 데이터
//        FmsDataDto dto1 = FmsDataDto.builder()
//                .id(1L)
//                .createdAt("2023-01-01T00:00:00Z")
//                .updatedAt("2023-01-02T00:00:00Z")
//                .deletedAt("2023-01-03T00:00:00Z")
//                .equip_seq(1001.0)
//                .equip_nm("장비명1")
//                .tag_nm("태그명1")
//                .current_value(50.5)
//                .current_status("N")
//                .build();
//        // 두 번째 더미 데이터
//        FmsDataDto dto2 = FmsDataDto.builder()
//                .id(2L)
//                .createdAt("2023-02-01T00:00:00Z")
//                .updatedAt("2023-02-02T00:00:00Z")
//                .deletedAt("2023-02-03T00:00:00Z")
//                .equip_seq(1002.0)
//                .equip_nm("장비명2")
//                .tag_nm("태그명2")
//                .current_value(75.3)
//                .current_status("A")
//                .build();
//        fmsDataDtoList.add(dto1);
//        fmsDataDtoList.add(dto2);
//        // 엔티티 데이터
//        List<FmsData> fmsDataList = fmsDataDtoList.stream()
//                .map(FmsDataDto::toEntity)
//                .collect(Collectors.toList());
//
//        // When
//        when(fmsRepository.saveAll(anyList())).thenThrow(new RuntimeException("테스트 실패"));
//
//        // Then
//        assertDoesNotThrow(() -> fmsService.setFmsData(fmsDataDtoList));
//
//    }

//}
