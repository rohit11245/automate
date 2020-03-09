package com.signzy.automate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_DEVICES")
public class DeviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	@Column(name="device_name")
    private String deviceName;


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name="location")
    private String location;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



    @Override
    public String toString() {
        return "Devices [id=" + id + ", deviceName=" + deviceName + ", location=" + location   + "]";
    }
}