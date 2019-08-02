package com.skillenza.parkinglotjava;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ParkingLotController {
	
	@Autowired
	ParkingLotRepository parkingLotRepository;

	@GetMapping("/api/parkings")
	public ResponseEntity<?> getParking() {
		List<ParkingLot> list = parkingLotRepository.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/api/parkings")
	public ResponseEntity<?> postParking(@RequestBody ParkingLot parkingLot) {
		
		List<ParkingLot> list = parkingLotRepository.findAll();
		
		for (ParkingLot parkingLot2 : list) {
			if(parkingLot.getLot().equals(parkingLot2.getLot())) {
				return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
			}
		}
				
		Double duration = parkingLot.getParking_duration();
		if(duration<=60.0) {
			parkingLot.setParking_amount(20.0);
		}
		else {
			double amount = 20.0+(duration-60.0)*0.333;
			parkingLot.setParking_amount(amount);
		}
		parkingLot.setUpdated_at(new Date(System.currentTimeMillis()));
		
		ParkingLot lot = parkingLotRepository.save(parkingLot);
		return new ResponseEntity<>(lot, HttpStatus.OK);
	}
	
}

