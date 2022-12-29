package publicadministration;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

public class CrimConvictionsColl { // Represents the total criminal convictions registered for a citizen
    private Set<CrimConviction> convictions; // Its components, that is, the set of criminal convictions

    public CrimConvictionsColl (){
        this.convictions = new HashSet<>();
    } // Initializes the object

    public Set<CrimConviction> getConvictions() {
        return convictions;
    }

    public void addCriminalConviction (CrimConviction crmC){
        this.convictions.add(crmC);
    }
    // Adds a criminal conviction
    public CrimConviction getCriminalConviction (Date date){
        for (CrimConviction c : convictions) {
            if (c.getCommitDate().equals(date)) {
                return c;
            }
        }
        return null;
    }
    // Gets a specific criminal conviction by date
    public String toString () {
        StringBuilder sb = new StringBuilder();
        for (CrimConviction c : convictions) {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    } // Converts to String
}
