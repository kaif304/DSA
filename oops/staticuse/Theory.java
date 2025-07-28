package oops.staticuse;

/*
Excellent Explanation!

static: In a standard definition we know that static class members are the associated
with class, not its objects. By this we get to understand that one static member
(variable, method, block, nested class) is shared with all instances/objects of the class.
Any changes done in the static member will reflect in all other objects as well. Ok.

If we go into more detail and try to explain it more simply by covering everything,
I can say that: why do we need static, very good question right. If try to answer it
and I say, suppose we don't have the concept of static, it's all classes and objects,
and now let's take a real-life scenario over here of a company. Suppose I am the owner
of a company in which we have multiple departments, in one department I have hired 10
employees, each having a separate office/cabin, now I need to give a facility to my
employees that is, a coffee shop, where they can get a coffee.

Now which approach would beneficial, I create/open a coffee shop in every cabin/office,
where all employees can get the coffee, or I create/open a single coffee shop just
beside or nearby the offices/cabins and all the employees can come over there and
get the coffee.
What would be the right answer, obviously second one, because that is saving my money,
space and efforts and here is one twist that other departments can also access this
coffee shop if they are present at the same floor, right!

One more key point is that if the coffee shop is inside the office, only when the
employee will say then only the coffee will be ready, but in the single coffee shop,
the coffee men already will keep some coffee ready.

So, now if we try to understand, how is it making sense in terms of programming.
We can connect departments with classes (like some class Student), coffee shop with
static members (let's say a int variable count), and offices or employees with objects.

Here we observe that to save memory we create a count var because we already know that
it's going to be used by all the objects and same one, so why to create separate count
for every object.

static is also used in static initialization, like I said, employee will say then only
coffee men will make the coffee but in single coffee shop coffee men will himself make
the coffee without any permission of words, in the same way we define some block of code
to run automatically as the class is loaded by JVM, without any object creation
or object calling. Why need static initialization ?, because if there is some logic
or some block of code which needs to be done as soon as the class loaded or program runs,
so we use static over there to achieve this, because non-static methods can't do anything
static members. So here I am over, this is all I know about static and it's functioning.
*/
public class Theory {
    public static void main(String[] args) {
        System.out.println("Read the theory commented above.");
    }
}
