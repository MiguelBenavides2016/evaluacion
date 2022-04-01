package cl.evaluation.service;

import cl.evaluation.repository.PhoneRepository;
import cl.evaluation.dto.RegisterDto;
import cl.evaluation.model.Phone;
import cl.evaluation.model.Users;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class PhoneService {

    private final PhoneRepository phoneRepository;

    @Transactional
    public Collection<Phone> saveAll(Users users, RegisterDto registerDto) {
        log.info("saveAll | users={}, registerDto={}", users, registerDto);
        return saveAll(Phone.from(users, registerDto));
    }

    @Transactional
    public Collection<Phone> saveAll(Collection<Phone> phones) {
        log.info("saveAll | phones={}",phones);
        return phoneRepository.saveAll(phones);
    }
}
