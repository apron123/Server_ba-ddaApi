package com.ziumks.badda.drone;

//import com.ziumks.badda.config.api.CommonApiProperties;
//import com.ziumks.badda.config.database.DatabaseProperties;
//import com.ziumks.badda.repository.base.drone.OpsAirRepository;
//import com.ziumks.badda.repository.base.drone.Ua2DroneRepository;
//import com.ziumks.badda.service.DroneService;
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

//@ExtendWith(MockitoExtension.class)
//@DisplayName("체계 드론 데이터 수집 테스트")
//class TestDroneService {
//
//    @InjectMocks
//    private DroneService droneService;
//
//    @Mock
//    private Ua2DroneRepository ua2DroneRepository;
//
//    @Mock
//    private OpsAirRepository opsAirRepository;
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
//
//    @Test
//    @DisplayName("기지경계용 드론 데이터 수집 로직 테스트")
//    void testSetUa2DroneReal() {
//
//        // Given
//        List<Ua2DroneRealDto> ua2DroneRealDtoList = new ArrayList<>();
//        // 첫 번째 드론 데이터
//        Ua2DroneRealDto.Coordinate coordinate1 = new Ua2DroneRealDto.Coordinate(33.11, 33.11, 100.11);
//        Ua2DroneRealDto.Rotate rotate1 = new Ua2DroneRealDto.Rotate(10.11, 12.12, 13.13);
//        Ua2DroneRealDto.Direction direction1 = new Ua2DroneRealDto.Direction(45.12, 45.12);
//        Ua2DroneRealDto dto1 = new Ua2DroneRealDto("1", coordinate1, direction1, rotate1, 1, 8923740891234710L);
//        // 두 번째 드론 데이터
//        Ua2DroneRealDto.Coordinate coordinate2 = new Ua2DroneRealDto.Coordinate(13.11, 23.11, 412.11);
//        Ua2DroneRealDto.Rotate rotate2 = new Ua2DroneRealDto.Rotate(10.11, 12.12, 13.13);
//        Ua2DroneRealDto.Direction direction2 = new Ua2DroneRealDto.Direction(45.12, 45.12);
//        Ua2DroneRealDto dto2 = new Ua2DroneRealDto("2", coordinate2, direction2, rotate2,1, 8923740891234710L);
//        // 세 번째 드론 데이터
//        Ua2DroneRealDto.Coordinate coordinate3 = new Ua2DroneRealDto.Coordinate(33.11, 43.11, 152.11);
//        Ua2DroneRealDto.Rotate rotate3 = new Ua2DroneRealDto.Rotate(14.11, 12.12, 13.13);
//        Ua2DroneRealDto.Direction direction3 = new Ua2DroneRealDto.Direction(45.12, 45.12);
//        Ua2DroneRealDto dto3 = new Ua2DroneRealDto("3", coordinate3, direction3, rotate3, 1, 8923740891234710L);
//        ua2DroneRealDtoList.add(dto1);
//        ua2DroneRealDtoList.add(dto2);
//        ua2DroneRealDtoList.add(dto3);
//        // 엔티티 데이터
//        List<Ua2DroneReal> ua2DroneRealList = ua2DroneRealDtoList.stream()
//                .map(Ua2DroneRealDto::toEntity)
//                .collect(Collectors.toList());
//
//
//        // When
//        when(ua2DroneRepository.saveAll(anyList())).thenReturn(ua2DroneRealList);
//
//        // Then
//        assertDoesNotThrow(() -> droneService.setUa2DroneReal(ua2DroneRealDtoList));
//
//    }
//
//    @Test
//    @DisplayName("소형급 무인항공기 드론 데이터 수집 로직 테스트")
//    void testSetOpsAir() {
//
//        // Given
//        List<OpsAirDto> opsAirDtoList = new ArrayList<>();
//        // 첫 번째 드론 데이터
//        OpsAirDto dto1 = OpsAirDto.builder()
//                .id("123")
//                .latitude(37.5665)
//                .longitude(126.9780)
//                .altitude(100.5)
//                .azimuth(45.0)
//                .speed(10.0)
//                .roll(0.0)
//                .pitch(0.0)
//                .yaw(0.0)
//                .status(1)
//                .timestamp(1672531199000L)
//                .build();
//        opsAirDtoList.add(dto1);
//        // 엔티티 데이터
//        List<OpsAir> opsAirList = opsAirDtoList.stream()
//                .map(OpsAirDto::toEntity)
//                .collect(Collectors.toList());
//
//        // When
//        when(opsAirRepository.saveAll(anyList())).thenReturn(opsAirList);
//
//        // Then
//        assertDoesNotThrow(() -> droneService.setOpsAir(opsAirDtoList));
//
//    }

//}
