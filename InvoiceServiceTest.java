package com.bridgelabz;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class InvoiceServiceTest {
	InvoiceGenerator invoiceGenerator = null;

	@Before
	public void setUp() throws Exception {
		invoiceGenerator = new InvoiceGenerator();
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assertions.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinFare() {
		invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assertions.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = { new Ride(25.0, 30), new Ride(12.0, 20) };
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 420);
		Assertions.assertEquals(expectedInvoiceSummary, summary);
	}

	@Test
	public void givenUserId_shouldReturnInvoiceSummary() {
		invoiceGenerator = new InvoiceGenerator();
		String userId = "srikanthh994@gmail.com";
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		invoiceGenerator.addRides(userId, rides);
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides, "normal");
		InvoiceSummary invoiceSummary = invoiceGenerator.getInvoiceSummary(userId);
		Assertions.assertEquals(invoiceSummary, summary);

	}
}