package starter.com.challenge.tiempo.metrologico.exceptions;

import java.io.Serializable;

public class FileException extends RuntimeException implements Serializable {

    private final String file;
    private final String fileName;
    private final transient Object fieldValue;

    private static FileException instance;

    private FileException(String file, String fileName, Object fieldValue) {
        super(String.format(
                "%s located in '%s' was not found or contains block errors : '%s'", file, fileName, fieldValue
        ));
        this.file = file;
        this.fileName = fileName;
        this.fieldValue = fieldValue;
    }

    public static FileException getInstance(String file, String fileName, Object fieldValue) {
        if (getObject() == null) {
            setObject(new FileException(file, fileName, fieldValue));
            return getObject();

        }
        return getObject();
    }

    private static void setObject(FileException instance) {
        FileException.instance = instance;
    }

    private static FileException getObject() {
        return instance;
    }

    public String getFile() {
        return file;
    }

    public String getFileName() {
        return fileName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

}
