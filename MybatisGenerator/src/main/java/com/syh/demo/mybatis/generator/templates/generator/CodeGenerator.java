package com.syh.demo.mybatis.generator.templates.generator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.syh.demo.mybatis.generator.templates.config.PropertyInjection;

import java.util.Map;

public class CodeGenerator {

    public static void main(String[] args) {

        /**
         * 使用注意事项：
         *  1、数据库表名，多个单词必须以“_”分割
         *  2、数据库表名和字段注释，千万不要带有换行符，不然实体类会报错，增加工作量
         */

        PropertyInjection propertyInjection = new PropertyInjection();
        propertyInjection.setAddUpdateDeleteOperationReturnName("NurseResponseUtil");
        propertyInjection.setAddUpdateDeleteOperationReturnPackage("unicom.cloud.nursing.data.sync.common.util");
        propertyInjection.setSelectOne("");
        propertyInjection.setSelectList("");
        propertyInjection.setSelectMap("");

        Map<String,Object> propertyInjectionMap = JSONObject.parseObject(JSON.toJSONString(propertyInjection));

        String table = "base_org_info";
        generatorManyTable("HSY",
                "jdbc:mysql://127.0.0.1:3306/database?useUnicode=true&useSSL=false&characterEncoding=utf8",
                "com.mysql.jdbc.Driver",
                "root",
                "root",
                "parent",
                "common",
                "",
                table,
                propertyInjectionMap);


    }

    /**
     * Mybatis一键生成entity,mapper,mapper.xml,service,serviceImpl,controller
     * @param author            开发人员
     * @param url               驱动连接的URL
     * @param driverName        驱动名称
     * @param username          数据库连接用户名
     * @param password          数据库连接密码
     * @param parent            父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
     * @param projectModule     项目模块包名
     * @param functionModule    功能模块包名
     * @param tableName         表名多个表名，用逗号隔开
     */
    public static void generatorManyTable(String author,
                                          String url,
                                          String driverName,
                                          String username,
                                          String password,
                                          String parent,
                                          String projectModule,
                                          String functionModule,
                                          String tableName, Map<String, Object> propertyInjection) {
        String[] tables = tableName.split(",");
        if (tables.length > 0) {
            for (String table : tables) {
                generator(author,
                        url,
                        driverName,
                        username,
                        password,
                        parent,
                        projectModule,
                        functionModule,
                        table,
                        propertyInjection);
            }
        }
    }

    /**
     * Mybatis一键生成entity,mapper,mapper.xml,service,serviceImpl,controller
     * @param author            开发人员
     * @param url               驱动连接的URL
     * @param driverName        驱动名称
     * @param username          数据库连接用户名
     * @param password          数据库连接密码
     * @param parent            父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
     * @param projectModule     项目模块包名
     * @param functionModule    功能模块包名
     * @param tableName         表名
     */
    private static void generator(String author,
                                 String url,
                                 String driverName,
                                 String username,
                                 String password,
                                 String parent,
                                 String projectModule,
                                 String functionModule,
                                 String tableName,
                                 Map<String, Object> propertyInjection) {

        /* 生成Entity/Mapper/Mapper.xml/Service/ServiceImpl/Controller */
        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig globalConfig = globalConfig(author, projectModule);
        mpg.setGlobalConfig(globalConfig);
        mpg.setDataSource(dataSourceConfig(url, driverName, username, password));
        PackageConfig packageConfig = packageConfig(parent, functionModule);
        mpg.setPackageInfo(packageConfig);
        mpg.setStrategy(strategyConfig(tableName));
        mpg.setTemplate(templateConfig());
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        configInjectionProperty(mpg, propertyInjection);

        StringBuilder entityName = new StringBuilder();

        String[] tableSplit = tableName.split("_");
        for (String split : tableSplit) {
            entityName.append(toUpperCase4Index(split));
        }

        String daoName = packageConfig.getParent() + "." +
                packageConfig.getService() + "." +
                entityName.toString() +
                globalConfig.getServiceName().replaceFirst("%s", "");
        propertyInjection.put("daoName", daoName);

        /* 生成ClientService/ClientService/ClientFallbackFactory */
        AutoGenerator autoGenerator = new AutoGenerator();
        GlobalConfig clientGlobalConfig = globalConfigClientService(author, projectModule);
        autoGenerator.setGlobalConfig(clientGlobalConfig);
        autoGenerator.setDataSource(dataSourceConfig(url, driverName, username, password));
        PackageConfig clientPackageConfig = packageConfigClientService(parent, functionModule);
        autoGenerator.setPackageInfo(clientPackageConfig);
        autoGenerator.setStrategy(strategyConfig(tableName));
        autoGenerator.setTemplate(templateConfigClientService());
        autoGenerator.setTemplateEngine(new VelocityTemplateEngine());
        configInjectionProperty(autoGenerator, propertyInjection);

        String serviceName = clientPackageConfig.getParent() + "." +
                clientPackageConfig.getService() + "." +
                entityName.toString() +
                clientGlobalConfig.getServiceName().replaceFirst("%s", "");
        propertyInjection.put("serviceName", serviceName);

        mpg.execute();
        autoGenerator.execute();
    }

