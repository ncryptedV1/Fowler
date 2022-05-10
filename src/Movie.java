public class Movie {
  private final String title;
  private PriceCode priceCode;

  public Movie(String title, PriceCode priceCode) {
    this.title = title;
    this.priceCode = priceCode;
  }

  public PriceCode getPriceCode() {
    return priceCode;
  }

  public String getTitle() {
    return title;
  }

  public enum PriceCode {
    REGULAR, NEW_RELEASE, CHILDREN
  }
}