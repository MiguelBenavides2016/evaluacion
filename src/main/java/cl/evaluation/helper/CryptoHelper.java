package cl.evaluation.helper;

import cl.evaluation.exception.EvaluationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CryptoHelper {

    private final PasswordEncoder passwordEncoder;

    public String encode(String text) {
        return passwordEncoder.encode(text);
    }

    public void checkPassword(String text, String encodedText) throws EvaluationException {
        if (!validate(text, encodedText)) {
            throw new EvaluationException(MessageHelper.MESSAGE_ERROR_CHECK_PASS);
        }
    }

    public boolean validate(String text, String encodedText) {
        return passwordEncoder.matches(text, encodedText);
    }
}
