
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class main {
    public static void main(String[] args) {
        
        List<Pyrmaid> myList ;
        PyrmaidCSVDAOImp _PyrmaidCSVDAOImp = new PyrmaidCSVDAOImp("D:\\pyramids.csv");
        myList =  _PyrmaidCSVDAOImp.GetAllPyrmaids();
        PrintPyramids( SortPyramidsbyHeight (myList));
        
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
    
    public static List<Pyrmaid> SortPyramidsbyHeight (List<Pyrmaid> lst)
    {
        List<Pyrmaid> Pyrmaids = lst;
        Comparator<Pyrmaid> compareByHeight = (Pyrmaid p1, Pyrmaid p2) -> p1.getHeight().compareTo( p2.getHeight() );
        Collections.sort(Pyrmaids, compareByHeight);
        return Pyrmaids;
        //Collections.sort(Pyrmaids, compareById.reversed()); 
    }
    
}
