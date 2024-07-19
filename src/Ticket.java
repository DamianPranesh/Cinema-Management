public class Ticket {

    //Attributes
    private int row;
    private int seat;
    private double price;
    private Person person;

    //Constructor
    public Ticket (int row, int seat, double price, Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    //Getters and Setters
    public int getRow (){
        return row;
    }

    public void setRow (int row){
        this.row = row;
    }

    public int getSeat (){
        return seat;
    }

    public void setSeat (int seat){
        this.seat = seat;
    }

    public double getPrice (){
        return price;
    }

    public void setPrice (double price){
        this.price = price;
    }

    public Person getPerson (){
        return person;
    }

    public void setPerson (Person person){
        this.person = person;
    }

    public String printTicketInformation (){
        return "Ticket [Row: " + row + ", Seat: " + seat + ", Price: " + price + ", Person: " + person + "]";
    }
}
