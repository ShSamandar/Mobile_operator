package uz.pdp.model;

public class Call extends Base{
    int spendingTimeForCall;
    int userCollingId;
    int receiverId;

    public int getSpendingTimeForCall() {
        return spendingTimeForCall;
    }

    public void setSpendingTimeForCall(int spendingTimeForCall) {
        this.spendingTimeForCall = spendingTimeForCall;
    }

    public int getUserCollingId() {
        return userCollingId;
    }

    public void setUserCollingId(int userCollingId) {
        this.userCollingId = userCollingId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    @Override
    public String toString() {
        return "Call{" +
                "id=" + id +
                ", spendingTimeForCall=" + spendingTimeForCall +
                ", userCollingId=" + userCollingId +
                ", receiverId=" + receiverId +
                '}';
    }
}