    private static void configInjectionProperty(AutoGenerator autoGenerator,
                                                Map<String, Object> propertyInjection) {
        InjectionConfig injectionConfig = new InjectionConfig() {
            //自定义属性注入:abc
            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                this.setMap(propertyInjection);
            }
        };
        //配置自定义属性注入
        autoGenerator.setCfg(injectionConfig);
    }

    /**
     * 全局配置
     * @param author            开发人员
     * @param projectModule     项目模块包名
     * @return                  GlobalConfig
     */
    private static GlobalConfig globalConfig (String author, String projectModule) {
        GlobalConfig globalConfig = configGlobal(author, projectModule);
        globalConfig.setEntityName("%s");
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("%sDao");
        globalConfig.setServiceImplName("%sDaoImpl");
        globalConfig.setControllerName("%sController");
        return globalConfig;
    }

    /**
     * 全局配置
     * @param author            开发人员
     * @param projectModule     项目模块包名
     * @return                  GlobalConfig
     */
    private static GlobalConfig globalConfigClientService(String author, String projectModule) {
        GlobalConfig globalConfig = configGlobal(author, projectModule);
        globalConfig.setEntityName("%s");
        globalConfig.setMapperName("%sClientService");
        globalConfig.setXmlName("%sClientFallbackFactory");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%ssServiceImpl");
        globalConfig.setControllerName("%sController");
        return globalConfig;
    }

    /**
     * 全局配置
     * @param author            开发人员
     * @param projectModule     项目模块包名
     * @return                  GlobalConfig
     */
    private static GlobalConfig configGlobal(String author, String projectModule) {
        String projectPath = System.getProperty("user.dir");
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(projectPath + "/" + projectModule + "/src/main/java");
        globalConfig.setFileOverride(true);
        globalConfig.setAuthor(author);
        globalConfig.setSwagger2(true);
        globalConfig.setOpen(false);
        globalConfig.setEnableCache(false);
        globalConfig.setKotlin(false);
        globalConfig.setActiveRecord(false);
        globalConfig.setBaseResultMap(false);
        globalConfig.setBaseColumnList(false);
        return globalConfig;
    }

    /**
     * 数据源设置
     * @param url           驱动连接的URL
     * @param driverName    驱动名称
     * @param username      数据库连接用户名
     * @param password      数据库连接密码
     * @return              DataSourceConfig
     */
    private static DataSourceConfig dataSourceConfig (String url,
                                                      String driverName,
                                                      String username,
                                                      String password) {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl(url);
        dataSourceConfig.setDriverName(driverName);
        dataSourceConfig.setUsername(username);
        dataSourceConfig.setPassword(password);
        return dataSourceConfig;
    }

    /**
     * 包配置
     * @param parent            父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
     * @param functionModule    功能模块包名
     * @return                  PackageConfig
     */
    private static PackageConfig packageConfig (String parent, String functionModule) {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(parent);
        packageConfig.setEntity("entity" + functionModule);
        packageConfig.setMapper("mapper" + functionModule);
        packageConfig.setXml("mapper.xml" + functionModule);
        packageConfig.setService("dao" + functionModule);
        packageConfig.setServiceImpl("dao.impl" + functionModule);
        packageConfig.setController("controller" + functionModule);
        return packageConfig;
    }
    /**
     * 包配置
     * @param parent            父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
     * @param functionModule    功能模块包名
     * @return                  PackageConfig
     */
    private static PackageConfig packageConfigClientService (String parent, String functionModule) {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(parent);
        packageConfig.setEntity("entity" + functionModule);
        packageConfig.setMapper("service.client" + functionModule);
        packageConfig.setXml("service.fallback" + functionModule);
        packageConfig.setService("service" + functionModule);
        packageConfig.setServiceImpl("service.impl" + functionModule);
        packageConfig.setController("controller" + functionModule);
        return packageConfig;
    }

    /**
     * 模板路径配置项
     * @return  TemplateConfig
     */
    private static TemplateConfig templateConfig () {
        /* .vm用VelocityTemplateEngine模板引擎，.ftl用FreemarkerTemplateEngine模板引擎 */
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity("/templates/entity.java");
        templateConfig.setMapper("/templates/mapper.java");
        templateConfig.setXml("/templates/mapper.xml");
        templateConfig.setService("/templates/dao.java");
        templateConfig.setServiceImpl("/templates/daoImpl.java");
        templateConfig.setController("/templates/controller.java");
        return templateConfig;
    }

    /**
     * 模板路径配置项
     * @return  TemplateConfig
     */
    private static TemplateConfig templateConfigClientService () {
        /* .vm用VelocityTemplateEngine模板引擎，.ftl用FreemarkerTemplateEngine模板引擎 */
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity(null);
        templateConfig.setMapper("/templates/clientService.java");
        templateConfig.setXml("/templates/clientFactory.java");
        templateConfig.setService("/templates/service.java");
        templateConfig.setServiceImpl("/templates/serviceImpl.java");
        templateConfig.setController(null);
        return templateConfig;
    }

    /**
     * 策略配置
     * @param tableName     数据库表名称，多个用英文逗号隔开
     * @return              StrategyConfig
     */
    private static StrategyConfig strategyConfig (String tableName) {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
//        strategyConfig.setSuperEntityColumns("id");
        strategyConfig.setInclude(tableName);
        strategyConfig.setControllerMappingHyphenStyle(true);
        return strategyConfig;
    }

    /**
     * 首字母大写
     *
     * @param string    字符串
     * @return          字符串
     */
    private static String toUpperCase4Index(String string) {
        char[] methodName = string.toCharArray();
        methodName[0] = toUpperCase(methodName[0]);
        return String.valueOf(methodName);
    }

    /**
     * 字符转成大写
     *
     * @param chars
     * @return
     */
    private static char toUpperCase(char chars) {
        if (97 <= chars && chars <= 122) {
            chars ^= 32;
        }
        return chars;
    }
}