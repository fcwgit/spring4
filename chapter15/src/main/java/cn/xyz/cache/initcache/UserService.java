package cn.xyz.cache.initcache;

import cn.xyz.cache.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service("initUserService")
public class UserService {
    private Map<Integer,User> users = new HashMap<Integer, User>();

    {
        User user1 = new User();
        user1.setUserId("1");
        user1.setUserName("w1");
        User user2 = new User();
        user2.setUserId("2");
        user2.setUserName("w2");

        users.put(1,user1);
        users.put(2,user2);
    }

    @Autowired
    private CacheManager cacheManager;

    @PostConstruct
    public void setUp(){
        Cache usersCache = cacheManager.getCache("users");
        System.out.println("1111111111111111");
        for (Integer key:users.keySet()){
            usersCache.put(key,users.get(key));
        }
    }

    @Cacheable("users")
    public User getUser(int userId){
        System.out.println("User with id " + userId);
        return users.get(userId);
    }
}
