import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class EventTest {

  @Test
  public void newEvent_instantiatesCorrectly() {
    Map<String, Integer> testFood = new HashMap();
    Map<String, Integer> testDrinks = new HashMap();
    Map<String, Integer> testEntertainment = new HashMap();
    Map<String, Integer> testCoupons = new HashMap();

    Event testEvent = new Event(50, testFood, testDrinks, testEntertainment, testCoupons);
    assertEquals(true, testEvent instanceof Event);
  }

  @Test
  public void newEvent_getsNumberOfGuests_50() {
    Map<String, Integer> testFood = new HashMap();
    Map<String, Integer> testDrinks = new HashMap();
    Map<String, Integer> testEntertainment = new HashMap();
    Map<String, Integer> testCoupons = new HashMap();

    Event testEvent = new Event(50, testFood, testDrinks, testEntertainment, testCoupons);
    assertEquals(50, testEvent.getNumberOfGuests());
  }

  @Test
  public void newEvent_getsFood_HashMap() {
    Map<String, Integer> testFood = new HashMap();
    Map<String, Integer> testDrinks = new HashMap();
    Map<String, Integer> testEntertainment = new HashMap();
    Map<String, Integer> testCoupons = new HashMap();

    testFood.put("light snacks", 9);

    Event testEvent = new Event(50, testFood, testDrinks, testEntertainment, testCoupons);
    assertEquals(testFood, testEvent.getFood());
  }

  @Test
  public void newEvent_getsDrinks_HashMap() {
    Map<String, Integer> testFood = new HashMap();
    Map<String, Integer> testDrinks = new HashMap();
    Map<String, Integer> testEntertainment = new HashMap();
    Map<String, Integer> testCoupons = new HashMap();

    testDrinks.put("non-alcoholic drinks", 7);

    Event testEvent = new Event(50, testFood, testDrinks, testEntertainment, testCoupons);
    assertEquals(testDrinks, testEvent.getDrinks());
  }

  @Test
  public void newEvent_getsEntertainment_HashMap() {
    Map<String, Integer> testFood = new HashMap();
    Map<String, Integer> testDrinks = new HashMap();
    Map<String, Integer> testEntertainment = new HashMap();
    Map<String, Integer> testCoupons = new HashMap();

    testEntertainment.put("live band", 700);

    Event testEvent = new Event(50, testFood, testDrinks, testEntertainment, testCoupons);
    assertEquals(testEntertainment, testEvent.getEntertainment());
  }

  @Test
  public void newEvent_getsCoupons_HashMap() {
    Map<String, Integer> testFood = new HashMap();
    Map<String, Integer> testDrinks = new HashMap();
    Map<String, Integer> testEntertainment = new HashMap();
    Map<String, Integer> testCoupons = new HashMap();

    testEntertainment.put("abcde", -100);

    Event testEvent = new Event(50, testFood, testDrinks, testEntertainment, testCoupons);
    assertEquals(testCoupons, testEvent.getCoupons());
  }

  // food, drinks are per person, so let's test for a function to multiply per person charge by number of getNumberOfGuests

  @Test
  public void multiplyPP_takesPerPersonChargeAndMultipliesByNumOfPeople_450(){
    Map<String, Integer> testFood = new HashMap();
    Map<String, Integer> testDrinks = new HashMap();
    Map<String, Integer> testEntertainment = new HashMap();
    Map<String, Integer> testCoupons = new HashMap();

    testFood.put("light snacks", 9);

    Event testEvent = new Event(50, testFood, testDrinks, testEntertainment, testCoupons);
    int thisNumberOfGuests = testEvent.getNumberOfGuests();
    Map<String,Integer> thisFood = testEvent.getFood();
    int expectedOutput = 0;
    for (String key : thisFood.keySet()) {
       int keyFoodTotal = thisNumberOfGuests * thisFood.get(key);
       expectedOutput += keyFoodTotal;
    }
    assertEquals(expectedOutput, testEvent.multiplyPP(testEvent.getFood(),testEvent.getNumberOfGuests()));

  }

  @Test
  public void multiplyPP_takesPerPersonChargeAndMultipliesByNumOfPeopleForFood_450(){
    Map<String, Integer> testFood = new HashMap();
    Map<String, Integer> testDrinks = new HashMap();
    Map<String, Integer> testEntertainment = new HashMap();
    Map<String, Integer> testCoupons = new HashMap();

    testFood.put("light snacks", 9);

    Event testEvent = new Event(50, testFood, testDrinks, testEntertainment, testCoupons);
    int numberOfGuests = testEvent.getNumberOfGuests();
    Map<String,Integer> thisFood = testEvent.getFood();
    int expectedOutput = 0;
    for (String item : thisFood.keySet()) {
       int itemFoodTotal = numberOfGuests * thisFood.get(item);
       expectedOutput += itemFoodTotal;
    }
    assertEquals(expectedOutput, testEvent.multiplyPP(testEvent.getFood(),testEvent.getNumberOfGuests()));

  }

  @Test
  public void multiplyPP_takesPerPersonChargeAndMultipliesByNumOfPeopleForLightDrinks_350(){
    Map<String, Integer> testFood = new HashMap();
    Map<String, Integer> testDrinks = new HashMap();
    Map<String, Integer> testEntertainment = new HashMap();
    Map<String, Integer> testCoupons = new HashMap();

    testFood.put("light snacks", 9); // put this in just to make sure test doesn't consider it
    testDrinks.put("non-alcoholic", 7);

    Event testEvent = new Event(50, testFood, testDrinks, testEntertainment, testCoupons);
    int numberOfGuests = testEvent.getNumberOfGuests();
    Map<String,Integer> theseDrinks = testEvent.getDrinks();
    int expectedOutput = 0;
    for (String item : theseDrinks.keySet()) {
       int itemDrinksTotal = numberOfGuests * theseDrinks.get(item);
       expectedOutput += itemDrinksTotal;
    }
    assertEquals(expectedOutput, testEvent.multiplyPP(theseDrinks,numberOfGuests));

  }

  @Test
  public void totalEvent_takesFoodAndDrinkChoiceAddsUpGrandTotal_1750(){
    Map<String, Integer> testFood = new HashMap();
    Map<String, Integer> testDrinks = new HashMap();
    Map<String, Integer> testEntertainment = new HashMap();
    Map<String, Integer> testCoupons = new HashMap();

    testFood.put("dinner", 15);
    testDrinks.put("full bar", 20);

    Event testEvent = new Event(50, testFood, testDrinks, testEntertainment, testCoupons);
    int numberOfGuests = testEvent.getNumberOfGuests();
    Map<String,Integer> theseDrinks = testEvent.getDrinks();
    Map<String,Integer> thisFood = testEvent.getFood();

    int expectedOutput = 0;

    expectedOutput += testEvent.multiplyPP(thisFood,numberOfGuests);
    expectedOutput += testEvent.multiplyPP(theseDrinks,numberOfGuests);

    assertEquals(expectedOutput, testEvent.totalEvent());

  }

  @Test
  public void totalEvent_takesFoodDrinkEntertainmentChoicesAddsUpGrandTotal_2700(){
    Map<String, Integer> testFood = new HashMap();
    Map<String, Integer> testDrinks = new HashMap();
    Map<String, Integer> testEntertainment = new HashMap();
    Map<String, Integer> testCoupons = new HashMap();

    testFood.put("dinner", 15);
    testDrinks.put("full bar", 20);
    testEntertainment.put("live band", 700);
    testEntertainment.put("balloons", 250);

    Event testEvent = new Event(50, testFood, testDrinks, testEntertainment, testCoupons);
    int numberOfGuests = testEvent.getNumberOfGuests();
    Map<String,Integer> theseDrinks = testEvent.getDrinks();
    Map<String,Integer> thisFood = testEvent.getFood();
    Map<String,Integer> theseEntertainments = testEvent.getEntertainment();

    int expectedOutput = 0;

    expectedOutput += testEvent.multiplyPP(thisFood,numberOfGuests);
    expectedOutput += testEvent.multiplyPP(theseDrinks,numberOfGuests);

    for (String entertainment : theseEntertainments.keySet()) {
      int cost = theseEntertainments.get(entertainment);
      expectedOutput += cost;
    }


    assertEquals(expectedOutput, testEvent.totalEvent());

  }

  @Test
  public void totalEvent_takesFoodDrinkEntertainmentChoicesAndCouponsAddsUpGrandTotal_2400(){
    Map<String, Integer> testFood = new HashMap();
    Map<String, Integer> testDrinks = new HashMap();
    Map<String, Integer> testEntertainment = new HashMap();
    Map<String, Integer> testCoupons = new HashMap();

    testFood.put("dinner", 15);
    testDrinks.put("full bar", 20);
    testEntertainment.put("live band", 700);
    testEntertainment.put("balloons", 250);
    testCoupons.put("abcde", -100);
    testCoupons.put("fghij", -200);

    Event testEvent = new Event(50, testFood, testDrinks, testEntertainment, testCoupons);
    int numberOfGuests = testEvent.getNumberOfGuests();
    Map<String,Integer> theseDrinks = testEvent.getDrinks();
    Map<String,Integer> thisFood = testEvent.getFood();
    Map<String,Integer> theseEntertainments = testEvent.getEntertainment();
    Map<String,Integer> theseCoupons = testEvent.getCoupons();

    int expectedOutput = 0;

    expectedOutput += testEvent.multiplyPP(thisFood,numberOfGuests);
    expectedOutput += testEvent.multiplyPP(theseDrinks,numberOfGuests);

    for (String entertainment : theseEntertainments.keySet()) {
      int cost = theseEntertainments.get(entertainment);
      expectedOutput += cost;
    }

    for (String coupon : theseCoupons.keySet()) {
      int discount = theseCoupons.get(coupon);
      expectedOutput += discount; //discount is negative integer
    }

    assertEquals(expectedOutput, testEvent.totalEvent());

  }
}
