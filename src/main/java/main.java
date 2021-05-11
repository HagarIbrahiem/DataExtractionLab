
import java.util.List;


public class main {
    public static void main(String[] args) {
        
        List<Pyrmaid> myList ;
        PyrmaidCSVDAOImp _PyrmaidCSVDAOImp = new PyrmaidCSVDAOImp("D:\\pyramids.csv");
        myList =  _PyrmaidCSVDAOImp.GetAllPyrmaids();
        PrintPyramids( myList);
        
    }
    
      
    public static void PrintPyramids (List<Pyrmaid> mylist)
    {
       if(!mylist.isEmpty())
       {
            for( Pyrmaid _Pyrmaid : mylist)
            {
             System.out.println(_Pyrmaid.getPharaoh() +
                                       _Pyrmaid.getAncientName()+
                                       _Pyrmaid.getModernName()+
                                       _Pyrmaid.getSite()+
                                       _Pyrmaid.getHeight().toString()
                    );
            }
       }  
        else
        System.out.println("EmptyList");
    }
    
}
