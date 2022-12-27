package data;

import exceptions.BadFormatGoalException;

final public class Goal {
    private final String goal;
    public Goal (String code) throws BadFormatGoalException {
        if (code == null) throw new NullPointerException("Goal code is null.");
        this.goal = code;
    }
    public String getGoal() { return goal; }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goal goall = (Goal) o;
        return goal.equals(goall.goal);
    }
    @Override
    public int hashCode () { return goal.hashCode(); }
    @Override
    public String toString () {
        return goal;
    }
}

