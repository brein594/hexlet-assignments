package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;
import java.util.HashMap;



class ValidationTest {

    @Test
    void testValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        List<String> result1 = Validator.validate(address1);
        List<String> expected1 = List.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        List<String> result2 = Validator.validate(address2);
        List<String> expected2 = List.of("country");
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        List<String> result3 = Validator.validate(address3);
        List<String> expected3 = List.of("city", "street", "houseNumber");
        assertThat(result3).isEqualTo(expected3);
    }



    // BEGIN
    @Test
    void advancedValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        Map<String, List<String>> result4 = Validator.advancedValidate(address1);
        List<String> key = List.of();
        Map<String, List<String>> expected4 = Map.of();
        assertThat(result4).isEqualTo(expected4);

        Address address2 = new Address("USA", "Texas", null, "7", "2");
        Map<String, List<String>> result5 = Validator.advancedValidate(address2);

        //Map<String, List<String>> expected5 = Map.of("country", List.of("length less than 3"), "street", List.of("can not be null"));
        Map<String, List<String>> expected5 = Map.of("street", List.of("can not be null"));
        assertThat(result5).isEqualTo(expected5);
    }
    // END
}
