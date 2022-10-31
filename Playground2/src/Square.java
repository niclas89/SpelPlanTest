public class Square {
    private Ship ship ;
    private String name;
    private boolean occupied;
    private boolean hit;


    Square(String name){
        this.name = name;
        occupied = false;
        hit = false;

    }

    public String getName(){
        return this.name;
    }
    public boolean isOccupied(){
        return this.occupied;
    }

    public void addShip(Ship ship){
        this.ship = ship;
        this.occupied = true;

    }

    public String hit(){
        String feedback;
       if(ship != null) {
           ship.hit();
           feedback = "H";
           if(ship.isSunk()){
               feedback=  "S";
           }

       }else feedback = "M";

       return feedback;
    }


}
