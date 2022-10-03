package starter.com.challenge.tiempo.metrologico.tasks;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://ovc.catastro.meh.es")
public class BaseUrl {

    private static BaseUrl instance;

    private BaseUrl() {}

    public static BaseUrl getInstance() {
        if (getObject() == null) {
            setObject(new BaseUrl());
            return getObject();
        }
        return getObject();
    }

    private static BaseUrl getObject() {
        return BaseUrl.instance;
    }

    private static void setObject(BaseUrl object) {
        instance = object;
    }

    public String getUrl() {
        return BaseUrl.getInstance().getClass().getAnnotation(DefaultUrl.class).value();
    }

}
