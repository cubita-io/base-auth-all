package io.cubita.base.commons;

/**
 * <p>
 *     常量
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
public interface Constants {
    /**
     * 过滤表无租户信息约束.
     */
    String[] TABLE_WITHOUT_TENANT = "t_role,t_authorized_uri,t_tenant".split(",");
    /**
     * 过滤自定义查询此时无租户信息约束.
     */
    String[] MAPPER_METHOD_WITHOUT_TENANT =
            "".split(",");
    String TENANT_COLUMN_NAME = "tenant_name";
}
