package company.com.domain.customerBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
    public class Customer {
    @Id
    private String email;
    private String name;
    private String surname;
    private String description;

    private Customer() {

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder {
        private String email;
        private String name;
        private String surname;
        private String description;


        public Builder(String email){
            this.email=email;
        }

        public Builder buildDescription(String description) {
            this.description = description;
            return this;
        }
        public Builder buildSurName (String surname) {
            this.surname = surname;
            return this;
        }

        public Builder buildName (String name) {
            this.name = name;
            return this;
        }

        public Customer build() {
            Customer customerProduct = new Customer();
            customerProduct.surname = this.surname;
            customerProduct.name = this.name;
            customerProduct.email = this.email;
            customerProduct.description = this.description;
            return customerProduct;
        }
    }
}
