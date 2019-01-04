package com.freshvotes.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetailsServiceTest {

	@Test
	public void test() {
		
		BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
		String rawPassword = "password1";
		String encodedPassword = encoder.encode(rawPassword);
		
		assertThat (rawPassword, not(encodedPassword));
		
		System.out.println("encodedPassword is =");
		System.out.println(encodedPassword);
		
		//fail("Not yet implemented");
	}

}
