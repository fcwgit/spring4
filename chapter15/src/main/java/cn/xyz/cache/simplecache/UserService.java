package cn.xyz.cache.simplecache;

import cn.xyz.cache.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("userServiceBean")
public class UserService {

    @Cacheable(cacheNames = "users")
    public User getUserById(String userId){
        System.out.println("real query user." + userId);
        return getFromDB(userId);
    }

    private User getFromDB(String userId) {
        System.out.println("real querying db..." + userId);
        User user = new User();
        user.setUserId(userId);
        return user;
    }
}
