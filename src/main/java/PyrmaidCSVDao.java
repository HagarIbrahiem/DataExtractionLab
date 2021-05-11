
import java.util.List;

public interface PyrmaidCSVDao {
    
    List<Pyrmaid> GetAllPyrmaids();
    void CreatePyrmaid(String [] pyrmaidMetaData);
    
}
