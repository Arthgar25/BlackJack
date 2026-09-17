package com.example.blackjack.Model;

import java.util.Arrays;

public class Pila<T> {
    private Object[] pila;
    private int top = -1;
    public Pila(int capacidad){
        this.pila = new Object[capacidad];
    }
    public void push(T data){
        if(isFull()){
            expandir(pila.length*2);
        }
        pila[++this.top] = data;
    }

    public T pop(){
        if(isEmpty()){
            return null;
        }
        T data = (T) pila[top];
        pila[top--] = null;
        if(top>0 && top==pila.length/4){
            expandir(pila.length/2);
        }
        return data;
    }

    public T peek(){
        if(isEmpty()){
            return null;
        }
        return (T) pila[top];
    }

    public int size(){
        return top+1;
    }

    private void expandir(int nuevaCapacidad){
        pila = Arrays.copyOf(pila, nuevaCapacidad);
    }

    private boolean isEmpty(){
        if(this.top == -1){
            return true;
        }
        return false;
    }

    private boolean isFull(){
        if(this.top == this.pila.length-1){
            return true;
        }
        return false;
    }
}
