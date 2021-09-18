package classes;

public class Product {
    
    private String id;
    private String name;
    private String artist;
    private String gender;
    private int year;
    private double cost;
    
    public Product(String id, String name, String artist, String gender, int year, double cost) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.gender = gender;
        this.year = year;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product [artist=" + artist + ", cost=" + cost + ", gender=" + gender + ", id=" + id + ", name=" + name
                + ", year=" + year + "]";
    }

}
