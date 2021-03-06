package cl.evaluation.controller;

import cl.evaluation.exception.EvaluationException;
import cl.evaluation.service.AuthorizationService;
import cl.evaluation.dto.RegisterDto;
import cl.evaluation.helper.MessageHelper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(path = "/authorization", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(
            @Valid @NotNull(message = MessageHelper.MESSAGE_NOT_NULL)
            @RequestBody RegisterDto registerDto) throws EvaluationException {
        log.info("register | registerDto={}", registerDto.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(authorizationService.register(registerDto));
    }
}
