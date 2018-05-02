package cn.xyz.annotation;

public class ForumService {
    @NeedTest(value = true)//标注注解
    public void deleteForum(int forumId){
        System.out.println("删除论坛模块" + forumId);
    }

    @NeedTest(false)
    public void deleteTopic(int postId){
        System.out.println("删除论坛主题" + postId);
    }

    public static void main(String[] args) {
        System.out.println("1111111111111111111111");
    }
}
