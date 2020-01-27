package io.sanye.test.flow;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * test-flow.
 *
 * @author jiawei
 * @since 1.0.0
 */
public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("cubita");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/auth8?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置

        String moudleName = "dao";
        String pkgName = "io.sanye.test.flow";
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moudleName);
        pc.setParent(pkgName);

//        Map<String, String> pathInfo = new HashMap<>();
//        final String path = Paths.get(gc.getOutputDir(), pkgName.replaceAll("\\.", StringPool.BACK_SLASH + File.separator), moudleName).toString();
//        pathInfo.put(ConstVal.ENTITY_PATH,
//                path + File.separator + ConstVal.ENTITY.toLowerCase());
//        String mapperPath = path + File.separator + ConstVal.MAPPER.toLowerCase();
//        pathInfo.put(ConstVal.MAPPER_PATH, mapperPath);
//        pathInfo.put(ConstVal.XML_PATH,
//                mapperPath + File.separator + ConstVal.XML.toLowerCase());
//
//        String servicePath = path + File.separator + ConstVal.SERVICE.toLowerCase();
//        pathInfo.put(ConstVal.SERVICE_PATH, servicePath);
//
//        pathInfo.put(ConstVal.SERVICE_IMPL_PATH,
//                servicePath + File.separator + "impl");

//        pc.setPathInfo(pathInfo);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                this.getConfig().getPathInfo().remove(ConstVal.CONTROLLER_PATH);
                this.getConfig().getPathInfo().remove(ConstVal.XML_PATH);
            }
        };
        mpg.setCfg(cfg);

        StrategyConfig strategy = new StrategyConfig();

        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix( "t_");
        mpg.setStrategy(strategy);

        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        mpg.execute();
    }

}
