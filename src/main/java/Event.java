import java.util.*;

public class Event {
  private int mNumberOfGuests;
  private Map<String, Integer> mFood;
  private Map<String, Integer> mDrinks;
  private Map<String, Integer> mEntertainment;
  private Map<String, Integer> mCoupons;

  public Event (int numberOfGuests, Map<String, Integer> food, Map<String, Integer> drinks, Map<String, Integer> entertainment, Map<String, Integer> coupons) {
    mNumberOfGuests = numberOfGuests;
    mFood = food;
    mDrinks = drinks;
    mEntertainment = entertainment;
    mCoupons = coupons;
  }

  public int getNumberOfGuests() {
    return mNumberOfGuests;
  }

  public Map<String, Integer> getFood() {
    return mFood;
  }

  public Map<String, Integer> getDrinks() {
    return mDrinks;
  }

  public Map<String, Integer> getEntertainment() {
    return mEntertainment;
  }

  public Map<String, Integer> getCoupons() {
    return mCoupons;
  }

}
