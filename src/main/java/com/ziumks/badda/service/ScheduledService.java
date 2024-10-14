package com.ziumks.badda.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 스케쥴러 서비스 로직
 *
 * @author  이상민
 * @since   2024.05.21 16:30
 */
@Slf4j
@RequiredArgsConstructor
@Service("scheduledService")
public class ScheduledService {

    private final SysMonitoringService sysMonitoringService;

    /**
     *  시스템 모니터링 상태 체크 스케줄러
     */
    @Scheduled(cron = "0 */5 * * * *")
    public void scheduledUpdateCollectorStatus() throws Exception {

        log.info("=========== SysMonitoring Update Collector Status start ============ ");
        log.info("set ViewSysMonitoring Status thread name : {}",Thread.currentThread().getName());
        sysMonitoringService.updateCollectorStatus();
        log.info("=========== SysMonitoring Update Collector Status end ============ ");

    }

}
