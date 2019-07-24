package com.cvs.rcom.kafka.poc.kafkaapi.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.cvs.rcom.kafka.poc.kafkaapi.model.KafkaTable;

public class KafkaTableJdbcRepository {
	public List<KafkaTable> findAll() {
		List<KafkaTable> kafkaList = new LinkedList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from kafka_test2");
			while (rs.next()) {
				KafkaTable kt = new KafkaTable();
				kt.setId(rs.getLong(1));
				kt.setV1(rs.getString(2));
				kt.setV2(rs.getString(3));
				kafkaList.add(kt);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return kafkaList;
	}
}
