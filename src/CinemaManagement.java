import java.util.Scanner;

public class CinemaManagement {

    static int[][] seats = new int[3][16];

    static Scanner scanner = new Scanner(System.in);

    public static void main (String args[]){

        System.out.println("Welcome to the London Lumiere");
        availableSeats();

        System.out.println();

        while (true){
            System.out.println("-------------------------------------------------");
            System.out.println("Please select an option: ");
            System.out.println("\t1) Buy a ticket ");
            System.out.println("\t2) Cancel ticket ");
            System.out.println("\t3) See seating plan ");
            System.out.println("\t4) Find first seat available ");
            System.out.println("\t5) Print tickets information and total price ");
            System.out.println("\t6) Search ticket ");
            System.out.println("\t7) Sort tickets by price ");
            System.out.println("\t8) Exit ");
            System.out.println("-------------------------------------------------");

            System.out.print("Select option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    buy_tickets();
                    break;

                case 2:
                    cancel_tickets();
                    break;

                case 3:
                    print_seating_area();
                    break;

                case 4:
                    find_first_available();
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }

    public static void availableSeats (){
        for (int i = 0; i < seats.length; i++){
            for (int j = 0; j < seats[i].length; j++){
                if (j == 8){

                }
                else {
                    seats[i][j] = 0;
                }
            }
        }
    }

    public static void buy_tickets (){
        System.out.print("Enter row number: ");
        int rowNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter seat number: ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine();

        if (rowNumber <= 3 && seatNumber <= 16){
            System.out.println("Row number " + rowNumber + ", Seat Number "+ seatNumber + " is valid.");
            if (seats[rowNumber - 1][seatNumber - 1] == 0){
                System.out.println("The seat has been booked. For row number " + rowNumber + ", Seat Number "+ seatNumber);
                seats[rowNumber - 1][seatNumber - 1] = 1;
            }
            else{
                System.out.println("But unfortunately, the seat is not available.");
            }
        }
        else {
            System.out.println("Row number " + rowNumber + ", Seat Number "+ seatNumber + " is not valid.");
        }
    }

    public static void cancel_tickets (){
        System.out.print("Enter row number: ");
        int rowNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter seat number: ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine();

        if (rowNumber <= 3 && seatNumber <= 16){
            System.out.println("Row number " + rowNumber + ", Seat Number "+ seatNumber + " is valid.");
            if (seats[rowNumber - 1][seatNumber - 1] == 1){
                System.out.println("The seat has been cancelled. For row number " + rowNumber + ", Seat Number "+ seatNumber);
                seats[rowNumber - 1][seatNumber - 1] = 0;
            }
            else{
                System.out.println("This seat is already available.");
            }
        }
        else {
            System.out.println("Row number " + rowNumber + ", Seat Number "+ seatNumber + " is not valid.");
        }
    }

    public static void print_seating_area (){
        System.out.println("*********************************");
        System.out.println("*             SCREEN            *");
        System.out.println("*********************************");
        System.out.println();

        for (int i = 0; i < seats.length; i++){
            for (int j = 0; j < seats[i].length; j++){
                if (seats[i][j] == 0){
                    if (j == 8){
                        System.out.print("  O ");
                    }
                    else {
                        System.out.print("O ");
                    }
                }
                else {
                    if (j == 8){
                        System.out.print("  X ");
                    }
                    else {
                        System.out.print("X ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void find_first_available (){

        for (int i = 0; i < seats.length; i++){
            for (int j = 0; j < seats[i].length; j++){
                if (seats[i][j] == 0){
                    System.out.println("The first available seat is at row number " + (i+1) +", seat number " + (j+1));
                    return;
                }
            }
        }
    }
}
