import java.util.ArrayList;

public class Items{

	private ArrayList<Item> items;

	public Items(String inFile){
		//create a new file reader
		ReadFile fileReader = new ReadFile(inFile);
		//Read file, open file, create array, close file
		fileReader.readOpenCloseFile();
		//set Items
		this.items = fileReader.getItems();
	}


	public ArrayList<Item> getItemsArray(){

		return this.items;
	}

	public int getItemsSize(){

		return this.items.size();
	}

	public Item getItem(int index){
		return items.get(index);
	}
	

}