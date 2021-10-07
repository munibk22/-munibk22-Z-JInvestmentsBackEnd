package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "holdings")
@Data
@NoArgsConstructor
public class CurrentHoldings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int holdingsId;

	@Column(name = "current_Usd")
	private double currentUsd;
	@Column(name = "current_Bitcion")
	private double currentBitcoin;
	@Column(name = "current_stockValue")
	private double stockValue;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

}
