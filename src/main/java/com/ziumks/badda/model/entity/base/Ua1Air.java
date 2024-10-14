package com.ziumks.badda.model.entity.base;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 임무 분야별 UAS 드론 엔티티
 *
 * @author  이상민
 * @since   2024.08.1 16:30
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "ua1_air")
public class Ua1Air {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "drone_id", nullable = false)
    private String droneId;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "altitude")
    private double altitude;

    @Column(name = "roll")
    private double roll;

    @Column(name = "pitch")
    private double pitch;

    @Column(name = "yaw")
    private double yaw;

    @Column(name = "azimuth")
    private double azimuth;

    @Column(name = "speed")
    private double speed;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

}
