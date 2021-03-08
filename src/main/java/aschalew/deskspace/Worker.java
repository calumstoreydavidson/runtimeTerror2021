package aschalew.deskspace;

public class Worker {
    String company;
    String bonusPotential;


    public Worker() {
    }

    public Worker(String company, String bonusPotential) {
        this.company = company;
        this.bonusPotential = bonusPotential;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBonusPotential() {
        return bonusPotential;
    }

    public void setBonusPotential(String bonusPotential) {
        this.bonusPotential = bonusPotential;
    }
}
