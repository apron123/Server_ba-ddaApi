package com.ziumks.badda.drone;

//@WebMvcTest(DroneController.class)
//@DisplayName("드론 데이터 수신 컨트롤러 테스트")
//class TestDroneController {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private DroneService droneService;
//
//    @Test
//    @DisplayName("기지경계용 드론 데이터 수신 테스트")
//    void testSetUa2DroneReal_success() throws Exception {
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
//
//        ua2DroneRealDtoList.add(dto1);
//        ua2DroneRealDtoList.add(dto2);
//        ua2DroneRealDtoList.add(dto3);
//        String jsonDto = gson.toJson(ua2DroneRealDtoList);
//
//        // When
//        doNothing().when(droneService).setUa2DroneReal(anyList());
//        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/uas1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonDto));
//
//        // Then
//        resultActions.andExpect(status().isOk()); // 응답 상태가 OK(200) 여부 확인
//
//    }
//
//    @Test
//    @DisplayName("소형급 무인항공기 드론 데이터 수신 테스트")
//    void testSetOpsAir_success() throws Exception {
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
//        String jsonDto = gson.toJson(opsAirDtoList);
//
//        // When
//        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/uas2")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonDto));
//        doNothing().when(droneService).setOpsAir(anyList());
//
//        // Then
//        resultActions.andExpect(status().isOk()); // 응답 상태가 OK(200) 여부 확인
//
//    }
//
//}
