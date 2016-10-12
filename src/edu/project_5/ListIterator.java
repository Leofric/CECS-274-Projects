package edu.project_5;

public interface ListIterator {
	
Object next();

boolean hasNext();

Object previous();

boolean hasPrevious();

void add(Object element);

Object remove();

void set(Object element);
}
