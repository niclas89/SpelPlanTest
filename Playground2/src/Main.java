import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

      GameBoard test = new GameBoard();

      test.buildBoard();
      test.buildFleet(1,2,3,4);
      test.placeShip(4,"B",test.fleet.get(0));
        System.out.println(test.fire(4,"B"));
        System.out.println(test.fire(5,"B"));
        System.out.println(test.fire(6,"B"));
        System.out.println(test.fire(7,"B"));
        System.out.println(test.fire(8,"B"));

      //test.printBoard();
      //test.printFleet();

      /*
        boolean invalidInput = true;
        Scanner scan = new Scanner(System.in);
        Connection connection = new Connection();
        while(invalidInput) {
            System.out.println("skriv 1 för att hosta eller 2 för att leta efter host");

            switch (scan.nextLine()) {
                case "1":
                    connection.newServer();
                    invalidInput = false;
                    break;
                case "2":
                    connection.connectToServer();
                    invalidInput = false;
                    break;
            }
        }
        if(connection.isConnected()){
            System.out.println(connection.reciveMessage());
        }

        while(true){
            connection.sendMessage(scan.nextLine());
            System.out.println(connection.reciveMessage());


        }
      */
     }

}