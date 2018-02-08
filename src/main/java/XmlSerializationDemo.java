import com.example.myschema.ObjectFactory;
import com.example.myschema.ShipOrder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static java.lang.Boolean.TRUE;
import static javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;

public class XmlSerializationDemo {

    private static String packageName = ShipOrder.class.getPackage().getName();

    public static void main(String[] args) throws Exception {

        ObjectFactory objectFactory = new ObjectFactory();
        ShipOrder emptyOrder = objectFactory.createShipOrder();
        writeToFile(emptyOrder, "target/emptyOrder.xml");

        ShipOrder readOrder = readFromFile("order.xml");
        System.out.println(readOrder.getOrderPerson());

        readOrder.setOrderPerson("Jean");
        writeToFile(readOrder, "target/orderForJean.xml");
    }

    private static ShipOrder readFromFile(String fileName) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(packageName);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (ShipOrder) unmarshaller.unmarshal(new FileInputStream(fileName));
    }

    private static void writeToFile(ShipOrder shiporder, String fileName) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(packageName);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(JAXB_FORMATTED_OUTPUT, TRUE);
        marshaller.marshal(shiporder, new FileOutputStream(fileName));
    }
}
