package com.ziumks.badda.model.entity.base;

import com.ziumks.badda.util.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 체계 상태 정보 엔티티
 *
 * @author  이상민
 * @since   2024.05.21 16:30
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "sys_monitoring")
public class SysMonitoring implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false)
    private int seq;

    @Column(name = "sys_table_info_seq", nullable = false)
    private int sysTableInfoSeq;

    @Builder.Default
    @Column(name = "crawler_status", nullable = false)
    private int crawlerStatus = 0;

    @Builder.Default
    @Column(name = "save_status", nullable = false)
    private int saveStatus = 0;

    @Builder.Default
    @Column(name = "elastic_status", nullable = false)
    private int elasticStatus = 0;

    @Column(name = "data_time")
    private LocalDateTime dataTime;

    @Column(name = "msg", length = 500)
    private String msg;

    @Column(name = "data_status", length = 4)
    private String dataStatus;

    @Column(name = "collector_time")
    private LocalDateTime collectorTime;

    @Column(name = "collector_status", length = 4)
    private String collectorStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sys_table_info_seq", referencedColumnName = "seq", insertable = false, updatable = false)
    private SysTableInfo sysTableInfo;

    @Transient
    public SysMonitoring updateCollectorStatusDown() {
        this.collectorStatus = Status.DOWN.getValue();
        return this;
    }

    @Transient
    public SysMonitoring setSysTableInfoSeq(int sysTableInfoSeq) {
        this.sysTableInfoSeq = sysTableInfoSeq;
        return this;
    }

}
