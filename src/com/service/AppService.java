package com.service;

import java.time.LocalDate;

public interface AppService {

	public double calculateAppleCost(LocalDate dateOfPurchase, int appleQuantity, double applePrice);

	public double calculateBreadCost(LocalDate dateOfPurchase, int soupQuantity, int breadQuantity, double breadPrice);

	public double calculateSoupCost(int appleQuantity, double applePrice);

	public double calculateMilkCost(int milkQuantity, double milkPrice);
}
