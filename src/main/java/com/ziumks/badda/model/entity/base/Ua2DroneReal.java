package com.ziumks.badda.model.entity.base;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 기지경계용 UAS 드론 엔티티
 *
 * @author  이상민
 * @since   2024.08.1 16:30
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "ua2_drone_real")
public class Ua2DroneReal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "drone_id", nullable = false)
    private String droneId;

    @Column(name = "coor_longitude")
    private double coorLongitude;

    @Column(name = "coor_latitude")
    private double coorLatitude;

    @Column(name = "coor_altitude")
    private double coorAltitude;

    @Column(name = "rotate_roll")
    private double rotateRoll;

    @Column(name = "rotate_pitch")
    private double rotatePitch;

    @Column(name = "rotate_yaw")
    private double rotateYaw;

    @Column(name = "direction_azimuth")
    private double directionAzimuth;

    @Column(name = "direction_ground_speed")
    private double directionGroundSpeed;

    @Column(name = "status")
    private int status;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

}
