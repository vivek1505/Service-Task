package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Scanner;

import com.service.AppService;
import com.service.AppServiceImpl;

public class MainController {

	public static void main(String[] args) {

		double soupPrice = 0.65;
		double breadPrice = 0.80;
		double milkPrice = 1.30;
		double applePrice = 0.10;

		Scanner input = new Scanner(System.in);
		System.out.println("Available Products: SOUP,BREAD,MILK AND APPLES");
		System.out.println("Enter Soup quantity(in tin):");
		int soupQuantity = input.nextInt();
		System.out.println("Enter BREAD quantity(in loaf):");
		int breadQuantity = input.nextInt();
		System.out.println("Enter MILK quantity(in bottle):");
		int milkQuantity = input.nextInt();
		System.out.println("Enter APPLE quantity(in single):");
		int appleQuantity = input.nextInt();
		LocalDate dateOfPurchase = null;
		AppService service = new AppServiceImpl();

		boolean flag = true;
		while (flag) {
			System.out.println("Enter date of purchase(DateFormat should be dd-MM-yyyy):");
			String dateOfPurchaseInput = input.next();
			try {
				dateOfPurchase = new SimpleDateFormat("dd-MM-yyyy").parse(dateOfPurchaseInput).toInstant()
						.atZone(ZoneId.systemDefault()).toLocalDate();
				flag = false;
			} catch (ParseException e) {
				flag = true;
				System.out.println("Enter valid DateFormat");
			}

		}

		System.out.println(service.calculateAppleCost(dateOfPurchase, appleQuantity, applePrice)
				+ service.calculateMilkCost(milkQuantity, milkPrice)
				+ service.calculateSoupCost(soupQuantity, soupPrice)
				+ service.calculateBreadCost(dateOfPurchase, soupQuantity, breadQuantity, breadPrice));
		input.close();

	}
}
