import java.util.Scanner;

public class CinemaManagement {

    static int[][] seats = new int[3][16];

    static Scanner scanner = new Scanner(System.in);
    static Ticket[] tickets = new Ticket[48];
    static int ticketCounter = 0;

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
                    print_tickets_info();
                    break;

                case 6:
                    search_ticket();
                    break;

                case 7:
                    sort_tickets();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid integer. Please try again!");
                    break;
            }
        }
    }

    public static void availableSeats (){
        for (int i = 0; i < seats.length; i++){
            for (int j = 0; j < seats[i].length; j++){
                seats[i][j] = 0;
            }
        }
    }

    public static void buy_tickets (){
        System.out.print("Enter first name: ");
        String name = scanner.nextLine();
        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
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

                double price;

                switch (rowNumber){
                    case 1:
                        price = 12.0;
                        System.out.println("The ticket price is £" + price + ".");
                        break;

                    case 2:
                        price = 10.0;
                        System.out.println("The ticket price is £" + price + ".");
                        break;

                    case 3:
                        price = 8.0;
                        System.out.println("The ticket price is £" + price + ".");
                        break;

                    default:
                        price = 0.0;
                        System.out.println("The ticket price is £" + price + ".");
                        break;
                }

                //Creating Objects
                Person person = new Person(name, surname, email);
                Ticket ticket = new Ticket(rowNumber, seatNumber, price, person);

                tickets[ticketCounter] = ticket;
                ticketCounter++;

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

                // Shift all subsequent tickets one position to the left
                for (int i = 0; i < tickets.length; i++){
                    if (tickets[i].getRow() == rowNumber && tickets[i].getSeat() == seatNumber){

                        //Moving every other element to the left
                        for (int j = i; j < tickets.length - 1; j++){
                            tickets[j] = tickets[j+1];
                        }
                        tickets[ticketCounter - 1] = null;
                        ticketCounter--;
                        break;
                    }
                }
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

    public static void print_tickets_info (){
        double totalPrice = 0;
        for (int i = 0; i < ticketCounter; i++){
            System.out.println(tickets[i].printTicketInformation());
            totalPrice += tickets[i].getPrice();
        }
        System.out.println("The total price of all tickets is £" + totalPrice + ".");
    }

    public static void search_ticket (){
        System.out.print("Enter row number: ");
        int rowNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter seat number: ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < ticketCounter; i++){
            if (tickets[i].getRow() == rowNumber && tickets[i].getSeat() == seatNumber){
                System.out.println("Ticket found: " + tickets[i].printTicketInformation());
                return;
            }
        }
        System.out.println("The seat is available.");
    }

    public static void sort_tickets (){
        for (int i = 0; i < ticketCounter - 1; i++) {
            for (int j = 0; j < ticketCounter - i - 1; j++) {
                if (tickets[j].getPrice() > tickets[j + 1].getPrice()) {
                    Ticket temp = tickets[j];
                    tickets[j] = tickets[j + 1];
                    tickets[j + 1] = temp;
                }
            }
        }
        System.out.println("Tickets sorted by price.");
        for (int i = 0; i < ticketCounter; i++) {
            System.out.println(tickets[i].printTicketInformation());
        }
    }
}
