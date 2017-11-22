import java.util.ArrayList;

public class KnapsackGA{


	public static void main(String[] args){

		//create new Items array from file
		Items items = new Items("Items.txt.txt");
		//create GA Object
		GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.95, 0.1, 3, items, 10);
		//initialise a population
		Population population = ga.initPopulation(items.getItemsSize());


		//evaluate the population initially
		ga.evalPopulation(population);
		//start  generation counter
		int generation = 1;



		//main loop
		while(generation < 1000){
			//print the fittest solution so far 
			System.out.println("Best solution: " + population.getFittest(0).toString());
			System.out.println("Best solution Profit: " + population.getFittest(0).getFitness());


			//Apply crossover
			population = ga.crossoverPopulation(population);

			//Apply mutations
			population = ga.mutatePopulation(population);

			//Evaluate population 
			ga.evalPopulation(population);


			generation ++;

		}

		
		System.out.println("Found solution in " + generation + " generations");
		Individual fittest = population.getFittest(0);
		System.out.println("Best solutinon: " + fittest.toString());
		System.out.println("Profit: " + fittest.getFitness());




	}
}