package com.cvs.rcom.kafka.poc.kafkaapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.cvs.rcom.kafka.poc.kafkaapi.model.KafkaTable;

public interface KafkaTableRepository extends CrudRepository<KafkaTable, Long> {
}
