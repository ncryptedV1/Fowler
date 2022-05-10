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
    String result = "Rental Record for " + this.getName() + "\n";
    result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

    for (Rental each : rentals) {
      // determine amounts for each line
      double thisAmount = each.calculateAmount();
      // add frequent renter points
      frequentRenterPoints++;
      // add bonus for a two-day new release rental
      if ((each.getMovie().getPriceCode() == Movie.PriceCode.NEW_RELEASE) && each.getDaysRented() > 1) {
        frequentRenterPoints++;
      }
      // show figures for this rental
      result += "\t" + each.getMovie().getTitle() + "\t" + "\t" + each.getDaysRented() + "\t" +
          thisAmount + "\n";
      totalAmount += thisAmount;
    }
    // add footer lines
    result += "Amount owed is " + totalAmount + "\n";
    result += "You earned " + frequentRenterPoints + " frequent renter points";
    return result;
  }

}
    