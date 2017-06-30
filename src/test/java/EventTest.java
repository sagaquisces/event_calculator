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

    testDrinks.put("light drinks", 7);

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
  public void multiplyPP_takesPerPersonChargeAndMultipliesByNumOfPeopleForLightDrinks_350(){
    Map<String, Integer> testFood = new HashMap();
    Map<String, Integer> testDrinks = new HashMap();
    Map<String, Integer> testEntertainment = new HashMap();
    Map<String, Integer> testCoupons = new HashMap();

    testFood.put("light snacks", 9); // put this in just to make sure test doesn't consider it
    testDrinks.put("light drinks", 7);

    Event testEvent = new Event(50, testFood, testDrinks, testEntertainment, testCoupons);
    int thisNumberOfGuests = testEvent.getNumberOfGuests();
    Map<String,Integer> thisDrinks = testEvent.getDrinks();
    int expectedOutput = 0;
    for (String key : thisDrinks.keySet()) {
       int keyDrinksTotal = thisNumberOfGuests * thisDrinks.get(key);
       expectedOutput += keyDrinksTotal;
    }
    assertEquals(expectedOutput, testEvent.multiplyPP(testEvent.getDrinks(),testEvent.getNumberOfGuests()));

  }
}
