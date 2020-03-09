package com.signzy.automate.repository;

import com.signzy.automate.model.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DeviceRepository
        extends JpaRepository<DeviceEntity, Long> {

    Optional<DeviceEntity> findByDeviceName(String deviceName);
}
