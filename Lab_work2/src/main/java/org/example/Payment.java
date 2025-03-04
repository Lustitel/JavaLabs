package org.example;

import java.util.Objects;

public class Payment
{
    String  fullName;//  ФИО человека
    int payment_date;//  дата  платежа
    int month;//месяц
    int year;// год
    int payment_amount;//  сумма платежа

    public Payment(String fullName,int payment_date,int month,int year,int payment_amount) {

        if(fullName == null || fullName.isEmpty()) throw new IllegalArgumentException("Ожидалось передача значения для fullName!");
        else this.fullName = fullName;

        if(payment_date <1 || payment_date >31) throw new IllegalArgumentException("Дата не должна выходить за пределы 31 или быть меньше 1!");
        else this.payment_date = payment_date;

        if(payment_amount <1) throw new IllegalArgumentException("Платеж не может быть отрицательным!");
        else this.payment_amount=payment_amount;

        if(month <1 || month >12) throw new IllegalArgumentException("Месяц не должен выходить за пределы 12 или быть меньше 1!");
        else this.month=month;

        if(year <1) throw new IllegalArgumentException("Год не может быть отрицательным!");
        else this.year=year;
    }

    public String getfullName(){return fullName;}
    public int getpayment_date(){return payment_date;}
    public int getMonth(){return month;}
    public int getYear(){return year;}
    public int getPayment_amount(){return payment_amount;}

    public void setfullName(String fullName){
        if(fullName == null || fullName.isEmpty()) throw new IllegalArgumentException("Ожидалось передача значения для fullName!");
        else this.fullName = fullName;
    }
    public void setPayment_date(int payment_date){
        if(payment_date <1 || payment_date >31) throw new IllegalArgumentException("Дата не должна выходить за пределы 31 или быть меньше 1!");
        this.payment_date=payment_date;
    }
    public void setYear(int year){
        if(year <1) throw new IllegalArgumentException("Год не может быть отрицательным!");
        else this.year=year;
    }
    public void setMonth(int month){
        if(month <1 || month >12) throw new IllegalArgumentException("Месяц не должен выходить за пределы 12 или быть меньше 1!");
        else this.month=month;
    }
    public void setPayment_amount(int payment_amount){

        if(payment_amount <1) throw new IllegalArgumentException("Платеж не может быть отрицательным!");
        else this.payment_amount=payment_amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { // проверка на идентичность
            return true;
        }
        if (!(obj instanceof Payment other)) { // проверка типа объекта
            return false;
        }
        return this.fullName.equals(other.fullName) &&
                this.payment_date == other.payment_date &&
                this.payment_amount == other.payment_amount &&
                this.month == other.month &&
                this.year == other.year; // сравнение содержимого
    }

    @Override
    public int hashCode() {return Objects.hash(fullName, payment_date, month,year, payment_amount);}

    @Override
    public String toString() {
        return "Платит[" +
                "Имя: " + fullName +
                ", Дата: " + payment_date + "." + month + "." + year +
                ", Сумма: " + payment_amount/100 + "руб." + payment_amount%100 +"коп." +
                ']';
    }
}