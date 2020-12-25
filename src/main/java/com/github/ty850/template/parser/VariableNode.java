package com.github.ty850.template.parser;

import lombok.ToString;

import java.util.Map;

/**
 * 变量节点
 *
 * @author xy
 */
@ToString
public class VariableNode implements Node {
    private final String variate;

    public VariableNode(String variate) {
        this.variate = variate;
    }

    @Override
    public void format(Map<String, String> params, StringBuilder builder) {
        String value = params.get(variate);
        if (value != null) {
            builder.append(value);
        }
    }
}
