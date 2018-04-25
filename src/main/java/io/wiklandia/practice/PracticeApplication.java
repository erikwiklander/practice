package io.wiklandia.practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.wiklandia.practice.linkedlist.ListNode;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	@Bean
	CommandLineRunner pre() {
		return args -> {
			ListNode<Integer> head = new ListNode<>(1);
			head.next = new ListNode<>(2);
			head.next.next = new ListNode<>(3);
			ListNode.print(head);
			ListNode.print(ListNode.reverse(head));
		};
	}
}
