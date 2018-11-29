import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<TauxFertilite> listeTauxExcel = new ArrayList<TauxFertilite>();

        Excel excel = new Excel();

        listeTauxExcel = excel.getListeTaux();

        for(TauxFertilite taux : listeTauxExcel){
            System.out.println("Annee : "+taux.getId()+" | Taux de fertilité : "+taux.getTaux());
        }
    }
}
