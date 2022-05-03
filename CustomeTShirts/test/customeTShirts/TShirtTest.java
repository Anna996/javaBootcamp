package customeTShirts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import customeTShirts.Tshirt.Size;

class TShirtTest {
	private Tshirt tShirt;
	
	public TShirtTest() {
		tShirt = new Tshirt();
	}

	@Test
	void checkFieldsValue() {
		assertEquals(Size.S, tShirt.size);
		assertEquals(0.1, tShirt.demandFactor);
		assertEquals(3.0, tShirt.besePrice);
	}
	
	@Test
	void checkSetSize() {
		tShirt.setSize(null);
		assertEquals(Size.S, tShirt.size);
		tShirt.setSize(Size.L);
		assertEquals(Size.L, tShirt.size);
		tShirt.setSize(Size.M);
		assertEquals(Size.M, tShirt.size);
	}
	
	
	@Test
	void checkSetDesign() {
		tShirt.setDesign(null);
		Design design = tShirt.design;
		assertEquals(20.0, design.width);
		assertEquals(10.0, design.height);
		assertEquals(1.0, design.complexity);
		assertEquals("T Shirt", design.slogan);
		assertEquals(0, design.color.red);
		assertEquals(0, design.color.green);
		assertEquals(0, design.color.blue);
		
		design =new Design(20, 10.2, "Hola 2022", new Color(142, 172, 152), 20);
		tShirt.setDesign(design);
		assertEquals(20, design.width);
		assertEquals(10.2, design.height);
		assertEquals(20, design.complexity);
		assertEquals("Hola 2022", design.slogan);
		assertEquals(142, design.color.red);
		assertEquals(172, design.color.green);
		assertEquals(152, design.color.blue);
	}	
	
	@Test
	void checkSetDemandFactor() {
		tShirt.setDemandFactor(0);
		assertEquals(0.1, tShirt.demandFactor);
		tShirt.setDemandFactor(5);
		assertEquals(0.1, tShirt.demandFactor);
		tShirt.setDemandFactor(0.3);
		assertEquals(0.3, tShirt.demandFactor);
	}	
	
	@Test
	void checkSetBesePrice() {
		tShirt.setBesePrice(1);
		assertEquals(3.0, tShirt.besePrice);
		tShirt.setBesePrice(3);
		assertEquals(3.0, tShirt.besePrice);
		tShirt.setBesePrice(20);
		assertEquals(20.0, tShirt.besePrice);
	}
	
	@Test
	void checkIsExpensive() {
		assertEquals(false, tShirt.isExpensive());
		setTShirt1();
		assertEquals(true, tShirt.isExpensive());
	}
	
	@Test
	void checkCalculateFinalPrice(){
		assertEquals(8000, tShirt.calculateFinalPrice());
		setTShirt1();
		assertEquals(12750, tShirt.calculateFinalPrice());
	}
	
	private void setTShirt1() {
		tShirt = new Tshirt(Size.L, null, 0.8, 50);
	}
}
