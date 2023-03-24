package Operações;

import TADs.Lista.Lista;
import TADs.Fila.Fila;

public abstract class Operation {

    // INTERSECÇÃO ===============================================================

    public static Object[] intersection(Object[] args1, Object[] args2) {
        int t = 0;
        Object[] result = new Object[t];
        for(Object obj: args1){
            for(Object obj2: args2){
                if(obj.equals(obj2)){
                    t++;
                    Object[] result2 = new Object[result.length];
                    if(result.length > 0){
                        for(int i = 0; i < result.length; i++){
                            result2[i] = result[i];
                        }
                        result = new Object[t];
                        for(int i = 0; i < result2.length; i++){
                            result[i] = result2[i];
                        }
                    }else{
                        result = new Object[t];
                    }
                    result = add(result, obj);
                }
            }
        }
        return result;
    }

    public static Lista<Object> intersection(Lista<Object> args1, Lista<Object> args2) {
        Lista<Object> result = new Lista<Object>();
        for(Object obj: args1){
            for(Object obj2: args2){
                if(obj.equals(obj2)){
                    result.add(obj);
                }
            }
        }
        return result;
    }

    public static Fila<Object> intersection(Fila<Object> args1, Fila<Object> args2) {
        Fila<Object> result = new Fila<Object>();
        for(Object obj: args1){
            for(Object obj2: args2){
                if(obj.equals(obj2)){
                    result.insert(obj);
                }
            }
        }
        return result;
    }

    public static Object[] intersection(Fila<Object> args1, Lista<Object> args2){
        Object[] result = intersection(args1.toArray(), args2.toArray());
        return result;
    }

    public static Object[] intersection(Lista<Object> args1, Fila<Object> args2){
        Object[] result = intersection(args1.toArray(), args2.toArray());
        return result;
    }

    // UNIÃO =====================================================================
                        //considerando situação onde podem haver valores repetidos

    public static Object[] union(Object[] args1, Object[] args2) {
        Object[] result = new Object[args1.length + args2.length];
        if(args1.length + args2.length > 0){
            for(int i = 0; i < args1.length; i++){
                result[i] = args1[i];
            }
            for(int i = 0; i < args2.length; i++){
                result[i + args1.length] = args2[i];
            }
        }
        return result; 
    }

    public static Lista<Object> union(Lista<Object> args1, Lista<Object> args2) {
        Lista<Object> result = new Lista<Object>();
        for(Object obj: args1){
            result.add(obj);
        }
        for(Object obj: args2){
            result.add(obj);
        }
        return result;
    }

    public static Fila<Object> union(Fila<Object> args1, Fila<Object> args2) {
        Fila<Object> result = new Fila<Object>();
        for(Object obj: args1){
            result.insert(obj);
        }
        for(Object obj: args2){
            result.insert(obj);
        }
        return result;
    }

    public static Object[] union(Fila<Object> args1, Lista<Object> args2){
        Object[] result = union(args1.toArray(), args2.toArray());
        return result;
    }

    public static Object[] union(Lista<Object> args1, Fila<Object> args2){
        Object[] result = union(args1.toArray(), args2.toArray());
        return result;
    }

    // PERTENCIMENTO ===============================================================

    public static boolean isOn(Object arg, Object[] args) {
        for(Object obj: args){
            if(obj.equals(arg)){
                return true;
            }
        }
        return false;
    }

    public static boolean isOn(Object arg, Lista<Object> args) {
        for(Object obj: args){
            if(obj.equals(arg)){
                return true;
            }
        }
        return false;
    }

    public static boolean isOn(Object arg, Fila<Object> args) {
        for(Object obj: args){
            if(obj.equals(arg)){
                return true;
            }
        }
        return false;
    }

    // EXTRAS ======================================================================

    private static Object[] add(Object[] result, Object obj) {
        result[result.length - 1] = obj;
        return result;
    }
}