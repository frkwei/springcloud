import java.time.ZonedDateTime;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Test {

	@ParameterizedTest
	@ValueSource(strings = {"Radar", "Rotor", "Tenet", "Madam", "Racecar"})
	public void test(String bbb) {
		ZonedDateTime z = ZonedDateTime.now();
		System.out.println(z+"   "+bbb);
	}
}
