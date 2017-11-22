import java.io.*;
import java.util.*;

public class test{

	private static Scanner in;
	private static ArrayList<Item> items = new ArrayList<Item>();

	public static void main(String args[]){

		try{
			in = new Scanner(new File("Items.txt.txt"));
		}catch(Exception e){
				System.out.println("FILE NOT FOUND!");
		}

		while(in.hasNext()){

				String weight = in.next();
				String profit = in.next();

				System.out.println(weight + profit);
		
		}

		in.close();

	}

}