package group.slsd.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import group.slsd.validator.annotation.Phone;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description：针对 group.slsd.validator.annotation.Phone 的验证
 * @author 0
 * @date 2019年8月29日 下午9:20:21
 */
@Slf4j
public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {

	private Pattern p = Pattern.compile("^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(value)) {
			return false;
		}
		Matcher matcher = p.matcher(value);
		return matcher.matches();
	}

}
