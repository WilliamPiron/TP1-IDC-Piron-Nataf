import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Excel {



    public Excel(){
        Fillo fillo = new Fillo();
        try {
            Connection connection = fillo.getConnection("C:\\Users\\William\\Documents\\Cours\\IDC\\TP1-Rendu\\version2000.xls");
            String query = "";
            Recordset recordset = connection.executeQuery(query);

            while(recordset.next()){
                
            }
        } catch(Exception e ){
            e.printStackTrace();
        }
    }
}
