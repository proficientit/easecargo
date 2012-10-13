package com.easecargo.user;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MY_BIL")
public class MyBilling implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MYBIL_ID")
	private Integer billingId;

	@Column(name = "TXN_TIME")
	private Timestamp transactionTime;
	@Column(name = "TXN_NAME")
	private String transactionName;
	@Column(name = "CURR")
	private String currency;
	@Column(name = "ACT_ACTVTY")
	private String accountActivity;
	@Column(name = "AMOUNT")
	private Float amount;
	@Column(name = "AMT_BALANCE")
	private Float amountBalance;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)	
	private User user;

	public Integer getBillingId() {
		return billingId;
	}

	public void setBillingId(Integer billingId) {
		this.billingId = billingId;
	}

	public Timestamp getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Timestamp transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAccountActivity() {
		return accountActivity;
	}

	public void setAccountActivity(String accountActivity) {
		this.accountActivity = accountActivity;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Float getAmountBalance() {
		return amountBalance;
	}

	public void setAmountBalance(Float amountBalance) {
		this.amountBalance = amountBalance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
