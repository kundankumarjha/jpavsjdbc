package com.cvs.rcom.kafka.poc.kafkaapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="kafka_test2")
public class KafkaTable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String v1;
	private String v2;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getV1() {
		return v1;
	}
	public void setV1(String v1) {
		this.v1 = v1;
	}
	public String getV2() {
		return v2;
	}
	public void setV2(String v2) {
		this.v2 = v2;
	}
}
