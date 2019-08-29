package group.slsd.mapper;

import org.junit.Test;

import group.slsd.validator.PhoneConstraintValidator;
import junit.framework.Assert;

public class PhoneValidatorTest {

	@Test
	public void test1() {
		PhoneConstraintValidator validator = new PhoneConstraintValidator();

		boolean valid = validator.isValid("15606885785", null);

		System.out.println(valid);

	}
}
