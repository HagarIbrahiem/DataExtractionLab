
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PyrmaidCSVDAOImp implements PyrmaidCSVDao{

    List<Pyrmaid> pyrmaids = new ArrayList <Pyrmaid>();

    public PyrmaidCSVDAOImp( String CSVFileName) {
       pyrmaids =  ReadPyrmaidFromCSV(CSVFileName);
    }
    
    @Override
    public List<Pyrmaid> GetAllPyrmaids() {
        return  pyrmaids;
    }
    
    @Override
    public void CreatePyrmaid(String [] pyrmaidMetaData)
    {
  
    }

    private List<Pyrmaid> ReadPyrmaidFromCSV(String CSVFileName)
    {
       try {
            //read from File
            BufferedReader _BufferedReader=new BufferedReader(new FileReader(CSVFileName));
            String line = _BufferedReader.readLine();
            do {       
                line= _BufferedReader.readLine();
               if(line != null)
               {
                   String [] attributes = line.split(",",-1);
                        Pyrmaid _Pyrmaid = new Pyrmaid ();
                        _Pyrmaid.setPharaoh(attributes[0]);
                        _Pyrmaid.setAncientName(attributes[1]);
                        _Pyrmaid.setModernName(attributes[2]);
                        _Pyrmaid.setSite(attributes[4]);
                        //validate Height value
                         if( attributes[7].isEmpty()  )
                             _Pyrmaid.setHeight(0.0);
                         else
                             _Pyrmaid.setHeight(Double.parseDouble(attributes[7]));
                        pyrmaids.add(_Pyrmaid);
               }
           } while (line != null);
            _BufferedReader.close();
        } 
        catch (IOException ex) {
            System.err.println("Error" + ex.getMessage());
        }
       return  pyrmaids;
    }
    
    
}
