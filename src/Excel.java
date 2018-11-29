import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Excel {

    private ArrayList<TauxFertilite> listeTaux;

    public Excel(){
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        Number number;
        double tmp;
        Fillo fillo = new Fillo();
        listeTaux = new ArrayList<TauxFertilite>();
        try {
            System.setProperty("ROW", "4");
            Connection connection = fillo.getConnection("C:\\Users\\William\\Documents\\Cours\\IDC\\TP1-Rendu\\version2000.xls");
            //String query = "Select 1985, 1990, 1995, 1997, 2000 From Data Where 'Country Code'='FRA' and 'Indicator Code'='SP.ADO.TFRT'";
            String query = "Select * From Data";
            Recordset recordset = connection.executeQuery(query);

            while(recordset.next()){
                number = format.parse(recordset.getField("1985"));
                tmp = number.doubleValue();
                listeTaux.add(new TauxFertilite(1985,tmp));
                /*
                number = format.parse(recordset.getField("1990"));
                tmp = number.doubleValue();
                listeTaux.add(new TauxFertilite(1990,tmp));

                number = format.parse(recordset.getField("1995"));
                tmp = number.doubleValue();
                listeTaux.add(new TauxFertilite(1995,tmp));

                number = format.parse(recordset.getField("1997"));
                tmp = number.doubleValue();
                listeTaux.add(new TauxFertilite(1997,tmp));

                number = format.parse(recordset.getField("2000"));
                tmp = number.doubleValue();
                listeTaux.add(new TauxFertilite(2000,tmp));*/
            }

            recordset.close();
            connection.close();
        } catch(Exception e ){
            e.printStackTrace();
        }
    }

    public ArrayList<TauxFertilite> getListeTaux(){
        return listeTaux;
    }
}
