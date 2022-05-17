package cars;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Runner {
	private static final String FILE_NAME = "myFiles/cars.xml";
	private static final String CARS = "cars";
	private static final String CAR = "car";
	private static final String MANUFACTURER = "manufacturer";
	private static final String MODEL = "model";
	private static final String YEAR = "year";
	private static final String LICENCE_PLATE = "licence_plate";
	private static final String PLATE_NUMBER = "plate_number";
	private static final String COLOR = "color";

	public static void main(String[] args) {

		List<Car> carList = Arrays.asList(new Car("Honda", "A", 2020, new LicencePlate("Yellow")),
				new Car("Toyota", "Chr", 2022, new LicencePlate("White")),
				new Car("BMW", "Gold", 2018, new LicencePlate("White")));

		saveCarListToXML(carList);

		List<Car> listFromXML = getCarListFromXML();
		listFromXML.forEach(System.out::println);

	}

	public static void saveCarListToXML(List<Car> carList) {
		Element rootElement = new Element(CARS);
		Document document = new Document(rootElement);

		for (Car car : carList) {
			Element carElement = getCarElement(car);
			rootElement.addContent(carElement);
		}

		try {
			File file = new File(FILE_NAME);
			OutputStream outputStream = new FileOutputStream(file);
			XMLOutputter xmlOutputter = new XMLOutputter();
			xmlOutputter.setFormat(Format.getPrettyFormat());
			xmlOutputter.output(document, outputStream);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Element getCarElement(Car car) {
		Element carElement = new Element(CAR);
		List<Element> elements = new LinkedList<>();

		Element manufacturer = new Element(MANUFACTURER);
		manufacturer.setText(car.getManufacturer());
		elements.add(manufacturer);

		Element model = new Element(MODEL);
		model.setText(car.getModel());
		elements.add(model);

		Element year = new Element(YEAR);
		year.setText(String.valueOf(car.getYear()));
		elements.add(year);

		Element licencePlate = new Element(LICENCE_PLATE);
		Element number = new Element(PLATE_NUMBER);
		number.setText(String.valueOf(car.getLicencePlate().getPLATE_NUMBER()));
		number.setAttribute("unique", "true");
		licencePlate.addContent(number);
		licencePlate.addContent(new Element(COLOR).setText(car.getLicencePlate().getColor()));
		elements.add(licencePlate);

		carElement.addContent(elements);
		return carElement;
	}

	public static List<Car> getCarListFromXML() {
		List<Car> listFromXML = new LinkedList<>();

		File file = new File(FILE_NAME);
		SAXBuilder saxBuilder = new SAXBuilder();

		try {
			Document document = saxBuilder.build(file);
			Element carList = document.getRootElement();
			List<Element> cars = carList.getChildren();

			for (Element car : cars) {
				Car carObject = getCarObject(car);
				listFromXML.add(carObject);
			}

		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listFromXML;
	}

	private static Car getCarObject(Element car) {
		String manufacturer = car.getChildText(MANUFACTURER);
		String model = car.getChildText(MODEL);
		int year = Integer.parseInt(car.getChildText(YEAR));

		Element LicencePlate = car.getChild(LICENCE_PLATE);
		long number = Long.parseLong(LicencePlate.getChildText(PLATE_NUMBER));
		String color = LicencePlate.getChildText(COLOR);

		return new Car(manufacturer, model, year, new LicencePlate(number, color));
	}
}
