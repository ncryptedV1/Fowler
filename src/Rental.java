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
      case REGULAR:
        thisAmount += 2 + Math.max(daysRented - 2, 0) * 1.5;
        break;
      case NEW_RELEASE:
        thisAmount += daysRented * 3;
        break;
      case CHILDREN:
        thisAmount += 1.5 + Math.max(daysRented - 3, 0) * 1.5;
        break;
    }
    return thisAmount;
  }

}