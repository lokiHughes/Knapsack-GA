import java.util.ArrayList;

public class GeneticAlgorithm{
	private int populationSize;
	private double mutationRate;
	private double crossoverRate;
	private int elitismCount;
	private Items items;
	private int maxWeight;

	public GeneticAlgorithm(int populationSize, double mutationRate, double crossoverRate, int elitismCount, Items items, int maxWeight){
		this.populationSize = populationSize;
		this.mutationRate = mutationRate;
		this.crossoverRate = crossoverRate;
		this.elitismCount = elitismCount;
		this.items = items;
		this.maxWeight = maxWeight;
	}

	public Population initPopulation(int chromosomeLength){
		Population population = new Population(this.populationSize, chromosomeLength);
		return population;
	}


	public void calcFitness(Individual individual){

		int profit = 0;
		int weight = 0;


		for( int geneIndex = 0; geneIndex < individual.getChromosomeLength(); geneIndex ++){

			profit += items.getItem(geneIndex).getProfit();
			weight += items.getItem(geneIndex).getWeight();

			if(weight > this.maxWeight){
				profit = -1;
			}
		}

		individual.setFitness(profit);

	}

	public void evalPopulation(Population population){

		for(Individual individual: population.getIndividuals()){
			calcFitness(individual);
		}

	}

	public boolean isTerminationConditionMet(Population population){
		for (Individual individual : population.getIndividuals()){
			if (individual.getFitness() == 1){
				return true;
			}
		}
		return false;
	}

	public Individual selectParent(Population population){

		//retrieve the individuals
		Individual individuals[] = population.getIndividuals();

		//implimentation of roulette wheel selection 
		double populationFitness = population.getPopulationFitness();
		double rouletteWheelPosition = Math.random() * populationFitness;

		//find parent
		double spinWheel = 0;
		for (Individual individual : individuals){
			spinWheel += individual.getFitness();
			if (spinWheel >= rouletteWheelPosition){
				return individual;
				}
			}
		return individuals[population.size()-1];

	}

	public Population crossoverPopulation(Population population){
		//create new population 
		Population newPopulation = new Population(population.size());

		//loop over current population by fitness
		for (int populationIndex = 0; populationIndex < population.size(); populationIndex++){
			Individual parent1 = population.getFittest(populationIndex);

			//Apply crossover on individual??
			if(this.crossoverRate > Math.random() && populationIndex >= this.elitismCount){
				//Initialise an offspring
				Individual offspring = new Individual(parent1.getChromosomeLength());


				//find second parent
				Individual parent2 = selectParent(population);

				//loop over geneome
				for (int geneIndex = 0; geneIndex < parent1.getChromosomeLength(); geneIndex ++){
					//use half of parent2's genes and half parent 1's genes
					if(Math.random() > 0.5){
						offspring.setGene(geneIndex, parent1.getGene(geneIndex));
					} else {
						offspring.setGene(geneIndex, parent2.getGene(geneIndex));
					}
				}

				//add offspring to the new population 
				newPopulation.setIndividual(populationIndex, offspring);

			} else {
				//Add individual without applying crossover
				newPopulation.setIndividual(populationIndex, parent1);
			}
		}

		return newPopulation;

	}

	public Population mutatePopulation(Population population){
		//initisalise new population
		Population newPopulation = new Population(this.populationSize);

		//loop over current population by fitness
		for (int populationIndex = 0; populationIndex < populationSize; populationIndex ++){
			Individual individual = population.getFittest(populationIndex);

			//loop over individual's genes
			for (int geneIndex = 0; geneIndex < individual.getChromosomeLength(); geneIndex ++){
				//skip if ellite individual 
				if(populationIndex >= this.elitismCount){
					//mutate?
					if (this.mutationRate > Math.random()){
						//get new gene
						int newGene = 1;

						if (individual.getGene(geneIndex) ==1){
							newGene = 0;
						} 
						//mutate gene 
						individual.setGene(geneIndex, newGene);
					}
				}
			}

			//Add individual to the population 
			newPopulation.setIndividual(populationIndex,individual);
		}

		//return new population 
		return newPopulation;

	}

}
	
