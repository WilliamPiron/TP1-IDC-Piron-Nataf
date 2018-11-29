import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        double displayvalue;
        int year1, year2;
        String pathToExcel = "";

        ArrayList<TauxFertilite> listeTaux = new ArrayList<TauxFertilite>();

        //Excel excel = new Excel(pathToExcel);

        listeTaux = new Excel(pathToExcel).getListeTaux();
        listeTaux.add(new TauxFertilite(2007, new XML().parseXML()));

        //Taux 1995 - Taux 1985
        displayvalue = listeTaux.get(2).getTaux() - listeTaux.get(0).getTaux();
        year1 = listeTaux.get(2).getId();
        year2 = listeTaux.get(0).getId();
        System.out.println("Annees "+year2+"-"+year1+" | Difference de taux : "+displayvalue);
        //Taux 2000 - Taux 1990
        displayvalue = listeTaux.get(4).getTaux() - listeTaux.get(1).getTaux();
        year1 = listeTaux.get(4).getId();
        year2 = listeTaux.get(1).getId();
        System.out.println("Annees "+year2+"-"+year1+" | Difference de taux : "+displayvalue);
        //Taux 2007 - Taux 1997
        displayvalue = listeTaux.get(5).getTaux() - listeTaux.get(3).getTaux();
        year1 = listeTaux.get(5).getId();
        year2 = listeTaux.get(3).getId();
        System.out.println("Annees "+year2+"-"+year1+" | Difference de taux : "+displayvalue);
    }
}
