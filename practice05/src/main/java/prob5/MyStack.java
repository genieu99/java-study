package prob5;

public class MyStack {
	private int maxSize;
    private String[] stackArray;
    private int top;

    public MyStack(int size) {
        this.maxSize = size;
        this.stackArray = new String[maxSize];
        this.top = -1;
    }

    public void push(String value){
    	if (top >= maxSize - 1) {
            resize(maxSize * 2);
        }
        stackArray[++top] = value;
    }

    public String pop() throws MyStackException {
        if (top < 0) {
            throw new MyStackException("stack is empty");
        }
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
    
    private void resize(int newSize) {
        String[] newArray = new String[newSize];
        System.arraycopy(stackArray, 0, newArray, 0, maxSize);
        stackArray = newArray;
        maxSize = newSize;
    }
}