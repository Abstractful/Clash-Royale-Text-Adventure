public class Obstacle {
  // creates instance variables for the Obstacle constructor
  private String name;
  private String abilityReq;

  // actual item class constructor with 4 parameters
  public Obstacle(String name, String abilityRequired) {
    this.name = name;
    this.abilityReq = abilityRequired;
  }
  //returns the String name of the obstacle
  public String getNameO() {
    return name;
  }
  //returns the string abilityreq of the obstacle
  public String getAbilityO() {
    return abilityReq;
  }
  //returns all of the previous returns
  public String getFullDescO() {
    return "\n" + "|" + getNameO() + "|" + "\n" + "|" + getAbilityO() + "|" + "\n";
  }
}