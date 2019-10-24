package company.com.domain.bridge;

import company.com.domain.customerBuilder.Customer;
import company.com.domain.users.Address;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User_address {
    @Id
    private String id;
    private String email;
    private String addressId;
    //private String gender;
    private String description;


    public User_address() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder {
        private String id;
        private String email;
        private String addressId;
        //private String gender;
        private String description;

        public Builder(String email) {
            this.email = email;
        }

        public Builder buildAddressId(String addressId) {
            this.addressId = addressId;
            return this;
        }

        public Builder buildDescription(String description) {
            this.description = description;
            return this;
        }
        public Builder buildId(String id){
            this.id=id;
            return this;
        }

        public User_address build() {
            User_address ca = new User_address();
            ca.addressId = this.addressId;
            ca.description = this.description;
            ca.email = this.email;
            ca.addressId = this.addressId;
            ca.id=this.id;
            return ca;
        }
    }
}
