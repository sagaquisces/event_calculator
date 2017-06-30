import java.io.Console;
import java.util.*;

public class App {
  public static void main(String[] args) {

    Map<String, Integer> baseFood = new HashMap();
    Map<String, Integer> baseDrinks = new HashMap();
    Map<String, Integer> baseEntertainment = new HashMap();
    Map<String, Integer> baseCoupons = new HashMap();

    baseDrinks.put("full bar", 20);
    baseEntertainment.put("live band", 700);
    baseEntertainment.put("balloons", 250);

    Console myConsole = System.console();
    System.out.println ("Welcome to Evening Event Master.");
    System.out.println ("I'll come up with a quote based on your preferences for an event.");
    System.out.println ("How many guests do you have?");

    Integer numberOfGuests = Integer.parseInt(myConsole.readLine());

    Event myEvent = new Event (numberOfGuests, baseFood, baseDrinks, baseEntertainment, baseCoupons);

    System.out.println ("What food choices would you like?");
    System.out.println ("Enter 'light snack', 'dinner', or 'both'");

    String userFood = myConsole.readLine();

    if (userFood.equals("light snack")) {myEvent.getFood().put("light snack", 9);}
    else if (userFood.equals("dinner")) {myEvent.getFood().put("dinner", 15);}
    else if (userFood.equals("both")) {myEvent.getFood().put("both", 20);}
    else {System.out.println("You only have three choices:");}


    System.out.println (myEvent.getFood());

  }
}
