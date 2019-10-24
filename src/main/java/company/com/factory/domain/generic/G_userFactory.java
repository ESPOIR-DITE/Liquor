package company.com.factory.domain.generic;

import company.com.domain.genericClasses.G_User;

public class G_userFactory {
    public static G_User getUser(String stat,String email,String Name,String SurName,String UserType,String password,String Address,String phoner_Number){
        return new G_User.Builder(email)
                .buildName(Name)
                .buildPassword(password)
                .buildStat(stat)
                .buildSuName(SurName)
                .buildUserTpe(UserType)
                .buildAddress(Address)
                .phoner_Number(phoner_Number)
                .build();
    }
    public static G_User updateUser(String stat,String id,String Name,String SurName,String UserType,String password){
return null;
    }
}
