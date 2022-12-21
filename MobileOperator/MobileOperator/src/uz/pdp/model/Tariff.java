package uz.pdp.model;

public class Tariff extends Base {
    private MCompany mCompany;
    private double priceForMonth;
    private int freeMinutes;
    private int freeMB;
    private int freeSMS;
    private double priceForOneMinute;
    private double priceForOneMB;
    private double priceForOneSMS;

    public MCompany getmCompany() {
        return mCompany;
    }

    public void setmCompany(MCompany mCompany) {
        this.mCompany = mCompany;
    }

    public double getPriceForMonth() {
        return priceForMonth;
    }

    public void setPriceForMonth(double priceForMonth) {
        this.priceForMonth = priceForMonth;
    }

    public int getFreeMinutes() {
        return freeMinutes;
    }

    public void setFreeMinutes(int freeMinutes) {
        this.freeMinutes = freeMinutes;
    }

    public int getFreeMB() {
        return freeMB;
    }

    public void setFreeMB(int freeMB) {
        this.freeMB = freeMB;
    }

    public int getFreeSMS() {
        return freeSMS;
    }

    public void setFreeSMS(int freeSMS) {
        this.freeSMS = freeSMS;
    }

    public double getPriceForOneMinute() {
        return priceForOneMinute;
    }

    public void setPriceForOneMinute(double priceForOneMinute) {
        this.priceForOneMinute = priceForOneMinute;
    }

    public double getPriceForOneMB() {
        return priceForOneMB;
    }

    public void setPriceForOneMB(double priceForOneMB) {
        this.priceForOneMB = priceForOneMB;
    }

    public double getPriceForOneSMS() {
        return priceForOneSMS;
    }

    public void setPriceForOneSMS(double priceForOneSMS) {
        this.priceForOneSMS = priceForOneSMS;
    }

    public void setPriceForOneSMS(int priceForOneSMS) {
        this.priceForOneSMS = priceForOneSMS;
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mCompany=" + mCompany +
                ", priceForMonth=" + priceForMonth +
                ", freeMinutes=" + freeMinutes +
                ", freeMB=" + freeMB +
                ", freeSMS=" + freeSMS +
                ", priceForOneMinute=" + priceForOneMinute +
                ", priceForOneMB=" + priceForOneMB +
                ", priceForOneSMS=" + priceForOneSMS +
                '}';
    }
}
