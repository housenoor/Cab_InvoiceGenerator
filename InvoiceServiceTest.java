package com.bridgelabz;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class InvoiceServiceTest {
	// testCase to write Total fare
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assertions.assertEquals(25, fare, 0.0);
	}

	// testCase to calculate the Minimum Charges
	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assertions.assertEquals(5, fare, 0.0);

	}
}