package urls;

public enum urlss {
	
	baseUrl("https://reqres.in/"),
	createpostapi("api/users"),
	retrievegetapi("api/users?page="),
	validateunknownapi("api/unknown");
	
	private String endpoint;
	urlss(String endpoint)
	{
		this.endpoint=endpoint;
	}
	
	public String endpoint()
	{
		return endpoint;
	}

}
