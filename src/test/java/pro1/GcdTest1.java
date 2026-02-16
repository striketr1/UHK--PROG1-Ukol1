package pro1;
import org.junit.jupiter.api.Assertions;

class GcdTest1
{
    @org.junit.jupiter.api.Test
    void test1()
    {
        Assertions.assertEquals(
                10,
                NumericUtils.gcd(20,50)
        );
    }

    @org.junit.jupiter.api.Test
    void test2()
    {
        Assertions.assertEquals(
                20,
                NumericUtils.gcd(240,100)
        );
    }

    @org.junit.jupiter.api.Test
    void test3()
    {
        Assertions.assertEquals(
                1,
                NumericUtils.gcd(60,1)
        );
    }

    @org.junit.jupiter.api.Test
    void test4()
    {
        Assertions.assertEquals(
                10,
                NumericUtils.gcd(10,50)
        );
    }

    @org.junit.jupiter.api.Test
    void test5()
    {
        Assertions.assertEquals(
                1,
                NumericUtils.gcd(7907,7919)
        );
    }

    @org.junit.jupiter.api.Test
    void test6()
    {
        Assertions.assertEquals(
                10,
                NumericUtils.gcd(10,10)
        );
    }
}