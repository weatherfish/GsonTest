
package com.felix.gsontest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Descript：
 * 
 * @auther：weatherfish Create time：2015年11月23日 上午9:52:23
 * @version
 */

public class Demo {
    public static void main(String[] args) {

        // TestSimpleModel();
        // TestComplexModel();
        // TestAnimModel();
        TestMap();
        TestTypeAdapter();
    }

    private static void TestTypeAdapter() {
        Gson gson = new GsonBuilder().registerTypeAdapter(SimpleModel.class, new MyTypeAdapter()).create();
    }

    private static void TestMap() {
        Type type = new TypeToken<Map<SimpleModel, String>>() {
        }.getType();
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        Map<SimpleModel, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            SimpleModel simpleModel = new SimpleModel();
            simpleModel.setId(i);
            simpleModel.setName("NAME" + i);
            simpleModel.setBirthday(new Date(System.currentTimeMillis() + 1000000 * i));
            map.put(simpleModel, "weatherfish" + i);
        }
        String json = gson.toJson(map);
        System.out.println(json);
        System.out.println("-----------------------------");

        System.out.println(gson.fromJson(json, type).toString());
    }

    private static void TestAnimModel() {
        Type type = new TypeToken<AnimModel>() {
        }.getType();
        AnimModel animModel = new AnimModel();
        animModel.setBirthday(new Date());
        animModel.setCode(123);
        animModel.setCode2(234);
        animModel.setCode3(345);
        animModel.setCode4(456);
        animModel.setNoSave(22222222l);
        animModel.setSecondName("weatherfish");

        String json = "{\"noSave\":22222222,\"code2\":234,\"code3\":345,\"code4\":456,\"list\":null,\"name\":\"weatherfish\",\"birthday\":\"Nov 23, 2015 11:43:34 AM\"}";
        System.out.println("source model: " + animModel.toString());
        System.out.println("source json: " + json);

        System.out.println("default model->Json: " + new Gson().toJson(animModel));
        System.out.println("default Json->model: " + new Gson().fromJson(json, type));

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        System.out.println(
                "excludeFieldsWithoutExposeAnnotation model->json : " + gson.toJson(animModel));
        System.out.println("excludeFieldsWithoutExposeAnnotation json->model : "
                + gson.fromJson(json, type).toString());

        gson = new GsonBuilder().serializeNulls().create();
        System.out.println("serializeNulls model->json : " + gson.toJson(animModel));
        System.out.println("serializeNulls json->model : " + gson.fromJson(json, type).toString());

        gson = new GsonBuilder().setVersion(2.0).create();
        System.out.println("setVersion2 model->json : " + gson.toJson(animModel));
        System.out.println("setVersion2 json->model : " + gson.fromJson(json, type).toString());

        gson = new GsonBuilder().setVersion(3.0).create();
        System.out.println("setVersion3 model->json : " + gson.toJson(animModel));
        System.out.println("setVersion3 json->model : " + gson.fromJson(json, type).toString());

        gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
                .create();
        System.out.println("setPrettyPrinting model->json : " + gson.toJson(animModel));
        json = "{\"noSave\":22222222,\"code2\":234,\"code3\":345,\"code4\":456,\"list\":null,\"name\":\"weatherfish\",\"birthday\":\"2015-11-23 14:26:53:892\"}";
        System.out
                .println("setPrettyPrinting json->model : " + gson.fromJson(json, type).toString());

    }

    private static void TestComplexModel() {
        Gson gson = new Gson();
        ComplexModel complexModel = new ComplexModel();
        complexModel.setCode(333);
        List<SimpleModel> list = new ArrayList<>();
        SimpleModel model = new SimpleModel();
        model.setId(12);
        model.setName("weatherfish");
        model.setBirthday(new Date());
        list.add(model);
        complexModel.setList(list);
        complexModel.setModel(model);
        String complexJson = gson.toJson(complexModel);
        System.out.println("Complex->Json: " + complexJson);

        Type type = new TypeToken<ComplexModel>() {
        }.getType();
        ComplexModel complexModel2 = gson.fromJson(complexJson, type);
        System.out.println(complexModel2.toString());
    }

    public static void TestSimpleModel() {
        Gson gson = new Gson();
        SimpleModel model = new SimpleModel();
        model.setId(12);
        model.setName("weatherfish");
        model.setBirthday(new Date());
        String json = gson.toJson(model);
        System.out.println("simpleModel to json : " + json);

        SimpleModel model2 = gson.fromJson(json, SimpleModel.class);
        System.out.println("json-> simpleModel : " + model2.toString());
    }

}
