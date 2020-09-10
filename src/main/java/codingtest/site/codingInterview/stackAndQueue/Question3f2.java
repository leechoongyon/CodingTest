package codingtest.site.codingInterview.stackAndQueue;

import codingtest.site.datastructure.Queue;

public class Question3f2 {
    private static final String DOG = "Dog";
    private static final String CAT = "Cat";

    private Queue<Animal> dogQueue;
    private Queue<Animal> catQueue;

    private int order = 0;

    public static class Animal {
        private String name;
        private int order;

        public Animal(String name, int order) {
            this.name = name;
            this.order = order;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        @Override
        public String toString() {
            return "Animal [name=" + name + ", order=" + order + "]";
        }
    }

    public Question3f2() {
        dogQueue = new Queue<Animal>();
        catQueue = new Queue<Animal>();
    }

    public String dequeueAny() {
        if (dogQueue.isEmpty())
            return catQueue.poll().getName();
        else if (catQueue.isEmpty())
            return dogQueue.poll().getName();
        else {
            if (dogQueue.peek().getOrder() < catQueue.peek().getOrder())
                return dogQueue.poll().getName();
            else
                return catQueue.poll().getName();
        }

    }

    public String dequeueDog() {
        return dogQueue.poll().getName();
    }

    public String dequeueCat() {
        return catQueue.poll().getName();
    }

    public void enqueue(String item) {
        Animal animal = new Animal(item, ++order);
        if (item.equals(DOG)) {
            dogQueue.add(animal);
        } else if (item.equals(CAT)) {
            catQueue.add(animal);
        } else
            throw new IllegalArgumentException("item is invalid. item : " + item);

    }

    @Override
    public String toString() {
        return "Question3f2 [dogQueue=" + dogQueue + ", catQueue=" + catQueue + ", order=" + order + "]";
    }

    public static void main(String[] args) {
        Question3f2 q = new Question3f2();
        q.enqueue(DOG);
        q.enqueue(DOG);
        q.enqueue(DOG);
        q.enqueue(CAT);
        q.enqueue(DOG);
        q.enqueue(CAT);
		/*System.out.println(q.dequeueAny());
		System.out.println(q.dequeueAny());
		System.out.println(q.dequeueAny());
		System.out.println(q.dequeueAny());
		System.out.println(q.dequeueAny());
		System.out.println(q.dequeueAny());*/
        System.out.println(q.dequeueCat());
        System.out.println(q);
    }
}
