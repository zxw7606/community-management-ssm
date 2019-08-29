package group.slsd.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SimplePhoneValidator implements Validator {

	private Pattern p = Pattern.compile("^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$");

	@Override
	public boolean supports(Class<?> clazz) {
		return String.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (StringUtils.isEmpty(target)) {
			errors.rejectValue("phone", "电话不能为空");
		}
		Matcher matcher = p.matcher((String) target);
		if (!matcher.matches()) {
			errors.rejectValue("phone", "电话字段不符合规范");
		}
	}

}
