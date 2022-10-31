import java.util.ArrayList;
import java.util.LinkedList;

public class GameBoard {
    //properties
    ArrayList<Square> squareGrid = new ArrayList<>();
    String[] xAxis = {"A", "B", "C", "D", "E", "F", "G", "H", "J"};
    ArrayList<Ship> fleet = new ArrayList<>();

    GameBoard() {


    }
    // skapar Square objekt och populerar ArrayList squareGrid
    // för varje Bokstav på xAxis skapas det 10st squares på y-axis
    public void buildBoard() {
        for (int i = 0; i < xAxis.length; i++) {
            squareGrid.add(new Square(xAxis[i] + 0));
            for (int j = 1; j < 10; j++) {
                squareGrid.add(new Square(xAxis[i] + j));
            }
        }

    }
    // metod för som tar emot en int för rad och String för colum , skjuter därefter på motsvarande Square på planen.
    public String fire(int row, String colum){
        String feedback = "";
        for(Square square: squareGrid){
             if(square.getName().equals(colum+row)){
               feedback = square.hit();
               break;
            }
        }
        return  feedback;
    }

    public void printBoard() {

        for (Square square : squareGrid) {
            System.out.println(square.getName());
        }
    }
     // tillfällig metod för att testa att lägga ut skepp .
    public void placeShip(int row, String colum  , Ship ship){
        for(int i = 0; i<ship.getLength(); i++){
            for(Square square: squareGrid) {
                if (square.getName().equalsIgnoreCase(colum + row)) {

                    square.addShip(ship);
                    System.out.println("Ship placed at" + square.getName());
                }
            }
             row++;
        }
    }
    // metod för att bygga en flotta, tar emot 4st int values för att bestämma antal av varje skeep
    // ropar därefter på addShip för varje typ av skepp.
    public void buildFleet(int carrier, int battleship, int cruiser, int submarine) {
        addShip("Carrier",carrier);
        addShip("BattleShip",battleship);
        addShip("Cruiser",cruiser);
        addShip("Submarine",submarine);
    }

    // Metod som tar emot en sträng för att kunna välja vilka typ av skepp den skall bygga,
    public Ship buildShip(String type){
         Ship ship;
        switch(type){
            case "Carrier":
                ship = new Carrier();
                break;
            case "BattleShip":
                ship = new BattleShip();
                break;
            case "Cruiser":
                ship = new Cruiser();
                break;
            default:
              ship = new Submarine();
        }
        return ship;
    }
    // metod som lägger till skepp i fleet ArrayList
    // den tar emot en string för att avgöra vilken typ av skepp och en int för att avgöra antal.
    public void addShip(String type, int numberOfShips){
        for(int i = 0; i<numberOfShips; i++) {
            fleet.add(buildShip(type));
        }

    }

    public void printFleet(){
       for(Ship ship: fleet){
           System.out.println(ship.getType() + " " + ship.lenght);
       }
    }





}
