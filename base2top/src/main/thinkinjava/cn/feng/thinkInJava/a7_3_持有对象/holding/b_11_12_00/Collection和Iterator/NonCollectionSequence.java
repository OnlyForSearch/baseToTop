package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_12_00.Collection和Iterator;

//: holding/NonCollectionSequence.java

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pets;

import java.util.Iterator;

class PetSequence {

    protected Pet[] pets = Pets.createArray(8);
}

public class NonCollectionSequence extends PetSequence {

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        InterfaceVsIterator.display(nc.iterator());
    }
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;


            public boolean hasNext() {
                return index < pets.length;
            }


            public Pet next() {
                return pets[index++];
            }


            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
} /*
 * Output: 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
 */// :~
