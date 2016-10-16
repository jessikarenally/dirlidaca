package com.service.problem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.support.KafkaNull;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import com.Application;
import com.dao.problem.ProblemRepository;
import com.kafka.ReceiverKafka;
import com.model.problem.Problem;
import com.model.solution.Solution;

@Service
public class ProblemServiceImpl implements ProblemService{
	
	@Autowired
	ProblemRepository problemRepository;
	
	ReceiverKafka receiver;

	@Override
	public List<Problem> findAll() {
		List<Problem> result = new ArrayList<Problem>();
		for(Problem element:problemRepository.findAll()){
			result.add(element);
		}
		receiver = new ReceiverKafka();
		receiver.receiveFromKafka();
		return result;
	}

	@Override
	public List<Problem> findByName(String name) {
		return problemRepository.findByName(name);
	}

	@Override
	public Problem findById(long id) {
		return problemRepository.findOne(id);
	}

	@Override
	public void save(Problem problem) {
		problemRepository.save(problem);
		sendToKafka(problem);
	}
	
	@Override
	public void removeProblem(long id){
		problemRepository.delete(id);
	}

	@Override
	public long countProblems() {
		return problemRepository.count();
	}
	
	/**
 	 * Envia um problema pra ser armazenado no Kafka
 	 * 
 	 * @param soluçao a ser salva
 	 */
 	public void sendToKafka(Problem problem) {
 		ConfigurableApplicationContext context = 
 				new SpringApplicationBuilder(Application.class)
			 		.web(false)
			 		.run();
 		MessageChannel toKafka = context.getBean("toKafka", MessageChannel.class);
 		for (int i = 0; i < 10; i++) {
 			toKafka.send(new GenericMessage<>(problem.toString()));
 		}
 		toKafka.send(new GenericMessage<>(KafkaNull.INSTANCE));
 
 		context.close();
 	}
}
