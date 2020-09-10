package codingtest.site.codingInterview.stackAndQueue;

import codingtest.site.datastructure.Queue;

/**
 * 3.6 동물 보호소
 * <p>
 * 1. queue 한 개 이용 가정
 * 2. dequeueAny 는 상관없음.
 * 3. dequeueCat, dequeueDog 가 문젠데.
 * - cat cat cat dog 가 있으면, dequeueDog 를 하면 cat 3개 임시 버퍼에 놔두고(stack), dog 를 리턴한다?
 * - 그런 뒤 임시버퍼에 있는 것을 queue 에 맨 앞에 넣어둔다.
 * - 즉, Queue 의 customizing 을 용인해줄 것인가? 테스트 해보니 addFirst 가능
 * <p>
 * <p>
 * 1. 있는 자료구조를 활용하여 동물 보호소에 맞는 자료구조를 만들어라.
 */
public class Question3f {
    private Queue<String> queue;
    private Stack<String> stack;

    private static final String DOG = "Dog";
    private static final String CAT = "Cat";

    public Question3f() {
        queue = new Queue<String>();
        stack = new Stack<String>();
    }

    public void enqueue(String item) {
        queue.add(item);
    }

    public String dequeueAny() {
        return queue.poll();
    }

    public String dequeueDog() {
        while (!queue.isEmpty()) {
            String animal = queue.poll();
            if (!animal.equals(DOG)) {
                stack.push(animal);
            } else {
                while (!stack.isEmpty())
                    queue.add(stack.pop());
                return animal;
            }
        }
        return null;
    }

    public String dequeuecat() {
        while (!queue.isEmpty()) {
            String animal = queue.poll();
            if (!animal.equals(CAT)) {
                stack.push(animal);
            } else {
                while (!stack.isEmpty())
                    queue.add(stack.pop());
                return animal;
            }
        }
        throw new RuntimeException("Queue is null.");
    }

    @Override
    public String toString() {
        return "Question3f [queue=" + queue + "]";
    }

    public static void main(String[] args) {
        Question3f dataStructure = new Question3f();
        dataStructure.enqueue(DOG);
        dataStructure.enqueue(DOG);
        dataStructure.enqueue(CAT);
        System.out.println(dataStructure.dequeuecat());
        System.out.println(dataStructure);
//		System.out.println(dataStructure.dequeuecat());
//		System.out.println(dataStructure.dequeueAny());
//		System.out.println(dataStructure.dequeueAny());
//		System.out.println(dataStructure.dequeueAny());
    }
}
