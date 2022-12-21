package uz.pdp.model;

public class User extends Base{
  private   String password;
  private   SimCard simCard;
  private String role;

  public User() {
  }

  public User(String  name,String password, String role) {
    this.name=name;
    this.password = password;
    this.role = role;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public SimCard getSimCard() {
    return simCard;
  }

  public void setSimCard(SimCard simCard) {
    this.simCard = simCard;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", simCard=" + simCard +
            ", role='" + role + '\'' +
            '}';
  }
}
