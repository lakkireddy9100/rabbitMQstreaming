package dev.rabbitMQ.streaming.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBinding(Sink.class)
@SpringBootApplication
@Configuration
public class CustomerFeedbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerFeedbackApplication.class, args);
	}


	// StreamListerner will listen to the queue we gave in the Properties file and receive the message asynchronously
	// Sink.Input is a Bindable  interface with one  input channel

	@StreamListener(target = Sink.INPUT)
		public void acknowledgeMessage(String message) {
		System.out.println("Feedback Acknowledge : Received Message is   --- >  " + message);
	}




}
