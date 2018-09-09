import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Arrays;

public class JavaBeanPropertyNameTrap {
    public static void main(String[] args) throws IntrospectionException {
        PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(BeanWithInappropriatePropertyName.class).getPropertyDescriptors();
        Arrays.stream(propertyDescriptors)
              .forEach(JavaBeanPropertyNameTrap::printBeanInfo);
    }

    private static void printBeanInfo(PropertyDescriptor property) {
        System.out.println("getter: " + property.getReadMethod().getName());
        System.out.println("name: " + property.getName());
        System.out.println("decapitalize as: " + Introspector.decapitalize(property.getName()));
        System.out.println();
    }
}

class BeanWithInappropriatePropertyName {
    String aName;
    private String URL;

    public String getAName() {
        return aName;
    }

    public String getURL() {
        return URL;
    }

    public void setAName(String aName) {
        this.aName = aName;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}

