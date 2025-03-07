package org.example.filter;

public class EndStringFilter implements Filter {
    //Проверка, что строка заканчивается на определенную подстроку.
    private String pattern;

    //  При создании объекта класса конструктор получает на вход и сохраняет строку pattern.
    public EndStringFilter(String pattern) {
        if (pattern == null) throw new IllegalArgumentException("EndFilter constructor: argument is null");
        this.pattern = pattern;
    }

    @Override
    //  Метод apply(str) проверяет, что строка str заканчивается подстрокой pattern.
    public boolean apply(String str) {//  Метод apply(str) проверяет, что строка str заканчивается подстрокой pattern.
        if (str == null) throw new IllegalArgumentException("EndFilter apply: argument is null");
        return str.endsWith(pattern);
    }
}