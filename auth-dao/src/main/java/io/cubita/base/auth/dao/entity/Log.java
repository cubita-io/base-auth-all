package io.cubita.base.auth.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cubita
 * @since 2020-01-31
 */
@TableName("t_log")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 租户
     */
    private String tntName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getTntName() {
        return tntName;
    }

    public void setTntName(String tntName) {
        this.tntName = tntName;
    }

    @Override
    public String toString() {
        return "Log{" +
            "id=" + id +
            ", name=" + name +
            ", tntName=" + tntName +
        "}";
    }
}
