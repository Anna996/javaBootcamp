package customeTShirts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class DesignTest {

	private Design design;

	@BeforeEach
	void initDesign() {
		design = new Design();
	}

	@Test
	void checkFieldsValue() {
		assertEquals(20.0, design.width);
		assertEquals(10.0, design.height);
		assertEquals("T Shirt", design.slogan);
		assertArrayEquals(getColorEmptyValues(), getColorValues(design.color));
		assertEquals(1.0, design.complexity);
	}

	short[] getColorEmptyValues() {
		return new short[] { 0, 0, 0 };
	}

	short[] getColorValues(Color color) {
		return new short[] { color.red, color.green, color.blue };
	}

	@Test
	void checkSetHeight() {
		design.setHeight(5);
		assertEquals(10.0, design.height);
		design.setHeight(40);
		assertEquals(10.0, design.height);
		design.setHeight(20);
		assertEquals(20.0, design.height);
	}

	@Test
	void checkSetSlogan() {
		String str = "Israel 2022";
		design.setSlogan(str);
		assertEquals(str, design.slogan);
		str = "Israel @@@";
		design.setSlogan(str);
		assertEquals("T Shirt", design.slogan);
	}

	@Test
	void checkSetComplexity() {
		design.setComplexity(0.5);
		assertEquals(1.0, design.complexity);
		design.setComplexity(120);
		assertEquals(1.0, design.complexity);
		design.setComplexity(25);
		assertEquals(25.0, design.complexity);
	}

	@Test
	void checkSetColor() {
		design.setColor(null);
		assertArrayEquals(getColorEmptyValues(), getColorValues(design.color));
		Color color = new Color(100, 255, 255);
		design.setColor(color);
		assertArrayEquals(getColorValues(color), getColorValues(design.color));
		color = new Color(500, 255, 255);
		design.setColor(color);
		assertArrayEquals(new short[] { 0, 255, 255 }, getColorValues(design.color));
	}
	
	@Test
	void checkcalculateArea() {
		assertEquals(20*10, design.calculateArea());
	}

}
