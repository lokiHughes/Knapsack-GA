public class AllOnesGA{

	public static void main(String[] args){
		//create GA Object
		GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.95, 2);
		//initialise a population
		Population population = ga.initPopulation(50);

		//evaluate the population initially
		ga.evalPopulation(population);
		//start  generation counter
		int generation = 1;

		//main loop
		while(ga.isTerminationConditionMet(population) == false){
			//print the fittest solution so far 
			System.out.println("Best solution: " + population.getFittest(0).toString());

			//Apply crossover
			population = ga.crossoverPopulation(population);

			//Apply mutations
			population = ga.mutatePopulation(population);

			//Evaluate population 
			ga.evalPopulation(population);

			generation ++;

		}

		System.out.println("Found solution in " + generation + " generations");
		System.out.println("Best solutinon: " + population.getFittest(0).toString());


	}
}