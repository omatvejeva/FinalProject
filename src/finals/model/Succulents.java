package finals.model;

public class Succulents 
{
	// instance variables 
	private String description; 
	
	/*
	 * constructor for succulent + make description 
	 */
	public Succulents()
	{
		description = "succulent, any plant with thick fleshy "
				+ "tissues adapted to water storage"; 
	}

	/*
	 * sets up description
	 * i don't know what to say 
	 */
	public void setDescription(String description)
	{
		this.description = description; 
	}
	/*
	 * string method 
	 */
	public String getDescription()
	{
		return description; 
	}
}
