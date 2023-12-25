
package mk.ukim.mk.lab.model.attr_convertes;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class AuthorFullnameConverter implements AttributeConverter<AuthorFullName, String> {
    @Override
    public String convertToDatabaseColumn(AuthorFullName authorFullName) {
        if (authorFullName == null) return null;

        StringBuilder result = new StringBuilder();
        if (authorFullName.getName() != null) {
            result.append(authorFullName.getName()).append(" ");
        }
        if (authorFullName.getSurname() != null) {
            result.append(authorFullName.getSurname());
        }

        return result.toString();
    }

    @Override
    public AuthorFullName convertToEntityAttribute(String s) {
        AuthorFullName result = new AuthorFullName();
        String[] split = s.split(" ");
        result.setName(split[0]);
        if (split.length > 1) {
            result.setSurname(split[1]);
        }

        return result;
    }
}
