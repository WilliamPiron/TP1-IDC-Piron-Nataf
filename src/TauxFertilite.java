public class TauxFertilite {
    private int id;
    private double taux;

    public TauxFertilite(int id, double taux){
        this.id = id;
        this.taux = taux;
    }

    public int getId(){
        return this.id;
    }

    public double getTaux() {
        return taux;
    }
}
