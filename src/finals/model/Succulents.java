package finals.model;

public class Succulents 
{
	private String description; 
	public Succulents()
	{
		description = "succulent, any plant with thick fleshy "
				+ "tissues adapted to water storage"; 
	}

	public void setDescription(String description)
	{
		this.description = description; 
	}
	public String getDescription()
	{
		return description; 
	}
}
