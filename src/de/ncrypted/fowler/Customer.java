package de.ncrypted.fowler;

import java.util.ArrayList;
import java.util.List;

class Customer {
  private final String name;
  private final List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  public String generateStatement() {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    String result = String.format("de.ncrypted.fowler.Rental Record for %s\n", getName());
    result += "\tTitle\t\tDays\tAmount\n";

    for (Rental each : rentals) {
      // determine amounts for each line
      double thisAmount = each.calculateAmount();
      // add frequent renter points
      frequentRenterPoints++;
      // add bonus for a two-day new release rental
      if ((each.getMovie().getPriceCode() == Movie.PriceCode.NEW_RELEASE) &&
          each.getDaysRented() > 1) {
        frequentRenterPoints++;
      }
      // show figures for this rental
      result += String.format("\t%s\t\t%s\t%s\n", each.getMovie().getTitle(), each.getDaysRented(),
          thisAmount);
      totalAmount += thisAmount;
    }
    // add footer lines
    result += String.format("Amount owed is %s\n", totalAmount);
    result += String.format("You earned %s frequent renter points", frequentRenterPoints);
    return result;
  }

}
    