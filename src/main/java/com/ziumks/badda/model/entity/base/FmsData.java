package com.ziumks.badda.model.entity.base;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * fms 센서 데이터 엔티티
 *
 * @author  이상민
 * @since   2024.08.06 16:30
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "fms_data")
public class FmsData {

    @Id
    @Column(name = "fms_id", nullable = false, length = 100)
    private String fmsId;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "equip_seq")
    private double equipSeq;

    @Column(name = "equip_nm")
    private String equipNm;

    @Column(name = "tag_nm")
    private String tagNm;

    @Column(name = "current_value")
    private double currentValue;

    @Column(name = "current_status", length = 1)
    private String currentStatus;

}
