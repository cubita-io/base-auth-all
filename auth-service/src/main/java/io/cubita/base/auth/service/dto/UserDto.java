package io.cubita.base.auth.service.dto;

/**
 * <p>
 *     用户实体
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
public class UserDto {

    /**
     * 用户名.
     */
    private String name;

    /**
     * 密码.
     */
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
