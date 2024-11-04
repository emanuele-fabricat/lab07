package it.unibo.inner.impl;

import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class UseIterableWithPolicy<T> implements IterableWithPolicy<T>{
    private T[] array;
    private Predicate<T> iteratorPolicy;

    public UseIterableWithPolicy(T[] array){
        this(array, new Predicate<T> ()
            {
                public boolean test (T elem){
                    return true;
                }
            }
        );
    }
    public UseIterableWithPolicy(T[] array, Predicate<T> method){
        this.array = array;
        this.iteratorPolicy = method;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    @Override
    public void setIterationPolicy(Predicate filter) {
        this.iteratorPolicy = filter;
    }

    public class MyIterator implements Iterator<T>{
        private int index = 0;

        @Override
        public boolean hasNext() {
            while (this.index < UseIterableWithPolicy.this.array.length){
                if(UseIterableWithPolicy.this.iteratorPolicy.test(UseIterableWithPolicy.this.array[this.index])){
                    return true;
                }
                this.index = this.index + 1;
            }
            return false;
        }

        @Override
        public T next() {
            if(hasNext()){
                return UseIterableWithPolicy.this.array[this.index++];
            }else{
                return null;
            }
        }
        
    }

}
