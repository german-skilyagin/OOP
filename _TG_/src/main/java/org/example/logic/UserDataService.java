package org.example.logic;
import java.util.HashMap;

public class UserDataService {
    private HashMap<String, UserData> userDataMap;

    public UserDataService() {
        userDataMap = new HashMap<>();
    }
    public void addUserData(UserData userData){
            userDataMap.put(userData.getId(), userData);
        }
    public void removeUserData(UserData userData){
            userDataMap.remove(userData.getId());
        }
    public UserData getOrCreateUserData(String id){
            UserData userData = userDataMap.get(id);

            if (userData == null) {
                userData = new UserData(id);
                userDataMap.put(id, userData);
            }

            return userData;
        }
}
