public class Individual{
	private int[] chromosome;
	private double fitness = -1;
	private int weight = 0;
	private int profit  = 0;

	public Individual(int[] chromosome){
		//create individual chromosome
		this.chromosome = chromosome;

	}

	public Individual(int chromosomeLength){
		//creates a random set of genes given a chromosomeLength
		this.chromosome = new int[chromosomeLength];
		for (int gene = 0; gene < chromosomeLength; gene++){
			if(Math.random() > 0.5){
				this.setGene(gene,1);
			} else {
				this.setGene(gene,0);
			}
		}
	}

	public int[] getChromosome(){
		return this.chromosome;
	}

	public int getChromosomeLength(){
		return this.chromosome.length;
	}

	public void setGene(int offset, int gene){
		this.chromosome[offset]  = gene;
	}

	public int getGene(int offset){
		return this.chromosome[offset];
	}

	public void setFitness(double fitness){
		this.fitness = fitness;
	}

	public double getFitness(){
		return this.fitness;
	}

	public String toString(){
		String output = "";
		for (int gene = 0; gene < this.chromosome.length; gene++){
			output += this.chromosome[gene];
		}
		return output;
	}
}