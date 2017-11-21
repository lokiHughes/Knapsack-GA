import java.io.*;
import java.util.*;

public class ReadFile{

	private Scanner scanner;
	private ArrayList<Item> items = new ArrayList<Item>();
	private String file;

	public ReadFile(String inFile){
		this.file = inFile;
	}

	public void openFile(){

		try{
			scanner = new Scanner(new File(file));
		}catch(Exception e){
			System.out.println("FILE NOT FOUND!");
		}

	}

	public void createItemArray(){
		while(scanner.hasNext()){

			try{

				int weight = Integer.parseInt(scanner.next());
				int profit = Integer.parseInt(scanner.next());
				Item item = new Item(weight,profit);
				items.add(item);

			}catch(NumberFormatException e){
				System.out.println("Not a number");
			}
	
		}

	}

	public void closeFile(){
		scanner.close();
	}

	public void readOpenCloseFile() {
		openFile();
		createItemArray();
		closeFile();

	}

	public ArrayList<Item> getItems(){
		return items;

	}

}