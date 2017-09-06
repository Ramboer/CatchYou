package entity;


import lombok.*;
import lombok.experimental.Accessors;

/**
 * Created by simon.liu on 2017/9/6.
 */
@Accessors(chain = true)
@Getter
@Setter
@Builder
public class User {
    @NonNull private String name;
    private String id;
    private String age;
    private String password;
}
