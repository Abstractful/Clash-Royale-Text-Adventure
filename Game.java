public class Game {
  private Parser parser;
  private Room currentRoom;
  private Room previousRoom;
  private Player player;
  private String winCondition;

  /**
   * Create the game and initialise its internal map.
   */
  public Game() {
    createRooms();
    parser = new Parser();
    player = new Player();
  }

  /**
   * Create all the rooms and link their exits together.
   */
  private void createRooms() {
    Room barbarianBowl, goblinJungle, serenityPeak, pekkasPlayhouse, buildersWorkshop, hogMountain, spellValley, electroValley, royalArena, frozenPeak, rascalsHidehout, mines, kitchen;
    
    // create the rooms
    barbarianBowl = new Room("Barbarian Bowl","at the training quarters of the Barbarians");
    goblinJungle = new Room("Goblin Jungle","in secret village of the goblins");
    serenityPeak = new Room("Serenity Peak","in a serene place");
    pekkasPlayhouse = new Room("Pekka's Playhouse","at the monster's playhouse");
    buildersWorkshop = new Room("Builders' Workshop","at a hub of machinery and ingenuity");
    hogMountain = new Room("Hog Mountain","on a mountain only the strongest could climb");
    spellValley = new Room("Spell Valley", "at a hub of magic and potions");
    electroValley = new Room("Electro Valley","at a hub of electricity");
    royalArena = new Room("Royal Arena", "where Royalty Resides");
    frozenPeak = new Room("Frozen Peak", "at the frigid peak of Hog Mountain");
    rascalsHidehout = new Room("Rascals' Hideout","at the hideout hidden in the mountain");
    kitchen = new Room("Giant's Kitchen","in the Giant's kitchen");
    mines = new Room("The Mines","in a deep cave...also there is nothing here I just wanted to waste your time :P");

    winCondition = royalArena.getShortDescription();

    // create items
    Item hammer = new Item("hammer", "Hog Rider's Hammer: Reliable hammer for destruction or building", 1, "destroy");
    Item infernoTower = new Item("infernoTower", "Word has it that the inferno tower can melt the ice caps of mars", 1, "melt");
    Item axe = new Item("axe","Valkyrie's Battle Axe: Great for chopping wood", 1, "cut");
    Item shovel = new Item("shovel","Miner's Shovel: Can excavate at unbelievable speed but could be used a big spoon", 1, "stir");
    Item tornado = new Item("tornado", "A Powerful Wind Spell: Can move many things at once", 1, "blow");
    Item earthquake = new Item("earthquake" , "A Destructive Earth Spell: Can break the floor and buildings", 1, "break");
    Item zap = new Item("zap", "Weak Electric Magic: Can stun things", 1, "stun");
    Item hog = new Item("hog" , "Hog Rider's Hog: It's a ram...It can jump far I guess?", 1, "jump");

    //create obstacles
    Obstacle statue = new Obstacle("A Goblin Statue", "destroy");
    Obstacle icicle = new Obstacle("An Icicle","melt");
    Obstacle tree = new Obstacle("A Large Oak Tree", "cut");
    Obstacle pot = new Obstacle("A Pot with Potion Ingredients", "stir");
    Obstacle pigs = new Obstacle("A bunch of big fat pigs", "blow");
    Obstacle rock = new Obstacle("A Massive boulder", "break");
    Obstacle mDoor = new Obstacle("A Reinforced, Electronic Metal Door", "stun");
    Obstacle ravine = new Obstacle("A huge hole", "jump");
    
    // initialise room exits
    barbarianBowl.setExit("east", goblinJungle);
    barbarianBowl.setExit("south", pekkasPlayhouse);
    barbarianBowl.setExit("west", serenityPeak);    
    
    goblinJungle.setExit("west", barbarianBowl);
    goblinJungle.setExit("east", spellValley);
    goblinJungle.setExit("north", kitchen);

    serenityPeak.setExit("east", barbarianBowl);

    pekkasPlayhouse.setExit("north", barbarianBowl);
    pekkasPlayhouse.setExit("south", buildersWorkshop);

    buildersWorkshop.setExit("west", hogMountain);
    buildersWorkshop.setExit("north", pekkasPlayhouse);
    
    hogMountain.setExit("east", buildersWorkshop);
    hogMountain.setExit("west", frozenPeak);

    spellValley.setExit("west", goblinJungle);
    spellValley.setExit("south", electroValley);
    
    electroValley.setExit("east", royalArena);

    royalArena.setExit("east", electroValley);

    frozenPeak.setExit("east", hogMountain);
    frozenPeak.setExit("west", rascalsHidehout);
    
    rascalsHidehout.setExit("east", frozenPeak);

    kitchen.setExit("north", mines);
    kitchen.setExit("south", goblinJungle);

    mines.setExit("south", kitchen);


    // initializes items in each room
    barbarianBowl.setItem(hammer);
    
    pekkasPlayhouse.setItem(axe);
    
    buildersWorkshop.setItem(shovel);

    goblinJungle.setItem(infernoTower);

    spellValley.setItem(tornado);
    spellValley.setItem(earthquake);
    
    rascalsHidehout.setItem(zap);

    serenityPeak.setItem(hog);

    //initializes obstacles in each room
    goblinJungle.setObstacle(statue);

    frozenPeak.setObstacle(icicle);

    buildersWorkshop.setObstacle(tree);

    spellValley.setObstacle(pot);

    kitchen.setObstacle(pigs);

    mines.setObstacle(rock);

    electroValley.setObstacle(mDoor);

    hogMountain.setObstacle(ravine);


    currentRoom = barbarianBowl; // start game barbarianBowl
  }

  /**
   * Main play routine. Loops until end of play.
   */
  public void play() {
    printWelcome();

    // Enter the main command loop. Here we repeatedly read commands and
    // execute them until the game is over.
    //if win equals true, end game
    boolean finished = false;
    while (!finished) {
      Command command = parser.getCommand();
      finished = processCommand(command);
      if (win()){
        System.out.println("Congratulations!!! You won!");
        break;
      }
    }
    System.out.println("Thank you for playing.  Good bye.");
  }

  /**
   * Print out the opening message for the player.
   */
  //prints the welcoming statement including starting room name and long description
  private void printWelcome() {
    System.out.println();
    System.out.println();
    System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
    System.out.println("Welcome to the world of Clash Royale!");
    System.out.println("Your goal is to use items and remove obstacles from your path to reach the Royal Arena.");
    System.out.println("Good Luck!");
    System.out.println("Type 'help' if you need help.");
    System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
    printHelp();
    System.out.println(currentRoom.getNameR());
    System.out.println(currentRoom.getLongDescription());
  }

  /**
   * Given a command, process (that is: execute) the command.
   * 
   * @param command The command to be processed.
   * @return true If the command ends the game, false otherwise.
   */
  private boolean processCommand(Command command) {
    boolean wantToQuit = false;

    if (command.isUnknown()) {
      System.out.println("I don't know what you mean...");
      return false;
    }

    String commandWord = command.getCommandWord();
    if (commandWord.equals("help")) {
      printHelp();
    } else if (commandWord.equals("go")) {
      goRoom(command);
    } else if (commandWord.equals("quit")) {
      wantToQuit = quit(command);
    } else if (commandWord.equals("look")) {
      look(command);
    } else if (commandWord.equals("obtain")) {
      obtainItem(command);
    } else if (commandWord.equals("drop")) {
      dropItem(command);
    } else if (commandWord.equals("use")) {
      useItem(command);
    } else if (commandWord.equals("inventory")) {
      getInv(command);
    }

    // else command not recognised.
    return wantToQuit;
  }

  // implementations of user commands:

  /**
   * Print out some help information. Here we print some stupid, cryptic message
   * and a list of the command words.
   */
  //from player class
  private void getInv(Command command) {
    this.player.getInventory();
  }
  //use item will use and delete both the item and obstacle involved
  private void useItem(Command command) {
    Item item = player.findItem(command.getSecondWord()); //the second word inputted is used to see if there is an item in the inventory and sets it to the item variable item
    Obstacle obstacle = currentRoom.getRoomObstacle();    //the program searches the current room to find any obstacles and sets it to the obstacle variabel obstacle
    if ((obstacle != null) && (item != null) && (item.getAbilityI().equals(obstacle.getAbilityO()))) { 
      //if statement checks to make sure that obstacle and item are valid inputs and that the ability of the item and the ability required by the obstacle are the same
      player.delete(item);
      currentRoom.removeObstacle(obstacle);
      System.out.println("\n" + "You have used " + item.getNameI() + " to overcome " + obstacle.getNameO() + "\n");
      System.out.println("\n" + item.getNameI() + " has been removed from your inventory. ");
    }
    else{
      System.out.println("Nothing Happened");
    }
  }
  //this method will drop the desired item as long as it is valid, removes from the player inventory and adds to the current room
  private void dropItem(Command command) {
    if (command.getSecondWord() != null){
    player.drop(command.getSecondWord(), currentRoom);
      }
    else{
      System.out.println("Nothing Happened");
    }
  }
  //adds the item to the player inventory array list and removes from the current room array list if it is a valid input
  private void obtainItem(Command command) {
    if (!command.hasSecondWord()) {
      // if there is no second word, we don't know where to go...
      System.out.println("Please specify the item you would like to pick up");
      return;
    }
    Item item = currentRoom.getRoomItem(command.getSecondWord());
    if (item != null) {
      currentRoom.removeItem(item);
      player.obtain(item);
    }
    else{
      System.out.println("I can't find that item in this room");
    }
  }
  //prints out command words
  private void printHelp() {
    System.out.println();
    System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
    System.out.println("Your command words are:");
    parser.showCommands();
    System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
  }

  /**
   * Try to in to one direction. If there is an exit, enter the new room,
   * otherwise print an error message.
   */
  private void goRoom(Command command) {
    if (!command.hasSecondWord()) {
      // if there is no second word, we don't know where to go...
      System.out.println("Go where?");
      return;
    }

    String direction = command.getSecondWord();

    // Try to leave current room.
    Room nextRoom = currentRoom.getExit(direction);

    if (nextRoom == null) {
      System.out.println("There is no door!");
    } else if (currentRoom.hasObstacle()&&(nextRoom != previousRoom)) {
      System.out.println(
          "There is an obstacle in your way. If you wish to adventure further, find a way to get rid of/overcome the obstacle");
    } else {
      previousRoom = currentRoom; //added previous room so that i could go back if needed
      currentRoom = nextRoom;
      System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
      System.out.println(currentRoom.getNameR());
      System.out.println(currentRoom.getLongDescription());
      System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
    }
    
  }
  //look command checks the current room for items and obstacles 
  private void look(Command command) {
    if (currentRoom.hasItem()) {
      System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
      System.out.println("\n" + "One or more items exist in this room." + "\n" + currentRoom.printRoomItems() + "\n");
      System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
    }
    if (currentRoom.hasObstacle()) {
      System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
      System.out.println("\n" + "There is an obstacle blocking your path." + "\n" + currentRoom.printRoomObstacles() + "\n");
      System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
    } else {
      System.out.println("No obstacles");
    }
  }

  /**
   * "Quit" was entered. Check the rest of the command to see whether we really
   * quit the game.
   * 
   * @return true, if this command quits the game, false otherwise.
   */
  private boolean quit(Command command) {
    if (command.hasSecondWord()) {
      System.out.println("Quit what?");
      return false;
    } else {
      return true; // signal that we want to quit
    }
  }
  
  //checks if current room is royal arena
  private boolean win(){
    if (currentRoom.getShortDescription().equals(winCondition)){
      return true;
    }
    else{
      return false;
    }
  }
}
