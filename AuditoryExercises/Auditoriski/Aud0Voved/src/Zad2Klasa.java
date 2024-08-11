public class Zad2Klasa {

    static class Bicycle{

        public int gear;
        public int speed;

        public Bicycle(int gear, int speed) {
            this.gear = gear;
            this.speed = speed;
        }

        public void applyBrake(int brake){ //koci
            speed-=brake; //od brzinata namali
        }

        public void speedUp(int increment){
            speed+=increment; //zgolemi ja brzinata
         }

        @Override
        public String toString() {
            return ("Number of gears are " + gear + "\n" + "Speed of bicycle is " + speed );
        }
    }

    //derived class - Nasleduvame
    static class MountainBike extends   Bicycle{

        public int seatHeight;

        public MountainBike(int gear, int speed, int seatHeight) {
            super(gear, speed); //pristap do konstruktor od klasata od koja nasleduvame
            this.seatHeight = seatHeight;
        }

        public void setSeatHeight(int newValue){
            seatHeight = newValue;
        }

        @Override
        public String toString() {
            //so super. imame pristap do metodite
            //override na toString metodot so super.
            return (super.toString() + "\nSeat height is " + seatHeight);
        }
    }

    public static void main(String[] args) {

        Bicycle bicycle = new Bicycle(2,5);
        System.out.println(bicycle);
        MountainBike mountainBike = new MountainBike(4,7,2);
        System.out.println(mountainBike);

    }

}

//preku toString metodot printame na output