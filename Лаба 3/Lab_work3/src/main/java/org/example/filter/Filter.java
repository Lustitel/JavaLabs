package org.example.filter;

public interface Filter
//TODO:Интерфейс «Фильтр» с единственным методом apply.
// Метод получает на вход строку
// и возвращает логическое значение (строка удовлетворяет условию фильтра или нет).
{
    boolean apply(String str);
}