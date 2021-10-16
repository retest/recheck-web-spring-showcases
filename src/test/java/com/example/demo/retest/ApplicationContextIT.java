package com.example.demo.retest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.PersonController;

@SpringBootTest
class ApplicationContextIT {

	@Autowired
	private PersonController controller;

	@Test
	void contextLoads() {}

	@Test
	public void controllerNotNull() {
		assertThat( controller ).isNotNull();
	}

}
