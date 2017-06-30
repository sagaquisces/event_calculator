import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class EventTest {

  @Test
  public void newEvent_instantiatesCorrectly() {
    Map<String, Double> testFood = new HashMap();
    Map<String, Double> testDrinks = new HashMap();
    Map<String, Double> testEntertainment = new HashMap();
    testFood.put("light snacks", new Double(5.50));
    testDrinks.put("light drinks", new Double(6.50));
    testEntertainment.put("live band", new Double(450.00));

    Event testEvent = new Event(50, testFood, testDrinks, testEntertainment);
    assertEquals(true, testEvent instanceof Event);
  }

  // @Test
  // public void newEvent_getsNumberOfGuests_50() {
  //   Event testEvent = new Event(50);
  //   assertEquals(50, testEvent.setNumberOfGuests());
  // }
}
