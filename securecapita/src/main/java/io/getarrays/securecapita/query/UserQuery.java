package io.getarrays.securecapita.query;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class UserQuery
{
    public static final String INSERT_USER_QUERY = "INSERT INTO Users (first_name, last_name, email, password) values (:firstName, :lastName, :email, :password)";
    public static final String COUNT_USER_EMAIL_QUERY = "SELECT COUNT(*) FROM Users WHERE email = :email";
    public static final String ACCOUNT_VERIFICATION_URL_QUERY = "INSERT INTO AccountVerifications (user_id, url) VALUES (:userId, :url)";
}
