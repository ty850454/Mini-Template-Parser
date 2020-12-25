package com.github.ty850.template.parser;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author xy
 */
public class TemplateParser {

    private final List<Node> nodes;

    public TemplateParser(String template) {
        this.nodes = parseToNodeList(template);
    }

    /**
     * 将模板解析为节点集合，如有需要可自行改造缓存节点集合
     *
     * @param template 模板
     * @return 节点结合
     */
    private static List<Node> parseToNodeList(String template) {
        LinkedList<Node> nodes = new LinkedList<>();
        char[] chars = template.toCharArray();

        int offset = 0;
        int start = template.indexOf("${", offset);
        if (start == -1) {
            // 没有参数，只有一条纯文本节点
            nodes.add(new PlainTextNode(template));
            return nodes;
        }

        // 存在参数，找一个处理一个，知道找不到了为止
        while (start > -1) {
            if (start - offset != 0) {
                nodes.add(new PlainTextNode(new String(chars, offset, start - offset)));
            }
            offset = start + "${".length();
            int end = template.indexOf("}", offset);
            if (end != -1) {
                nodes.add(new VariableNode(new String(chars, offset, end - offset)));
                offset = end + "}".length();
            } else {
                nodes.add(new PlainTextNode(new String(chars, offset, chars.length - offset)));
                offset = chars.length;
            }
            start = template.indexOf("${", offset);
        }
        if (offset < chars.length) {
            nodes.add(new PlainTextNode(new String(chars, offset, chars.length - offset)));
        }
        return nodes;
    }


    public String format(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        for (Node node : nodes) {
            node.format(params, builder);
        }
        return builder.toString();
    }

}
