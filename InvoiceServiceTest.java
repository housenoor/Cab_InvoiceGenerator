package com.bridgelabz;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class InvoiceServiceTest {
	InvoiceGenerator invoiceGenerator = null;

	@Before
	public void setUp() {
		invoiceGenerator = new InvoiceGenerator();
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assertions.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assertions.assertEquals(5, fare, 0.0);

	}

	@Test
	public void givenMultipleRides_ShouldReturnTotalFare() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		double fare = invoiceGenerator.calculateFare(rides);
		Assertions.assertEquals(30, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(5.0, 10), new Ride(10, 20) };
		InvoiceSummary invoiceSummary = invoiceGenerator.getInvoiceSummary(rides);
		InvoiceSummary summary = new InvoiceSummary(2, 180);
		Assertions.assertEquals(summary, invoiceSummary);
	}
}