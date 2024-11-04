package it.unibo.inner.impl;

import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class UseIterableWithPolicy<T> implements IterableWithPolicy<T>{
    private T[] array;

    public UseIterableWithPolicy(T[] array){
        this.array = array;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    @Override
    public void setIterationPolicy(Predicate filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIterationPolicy'");
    }

    public class MyIterator implements Iterator<T>{
        private int index = 0;

        @Override
        public boolean hasNext() {
            if (this.index < UseIterableWithPolicy.this.array.length){
                return true;
            }else{
                return false;
            }
        }

        @Override
        public T next() {
            return UseIterableWithPolicy.this.array[this.index++];
        }
    
        
    }

}
