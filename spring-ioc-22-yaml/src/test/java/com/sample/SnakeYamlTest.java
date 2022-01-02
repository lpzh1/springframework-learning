package com.sample;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Node;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;


// yaml规范参考:
// http://yaml.org/type/index.html

public class SnakeYamlTest {


    @Test
    public void testLoad() {
        String yamlStr = "key: hello yaml";
        Yaml yaml = new Yaml();
        Object ret = yaml.load(yamlStr);
        System.out.println(ret);

        System.out.println(ret.getClass().getSimpleName());

    }

    @Test
    public void testLoad2() throws FileNotFoundException {
        //String yamlStr = "key: hello yaml";
        //Object ret = yaml.load(yamlStr);

        Yaml yaml = new Yaml();
        Reader reader = new InputStreamReader(new FileInputStream("application.yaml"));
       Object obj = yaml.load(reader);
        //Node compose = yaml.compose(reader);

        //{server={port=8080, path=/a}}
        System.out.println(obj);

        //java.util.LinkedHashMap
        System.out.println(obj.getClass().getName());

    }


}
