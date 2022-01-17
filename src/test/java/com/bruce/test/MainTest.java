package com.bruce.test;

import net.minidev.json.JSONObject;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.shardingsphere.sql.parser.api.SQLParserEngine;
import org.apache.shardingsphere.sql.parser.api.SQLVisitorEngine;

import java.util.Properties;

/**
 * MainTest
 * 类描述：
 *
 * @author:zhangyongbin5
 * @date:2021/8/24
 */
public class MainTest {

    public static void main(String[] args) {
        ParseTree tree = new SQLParserEngine("MySQL").parse("select  * from customer", false);

        SQLVisitorEngine sqlVisitorEngine = new SQLVisitorEngine("MySQL", "FORMAT", new Properties());
        String formatedSql = sqlVisitorEngine.visit(tree);
        System.out.println(formatedSql);

    }


}
