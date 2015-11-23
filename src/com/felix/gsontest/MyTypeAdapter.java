package com.felix.gsontest;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
* Descript：
* @auther：weatherfish
* Create time：2015年11月23日 下午3:03:45
* @version
*/

public class MyTypeAdapter extends TypeAdapter<SimpleModel> {

    @Override
    public SimpleModel read(JsonReader reader) throws IOException {
        if(reader.hasNext()){
            
        }
        return null;
    }

    @Override
    public void write(JsonWriter writer, SimpleModel value) throws IOException {
        if(value == null)
            writer.nullValue();
        else
            writer.value(value.toString());
    }

}


