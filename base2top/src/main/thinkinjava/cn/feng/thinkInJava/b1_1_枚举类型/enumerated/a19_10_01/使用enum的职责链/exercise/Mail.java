package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_10_01.使用enum的职责链.exercise;
//: enumerated/PostOffice.java
// Modeling a post office.

import net.mindview.util.Enums;

import java.util.Iterator;

/**
 * 使用enum枚举的职责链
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Mail {

    static long counter = 0;
    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    long id = counter++;
    // Generate test Mail:
    public static Mail randomMail() {
        Mail m = new Mail();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }
    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>() {
            int n = count;
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    public boolean hasNext() { return n-- > 0; }
                    public Mail next() { return randomMail(); }
                    public void remove() { // Not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
    public String toString() { return "Mail " + id; }
    public String details() {
        return toString() +
                ", General Delivery: " + generalDelivery +
                ", Address Scanability: " + scannability +
                ", Address Readability: " + readability +
                ", Address Address: " + address +
                ", Return address: " + returnAddress;
    }
    // The NO's lower the probability of random selection:
    enum GeneralDelivery {
        YES, NO1, NO2, NO3, NO4, NO5
    }
    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}
    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}
    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}
    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}
}

