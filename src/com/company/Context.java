package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Context {
    private HashMap<String, Double> params = new HashMap<>();
    private Stack<Double> stack = new Stack<>();

    public void pushStack(Double element){
        stack.push(element);
    }

    public double peekStack(){
        return stack.peek();
    }

    public int getSizeStack(){
        return stack.size();
    }

    public void popStack()
    {
        stack.pop();
    }

    public void setParams(String a, Double b) {
        params.put(a, b);
    }

    public boolean containsParam(String param)
    {
        return params.containsKey(param);
    }

    public Double getParamValue(String param)
    {
        return params.get(param);
    }
}
