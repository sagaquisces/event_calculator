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

  public int multiplyPP(Map<String,Integer> ppType, Integer numberOfGuests) {
    int result = 0;
    for (String key : ppType.keySet()) {
       int keyFoodTotal = numberOfGuests * ppType.get(key);
       result += keyFoodTotal;
    }
    return result;
  }

  public int totalEvent() {

    int numberOfGuests = getNumberOfGuests();
    Map<String,Integer> theseDrinks = getDrinks();
    Map<String,Integer> thisFood = getFood();
    Map<String,Integer> theseEntertainments = getEntertainment();
    Map<String,Integer> theseCoupons = getCoupons();

    int eventTotal = 0;

    int foodTotal = multiplyPP(thisFood,numberOfGuests);
    int drinkTotal = multiplyPP(theseDrinks,numberOfGuests);
    eventTotal += foodTotal;
    eventTotal += drinkTotal;

    for (String entertainment : theseEntertainments.keySet()) {
      int cost = theseEntertainments.get(entertainment);
      eventTotal += cost;
    }

    for (String coupon : theseCoupons.keySet()) {
      int discount = theseCoupons.get(coupon);
      eventTotal += discount; //discount is negative integer
    }

    return eventTotal;
  }

}
