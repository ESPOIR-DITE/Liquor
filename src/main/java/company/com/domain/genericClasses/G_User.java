package company.com.domain.genericClasses;

public class G_User {
    private String stat;
    private String email;
    private String Name;
    private String SurName;
    private String UserType;
    private String password;
    private String Address;
    private String phoner_Number;
    private String description;

    private G_User() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoner_Number() {
        return phoner_Number;
    }

    public void setPhoner_Number(String phoner_Number) {
        this.phoner_Number = phoner_Number;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String email) {
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "G_User{" +
                "stat='" + stat + '\'' +
                ", email='" + email + '\'' +
                ", Name='" + Name + '\'' +
                ", SurName='" + SurName + '\'' +
                ", UserType='" + UserType + '\'' +
                ", password='" + password + '\'' +
                ", Address='" + Address + '\'' +
                ", phoner_Number='" + phoner_Number + '\'' +
                '}';
    }

    public static class Builder{
        private String stat;
        private String email;
        private String Name;
        private String SurName;
        private String UserType;
        private String password;
        private String Address;
        private String phoner_Number;
        private String description;


        public Builder(String email){
            this.email=email;
        }
        public Builder buildName(String name){
            this.Name=name;
            return this;
        }
        public Builder buildDescription(String description){
            this.description=description;
            return this;
        }
        public Builder buildAddress(String Address){
            this.Address=Address;
            return this;
        }
        public Builder buildSuName(String surName){
            this.SurName=surName;
            return this;
        }
        public Builder phoner_Number(String phoner_Number){
            this.phoner_Number=phoner_Number;
            return this;
        }
        public Builder buildUserTpe(String userType){
            this.UserType=userType;
            return this;
        }
        public Builder buildStat(String stat){
            this.stat=stat;
            return this;
        }
        public Builder buildPassword(String password){
            this.password=password;
            return this;
        }
        public G_User build(){
            G_User g=new G_User();
            g.email=this.email;
            g.Name=this.Name;
            g.password=this.password;
            g.stat=this.stat;
            g.SurName=this.SurName;
            g.password=this.password;
            g.UserType=this.UserType;
            g.phoner_Number=this.phoner_Number;
            g.Address=this.Address;
            return g;
        }
    }
}
