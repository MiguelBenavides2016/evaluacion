package cl.evaluation.service;

import cl.evaluation.exception.EvaluationException;
import cl.evaluation.dto.RegisterDto;
import cl.evaluation.model.Users;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class AuthorizationService {

    private final UsersService usersService;
    private final PhoneService phoneService;

    @Transactional
    public Users register(RegisterDto registerDto) throws EvaluationException {
        log.info("register | registerDto={}", registerDto);
        usersService.validNotExistByEmail(registerDto.getEmail());
        Users users = usersService.save(registerDto);
        phoneService.saveAll(users, registerDto);
        return users;
    }
}
