package org.example;

import java.util.ArrayList;
import java.util.List;

public class FinanceReportProcessor
// TODO: Задание №11
//  Создайте новый класс FinanceReportProcessor, в котором реализуйте статические  методы,
//  все методы возвращают объект класса FinanceReport:
//  1) получение платежей всех людей, чья фамилия начинается на указанный символ  (символ — входной параметр),
//  2) получение всех платежей, размер которых меньше заданной величины.
{
    public static void main(String[] args) {
        FinanceReport new_report;
        Payment user_1 = new Payment("Илья", 12, 2, 2000, 15345);
        Payment user_2 = new Payment("Максим", 25, 4, 2014, 352345);
        Payment user_3 = new Payment("Иван", 5, 6, 2020, 5435);

        Payment[] payments = {user_1, user_2, user_3};
        new_report = new FinanceReport(payments, "Максим Юрьевич", 8, 12, 2024);


        String old_str_report = new_report.toString();
        System.out.println(old_str_report);

        List<Payment> valuePayments = null;
        List<Payment> minPayments = null;
        int id1 = 1, id2 = 1;

        try {
            minPayments = FinanceReportProcessor.getPaymentsOnMinPayment(new_report, -50000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            assert minPayments != null;
            try {
                for (Payment i : minPayments) {
                    System.out.println("№" + id2++ + " Начинается следующий плательщик: \t" + i);
                }
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }


        try {
            valuePayments = FinanceReportProcessor.getPaymentsChar(new_report, '\u0000');
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            assert valuePayments != null;
            try {
                for (Payment i : valuePayments) {
                    System.out.println("№" + id1++ + " Начинается следующий плательщик: \t" + i);
                }
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }

    public static List<Payment> getPaymentsChar(FinanceReport obj, char user_char) {
        if (obj == null || user_char == '\u0000') {
            throw new IllegalArgumentException("Expected: obj == null" +
                    " or user_char is Empty");
        } else {
            List<Payment> paymentStartChar = new ArrayList<>();

            Payment old_payment;
            String str_forPaymentChar;

            for (int i = 0; i < obj.getLengthPayments(); i++) {

                old_payment = obj.getIndexPayments(i);
                str_forPaymentChar = old_payment.getfullName();

                if (str_forPaymentChar.startsWith(String.valueOf(user_char).toUpperCase())) {
                    paymentStartChar.add(old_payment);
                }
            }
            return paymentStartChar;
        }
    }

    public static List<Payment> getPaymentsOnMinPayment(FinanceReport obj, int user_payment) {
        if (obj == null || user_payment < 0) {
            throw new IllegalArgumentException("Expected: obj == null" +
                    " or user_payment <0");
        } else {
            List<Payment> paymentsOnMinPayment = new ArrayList<>();

            Payment old_payment;
            int int_forMinPayment;

            for (int i = 0; i < obj.getLengthPayments(); i++) {

                old_payment = obj.getIndexPayments(i);
                int_forMinPayment = old_payment.getPayment_amount();

                if (int_forMinPayment < user_payment) {
                    paymentsOnMinPayment.add(obj.getIndexPayments(i));
                }
            }
            return paymentsOnMinPayment;
        }

    }
}