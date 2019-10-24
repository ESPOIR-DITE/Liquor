package company.com.factory.domain.bridge;

import company.com.domain.bridge.User_address;
import company.com.util.IdGenerator;

public class User_AddressFactory {
    public static User_address getCustomerAddress(String email, String addressId, String description){
        return new User_address.Builder(email)
                .buildId(IdGenerator.getSuffixFromClassName(User_AddressFactory.class))
                .buildAddressId(addressId)
                .buildDescription(description)
                .build();
    }
}
