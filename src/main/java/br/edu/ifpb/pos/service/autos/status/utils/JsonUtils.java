package br.edu.ifpb.pos.service.autos.status.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class JsonUtils {

    public static <T> T converterJsonEmLista(String json, T list){
        JsonArray array = (JsonArray) new JsonParser().parse(json);
        Type listType = new TypeToken<T>() {}.getType();
        T result = new Gson().fromJson(array, listType);
        return result;
    }
    
    public static <T> T converterJsonEmObjeto (String json, Class<T> type){
        return (T) new Gson().fromJson(json, type);
    }
    
    public static String converterObjectEmJson (Object src, Class type){
        return new Gson().toJson(src, type);
    }
    
}
