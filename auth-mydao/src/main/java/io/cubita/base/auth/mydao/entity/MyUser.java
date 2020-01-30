package io.cubita.base.auth.mydao.entity;

import com.baomidou.mybatisplus.annotation.TableField;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
public class MyUser {

    private String name;

    private String roleName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "name='" + name + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
