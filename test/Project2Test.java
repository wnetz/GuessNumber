import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Project2Test
{
    private static File f;
    private static Scanner scan;
    private Project2 p;
    @BeforeAll
    static void prep()
    {
        f = new File("./test/testInput.txt");
        try
        {
            scan = new Scanner(f);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("file not found");
        }

    }
    @Test
    @Order(1)
    void testvalidInput()
    {
        p = new Project2(scan);
        assertAll("test input",
                () -> assertEquals(1,p.userInput()),
                () -> assertEquals(20,p.userInput())
        );
    }
    @Test
    @Order(2)
    void testInvalidInput()
    {
        p = new Project2(scan);
        assertEquals(-1,p.userInput());
    }
    @Test
    @Order(3)
    void testall()
    {
        p = new Project2(scan);
        assertEquals(0,p.run());
    }
    @AfterAll
    static void clean()
    {
        scan.close();
    }
}