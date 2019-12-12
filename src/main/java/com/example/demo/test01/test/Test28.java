package com.example.demo.test01.test;

public class Test28 {
    public static void main(String[] args) {
		/*String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2);
		
		String s3 = new String("abc");
		System.out.println(s1 == s3);*/

//		System.out.println("A");
//		new Test28();
//		new Test28();
//		
//		List list = new ArrayList();
//		System.out.println(list.size());
        BC bc = new BC();
//		System.out.println(bc.c);
    }

    /**
     *
     */
/*	public Test28() {
		// TODO Auto-generated constructor stub
		System.out.println("B");
	}
	
	{
		System.out.println("C");
	}
	static {
		System.out.println("D");
	}*/
}

class A {
    static {
        System.out.println("A");
    }
}

class BC extends A {
    static {
        System.out.println("BC");
    }

    public final static String c = "C";
}
