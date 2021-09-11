package com.revature.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.CurrentHoldings;

public interface CurrentHoldingsDAO extends JpaRepository<CurrentHoldings, Integer> {

}
