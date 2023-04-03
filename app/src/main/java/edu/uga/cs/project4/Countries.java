package edu.uga.cs.project4;

public class Countries {

    private long id;
    private String country;
    private String continent;

    public Countries() {
        this.id = -1;
        this.country = null;
        this.continent = null;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setId( long id ) {
        this.id = id;
    }

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
