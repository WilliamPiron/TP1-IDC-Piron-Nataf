import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Excel {

    private ArrayList<TauxFertilite> listeTaux;

    public Excel(String pathToFile){
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        Number number;
        double tmp;
        String country, indicator;
        Fillo fillo = new Fillo();
        listeTaux = new ArrayList<TauxFertilite>();
        try {
            System.setProperty("ROW", "4");
            Connection connection = fillo.getConnection(pathToFile);
            String query = "Select * From Data";
            Recordset recordset = connection.executeQuery(query);

            while(recordset.next()){
                country = recordset.getField("Country Code");
                indicator = recordset.getField("Indicator Code");

                if (country.equals("FRA") && indicator.equals("SP.ADO.TFRT")) {
                    number = format.parse(recordset.getField("1985"));
                    tmp = number.doubleValue();
                    listeTaux.add(new TauxFertilite(1985,tmp));

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
                    listeTaux.add(new TauxFertilite(2000,tmp));
                }
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
