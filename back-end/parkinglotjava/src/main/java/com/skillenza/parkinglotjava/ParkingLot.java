package com.skillenza.parkinglotjava;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "parkinglots")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class ParkingLot {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date created_at;
    @Column(unique=true)
    private Integer lot;
    private Double parking_amount;
    private Double parking_duration;
    private Date updated_at;
    @Column(unique=true)
    private Integer vehicle_number;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Integer getLot() {
		return lot;
	}
	public void setLot(Integer lot) {
		this.lot = lot;
	}
	public Double getParking_amount() {
		return parking_amount;
	}
	public void setParking_amount(Double parking_amount) {
		this.parking_amount = parking_amount;
	}
	public Double getParking_duration() {
		return parking_duration;
	}
	public void setParking_duration(Double parking_duration) {
		this.parking_duration = parking_duration;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Integer getVehicle_number() {
		return vehicle_number;
	}
	public void setVehicle_number(Integer vehicle_number) {
		this.vehicle_number = vehicle_number;
	}
    
    
}
