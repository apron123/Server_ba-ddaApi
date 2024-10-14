package com.ziumks.badda.sysmonitoring;

//import com.ziumks.badda.controller.SysMonitoringController;
//import com.ziumks.badda.model.dto.common.SysMonitoringDto;
//import com.ziumks.badda.service.SysMonitoringService;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.concurrent.CompletableFuture;
//
//import static com.ziumks.badda.util.Utils.gson;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@Slf4j
//@WebMvcTest(SysMonitoringController.class)
//@DisplayName("시스템 모니터링 flag 데이터 수신 컨트롤러 테스트")
//class TestSysMonitoringController {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private SysMonitoringService sysMonitoringService;
//
//    @Test
//    @DisplayName("시스템 모니터링 flag 데이터 수신 테스트 - 성공")
//    void testUpdateSysMonitoringStatus_Success() throws Exception {
//
//        // Given
//        SysMonitoringDto sysMonitoringDto = SysMonitoringDto.builder()
//                .schemaName("test_schema")
//                .tableName("test_table")
//                .build();
//        String jsonDto = gson.toJson(sysMonitoringDto);
//
//        // When
//        when(sysMonitoringService.updateStatus(any(SysMonitoringDto.class)))
//                .thenReturn(CompletableFuture.completedFuture(1L));
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/sys/update")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonDto))
//                .andExpect(request().asyncStarted())
//                .andReturn();
//
//        // Then
//        mockMvc.perform(asyncDispatch(mvcResult))
//                .andExpect(status().isOk())
//                .andDo(result -> {
//                    String content = result.getResponse().getContentAsString();
//                    log.info(content);
//                });
//
//    }
//
//    @Test
//    @DisplayName("시스템 모니터링 flag 데이터 수신 테스트 - 실패")
//    void testUpdateSysMonitoringStatus_Failure() throws Exception {
//
//        // Given
//        SysMonitoringDto sysMonitoringDto = SysMonitoringDto.builder()
//                .schemaName("test_schema")
//                .tableName("test_table")
//                .build();
//        String jsonDto = gson.toJson(sysMonitoringDto);
//
//        // When
//        when(sysMonitoringService.updateStatus(any(SysMonitoringDto.class)))
//                .thenReturn(CompletableFuture.completedFuture(0L));
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/sys/update")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonDto))
//                .andExpect(request().asyncStarted())
//                .andReturn();
//
//        // Then
//        mockMvc.perform(asyncDispatch(mvcResult))
//                .andExpect(status().isInternalServerError())
//                .andDo(result -> {
//                    String content = result.getResponse().getContentAsString();
//                    log.error(content);
//                });
//
//    }
//
//
//    @Test
//    @DisplayName("시스템 모니터링 flag 데이터 수신 테스트 - 500 예외")
//    void testUpdateSysMonitoringStatus_Exception_500() throws Exception {
//
//        // Given
//        SysMonitoringDto sysMonitoringDto = SysMonitoringDto.builder()
//                .schemaName("test_schema")
//                .tableName("test_table")
//                .build();
//        String jsonDto = gson.toJson(sysMonitoringDto);
//
//        // When
//        when(sysMonitoringService.updateStatus(any(SysMonitoringDto.class)))
//                .thenReturn(CompletableFuture.supplyAsync(() -> {
//                            throw new RuntimeException("Test exception");
//                        }));
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/sys/update")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonDto))
//                .andExpect(request().asyncStarted())
//                .andReturn();
//
//        // Then
//        mockMvc.perform(asyncDispatch(mvcResult))
//                .andExpect(status().isInternalServerError())
//                .andDo(result -> {
//                    String content = result.getResponse().getContentAsString();
//                    log.error(content);
//                });
//
//    }
//
//
//    @Test
//    @DisplayName("시스템 모니터링 flag 데이터 수신 테스트 - 400 예외")
//    void testUpdateSysMonitoringStatus_Exception() throws Exception {
//
//        // Given
//        SysMonitoringDto sysMonitoringDto = SysMonitoringDto.builder()
//                .build();
//        String jsonDto = gson.toJson(sysMonitoringDto);
//
//        // When
//        when(sysMonitoringService.updateStatus(any(SysMonitoringDto.class)))
//                .thenReturn(CompletableFuture.completedFuture(1L));
//        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/sys/update")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonDto));
//
//        // Then
//        resultActions.andExpect(status().isBadRequest());
//
//    }
//
//
//}
