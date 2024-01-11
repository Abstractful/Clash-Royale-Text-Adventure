import java.util.*;


public class Room {
  private ArrayList<Item> items; // creates an array list for items (items in room)
  private String description;    //description of the room
  private String name;           //name of the room
  private HashMap<String, Room> exits; // stores exits of this room.
  private ArrayList<Obstacle> obstacles; // creates an array list for obstacles (obstacles in room)

 //intializes all of the instance variables
  public Room(String n, String description) {
    this.description = description;
    this.name = n;
    exits = new HashMap<>();
    items = new ArrayList<>();
    obstacles = new ArrayList<>();
  }

 //sets the exit for each room
  public void setExit(String direction, Room neighbor) {
    exits.put(direction, neighbor);
  }

  /**
   * @return The short description of the room (the one that was defined in the
   *         constructor).
   */
  public String getShortDescription() {
    return description;
  }
  //returns the String name of the room
  public String getNameR() {
    return name;
  }

  /**
   * Return a description of the room in the form: You are in the kitchen. Exits:
   * north west
   * 
   * @return A long description of this room
   */
  public String getLongDescription() {
    return "\n You are " + description + ".\n" + getExitString();
  }

  /**
   * Return a string describing the room's exits, for example "Exits: north west".
   * 
   * @return Details of the room's exits.
   */
  private String getExitString() {
    String returnString = "Exits:";
    Set<String> keys = exits.keySet();
    for (String exit : keys) {
      returnString += " " + exit;
    }
    return returnString;
  }

  /**
   * Return the room that is reached if we go from this room in direction
   * "direction". If there is no room in that direction, return null.
   * 
   * @param direction The exit's direction.
   * @return The room in the given direction.
   */
  public Room getExit(String direction) {
    return exits.get(direction);
  }
  //allows for adding items to a room
  public void setItem(Item item) {
    items.add(item);
  }
  
  //allows for adding obstacles to a room
  public void setObstacle(Obstacle obstacle) {
    obstacles.add(obstacle);
  }
  
  //allows for removing items to a room
  public void removeItem(Item item) {
    items.remove(item);
  }

    //allows for removing obstacles to a room
  public void removeObstacle(Obstacle obstacle) {
    obstacles.remove(obstacle);
  }
  //returns the actual item when inputting the valid string name -- checks through the item array list of the room constructor
  public Item getRoomItem(String name) {
    for (Item stuff : items) {
      if (name.toLowerCase().equals(stuff.getNameI().toLowerCase())) {
        return stuff;
      }
    }
    return null;
  }
  //prints out all of the items in a room
  public String printRoomItems() {
    String str = "";
    for (Item i : items) {
      str += i.getNameI() + " ";
    }
    return str;
  }
  //returns the actual obstacle when inputting the valid string name -- checks through thhe obstacle array list
  public Obstacle getRoomObstacle() {
    for (Obstacle i : obstacles) {
      return i;
    }
    return null;
  }
  //prints out all of the obstacles in a room
  public String printRoomObstacles() {
    String str = "";
    for (Obstacle i : obstacles) {
      str += i.getNameO() + " ";
    }
    return str;
  }
  //checks to see if a room has an obstacle(s) in its array list of obstacles
  public boolean hasObstacle() {
    if (obstacles.size() > 0) {
      return true;
    } else {
      return false;
    }
  }
  //checks to see if a room has an item(s) in its array list of items
  public boolean hasItem() {
    if (items.size() > 0) {
      return true;
    } else {
      return false;
    }
  }
}
