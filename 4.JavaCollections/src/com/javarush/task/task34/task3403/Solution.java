package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
Разложить целое число n > 1 на простые множители.
Вывести в консоль через пробел все множители в порядке возрастания.
Написать рекурсивный метод для вычисления простых множителей.
Не создавай в классе Solution дополнительные поля.

Пример:
132

Вывод на консоль:
2 2 3 11


*/
public class Solution {
    public void recurse(int n) {

        for (int i = 2; i <= n; i++) {
            if(n%i == 0){
                System.out.print(i + " ");
                recurse(n / i);
                break;
        }
        }
    }

    public static void main(String[] args) {
        new Solution().recurse(132);
    }
}
