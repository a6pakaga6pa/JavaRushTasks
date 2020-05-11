package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry root;
    List<Entry<String>> list = new ArrayList<>();
    int count = 0;

    public CustomTree(Entry<String> root) {
        this.root = root;

    }

    public CustomTree(){
        root = new Entry("0");
        list.add(root);
    }

    public boolean add(String name) {
        Queue<Entry> queue = new LinkedList<> ();
        count = count+1;
        queue.add(root);

        while (!queue.isEmpty()){
            Entry top = queue.poll();
            if(top.availableToAddLeftChildren){
                Entry entry = new Entry(name);
                top.leftChild = entry;
                entry.parent = top;
                top.availableToAddLeftChildren = false;
                queue.clear();
            }
            else if(top.availableToAddRightChildren){
                Entry entry = new Entry(name);
                top.rightChild = entry;
                entry.parent = top;
                top.availableToAddRightChildren = false;
                queue.clear();
            }
            else {
                queue.add(top.leftChild);
                queue.add(top.rightChild);
            }
        } return true;
        /*Entry newElement = new Entry(name);
        for (int i = 0; i < list.size() ; i++) {
            Entry currentElement = list.get(i);
            if(currentElement.isAvailableToAddChildren()){
                if(currentElement.leftChild == null) {
                    currentElement.leftChild = currentElement;
                    currentElement.availableToAddLeftChildren = false;
                } else if(currentElement.rightChild == null) {
                    currentElement.rightChild = currentElement;
                    currentElement.availableToAddRightChildren = false;
                }
                newElement.parent = currentElement;
                list.add(newElement);
                count++;
                return true;
            }
        } return true;*/
    }

    public String getParent(String name) {
        Queue<Entry> queue = new LinkedList<> ();
        queue.add(root);

        while (!queue.isEmpty()){
            Entry top = queue.poll();
            if(!top.availableToAddLeftChildren){
                if(top.leftChild.elementName.equals(name)){
                    return top.elementName;
                }
                else{
                    try {
                        queue.add(top.leftChild);
                    }catch (NullPointerException e){
                        return null;
                    }
                }

            } if(!top.availableToAddRightChildren){
                if(top.rightChild.elementName.equals(name)){
                    return top.elementName;
                }
                else{
                    try{
                        queue.add(top.rightChild);
                    }catch (NullPointerException e){
                        return null;
                    }
                }
            }
        }
        return null;
        /*for (int i = 1; i < list.size(); i++) {
            Entry<String> currentElement = list.get(i);
            if(currentElement.elementName.equals(name)){
                return currentElement.parent.elementName;
            }
        } return null;*/
    }

    public boolean remove(Object o){
        if(o instanceof String){
            Queue<Entry> queue = new LinkedList<> ();
            queue.add(root);
            while (!queue.isEmpty()){
                String name = (String)o;
                Entry top = queue.poll();
                if(!top.availableToAddLeftChildren){
                    if(top.leftChild.elementName.equals(name)){
                        top.availableToAddLeftChildren = true;
                        queue.clear();
                        Queue<Entry> queue2 = new LinkedList<> ();
                        queue2.add(top.leftChild);
                        while (!queue2.isEmpty()){
                            Entry top2 = queue2.poll();
                            if(!top2.availableToAddLeftChildren){
                                queue2.add(top2.leftChild);
                            }
                            if(!top2.availableToAddRightChildren){
                                queue2.add(top2.rightChild);
                            }
                            top2 = null;
                            count--;
                        }

                    }else queue.add(top.leftChild);
                }
                if(!top.availableToAddRightChildren){
                    if(top.rightChild.elementName.equals(name)){
                        top.availableToAddRightChildren = true;
                        queue.clear();
                        LinkedList<Entry> queue2 = new LinkedList<> ();
                        queue2.add(top.rightChild);
                        while (!queue2.isEmpty()){
                            Entry top2 = queue2.poll();
                            if(!top2.availableToAddLeftChildren){
                                queue2.add(top2.leftChild);
                            }
                            if(!top2.availableToAddRightChildren){
                                queue2.add(top2.rightChild);
                            }
                            top2 = null;
                            count--;
                        }

                    }else queue.add(top.rightChild);
                }
            }

            return true;
        }
        else throw new UnsupportedOperationException();
    }

    @Override
    public String get(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size()
    {
        return this.count;
    }

    public String set(int index, String element){
        throw new UnsupportedOperationException();
    }

    public void add(int index, String element){
        throw new UnsupportedOperationException();
    }

    public String remove(int index){
        throw new UnsupportedOperationException();
    }

    public List<String> subList(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }

    protected void removeRange(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends String> c){
        throw new UnsupportedOperationException();
    }




    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return (this.availableToAddLeftChildren || this.availableToAddRightChildren);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?> entry = (Entry<?>) o;
            return Objects.equals(elementName, entry.elementName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(elementName);
        }
    }


}
