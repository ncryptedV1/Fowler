package de.ncrypted.fowler;

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
    switch (movie.getPriceCode()) {
      case REGULAR:
        return 2 + Math.max(daysRented - 2, 0) * 1.5;
      case NEW_RELEASE:
        return daysRented * 3;
      case CHILDREN:
        return 1.5 + Math.max(daysRented - 3, 0) * 1.5;
      default:
        return 0;
    }
  }

}