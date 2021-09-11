package com.revature.controllers;

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

import com.revature.models.CurrentHoldings;
import com.revature.repos.CurrentHoldingsDAO;

@RestController
@RequestMapping(value="/holdings")
@CrossOrigin
public class HoldingsController {
	private CurrentHoldingsDAO holdingDao;

	@Autowired
	public HoldingsController(CurrentHoldingsDAO currentHoldingDao) {
		super();
		this.holdingDao = currentHoldingDao;
	}
	
	@PostMapping("/post")
	public ResponseEntity<CurrentHoldings> postHolding(@RequestBody CurrentHoldings holdings){
		System.out.println("Client invoked post current holdings");
		holdingDao.save(holdings);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public ResponseEntity<List<CurrentHoldings>> allHoldings(){
		System.out.println("Client invoked get all Holdings");
		List<CurrentHoldings> holdings = holdingDao.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(holdings);
	}
	

}
