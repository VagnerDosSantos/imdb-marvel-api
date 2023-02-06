package port.filmes.parser;

import org.json.JSONObject;

public class Json {
    public static String getString(Object json, String key) {
        JSONObject jsonObject = ((JSONObject) json);

        if (jsonObject.isNull(key)) {
            return null;
        }

        return jsonObject.getString(key);
    }

    public static Integer getInteger(Object json, String key) {
        JSONObject jsonObject = ((JSONObject) json);

        if (jsonObject.isNull(key)) {
            return null;
        }

        return jsonObject.getInt(key);
    }
}
