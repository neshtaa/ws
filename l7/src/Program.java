public class Program {

	public static void main(String args[])
    {
        int startValue = 2;
        int endValue = 100;
        int maxCount = 0; 
        int maxVal = 0;
        
        tostr toBinStr = (int x) -> Integer.toBinaryString(x);
        counter oneCounter = (int x) -> (int)toBinStr.convert(x).chars().filter(ch -> ch == '1').count();
        
        outer:for(int i = startValue; i < endValue; i++)
        {
            for(int j = 2; j < i; j++)
            if(i%j == 0) continue outer;
            int count = oneCounter.count(i);
            if(count > maxCount) {maxCount = count; maxVal = i;};
        }
        System.out.println("Количество единиц:" + maxCount);
        System.out.println("Число:" + maxVal);
    }
}
