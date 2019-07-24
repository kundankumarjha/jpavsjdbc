package com.cvs.rcom.kafka.poc.kafkaapi.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvs.rcom.kafka.poc.kafkaapi.model.KafkaTable;
import com.cvs.rcom.kafka.poc.kafkaapi.repository.KafkaTableJdbcRepository;
import com.cvs.rcom.kafka.poc.kafkaapi.repository.KafkaTableRepository;

@RestController
public class KafkaTableController {
	@Autowired
	KafkaTableRepository kafkaTableRepository;
	KafkaTableJdbcRepository KafkaTableJdbcRepository = new KafkaTableJdbcRepository();

	@RequestMapping("/jpaFindAll")
	public Iterable<KafkaTable> jpaFindAll() {
		System.out.println("###STARTED jpaFindAll");
		long noSendStartTime = System.currentTimeMillis();
		Iterable<KafkaTable> kafkaTables = kafkaTableRepository.findAll();
		System.out.println("###ENDED jpaFindAll. Time Taken : " + (System.currentTimeMillis() - noSendStartTime));
		return kafkaTables;
	}

	@RequestMapping("/jdbcFindAll")
	public List<KafkaTable> jdbcFindAll() {
		System.out.println("###STARTED jdbcFindAll");
		long noSendStartTime = System.currentTimeMillis();
		List<KafkaTable> kafkaTables = KafkaTableJdbcRepository.findAll();
		System.out.println("###ENDED jdbcFindAll. Time Taken : " + (System.currentTimeMillis() - noSendStartTime));
		return kafkaTables;
	}
	
	@RequestMapping("/save")
	public void save() {
		int count = 1;
		for(int j=1; j<1000;j++) {
			List<KafkaTable> list = new LinkedList<KafkaTable>();
			for(int i=1; i<1000;i++) {
				KafkaTable kt = new KafkaTable();
				kt.setV1("V1_"+ count);
				kt.setV1("V1_"+ count);
				list.add(kt);
				count++;
			}
			kafkaTableRepository.saveAll(list);
		}
	}
}
