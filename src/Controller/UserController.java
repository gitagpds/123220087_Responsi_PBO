package Controller;

import Model.UserModel;

public class UserController {
    UserModel userModel;

    public UserController() {
        userModel = new UserModel();
    }

    public boolean validateUser(String username, String password) {
        return userModel.checkUserCredentials(username, password);
    }
}
