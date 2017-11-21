public class Item {

	int weight;
	int profit;

	public Item(int inWeight, int inProfit){
		this.weight = inWeight;
		this.profit = inProfit;
	}

	public void setWeightAndProfit(int inWeight, int inProfit){
		this.weight = inWeight;
		this.profit = inProfit;

	}

	public int getWeight(){
		return this.weight;

	}

	public int getProfit(){
		return this.profit;
	}
}