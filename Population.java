import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;



public class Population{
	private Individual[] population;
	private double populationFitness = -1;

	public Population(int populationSize){
		this.population = new Individual[populationSize];
	}

	public Population(int populationSize, int chromosomeLength){
		this.population = new Individual[populationSize];

		for (int individualCount = 0; individualCount < populationSize -2; individualCount ++){
			Individual individual = new Individual(chromosomeLength);
			this.population[individualCount] = individual;
		}

		Individual allZeros = new Individual(chromosomeLength);
		Individual allOnes = new Individual(chromosomeLength);

		for(int chromosomeIndex = 0; chromosomeIndex < chromosomeLength; chromosomeIndex ++){
			allOnes.setGene(chromosomeIndex, 1);
			allZeros.setGene(chromosomeIndex, 0);
		}

		population[populationSize -1] = allZeros;
		population[populationSize -2] = allOnes;

	}

	public Individual[] getIndividuals(){
		return this.population;
	}

	public Individual getFittest(int offset){
		Arrays.sort(this.population, new Comparator<Individual>(){
			@Override
			public int compare(Individual o1, Individual o2){
				if(o1.getFitness() > o2.getFitness()){
					return -1;
				} else if(o1.getFitness() < o2.getFitness()){
					return 1;
				}
				return 0;
			}
		});

		return this.population[offset];
	}


	public void setPopulationFitness(double fitness){
		this.populationFitness = fitness;
	}

	public double getPopulationFitness(){
		return this.populationFitness;
	}

	public int size(){
		return this. population.length;
	}

	public void setIndividual(int offset, Individual individual){
		population[offset] = individual;
	}

	public Individual getIndividual(int offset){
		return population[offset];
	}

	public void shuffle(){
		Random rnd = new Random();
		for (int i = population.length -1; i > 0; i--){
			int index = rnd.nextInt(i + 1);
			Individual a = population[index];
			population[index] = population[i];
			population[i] = a;
		}
	}


}