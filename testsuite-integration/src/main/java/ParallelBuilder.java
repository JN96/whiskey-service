import com.intuit.karate.Runner.Builder;
import org.junit.jupiter.api.Test;

class ParallelBuilder {

	@Test
	public void executeKarateTest() {
		Builder aRunner = new Builder();
		aRunner.path("classpath:");
		aRunner.parallel(5);
	}

}
