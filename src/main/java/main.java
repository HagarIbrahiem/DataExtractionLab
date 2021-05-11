
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class main {
    public static void main(String[] args) {

        List<Pyrmaid> lst ;
        PyrmaidCSVDAOImp _PyrmaidCSVDAOImp = new PyrmaidCSVDAOImp("D:\\pyramids.csv");
        //Get List
        lst =  _PyrmaidCSVDAOImp.GetAllPyrmaids();
        
        //Sort List
        PrintPyramids( SortPyramidsbyHeight (lst));
        
        //Mapping List 
        MapPyramidsLst(lst);
     
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
        //Set Comparator using limda expression
        Comparator<Pyrmaid> compareByHeight = (Pyrmaid p1, Pyrmaid p2) -> p1.getHeight().compareTo( p2.getHeight() );
        Collections.sort(Pyrmaids, compareByHeight);
        return Pyrmaids;
        //Collections.sort(Pyrmaids, compareById.reversed()); 
    }
    
    public static void MapPyramidsLst (List<Pyrmaid> lst) {
        
        Map<String, Set<String>> pyrmaidMap = lst.stream()
                                      .collect(
                                           Collectors.groupingBy(
                                               Pyrmaid::getSite, 
                                           Collectors.mapping(Pyrmaid::getPharaoh,Collectors.toSet())
                                                              ));

        for (Map.Entry<String,Set<String>> entry : pyrmaidMap.entrySet())
            System.out.println("Key = " + entry.getKey() +
                             ", Value = " +entry.getValue().size());
    }
}
