package customeTShirts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_METHOD)
class ColorTest {
	private Color[] colors;
	private int[][] fields;

	public ColorTest() {
		fields = new int[][] { new int[] { -5, 150, 255 }, new int[] { 120, 200, 300 }, new int[] { 140, 15, 132 } };

		colors = new Color[fields.length];
		for (int i = 0; i < fields.length; i++) {
			int[] field = fields[i];
			colors[i] = new Color(field[0], field[1], field[2]);
		}
	}

	@Test
	void checkLocalArrayNotNull() {
		assertNotNull(colors);
	}

	@Test
	void checkFieldsEquality() {
		int[][] expected = new int[][] { new int[] { 0, 150, 255 }, new int[] { 120, 200, 0 },
				new int[] { 140, 15, 132 } };

		for (int i = 0; i < fields.length; i++) {
			int[] field = expected[i];
			assertEquals(field[0], colors[i].red);
			assertEquals(field[1], colors[i].green);
			assertEquals(field[2], colors[i].blue);
		}
	}

	@Test
	void checkDominantValues() {
		String[] dominants = new String[fields.length];
		dominants[0] = Color.BLUE;
		dominants[1] = Color.GREEN;
		dominants[2] = Color.RED;

		for (int i = 0; i < colors.length; i++) {
			assertEquals(dominants[i], colors[i].getDominant());
		}
	}

	@Test
	void checkNormalizedValues() {
		final int max = 255;

		float[][] normals = new float[][] { new float[] { 0, 150 / max, 255 / max },
				new float[] { 120 / max, 200 / max, 0 }, new float[] { 140 / max, 15 / max, 132 / max } };

		for (int i = 0; i < colors.length; i++) {
			float[] actual = colors[i].normalized();
			assertArrayEquals(normals[i], actual);
		}
	}

	@Test
	void checkEmptyConstractor() {
		Color color = new Color();
		assertArrayEquals(new short[] { 0, 0, 0 }, new short[] { color.red, color.green, color.blue });
	}
}
