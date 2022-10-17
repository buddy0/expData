package com.expdata.expdata;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExpdataApplicationTests {

	@Test
	void contextLoads() {
		String query = String.format("select * from Employee name like \"%%s%%\"", "test");
		System.out.println(query);
	}

}
