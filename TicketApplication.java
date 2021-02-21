package useCase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Scanner;

public class TicketApplication {

	public static void main(String[] args)
	{
		System.out.println("=========Ticket Application========");
		DateTimeFormatter pattern =DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		TrainDao trainDao=new TrainDao();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the train no");
		int trainNumber=scanner.nextInt();
		
		System.out.println("enter source");
		String source=scanner.next();
		
		System.out.println("enter destination");
		String destination=scanner.next();
		
		System.out.println("enter travel date");
		String travelDate=scanner.next();
		
		
		Train train=trainDao.findTrain(trainNumber);
		System.out.println("train name is "+train.getTrainName()+"train price is"+train.getTicketPrice());
		
		if(train==null)
			System.out.println("train not found");
		
		
		LocalDate date =LocalDate.parse(travelDate, pattern);
		System.out.println("your travel date is "+date);
		
		
		Ticket ticket =new Ticket(date,train);
		//generating pnr number
		ticket.pnrnumber();
		
		System.out.println("enter no of passenger");
		int noOfPassenger=scanner.nextInt();
		
		for(int i=0;i<noOfPassenger;i++)
		{
			System.out.println("enter name :");
			String name=scanner.next();
			
			System.out.println("enter age :");
			int age=scanner.nextInt();
			
			System.out.println("enter gender :");
			char gender=scanner.next().charAt(0);
			
			ticket.addPassenger(new Passenger(name,age,gender));

		}
		ticket.generatedTicket();
		
			
		}
	}


