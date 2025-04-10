import java.util.ArrayList;
public class TicketCreator
{
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

    private static String createCustomerName()
    {
        
    }
}
