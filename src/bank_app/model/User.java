package bank_app.model;

public class User {
    private String name;
    private Double capital;

    public User(String name, Double capital) {
        this.name = name;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCapital() {
        return capital;
    }

    public void setCapital(Double capital) {
        if(capital>0){
            this.capital = capital;
        }
        }
    }

