package org.farhana273.khidashamlao.vmutility;

import org.farhana273.khidashamlao.domain.User;
import org.farhana273.khidashamlao.vm.UserVM;

public class UserVMUtility {

    public static User mapToUser(UserVM userVM) {
        User user = new User();
        user.setFirstName(userVM.getFirstName());
        user.setLastName(userVM.getLastName());
        user.setGender(userVM.getGender());
        user.setDateOfBirth(userVM.getDateOfBirth());
        user.setPassword(userVM.getPassword());
        user.setEmail(userVM.getEmail());
        user.setMobile(userVM.getMobile());
        user.setStreet(userVM.getStreet());
        user.setCity(userVM.getCity());
        user.setState(userVM.getState());
        user.setZipCode(userVM.getZipCode());
        return user;
    }
}