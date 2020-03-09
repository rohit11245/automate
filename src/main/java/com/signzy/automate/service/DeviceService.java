package com.signzy.automate.service;

import com.signzy.automate.exception.RecordNotFoundException;
import com.signzy.automate.model.DeviceEntity;
import com.signzy.automate.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
@Service
public class DeviceService {
     
    @Autowired
    DeviceRepository repository;
     
    public List<DeviceEntity> getAllDevices()
    {
        List<DeviceEntity> deviceList = repository.findAll();
         
        if(deviceList.size() > 0) {
            return deviceList;
        } else {
            return new ArrayList<DeviceEntity>();
        }
    }
     
    public DeviceEntity getDeviceById(Long id) throws RecordNotFoundException
    {
        Optional<DeviceEntity> device = repository.findById(id);
         
        if(device.isPresent()) {
            return device.get();
        } else {
            throw new RecordNotFoundException("No device record exist for given id");
        }
    }
    public DeviceEntity findByDeviceName(String deviceName) throws RecordNotFoundException
    {
        Optional<DeviceEntity> device = repository.findByDeviceName(deviceName);

        if(device.isPresent()) {
            return device.get();
        } else {
            throw new RecordNotFoundException("No device record exist for given id");
        }
    }
     
    public DeviceEntity createOrUpdateDevice(DeviceEntity entity) throws RecordNotFoundException
    {
        Optional<DeviceEntity> device = repository.findByDeviceName(entity.getDeviceName());
         
        if(device.isPresent())
        {
            DeviceEntity newEntity = device.get();
            newEntity.setLocation(entity.getLocation());
            newEntity.setDeviceName(entity.getDeviceName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    }
     
    public void deleteDeviceById(Long id) throws RecordNotFoundException
    {
        Optional<DeviceEntity> device = repository.findById(id);
         
        if(device.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No device record exist for given id");
        }
    }

}