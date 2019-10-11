package cn.yunding.cp.mapper;

        import cn.yunding.cp.dto.UserFindPassword;
        import cn.yunding.cp.entity.User;
        import cn.yunding.cp.entity.UserEmail;

        import java.util.HashMap;
        import java.util.List;

/**
 * @author haoyuli
 */
public interface UserEmailMapper {



    int savecaptcha(UserEmail userEmail);




    int updatecaptcha(UserEmail userEmail);


    User findPassword(String email);

    UserEmail selectByEmail(String email);



    UserFindPassword verifycaptchaByEmail(UserFindPassword userFindPassword);

    void delete(String email);

    String selectDateline(String email);



    

    Long selectUserIdByEmail(String email);

    String selectUsernameByUserId(Long userId);
}
