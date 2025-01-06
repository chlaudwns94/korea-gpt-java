package com.korit.main;

@FunctionalInterface
interface 무기 {
    String 공격(Integer 데미지);
}

class 총 implements 무기   {
    @Override
    public String 공격(Integer 데미지) {
        System.out.println("데미지: " + 데미지);
        System.out.println("총을 쏜다");
        return "총 데미지: " + 데미지;
    }
}


public class Main5 {
    public static void main(String[] args) {
        무기 wp1 = new 총() ;
        wp1.공격(100);

        무기 wp2 = new 무기() {
            @Override
            public String  공격(Integer 데미지) {
                System.out.println("데미지: " + 데미지);
                System.out.println("만든 무기로 공격");
                return "커스텀 무기 데미지: " + 데미지;
            }
        };

        wp2.공격(70);


        무기 wp3 = (Integer 데미지) -> {System.out.println("데미지: " + 데미지);
                System.out.println("람다로 만든 무기로 공격");
        return "람다 무기 데미지: " + 데미지;
        };
        wp3.공격(90);

        // 매개변수 자료형 생략 가능
        무기 wp4 = (데미지) -> {
            System.out.println("데미지: " + 데미지);
            System.out.println("람다로 만든 무기로 공격");
            return "람다 무기 데미지: " + 데미지;
        };
        wp4.공격(90);

        // 매개변수 하나면 () 생략 가능
        무기 wp5 = 데미지 -> {
            System.out.println("데미지: " + 데미지);
            System.out.println("람다로 만든 무기로 공격");
            return "람다 무기 데미지: " + 데미지;
        };
        wp5.공격(90);

        // 리턴 값이 있는 경우 {}를 생략하고 바로 리턴 값을 입력할수 있다.
        무기 wp6 = 데미지 -> "람다 무기 데미지: " + 데미지;

        wp6.공격(90);

    }
}
