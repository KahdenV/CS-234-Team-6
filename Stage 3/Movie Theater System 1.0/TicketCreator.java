import java.util.ArrayList;
import java.util.Scanner;
public class TicketCreator
{
    public static Scanner ticketScanner = new Scanner(System.in);


    private static String createTicketID(ArrayList<Ticket> tickets_list)
    {
        ArrayList<Integer> temp_ListOfIDs = new ArrayList<>();
        for (int counter = 0; counter < tickets_list.size(); counter++)
        {
            temp_ListOfIDs.add(tickets_list(counter).getTicketID);
        }

        int ticketID = Integer.parseInt(tickets_list[tickets_list.size()-1])+1;
        while (temp_ListOfIDs.contains(ticketID) == true)
        {
            ticketID++;
        }
        return ticketID;
    }


    private static String createCustomer(String customerID, ArrayList<Customer> customers)
    {
        Customer ticketCustomer;
        for (int counter = 0; counter < customers.size(); counter++)
        {
            if (customerID == customers(counter).getCustomerId())
            {
                ticketCustomer = customers(counter);
            }
        }

        return ticketCustomer;
    }


    private static Showtime createTicketShowtime(ArrayList<Movie> movies, ArrayList<Showtime> showtimes)
    {
        // this showtime is used whenever the user wants to exit the ticket booking process entirely
        Showtime nullShowtime;

        Showtime desiredShowtime;

        System.out.printf("Enter movie title to book (please be case-sensitive!): ");
        String desiredTitle = ticketScanner.nextLine();
        
        ArrayList<String> movieTitlesList = addAll(movies.getMovieTitle());
        if (movieTitlesList.contains(desiredTitle) != false)
        {
            System.out.println("Movie " + desiredTitle + " does not exist!\n 1) Start over\n2) Exit\nInput answer: ");

            if (ticketScanner.nextInt() == 2)
            {
                return nullShowtime;
            }

            else
            {
                createTicketShowtime(movies, showtimes);
            }
        }

        System.out.printf("Would you like a list of showing times for that particular movie?\n 1) Yes\n 2) No\n Input Answer: ");
        if (ticketScanner.nextInt() == 1)
        {
            for (int counter = 0; counter < showtimes.size(); counter++)
            {
                if (showtimes(counter).getShownMovie() == desiredTitle)
                {
                    System.out.println(showtimes(counter).getTime());
                }
            }
        }

        System.out.printf("Enter movie showtime to book: ");
        String desiredTime = ticketScanner.nextLine();
        for (int counter = 0; counter<showtimes.size(); counter++)
        {
            if (showtimes(counter).getShownMovie() == desiredTitle && showtimes(counter).getTime == desiredTime)
            {
                desiredShowtime = showtimes(counter);
                break;
            }

            else if (counter+1 == showtimes.size())
            {
                System.out.printf("Desired showtime does not exist!\n1) Start over\n2) Exit");
                if (scanner.nextInt() == 2)
                {
                    return nullShowtime;
                }
                else
                {
                    createTicketShowtime(movies, showtimes);
                }
            }
        }

        return desiredShowtime;
    }


    public static double createTicketPrice()
    {
        double ticketPrice = 10.78;
        System.out.printf("Are you a senior, veteran, or minor?:\n1) Yes\n2) No\nInput Answer: ");
        if (ticketScanner.nextInt() == 1)
        {
            ticketPrice = ticketPrice-3.00;
        }
        System.out.printf("Is it matinee day?\n1) Yes\n2) No\nInput Answer: ");
        if (ticketScanner.nextInt() == 1)
        {
            ticketPrice = ticketPrice/2.00;
        }
        return ticketPrice;
    }

    public static String createTicketStatus()
    {
        return "Booked";
    }
}
