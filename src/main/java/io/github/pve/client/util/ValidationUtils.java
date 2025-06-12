package io.github.pve.client.util;

import io.github.pve.client.exception.PveClientValidationException;
import io.github.pve.client.model.Validatable;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;


import java.util.Set;

public class ValidationUtils {
    private static final Validator validator;

    static {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
    }

    /**
     * 校验一个对象，但仅当该对象实现了 Validatable 接口时才执行。
     *
     * @param object 要校验的对象
     */
    public static <T> void validate(T object) {
        // 只有实现了 Validatable 接口的对象才会被校验。
        if (!(object instanceof Validatable)) {
            return;
        }

        Set<ConstraintViolation<T>> violations = validator.validate(object);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder("参数校验失败: ");
            for (ConstraintViolation<T> v : violations) {
                sb.append("[属性 '").append(v.getPropertyPath()).append("' 的值 '")
                        .append(v.getInvalidValue()).append("' 不满足约束: ");
                if (v.getMessage() != null || v.getMessage().isEmpty()) {
                    sb.append("It must not be empty.");
                } else {
                    sb.append(v.getMessage());
                }
                sb.append("]; ");
            }
            throw new PveClientValidationException(sb.toString());
        }
    }
}
