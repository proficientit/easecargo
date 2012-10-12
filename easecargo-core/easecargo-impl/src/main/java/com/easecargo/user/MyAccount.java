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
@Table(name = "MY_ACC")
public class MyAccount implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MYACC_ID")
	private Integer accountId;
	@Column(name = "CURR")
	private String currency;
	@Column(name = "ACC_BAL")
	private Float accountBalance;
	@Column(name = "LST_RECH_DATE")
	private Timestamp lastRechargeDate;
	@Column(name = "LST_RECH_BY")
	private String lastRechargeBy;
	@Column(name = "STATUS")
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;
	
	public MyAccount() {
		super();
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Float accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Timestamp getLastRechargeDate() {
		return lastRechargeDate;
	}

	public void setLastRechargeDate(Timestamp lastRechargeDate) {
		this.lastRechargeDate = lastRechargeDate;
	}

	public String getLastRechargeBy() {
		return lastRechargeBy;
	}

	public void setLastRechargeBy(String lastRechargeBy) {
		this.lastRechargeBy = lastRechargeBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
