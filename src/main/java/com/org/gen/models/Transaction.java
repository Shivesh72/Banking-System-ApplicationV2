package com.org.gen.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transaction")
public class Transaction {
	
	@Column(nullable = false,length = 10)
	private long account_id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long trans_id;
	
	@Column(nullable = false,length = 10)
	private long amount;
	
	@Column(nullable = false,length = 2)
	private int type;
	
	public long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}
	public long getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(long trans_id) {
		this.trans_id = trans_id;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Transaction [account_id=" + account_id + ", trans_id=" + trans_id + ", amount=" + amount + ", type="
				+ type + "]";
	}
	

}
