package publicadministration;

import java.util.*;

public class CrimConvictionsColl { // Represents the total criminal convictions registered for a citizen
    private Map<Date, CrimConviction> conviction;// Its components, that is, the set of criminal convictions
    public CrimConvictionsColl (){
        this.conviction = new HashMap<>();
    } // Initializes the object

    public void addCriminalConviction (CrimConviction crmC){
        this.conviction.put(crmC.getCommitDate(), crmC);
    }
    // Adds a criminal conviction
    public CrimConviction getCriminalConviction (Date date){
        return conviction.get(date);
    }
    public Map<Date, CrimConviction> getConvictions() {
        return conviction;
    }
    // Gets a specific criminal conviction by date
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CrimConvictionsColl{\n");
        for (Map.Entry<Date, CrimConviction> entry : conviction.entrySet()) {
            sb.append("  ").append(entry.getValue()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

}
