package com.shui.one.generator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * topsun 代码生成器
 * </p>
 */
public class TopSunGenerator_supply {

    private static String JAVA_FILE_PATH = "/src/main/java";
    private static String XML_FILE_PATH = "/src/main/resources/mapper";
    private static String AUTH_NAME = "shui";

    private static String URL = "jdbc:mysql://121.36.174.215:3306/test?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8";
    private static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static String USER_NAME = "root";
    private static String PASSWORD = "123456";

    private static String PACKAGE = "com.shui";
    private static String MODULE_NAME = "one"; //改成自己的模块名称

    private static String[] IGNORE_PRE_FIX = { "m_"};  //需要忽略的表头名称
    private static String[] GEN_TABLES = { "m_blog"}; //需要生成的表名称

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + JAVA_FILE_PATH);
        gc.setAuthor(AUTH_NAME);
        gc.setOpen(false);
        /* 自定义文件命名，注意 %s 会自动填充表实体属性！ */
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        gc.setSwagger2(true); //开启swagger注解
        gc.setDateType(DateType.ONLY_DATE); //设置日期转换的格式
        gc.setBaseColumnList(false); //默认不开启字段参数到xml里
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        // dsc.setSchemaName("public");
        dsc.setDriverName(DRIVER_NAME);
        dsc.setUsername(USER_NAME);
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(PACKAGE);
        pc.setModuleName(MODULE_NAME);
        mpg.setPackageInfo(pc);

        // 自定义参数配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
//                Map<String, Object> map = new HashMap<String, Object>();
//                map.put("dtoPackage", pc.getParent()+".dto");
//                map.put("extControllerStyle", extControllerStyle);
//                this.setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();

        focList.add(new FileOutConfig("/templates/serviceImpl.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + JAVA_FILE_PATH + "/" + pc.getParent().replace(".", "/")
                        + "/service/impl/" + tableInfo.getServiceImplName() + StringPool.DOT_JAVA;
            }
        });

        focList.add(new FileOutConfig("/templates/controller.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + JAVA_FILE_PATH + "/" + pc.getParent().replace(".", "/")
                        + "/controller/" + tableInfo.getControllerName() + StringPool.DOT_JAVA;
            }
        });


        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // xml
                return projectPath + XML_FILE_PATH
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        focList.add(new FileOutConfig("/templates/entity.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + JAVA_FILE_PATH + "/" + pc.getParent().replace(".", "/")
                        + "/entity/" + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("/templates/service.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + JAVA_FILE_PATH + "/" + pc.getParent().replace(".", "/")
                        + "/service/" + tableInfo.getServiceName() + StringPool.DOT_JAVA;
            }
        });


        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        //不生成如下类型模板
        templateConfig.setService(null);
        templateConfig.setEntity(null);
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(IGNORE_PRE_FIX);// 此处可以修改为您的表前缀
        strategy.setInclude(GEN_TABLES);// 需要生成的表
        strategy.setNaming(NamingStrategy.underline_to_camel); //数据库表映射到实体的命名策略
        //strategy.setColumnNaming(NamingStrategy.no_change); //数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true);
        //strategy.setSuperControllerClass("com.baomidou.mybatisplus.samples.generator.common.BaseController");
        strategy.setControllerMappingHyphenStyle(true); //接口类型是
        strategy.setRestControllerStyle(true); //是否是rest接口
        //strategy.setEntityTableFieldAnnotationEnable(true); //@TableFiled

        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    private static boolean isExists(String path) {
        File file = new File(path);
        return file.exists();
    }
}