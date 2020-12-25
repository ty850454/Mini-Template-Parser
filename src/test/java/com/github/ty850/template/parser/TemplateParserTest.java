package com.github.ty850.template.parser;


import java.util.HashMap;

/**
 * @author xy
 */
class TemplateParserTest {

    public static void main(String[] args) {
        TemplateParser templateParser = new TemplateParser("${变量1}文本1${变量2}文本2${变量1}");

        HashMap<String, String> params = new HashMap<>();
        params.put("变量1", "11111");
        params.put("变量2", "22222");
        System.out.println(templateParser.format(params));

    }
}