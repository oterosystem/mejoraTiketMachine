/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    //billete premiado
    private boolean premio;
    //numero billetes
    private int numeroBillete;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost, boolean billetePremio, int numBillete )
    {
        price = cost;
        balance = 0;
        total = 0;
        premio = billetePremio;
        numeroBillete = 5 * cost;

    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if (numeroBillete > total){
            if (amount > 0) {   
                balance = balance + amount;
            }
            else {
                System.out.println("Use a positive amount rather than: " +
                    amount);

            }
        }
            else {
                System.out.println("vendidos todos los billetes");
            }
        
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();
            if(premio ==true)
            {
                System.out.println("#****************#");
                System.out.println("tiket premiado");
                System.out.println("#****************#");
            }
            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
        }
        else {
            System.out.println("You must insert at least: " +
                (price - balance) + " more cents.");

        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }

    /**
     * vacia la maquina si no hay operaciones
     */

    public int emptyMachine()    
    { 
        int devolucionTotalDinero;
        if(balance == 0){

            devolucionTotalDinero = total;
            total = 0;
        }
        else
        {
            System.out.println("WARRNING�� No se puede vacear");
            devolucionTotalDinero = -1;
        }
        return devolucionTotalDinero;
    }

    /**
     * 
     */
}
