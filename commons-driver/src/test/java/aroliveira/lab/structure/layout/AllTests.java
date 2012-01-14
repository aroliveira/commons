package aroliveira.lab.structure.layout;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import aroliveira.lab.structure.util.CurrencyFieldTest;
import aroliveira.lab.structure.util.DateFieldTest;
import aroliveira.lab.structure.util.IntegerFieldTest;
import aroliveira.lab.structure.util.TypedFieldConverterTest;

@RunWith(Suite.class)
@SuiteClasses({
	FieldTest.class,
	LayoutFieldTest.class, 
	LayoutTest.class,
	FileManagerTest.class,
	DriverTest.class,
	DateFieldTest.class,
	CurrencyFieldTest.class,
	IntegerFieldTest.class,
	TypedFieldConverterTest.class})
public class AllTests {
}