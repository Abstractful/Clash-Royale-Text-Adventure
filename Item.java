public class Item {
  // creates instance variables for the Item constructor
  private String name;
  private String description;
  private int weight;
  private String ability;

  // actual item class constructor with 4 parameters
  public Item(String name, String description, int weight, String ability) {
    this.name = name;
    this.description = description;
    this.weight = weight;
   
    this.ability = ability;
  }
  // returns the String name of the item
  public String getNameI() {
    return name;
  }
  // returns the String description of the item
  public String getDescI() {
    return description;
  }
  // returns the Int weight of the item
  public int getWeightI() {
    return weight;
  }

  // returns the String ability of the item
  public String getAbilityI() {
    return ability;
  }
  //returns all of the previous returns
  public String getFullDescI() {
    return "\n" + "|" + getNameI() + "|" + "\n" + "|" + getDescI() + "|" + "\n" + "|" + getWeightI() + "|" + "\n"  + "|" + getAbilityI() + "|" + "\n";
  }
}
