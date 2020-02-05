package io.cubita.base.auth.webmvc;

import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        System.out.println("aaaaa");
        return super.getErrorAttributes(webRequest, includeStackTrace);
    }
}
