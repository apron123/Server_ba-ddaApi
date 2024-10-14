package com.ziumks.badda.model.entity.base;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 체계 테이블 정보 엔티티
 *
 * @author  이상민
 * @since   2024.05.21 16:30
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "sys_table_info", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"table_name", "schema_name"})
})
public class SysTableInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false, insertable = false)
    private int seq;

    @Column(name = "system_code", nullable = false, length = 50)
    private String systemCode;

    @Column(name = "table_name", nullable = false, length = 100)
    private String tableName;

    @Column(name = "table_description", length = 100)
    private String tableDescription;

    @Column(name = "schema_name", nullable = false, length = 50)
    private String schemaName;

    @OneToOne(mappedBy = "sysTableInfo")
    private SysMonitoring sysMonitoring;

}
