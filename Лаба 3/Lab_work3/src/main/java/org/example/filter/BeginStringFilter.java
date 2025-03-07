package org.example.filter;

public class BeginStringFilter implements Filter
// TODO: Класс BeginStringFilter, реализующий этот интерфейс, со следующим поведением.
{
    private final String pattern;

    public BeginStringFilter(String pattern)
    //  При создании объекта класса конструктор получает на вход и сохраняет строку pattern.
    {
        if (pattern == null) throw new IllegalArgumentException("Строчка не может быть null!");
        this.pattern = pattern;
    }

    @Override
    public boolean apply(String str)
    //  Метод apply(str) проверяет, что строка str начинается с подстроки pattern.
    {
        if (str == null) {
            return false;
        }
        return str.startsWith(pattern);
    }
}