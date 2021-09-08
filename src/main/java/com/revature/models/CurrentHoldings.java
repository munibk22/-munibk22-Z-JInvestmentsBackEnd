package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "holdings")
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
	

	public CurrentHoldings(int holdingsId, double currentUsd, double currentBitcoin, double stockValue) {
		super();
		this.holdingsId = holdingsId;
		this.currentUsd = currentUsd;
		this.currentBitcoin = currentBitcoin;
		this.stockValue = stockValue;
	}

	public CurrentHoldings() {
		super();
	}

	public int getHoldingsId() {
		return holdingsId;
	}

	public void setHoldingsId(int holdingsId) {
		this.holdingsId = holdingsId;
	}

	public double getCurrentUsd() {
		return currentUsd;
	}

	public void setCurrentUsd(double currentUsd) {
		this.currentUsd = currentUsd;
	}

	public double getCurrentBitcoin() {
		return currentBitcoin;
	}

	public void setCurrentBitcoin(double currentBitcoin) {
		this.currentBitcoin = currentBitcoin;
	}

	public double getStockValue() {
		return stockValue;
	}

	public void setStockValue(double stockValue) {
		this.stockValue = stockValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(currentBitcoin);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(currentUsd);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + holdingsId;
		temp = Double.doubleToLongBits(stockValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrentHoldings other = (CurrentHoldings) obj;
		if (Double.doubleToLongBits(currentBitcoin) != Double.doubleToLongBits(other.currentBitcoin))
			return false;
		if (Double.doubleToLongBits(currentUsd) != Double.doubleToLongBits(other.currentUsd))
			return false;
		if (holdingsId != other.holdingsId)
			return false;
		if (Double.doubleToLongBits(stockValue) != Double.doubleToLongBits(other.stockValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CurrentHoldings [holdingsId=" + holdingsId + ", currentUsd=" + currentUsd + ", currentBitcoin="
				+ currentBitcoin + ", stockValue=" + stockValue + "]";
	}

}
