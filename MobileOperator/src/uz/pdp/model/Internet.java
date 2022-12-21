package uz.pdp.model;

public class Internet extends  Base {
    String spentPlace;
    int spentMb;
    int spenderId;


    public int getSpenderId() {
        return spenderId;
    }

    public void setSpenderId(int spenderId) {
        this.spenderId = spenderId;
    }

    public String getSpentPlace() {
        return spentPlace;
    }

    public void setSpentPlace(String spentPlace) {
        this.spentPlace = spentPlace;
    }

    public int getSpentMb() {
        return spentMb;
    }

    public void setSpentMb(int spentMb) {
        this.spentMb = spentMb;
    }

    @Override
    public String toString() {
        return "Internet{" +
                "id=" + id +
                ", spenderId=" + spenderId +
                ", spentPlace='" + spentPlace + '\'' +
                ", spentMb=" + spentMb +
                '}';
    }
}
