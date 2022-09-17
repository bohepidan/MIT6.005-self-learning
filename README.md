# MIT 6.005 SUMMARY
- **[Lecture website](https://ocw.mit.edu/courses/6-005-software-construction-spring-2016/pages/readings/)**

## Reading 1 : Static Checking

## Reading 2 : Basic java
- [Java Tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html)

## Reading 3 : Testing
- Test-first programming. Write tests before you write code.
- Partitioning and boundaries for choosing test cases systematically.
- White box testing and statement coverage for filling out a test suite.
- Unit-testing each module, in isolation as much as possible.
- Automated regression testing to keep bugs from coming back.

## Reading 4 : Code Review
- Don’t Repeat Yourself (DRY)
- Comments where needed
- Fail fast
- Avoid magic numbers
- One purpose for each variable
- Use good names
- No global variables
- Return results, don’t print them
- Use whitespace for readability

## Reading 5 : Version Control
- *How Git works and how to use it*
> Everything you need to know about Git is on the [Pro Git book](https://git-scm.com/book/zh/v2).

## Reading 6 : Specifications
- *An appropriately weak specification gives freedom to the implementor, and an appropriately strong specification gives freedom to the client.*
- [Java exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)

## Reading 7 : Designing Specifications
- *Three dimensions for comparing specs: deterministic, declarative, strong*
- *Package and Access Controll*
- *An appropriately weak specification gives freedom to the implementor, and an appropriately strong specification gives freedom to the client.*

## Reading 8 : Avoiding Debugging
- *Use assert in code implementation*
- *Modualrity & Encapsulation*
- Avoid debugging
  - make bugs impossible with techniques like static typing, automatic dynamic checking, and immutable types and references
- Keep bugs confined
  - failing fast with assertions keeps a bug’s effects from spreading
  - incremental development and unit testing confine bugs to your recent code
  - scope minimization reduces the amount of the program you have to search

## Reading 9 : Mutability & Immutability
- **Safe from bugs.** Immutable objects aren’t susceptible to bugs caused by aliasing. Immutable references always point to the same object.
- **Easy to understand.** Because an immutable object or reference always means the same thing, it’s simpler for a reader of the code to reason about — they don’t have to trace through all the code to find all the places where the object or reference might be changed, because it can’t be changed.
- **Ready for change.** If an object or reference can’t be changed at runtime, then code that depends on that object or reference won’t have to be revised when the program changes.

## Reading 10 : Recursion
- **Safe from bugs.** Recursive code is simpler and often uses immutable variables and immutable objects.

- **Easy to understand.** Recursive implementations for naturally recursive problems and recursive data are often shorter and easier to understand than iterative solutions.

- **Ready for change.** Recursive code is also naturally reentrant, which makes it safer from bugs and ready to use in more situations.