package edu.uga.cs.project4;

/**
 * POJO for Country
 */
public class Country {

    //Variables for country.
    private long id;
    private String country;
    private String continent;

    //Empty Constructor
    public Country() {
        this.id = -1;
        this.country = null;
        this.continent = null;
    }

    //Constructor
    public Country(String country, String continent){
        this.id = id;
        this.country = country;
        this.continent = continent;
    }


    //Setters
    public void setCountry(String country) {
        this.country = country;
    }
    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setId( long id ) {
        this.id = id;
    }

    //Getters
    public String getCountry() {
        return country;
    }
    public String getContinent() {
        return continent;
    }

    public long getId(){
        return id;
    }
}
