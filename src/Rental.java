class Rental {
  private final Movie movie;
  private final int daysRented;

  public Rental(Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  public double calculateAmount() {
    double thisAmount = 0;
    switch (movie.getPriceCode()) {
      case Movie.REGULAR:
        thisAmount += 2;
        if (daysRented > 2) {
          thisAmount += (daysRented - 2) * 1.5;
        }
        break;
      case Movie.NEW_RELEASE:
        thisAmount += daysRented * 3;
        break;
      case Movie.CHILDREN:
        thisAmount += 1.5;
        if (daysRented > 3) {
          thisAmount += (daysRented - 3) * 1.5;
        }
        break;
    }
    return thisAmount;
  }

}