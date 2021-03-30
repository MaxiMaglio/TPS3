package utils;

import StacksAndQueues.DynamicStack;
import StacksAndQueues.StackInterface;
import StacksAndQueues.StaticStack;

/**
 * Factory creates stacks from types of implementation
 * Each type of implementation extends from StackInterface and
 * behaves as implementation type declares.
 *
 * @param <T>
 *     Indicates type of object to be stacked
 *     Stacks creates should also be type <T>
 */
public class StackFactory<T> {
    public StackInterface<T> createFromType(ImplementationType type){
        switch (type){
            case DYNAMIC: return new DynamicStack<T>(); //TODO create static stack implementation
            case STATIC: return new StaticStack<T>(); //TODO create dynamic stack implementation
            default: return null;
        }
    }

}
