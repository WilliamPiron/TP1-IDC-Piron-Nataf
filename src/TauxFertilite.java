public class TauxFertilite {
    private int id;
    private float taux;

    public TauxFertilite(int id, float taux){
        this.id = id;
        this.taux = taux;
    }

    public int getId(){
        return this.id;
    }

    public float getTaux() {
        return taux;
    }
}
