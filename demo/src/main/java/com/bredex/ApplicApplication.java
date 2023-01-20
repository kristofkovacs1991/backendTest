package com.bredex;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class ApplicApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(ApplicApplication.class, args);


		InetAddress ip = InetAddress.getLocalHost();


	}

}
