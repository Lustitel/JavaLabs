package org.example.filter;

public class ContainsStringFilter implements Filter
//Проверка, что строка содержит определенную подстроку.
{
    private final String pattern;

    public ContainsStringFilter(String pattern)
    //  При создании объекта класса конструктор получает на вход и сохраняет строку pattern.
    {
        if (pattern == null) throw new IllegalArgumentException("Pattern cannot be null");
        this.pattern = pattern;
    }

    @Override
    public boolean apply(String str)
    //  Метод apply(str) проверяет, что строка str содержит подстроки pattern.
    {
        if (str == null) {
            return false;
        }
        return str.contains(pattern);
    }
}