package com.ziumks.badda.model.entity.base.view;

import lombok.*;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *  v_sys_monitoring view 엔티티
 *
 * @author  이상민
 * @since   2024.07.31 16:30
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Immutable
@Entity
@Table(name = "v_sys_monitoring")
public class ViewSysMonitoring implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private int seq;

    @Column(name = "schema_name", length = 50)
    private String schemaName;

    @Column(name = "system_name", length = 100)
    private String systemName;

    @Column(name = "table_name", length = 100)
    private String tableName;

    @Column(name = "table_description", length = 100)
    private String tableDescription;

    @Column(name = "crawler_status")
    private int crawlerStatus;

    @Column(name = "save_status")
    private int saveStatus;

    @Column(name = "elastic_status")
    private int elasticStatus;

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

}
