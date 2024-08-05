package io.getarrays.securecapita.repository.implementation;

import io.getarrays.securecapita.domain.Role;
import io.getarrays.securecapita.domain.User;
import io.getarrays.securecapita.exception.ApiException;
import io.getarrays.securecapita.repository.RoleRepository;
import io.getarrays.securecapita.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static io.getarrays.securecapita.enumation.RoleType.*;
import static io.getarrays.securecapita.enumation.VerificationType.*;
import static io.getarrays.securecapita.query.UserQuery.*;
import static java.util.Objects.requireNonNull;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository<User> {


    private final NamedParameterJdbcTemplate jdbc;
    private final RoleRepository<Role> roleRepository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public User create(User user) {
        //Todos
        //1- Check the email is unique
        if (getEmailCount(user.getEmail().trim().toLowerCase())>0) throw new ApiException("Email already in use. Please use a different email");
        //2- Save new user

        try {
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource parameters = getSqlParameterSource(user);
            jdbc.update(INSERT_USER_QUERY, parameters, holder);
            user.setId(requireNonNull(holder.getKey()).longValue());
            //3- Add role to the user
            roleRepository.addRoleToUser(user.getId(), ROLE_USER.name());
            //4- Send verification url
            String verificationUrl = getVerificationUrl(UUID.randomUUID().toString(), ACCOUNT.getType());
            //5- Save Url is verification table
            jdbc.update(ACCOUNT_VERIFICATION_URL_QUERY,Map.of("userId", user.getId(), "url", verificationUrl));
            //6- Send email to user with verification Url
            //emailService.sendVerification(user.getFirstName(), user.getEmail(),verificationUrl, ACCOUNT);
            user.setEnabled(false);
            user.setNotLocked(true);
            //7- Return the newly created user
            return user;
            //8- If any error throw it with proper message

        } catch (Exception exception){
            log.error(exception.getMessage());
            throw new ApiException("An error occurred. Please try again later");
        }
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public User update(User data) {
        return null;
    }

    @Override
    public Collection list(int page, int pageSize) {
        return List.of();
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    private Integer getEmailCount(String email) {
        // queryForObject's parameters are; query, params, type
        return jdbc.queryForObject(COUNT_USER_EMAIL_QUERY, Map.of("email",email), Integer.class);
    }
    private SqlParameterSource getSqlParameterSource(User user) {
        return new MapSqlParameterSource()
                .addValue("firstName", user.getFirstName())
                .addValue("lastName", user.getLastName())
                .addValue("email", user.getEmail())
                .addValue("password", encoder.encode(user.getPassword()));

    }

    private String getVerificationUrl(String key, String type){
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/verify/"+type+"/"+ key).toUriString();
    }
}
