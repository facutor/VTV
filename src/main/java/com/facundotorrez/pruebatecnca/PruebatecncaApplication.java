package com.facundotorrez.pruebatecnca;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.facundotorrez.pruebatecnca.interfaceServices.IInspectorService;

@SpringBootApplication
public class PruebatecncaApplication implements CommandLineRunner{
	@Autowired
	private IInspectorService inspectorService;

	public static void main(String[] args) {
		SpringApplication.run(PruebatecncaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
 
    
	
	

	
}
