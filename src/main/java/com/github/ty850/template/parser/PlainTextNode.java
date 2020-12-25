package com.github.ty850.template.parser;

import lombok.ToString;

import java.util.Map;

/**
 * 纯文本节点
 *
 * @author xy
 */
@ToString
public class PlainTextNode implements Node {

    private final String plainText;

    public PlainTextNode(String text) {
        this.plainText = text;
    }

    @Override
    public void format(Map<String, String> params, StringBuilder builder) {
        builder.append(plainText);
    }
}
