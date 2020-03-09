package com.signzy.automate.web;


import com.signzy.automate.exception.RecordNotFoundException;
import com.signzy.automate.model.DeviceEntity;
import com.signzy.automate.service.DeviceService;
import jdk.jfr.internal.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/devices")
public class DeviceController
{
    @Autowired
    DeviceService service;
 
    @GetMapping
    public ResponseEntity<List<DeviceEntity>> getAllDevices() {
        List<DeviceEntity> list = service.getAllDevices();
 
        return new ResponseEntity<List<DeviceEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<DeviceEntity> getDeviceById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        DeviceEntity entity = service.getDeviceById(id);
 
        return new ResponseEntity<DeviceEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<DeviceEntity> createOrUpdateDevice(@RequestBody DeviceEntity device)
                                                    throws RecordNotFoundException {
        DeviceEntity updated = service.createOrUpdateDevice(device);
        return new ResponseEntity<DeviceEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteDeviceById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteDeviceById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}