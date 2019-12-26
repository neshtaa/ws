import org.junit.jupiter.api.Test;
import org.junit.Assert;

class Lab7Test {

	@Test
	void test() {
		tostr toBinStr = (int x) -> Integer.toBinaryString(x);
        counter oneCounter = (int x) -> (int)toBinStr.convert(x).chars().filter(ch -> ch == '1').count();
        int expected = 5;
        int x = 31; //0001 1111
        
        Assert.assertEquals(expected, oneCounter.count(x));
	}

}
