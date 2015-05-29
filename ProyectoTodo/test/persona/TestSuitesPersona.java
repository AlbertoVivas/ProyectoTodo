/**
 * 
 */
package persona;

/**
 * @author Alberto Vivas
 *
 * 
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class) // le digo a junit que esto es una suite class
@Suite.SuiteClasses({
	TestListaPersona.class, TestPersona.class
})
public class TestSuitesPersona {
}
