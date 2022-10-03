package starter.com.challenge.tiempo.metrologico.exceptions;

import java.io.Serializable;

public class ReadDataException extends RuntimeException implements Serializable {

    private final String data;
    private final String dataName;
    private final transient Object fieldValue;

    private static ReadDataException instance;

    private ReadDataException(String data, String dataName, Object fieldValue) {
        super(String.format(
                "%s contained in the file called '%s' presents binary array error conversion at : '%s'", data, dataName, fieldValue
        ));
        this.data = data;
        this.dataName = dataName;
        this.fieldValue = fieldValue;
    }

    public static ReadDataException getInstance(String data, String dataName, Object fieldValue) {
        if (getObject() == null) {
            setObject(new ReadDataException(data, dataName, fieldValue));
            return getObject();

        }
        return getObject();
    }

    private static void setObject(ReadDataException instance) {
        ReadDataException.instance = instance;
    }

    private static ReadDataException getObject() {
        return instance;
    }

    public String getData() {
        return data;
    }

    public String getDataName() {
        return dataName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
