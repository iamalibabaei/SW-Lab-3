package usermanagement.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import usermanagement.entity.Person;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TransformServiceTest {


    private static final String ALI = "Ali";
    private static final String BABAEI = "Babaei";
    private static final String TEST_COMPANY = "Test";
    private final Person person = new Person();
    private final User nullUser = new User();
    private final User user = new User();

    @InjectMocks
    private TransformService transformService;


    @Before
    public void setUp() {
        person.setPersonId(1);
        person.setfName(ALI);
        person.setlName(BABAEI);
        person.setCompanyName(TEST_COMPANY);

        nullUser.setFirstName(ALI);
        nullUser.setFirstName(BABAEI);
        nullUser.setCompanyName(TEST_COMPANY);

        user.setUserId(1);
        user.setFirstName(ALI);
        user.setLastName(BABAEI);
        user.setCompanyName(TEST_COMPANY);
    }

    @Test
    public void test_to_user_domain_unit_test() {
        User gotUser = transformService.toUserDomain(person);
        assertEquals(Integer.valueOf(1), gotUser.getUserId());
        assertEquals(person.getfName(), gotUser.getFirstName());
        assertEquals(person.getlName(), gotUser.getLastName());
        assertEquals(person.getCompanyName(), gotUser.getCompanyName());
    }

    @Test
    public void test_to_user_entity_with_user_id_unit_test() {
        Person gotPerson = transformService.toUserEntity(user);
        assertEquals(1, gotPerson.getPersonId());
        assertEquals(user.getFirstName(), gotPerson.getfName());
        assertEquals(user.getLastName(), gotPerson.getlName());
        assertEquals(user.getCompanyName(), gotPerson.getCompanyName());
    }

    @Test
    public void test_to_user_entity_with_null_id_unit_test() {
        Person gotPerson = transformService.toUserEntity(nullUser);
        assertEquals(0, gotPerson.getPersonId());
        assertEquals(nullUser.getFirstName(), gotPerson.getfName());
        assertEquals(nullUser.getLastName(), gotPerson.getlName());
        assertEquals(nullUser.getCompanyName(), gotPerson.getCompanyName());
    }
}
