package uz.pdp.model;

public class SimCard extends  Base{
    private  MCompany mCompany;
    private  Tariff tariff;
    private  int userId;
    private int simCardNumber;
    private int simCardPassword;
    private  boolean inActive=false;
    private double balance;
    private double benefitFromCall;
    private double benefitFromMb;
    private double benefitFromSMS;

    public double getBenefitFromMb() {
        return benefitFromMb;
    }

    public void setBenefitFromMb(double benefitFromMb) {
        this.benefitFromMb = benefitFromMb;
    }

    public double getBenefitFromSMS() {
        return benefitFromSMS;
    }

    public void setBenefitFromSMS(double benefitFromSMS) {
        this.benefitFromSMS = benefitFromSMS;
    }

    public double getBenefitFromCall() {
        return benefitFromCall;
    }

    public void setBenefitFromCall(double benefitFromCall) {
        this.benefitFromCall = benefitFromCall;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public MCompany getmCompany() {
        return mCompany;
    }

    public void setmCompany(MCompany mCompany) {
        this.mCompany = mCompany;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSimCardNumber() {
        return simCardNumber;
    }

    public void setSimCardNumber(int simCardNumber) {
        this.simCardNumber = simCardNumber;
    }

    public int getSimCardPassword() {
        return simCardPassword;
    }

    public void setSimCardPassword(int simCardPassword) {
        this.simCardPassword = simCardPassword;
    }

    public boolean isInActive() {
        return inActive;
    }

    public void setInActive(boolean inActive) {
        this.inActive = inActive;
    }

    @Override
    public String toString() {
        return "SimCard{" +
                "id=" + id +
                ", userId=" + userId +
                ", tariff=" + tariff +
                ", simCardNumber=" + simCardNumber +
                ", simCardPassword=" + simCardPassword +
                ", inActive=" + inActive +
                ", balance=" + balance +
                '}';
    }
}
