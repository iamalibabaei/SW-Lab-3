package usermanagement.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {

    // Our code
    private static final String TEST_COMPANY = "Test";

    @Test
    public void test_person_default_constructor() {
        Person testClass = new Person();

        testClass.setmName("mName1");
        assertEquals("mName1", testClass.getmName());

        testClass.setfName("fName1");
        assertEquals("fName1", testClass.getfName());

        testClass.setlName("lName1");
        assertEquals("lName1", testClass.getlName());
    }



    // Our code
    @Test
    public void test_set_person_company() {
        Person person = new Person();

        person.setCompanyName(TEST_COMPANY);
        assertEquals(TEST_COMPANY, person.getCompanyName());
    }

    @Test
    public void test_full_person() {
        Person person = new Person();
        person.setPersonId(1);
        person.setmName("mName1");
        person.setfName("fName1");
        person.setlName("lName1");
        person.setCompanyName(TEST_COMPANY);

        assertEquals("mName1", person.getmName());
        assertEquals("fName1", person.getfName());
        assertEquals("lName1", person.getlName());
        assertEquals(TEST_COMPANY, person.getCompanyName());
        assertEquals(1, person.getPersonId());
    }

}
