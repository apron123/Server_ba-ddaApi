package com.ziumks.badda.fms;

//@WebMvcTest(FmsController.class)
//@DisplayName("fms 데이터 수신 컨트롤러 테스트")
//class TestFmsController {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private FmsService fmsService;
//
//    @Test
//    @DisplayName("fms 데이터 수신 테스트")
//    void testSetFmsData_success() throws Exception {
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
//
//        fmsDataDtoList.add(dto1);
//        fmsDataDtoList.add(dto2);
//        String jsonDto = gson.toJson(fmsDataDtoList);
//
//        // When
//        doNothing().when(fmsService).setFmsData(anyList());
//        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/fms")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonDto));
//
//        // Then
//        resultActions.andExpect(status().isOk()); // 응답 상태가 OK(200) 여부 확인
//
//    }
//
//}
