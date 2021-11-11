package com.bridgelabz;

public class InvoiceGenerator {

	public final double MINIMUM_COST_PER_KM = 10;
	public final int COST_PER_MIN = 1;
	public final int MINIMUM_FARE = 5;
	public RideRepository rideRepository;

	public enum RideMode {
		NORMAL(10, 1, 5), PREMIUM(15, 2, 20.0);

		private double MINIMUM_COST_PER_KM;
		private int COST_PER_MIN;
		private double MINIMUM_FARE;

		RideMode(double MINIMUM_COST_PER_KM, int COST_PER_MIN, double MINIMUM_FARE) {
			this.MINIMUM_COST_PER_KM = MINIMUM_COST_PER_KM;
			this.COST_PER_MIN = COST_PER_MIN;
			this.MINIMUM_FARE = MINIMUM_FARE;
		}
	}

	public InvoiceGenerator() {
		this.rideRepository = new RideRepository();
	}

	public double calculateFare(double distance, double time) {
		double totalFare = (distance * MINIMUM_COST_PER_KM) + (time * COST_PER_MIN);
		if (totalFare < MINIMUM_FARE)
			return MINIMUM_FARE;
		return totalFare;
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRides(userId, rides);
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}
}
