package edu.tongji.amazing.model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component("finance")
public class Finance {

	private String finance_date;
	private double income;
	private double outgoing;

	public String getFinance_date() {
		return finance_date;
	}

	public void setFinance_date(String finance_date) {
		this.finance_date = finance_date;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getOutgoing() {
		return outgoing;
	}

	public void setOutgoing(double outgoing) {
		this.outgoing = outgoing;
	}

}
