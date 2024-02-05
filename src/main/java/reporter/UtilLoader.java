package reporter;

import utils.helpers.PropertyUtils;

public class UtilLoader {

    public static PropertyUtils propertyUtils;

    public void loadUtilsFactory(){
        propertyUtils = new PropertyUtils();
    }
}
