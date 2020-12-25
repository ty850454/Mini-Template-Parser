package com.github.ty850.template.parser;

import java.util.Map;

/**
 * 接点接口
 *
 * @author xy
 */
public interface Node {

    void format(Map<String, String> params, StringBuilder builder);

}
