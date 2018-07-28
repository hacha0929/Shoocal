package data.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("first name")
    @Expose
    private String firstName;
    @SerializedName("last name")
    @Expose
    private String lastName;
    @SerializedName("phone")
    @Expose
    private Long phone;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("restaurant name")
    @Expose
    private String restaurantName;
    @SerializedName("request by")
    @Expose
    private Integer requestBy;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Integer getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(Integer requestBy) {
        this.requestBy = requestBy;
    }

    @Override
    public String toString() {
        return "Post{" +
                "first name='" + firstName + '\'' +
                ", last name='" + lastName + '\'' +
                ", phone=" + phone +
                ", address=" + address + '\'' +
                ", restaurant name=" + restaurantName +'\'' +
                ", request by=" + requestBy +
                '}';
    }
}
