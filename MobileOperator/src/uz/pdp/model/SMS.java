package uz.pdp.model;

public class SMS extends Base{
    String massage;
    int receiverId;
    int senderId;

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    @Override
    public String toString() {
        return "SMS{" +
                "id=" + id +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", massage='" + massage + '\'' +
                '}';
    }
}
