package com.service;

import java.time.LocalDate;

public class AppServiceImpl implements AppService {

	public double calculateAppleCost(LocalDate dateOfPurchase, int appleQuantity, double applePrice) {
		double result = 0;
		try {
		LocalDate currentDate = LocalDate.now();
		
		if (appleQuantity != 0 && dateOfPurchase.isAfter(currentDate.minusDays(4))
				&& dateOfPurchase
						.isBefore(currentDate.plusDays(LocalDate.now().getMonth().length(currentDate.isLeapYear())
								- dateOfPurchase.getDayOfMonth() + 1))) {
			result = (applePrice - (applePrice / 10)) * appleQuantity;
		} else {
			result = appleQuantity * applePrice;
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		return result;

	}

	public double calculateBreadCost(LocalDate dateOfPurchase, int soupQuantity, int breadQuantity, double breadPrice) {
		double result = 0;
		try {
		LocalDate currentDate = LocalDate.now();
		
		if (dateOfPurchase.isAfter(currentDate.minusDays(2)) && dateOfPurchase.isBefore(currentDate.plusDays(7))) {
			if (soupQuantity >= 2) {
				int discountBreadCount = (soupQuantity % 2 == 0 ? soupQuantity : soupQuantity - 1) / 2;
				if (discountBreadCount >= breadQuantity)
					result = breadQuantity * (breadPrice / 2);
				else
					result = (discountBreadCount * (breadPrice / 2))
							+ (breadQuantity - discountBreadCount) * breadPrice;

			} else {
				result = breadQuantity * breadPrice;
			}
		} else {
			result = breadQuantity * breadPrice;
		}}catch(Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public double calculateSoupCost(int soupQuantity, double soupPrice) {
		return soupQuantity * soupPrice;
	}

	public double calculateMilkCost(int milkQuantity, double milkPrice) {
		return milkQuantity * milkPrice;
	}
}
