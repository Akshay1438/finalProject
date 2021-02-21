package useCase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;

public class Ticket
{
private int counter=100;
private String  pnr;
private LocalDate date;
private Train train;
private HashMap<Passenger, Double>passengers;
public Ticket(LocalDate date,Train train)
{
	super();
	this.date=date;
	this.train=train;
	
}
public int getCounter() {
	return counter;
}
public void setCounter(int counter) {
	this.counter = counter;
}
public String getPnr() {
	return pnr;
}
public void setPnr(String pnr) {
	this.pnr = pnr;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public Train getTrain() {
	return train;
}
public void setTrain(Train train) {
	this.train = train;
}
public HashMap<Passenger, Double> getPassengers() {
	return passengers;
}
public void setPassengers(HashMap<Passenger, Double> passengers) {
	this.passengers = passengers;
}






@Override
public String toString() {
	return "Ticket [counter=" + counter + ", pnr=" + pnr + ", date=" + date + ", train=" + train + ", passengers="
			+ passengers + "]";
}
public String generatePnr()
{

	String S=String.valueOf(train.getSource().charAt(0));
	String D=String.valueOf(train.getDestination().charAt(0));
	String Date=date.format(DateTimeFormatter.ofPattern("YYYYMMDD"));
	String pnr=S+D+"_"+Date+"_"+counter++;
	
	if((date.isAfter(LocalDate.now())))
	{
		return pnr;
	}
	else
	{
		return "please enter valid date";

		
	}
}
	
	void pnrnumber()
	{
		System.out.println("pnr number is"+generatePnr());
	}







double calcPassengerFare(Passenger passenger)
{
	if(passenger.getAge()<=12)
		return train.getTicketPrice()*0.5;
	else if(passenger.getAge()>=60)
		return train.getTicketPrice()*0.6;
	else if(passenger.getGender()=='f')
		return train.getTicketPrice()*0.75;
	return train.getTicketPrice();
	
}

void addPassenger(Passenger passenger)
{
	passengers=new HashMap<Passenger, Double>();
	passengers.put(new Passenger(passenger.getName(),passenger.getAge(),passenger.getGender()),calcPassengerFare(passenger));
}


//calculate total ticket price
	double calculateTotalTicketPrice()
	{
		int totalPrice=0;
		Collection<Double> price=passengers.values();
		for(Double values:price)
		{
			totalPrice=(int) (totalPrice+values);
		}
		return (double)totalPrice;
	}




StringBuilder generateTicket()
{
	StringBuilder sb=new StringBuilder();
	sb.append("PNR    :"+generatePnr()).append(" "+"travelDate  :"+date).append(" "+"trainNo :"+train.getTrainNo());
    return sb;
    
}
void generatedTicket()
{
	System.out.println("your ticket is generated =" +" "+ generateTicket());
	System.out.println("values "+passengers);
	System.out.println(" total ticket price is"+calculateTotalTicketPrice());
}
}
