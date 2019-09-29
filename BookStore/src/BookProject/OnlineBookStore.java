package BookProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineBookStore {
	public static int ISBN_INDEX = 0;
	public static int TITLE_INDEX = 1;
	public static int AUTHOR_INDEX = 2;
	public static int PUBLISHER_INDEX = 3;
	public static int PUBLISHER_YEAR_INDEX = 4;
	public static int QUANTITY_INDEX = 5;
	public static int PRICE_INDEX = 6;
	
	public static void main(String[] args) {
		ArrayList<Book> bookList = new ArrayList<Book>();
		try {
			FileReader fileReader = new FileReader("books");// Enter the entire path of the file if needed
			BufferedReader bufferedReader = new BufferedReader(fileReader);  
			boolean endOfFile = false;
	        while(!endOfFile){
	        	String bookLine = bufferedReader.readLine();
	        	if (bookLine != null) {
	        		String[] bookData = bookLine.split(", ");
	        		String isbn = bookData[ISBN_INDEX];
	        		String title = bookData[TITLE_INDEX];
	        		String author = bookData[AUTHOR_INDEX];
	        		String publisher = bookData[PUBLISHER_INDEX];
	        		int publishYear = Integer.parseInt (bookData[PUBLISHER_YEAR_INDEX]);
	        		int quantity = Integer.parseInt (bookData[QUANTITY_INDEX]);
	        		double price = Double.parseDouble (bookData[PRICE_INDEX]);
	        		Book book = new Book(isbn, title, author, publisher, publishYear, quantity, price);
	        		bookList.add(book);

	        	} else {
	        		endOfFile = true;
	        	}
	        }
	        
	        bufferedReader.close();    
	        fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		printBookDetails(bookList);
		
		purchaseBook(bookList);
	}
	public static void printBookDetails(ArrayList<Book>bookList){
		for(int index = 0; index < bookList.size(); index++)
		{
			Book bookDetails = bookList.get(index);
			System.out.println(index + " - "+bookDetails.toString());
		}
	}
	public static Book getBook(ArrayList<Book>bookList, String title){
		boolean found = false;
		int index = 0;
		Book member = null;
		
		while(!found && index < bookList.size())
		{
			member = bookList.get(index);
			if(title.equals(member))
			{
				return bookList.get(index);
			}
			else
			{
				index++;
			}
		}
		return null;
	}
	public static void topUpCard(ChargeCard card, double amount){
		card.topUpFunds(amount);
	}
	public static void purchaseBook(ArrayList<Book>booksList){
		try{
			System.out.println("Enter the funds in your card > ");
			Scanner fundInput = new Scanner(System.in);
			if (fundInput.hasNextDouble()&&fundInput.nextDouble()>0){
				Double customerAmount = fundInput.nextDouble();
				ChargeCard customerCard = new ChargeCard();
				topUpCard(customerCard, customerAmount);
				fundInput.close();
				boolean quit = false;
				while (!quit){
					System.out.println("Enter a book title you would like to purchase (or else type in quit) > ");
					Scanner bookInput = new Scanner(System.in);
					String customerTitle = bookInput.nextLine();
					if (customerTitle=="quit"){
						quit = true;
					}
					else
					{
						Book requestedBook = getBook(booksList, customerTitle);
						if (requestedBook == null || requestedBook.getQuantity()==0){
							System.out.println("We have no book by the title "+requestedBook.getTitle()+".");
						}
						else{
							System.out.println("This book is €"+requestedBook.getPrice());
							if (requestedBook.getPrice()>=customerCard.getFunds()){
								System.out.println("Unfortunately, you do not have enough funds to complete this purchase.");
							}
							else{
								customerCard.removeFunds(requestedBook.getPrice());
								requestedBook.setQuantity(requestedBook.getQuantity()-1);
								booksList.remove(getBook(booksList, customerTitle));
								booksList.add(requestedBook);
								System.out.println("Congrats! You have just purchased "+requestedBook.getTitle()+"!");
							}
						}
					}
				}
			}
			else 
			{
				System.out.println("Invalid Input.");
			}
		}catch (Exception e){
			System.out.println(e);
		}
		System.out.println("Success");
	}
}
