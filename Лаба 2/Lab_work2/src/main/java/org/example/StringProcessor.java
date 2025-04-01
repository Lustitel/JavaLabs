package org.example;

public class StringProcessor{
    public String StringCopy(String s, int n) throws IllegalArgumentException
    {
        if (n < 0) {throw new IllegalArgumentException("N должно быть неотрицательным");}
        if (n == 0) {s = "";}
        else s = s.repeat(n);
        return s;
    }
    public int CountSecondInFirst(String s1, String s2) throws IllegalArgumentException
    {
        if (s2 == null || s2.isEmpty()) throw new IllegalArgumentException("String is empty or null!");
        int str_count = 0; //Считает колличество вхождений строки
        int str_index = 0; //Начальный индекс поиска
        while ((str_index = s1.indexOf(s2, str_index)) != -1) //indexOf ищет s2 в s1, начиная с позиции str_index. Если подстрока s2 найдена...
        {//str_index будет обновлен на позицию первого вхождения. Если подстрока не найдена, indexOf возвращает -1, и цикл завершится.
            str_count ++;//Увеличиваем счётчик второй строки в первой
            str_index ++;//Увличиваем индекс поиска на длину найленной строки
        }
        return str_count;
    }

    public String stringReplacer(String str) throws IllegalArgumentException
    {
        if ((str == null)) {throw new IllegalArgumentException("String most not be null!");}
        str = str.replace("1", "один").replace("2", "два").replace("3", "три");

        return str;
    }

    public StringBuilder DeleteSecond(StringBuilder str) throws IllegalArgumentException
    {
        if ((str == null)) {throw new IllegalArgumentException("String must not be null!");}
        for (int i=1; i<str.length(); i++){
            str.deleteCharAt(i);// В цикле вызываем метод deleteCharAt(i), чтобы удалить i-ый символ. После удаления символа длина строки уменьшается на 1
        }
        return str;
    }

}


