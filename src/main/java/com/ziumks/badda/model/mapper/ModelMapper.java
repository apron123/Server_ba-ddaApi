package com.ziumks.badda.model.mapper;

import com.ziumks.badda.model.dto.FmsDataDto;
import com.ziumks.badda.model.dto.OpsAirDto;
import com.ziumks.badda.model.dto.Ua2DroneRealDto;
import com.ziumks.badda.model.dto.common.SysMonitoringDto;
import com.ziumks.badda.model.entity.base.FmsData;
import com.ziumks.badda.model.entity.base.OpsAir;
import com.ziumks.badda.model.entity.base.SysMonitoring;
import com.ziumks.badda.model.entity.base.Ua2DroneReal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * DTO & Entity 객체간의 매핑하는 객체
 * componentModel="spring"을 통해서 spring container에 Bean으로 등록
 * unmappedTargetPolicy IGNORE 만약, target class에 매핑되지 않는 필드가 있으면, null로 넣게 되고, 따로 report하지 않음
 *
 * @author  이상민
 * @since   2024.06.13 16:30
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ModelMapper {

    // 모니터링
    SysMonitoring toEntity(SysMonitoringDto dto);
    SysMonitoringDto toDto(SysMonitoring entity);

    // 드론
    @Mapping(target = "timestamp", source = "timestamp", qualifiedByName = "unixToDate")
    @Mapping(target = "droneId", source = "id")
    @Mapping(target = "id", ignore = true)
    OpsAir toEntity(OpsAirDto dto);

    @Mapping(target = "timestamp", source = "timestamp", qualifiedByName = "dateToUnix")
    @Mapping(target = "id", source = "droneId")
    OpsAirDto toDto(OpsAir entity);

    @Mapping(target = "rotateYaw", source = "rotate.yaw")
    @Mapping(target = "rotatePitch", source = "rotate.pitch")
    @Mapping(target = "rotateRoll", source = "rotate.roll")
    @Mapping(target = "directionGroundSpeed", source = "direction.groundSpeed")
    @Mapping(target = "directionAzimuth", source = "direction.azimuth")
    @Mapping(target = "coorAltitude", source = "coordinate.altitude")
    @Mapping(target = "coorLatitude", source = "coordinate.latitude")
    @Mapping(target = "coorLongitude", source = "coordinate.longitude")
    @Mapping(target = "timestamp", source = "timestamp", qualifiedByName = "unixToDate")
    @Mapping(target = "droneId", source = "id")
    @Mapping(target = "id", ignore = true)
    Ua2DroneReal toEntity(Ua2DroneRealDto dto);
    @Mapping(target = "rotate.yaw", source = "rotateYaw")
    @Mapping(target = "rotate.pitch", source = "rotatePitch")
    @Mapping(target = "rotate.roll", source = "rotateRoll")
    @Mapping(target = "direction.groundSpeed", source = "directionGroundSpeed")
    @Mapping(target = "direction.azimuth", source = "directionAzimuth")
    @Mapping(target = "coordinate.altitude", source = "coorAltitude")
    @Mapping(target = "coordinate.latitude", source = "coorLatitude")
    @Mapping(target = "coordinate.longitude", source = "coorLongitude")
    @Mapping(target = "timestamp", source = "timestamp", qualifiedByName = "dateToUnix")
    @Mapping(target = "id", source = "droneId")
    Ua2DroneRealDto toDto(Ua2DroneReal entity);

    @Named("unixToDate")
    static LocalDateTime unixToDate(long unixTime) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(unixTime), ZoneId.systemDefault());
    }

    @Named("dateToUnix")
    static long dateToUnix(LocalDateTime dateTime) {
        return dateTime.toEpochSecond(ZoneOffset.UTC);
    }

    // FMS
    FmsData toEntity(FmsDataDto dto);
    FmsDataDto toDto(FmsData entity);

}
