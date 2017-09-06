package entity;

import org.junit.Test;

/**
 * Created by simon.liu on 2017/9/6.
 */
public class UserTest {
    @Test
    public void entityTest() {
        /*User user = User.of("lixu").setName("lx");*/
        /*user.setAge("1");*/
        /*user.setId("2");*/
        /*System.out.println(user.getName());*/
    }
    @Test
    public void buildTest() {
        User user = User.builder().name("lx")
                .age("23")
                .id("1").build();
        System.out.println(user.getName());
    }
}
