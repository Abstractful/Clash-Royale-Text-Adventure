import java.util.*;

//making player class 
public class Player {
  // private instance variables for player class
  private final int MAXWEIGHT = 4;
  // i created a final constant so that if anyone wanted to change the max amount
  // of items the player can carry, they could do it all in one spot
  private ArrayList<Item> inventory;

  // initializes inventory
  public Player() {
    inventory = new ArrayList<Item>();
  }
  //prints out the items in the arraylist of items [inventory] -- whatever the player is holding
  public void getInventory() {
    if (inventory.size() == 0) {
      System.out.println("You have no items");
    } else {
      System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
      System.out.println(
          "You have " + inventory.size() + " items and " + (MAXWEIGHT - inventory.size()) + " available spaces.");
      for (Item item : inventory) {
        System.out.println(item.getFullDescI()); System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
      }
    }
  }
  //searches the inventory for a specific item if the input is valid
  public Item findItem(String name){
    for (Item item : inventory){
      if(item.getNameI().toLowerCase().equals(name.toLowerCase())){
        return item;
      }
    }
    return null;
  }
  //adds the the item input if valid to the player inventory and removes it from the array list items of the current room
  public void obtain(Item item) {
    if (inventory.size() < MAXWEIGHT) {
      inventory.add(item);
      System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
      System.out.println("You have obtained " + item.getNameI() + "!");
      System.out.println(item.getFullDescI());
      System.out.println("You have " + (MAXWEIGHT - inventory.size()) + " available spaces in your inventory.");
      System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
    } else {
      System.out.println("You have no room in your inventory...");
      
    }
  }
//removes items from inventory and adds it to the current room
  public void drop(String itemName, Room room) {
    for (Item i : inventory) {
      String temp = i.getNameI();
      if (temp.toLowerCase().equals(itemName.toLowerCase())) {
        inventory.remove(i);
        room.setItem(i);
       break;
      }
    }
    System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
    System.out.println("You have " + inventory.size() + " items and " + (MAXWEIGHT - inventory.size()) + " available spaces.");
    System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
  }
//removes the item from inventory and does not add it anywhere else
  public void delete(Item item) {
    for (Item i : inventory) {
      String temp =i.getNameI();
      if (temp.toLowerCase().equals(item.getNameI().toLowerCase())) {
        inventory.remove(i);
        break;
      }
    }
    System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
    System.out.println("You have " + inventory.size() + " items and " + (MAXWEIGHT - inventory.size()) + " available spaces.");
    System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
  }
}
