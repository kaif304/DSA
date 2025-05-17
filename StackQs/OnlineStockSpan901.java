package StackQs;

import java.util.ArrayList;
import java.util.Stack;

public class OnlineStockSpan901 {
    static class Stock{
        int price;
        int span;
        public Stock(int p, int s){
            this.price = p;
            this.span = s;
        }
    }
    Stack<Stock> stack;

    public OnlineStockSpan901() {
        this.stack = new Stack<>();
    }

    public int next(int price) {
        Stock newStock = new Stock(price, 1);

        while(!stack.isEmpty() && stack.peek().price <= price){
            newStock.span = newStock.span + stack.pop().span;
        }

        stack.push(newStock);

        return stack.peek().span;
    }
    public static void main(String[] args) {
        OnlineStockSpan901 stockSpanner = new OnlineStockSpan901();

        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
    }
}
