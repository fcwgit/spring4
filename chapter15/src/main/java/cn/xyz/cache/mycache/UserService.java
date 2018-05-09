package cn.xyz.cache.mycache;

import cn.xyz.cache.domain.User;

public class UserService {
    private CacheManager<User> cacheManager;

    public UserService(){
        cacheManager = new CacheManager<User>();
    }

    public User getUserById(String userId){
        User result = cacheManager.getValue(userId);
        if (result != null){
            System.out.println("get from cache ..." + userId);
            return result;
        }
        result = getFromDB(userId);
        if (result != null){
            cacheManager.addOrUpdateCache(userId,result);
        }

        return result;
    }

    public void reload(){
        cacheManager.evictCache();
    }

    private User getFromDB(String userId) {
        System.out.println("real querying db ... " + userId);
        User user = new User();
        user.setUserId(userId);
        return user;
    }
}
