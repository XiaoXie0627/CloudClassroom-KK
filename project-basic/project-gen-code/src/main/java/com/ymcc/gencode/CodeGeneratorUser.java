package com.ymcc.gencode;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;
import java.util.ResourceBundle;

/**
 * @author Light xhh032533@163.com
 * @text Passion！无他,唯手熟尔！More Code & Thinking Why, 每一行代码但是你进步的基石！理解大于记忆
 * @time 2025/9/27 03:03
 */
public class CodeGeneratorUser{
    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("mybatiesplus-config-user"); //不要加后缀
        String outputDir = rb.getString("OutputDir");
        String outputDirXml = rb.getString("OutputDirXml");
        String outputDirBase = rb.getString("OutputDirBase");
        String moduleDir = rb.getString("ModuleDir");
        String author = rb.getString("author");
        String parent = rb.getString("parent");
        String jdbcDriver = rb.getString("jdbc.driver");
        String jdbcUrl = rb.getString("jdbc.url");
        String jdbcRoot = rb.getString("jdbc.root");
        String jdbcPwd = rb.getString("jdbc.pwd");
        //替换
        FastAutoGenerator.create(jdbcUrl, jdbcRoot, jdbcPwd)
                .globalConfig(builder -> {
                    builder.author(author) // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("E:/Software/KKProject/"); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent(parent) // 设置父包名
                                .moduleName(moduleDir) // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, outputDirXml)) // 设置mapperXml生成路径
                )
                //TODO
                .strategyConfig(builder ->
                        builder.addInclude("") // 设置需要生成的表名
                                .addTablePrefix("t_", "c_") // 设置过滤表前缀
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
